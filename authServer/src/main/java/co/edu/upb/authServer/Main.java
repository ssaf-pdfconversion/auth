package co.edu.upb.authServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.Connection;

import co.edu.upb.authServer.Interfaces.InterfaceAuth;
import co.edu.upb.authServer.Interfaces.InterfaceRMI;
import co.edu.upb.authServer.Model.RegisterModel;
import co.edu.upb.authServer.utils.DBManager;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			
			RegisterModel register= new RegisterModel("sofia123", "123", "sofia","salas", "sofia@gmail.com");
			register.registerUser();
			
			
			
			
			InterfaceRMI service = new InterfaceAuth();
			LocateRegistry.createRegistry(1802);
			Naming.rebind("//127.0.0.1:1802/service", service);
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
