package co.edu.upb.authServer.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import co.edu.upb.authServer.utils.DBManager;

public class RegisterModel {

	  private String username;
	  private String password;
	  private String nombre;
	  private String apellido;
	  private String email;
	  private DBManager db= new DBManager();
	
	  public RegisterModel(String username, String password, String nombre, String apellido, String email) {
	        this.username = username;
	        this.password = password; 
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.email = email;
	    }
	  
	  
	  
	  public boolean registerUser() {
	        
		  
		  	
		  
		  
	        String sql = "INSERT INTO USUARIO (USERNAME, PASSWORD, NOMBRE, APELLIDO, EMAIL) VALUES (?, ?, ?, ?, ?)";
	        
	        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12)); 
	        
	        
	        try (Connection connection = db.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, hashedPassword);
	            preparedStatement.setString(3, nombre);
	            preparedStatement.setString(4, apellido);
	            preparedStatement.setString(5, email);
	            
	            int rowsAffected = preparedStatement.executeUpdate();
	            
	            db.closeConnection(connection);
	            
	            
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            System.err.println("Error registering user: " + e.getMessage());
	            e.printStackTrace();
	            
	            return false;
	        }
	    }
}
