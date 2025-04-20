package co.edu.upb.authServer;
import java.rmi.RemoteException;

import co.edu.upb.authServer.controller.ControllerAuth;

public class Principal {
	
	public static void main(String[] args) {
		
		try {
			
			AuthView server = new AuthView(6969);
	        server.run();
	        
	        ControllerAuth controller = new ControllerAuth();
	        
	        //controller.register("hola", "hola", "hola", "hola", "hola");
	        //controller.login("hola", "hola");
	        
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

	}

}
