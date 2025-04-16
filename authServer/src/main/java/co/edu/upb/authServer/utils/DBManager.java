package co.edu.upb.authServer.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class DBManager {

	
	public Connection getConnection(){
		
	    String dbUrl = Environment.getInstance().getDotenv().get("DB_URL");
	    String dbUser = Environment.getInstance().getDotenv().get("DB_USER");
	    String dbPassword = Environment.getInstance().getDotenv().get("DB_PASSWORD");
	  
		
	    try {
	        
	        Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	        System.out.println("Connection established successfully with the Database! :)");
	        return connection;
	        
	    } catch (SQLException e) {
	        System.err.println("Connection failed with the Database: " + e.getMessage());
	        e.printStackTrace();
	        return null;
	    }
		
	}
	
	public void closeConnection(Connection connection) {
		
		try {
			 connection.close();
			 System.out.println("Connection closed with the Database.");
		}catch (SQLException e) {
	        System.err.println("Failed to close the connection with the Database:( " + e.getMessage());
	        e.printStackTrace();
	       
	    }
		
	}
	
	
	
}
