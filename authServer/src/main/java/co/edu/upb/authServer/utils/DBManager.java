package co.edu.upb.authServer.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class DBManager {

	
	public Connection getConnection(){
		
		Dotenv dotenv = Dotenv.load();
	    String dbUrl = dotenv.get("DB_URL");
	    String dbUser = dotenv.get("DB_USER");
	    String dbPassword = dotenv.get("DB_PASSWORD");
	  
		
	    try {
	        
	        Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	        System.out.println("Connection established successfully! :)");
	        return connection;
	        
	    } catch (SQLException e) {
	        System.err.println("Connection failed: " + e.getMessage());
	        e.printStackTrace();
	        return null;
	    }
		
	}
	
	public void closeConnection(Connection connection) {
		
		try {
			 connection.close();
			 System.out.println("Connection closed.");
		}catch (SQLException e) {
	        System.err.println("Failed to close the connection:( " + e.getMessage());
	        e.printStackTrace();
	       
	    }
		
	}
	
	
	
}
