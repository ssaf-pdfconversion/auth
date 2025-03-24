package classes;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import co.edu.upb.authServer.Interfaces.InterfaceAuth;

public class RMIClient {

	 private final String addressName;
	    
	   

	    public RMIClient(String address, int port) {
	        
	        this.addressName = "rmi://127.0.0.1:6969/auth";
	    }

	
	public void request() {
		
		
		try {
			InterfaceAuth service = (InterfaceAuth) Naming.lookup(this.addressName);
			service.register("dan123", "dan", "dan", "dan", "dan");
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
		
		
		
	}
}
