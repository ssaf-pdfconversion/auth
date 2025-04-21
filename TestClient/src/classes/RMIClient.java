package classes;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import co.edu.upb.authServer.Interfaces.InterfaceAuth;

public class RMIClient {

	 private final String addressName;
	    
	   

	    public RMIClient(String address, int port) {
	        
	        this.addressName = "rmi://192.168.1.20:6969/auth";
	    }

	
	public void request() {
		
		
		try {
			InterfaceAuth service = (InterfaceAuth) Naming.lookup(this.addressName);
			service.login("admin", "admin");
			service.register("admin", "admin", "admin", "admin", "admin");
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
		
		
		
	}
}
