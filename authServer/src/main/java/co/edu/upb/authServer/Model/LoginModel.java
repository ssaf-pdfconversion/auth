package co.edu.upb.authServer.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import co.edu.upb.authServer.utils.DBManager;
import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class LoginModel {

	 private String username;
	 private String password;
	 private DBManager db= new DBManager();
		
	 
	 
	 public LoginModel(String username, String password) {
	        this.username = username;
	        this.password = password; 
	       
	    }
	  
	 
	 
	   public boolean loginUser() {
	       
	        String sql = "SELECT password FROM USUARIO WHERE username = ?";

	        try (Connection connection = db.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            
	            preparedStatement.setString(1, username);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	            if (resultSet.next()) {
	                // Get the hashed password from the database.
	                String hashedPassword = resultSet.getString("password");
	                // Use BCrypt to check if the provided password matches the hashed password.
	                if (BCrypt.checkpw(password, hashedPassword)) {
	                    // Generate and return the JWT token if password is valid
	                    //return generateJwt(username);
	                	return true;
	                }
	            }
	            
	            
	            return false;
	            
	        } catch (SQLException e) {
	            System.err.println("Error logging in user: " + e.getMessage());
	            e.printStackTrace();
	            return false;
	        }
	        
	        
	        
	        
	    }
	 
	    @SuppressWarnings("deprecation")
		private String generateJwt(String username) {
	        
	        Dotenv dotenv = Dotenv.load();
	        String secretKey = dotenv.get("JWT_SECRET");

	        return Jwts.builder()
	                   .setSubject(username)
	        		   .signWith(SignatureAlgorithm.ES384, secretKey.getBytes())
	        		   .compact();
	    }
	 
}
