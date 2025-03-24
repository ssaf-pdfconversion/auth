package co.edu.upb.authServer;
import java.rmi.RemoteException;

public class Principal {
	
	public static void main(String[] args) {
		
		try {
			
			AuthView server = new AuthView(6969);
	        server.run();
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

	}

}
