package co.edu.upb.authServer.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;
import co.edu.upb.authServer.utils.DBManager;
import co.edu.upb.authServer.utils.Environment;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class LoginModel {

    private String username;
    private String password;
    private DBManager db = new DBManager();

    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }
  
    public String loginUser() {
        
        String sql = "SELECT idusuario, password FROM USUARIO WHERE username = ?";

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
               
                int userId = resultSet.getInt("idusuario");
                String hashedPassword = resultSet.getString("password");
                
               
                if (BCrypt.checkpw(password, hashedPassword)) {
                    
                    return generateJwt(username, userId);
                }
            }
            
            
            return null;
            
        } catch (SQLException e) {
            System.err.println("Error logging in user: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    
    private String generateJwt(String username, int userId) {
      
        
        String secretKey =  Environment.getInstance().getDotenv().get("JWT_SECRET");

        return Jwts.builder()
                   .setSubject("autentication")
                   .claim("username", username)
                   .claim("userId", userId)
                   .signWith(SignatureAlgorithm.HS384, secretKey.getBytes())
                   .compact();
    }
}
