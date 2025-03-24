package co.edu.upb.authServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



public class AuthInterface extends UnicastRemoteObject implements iRMI {
	
	protected AuthInterface() throws RemoteException {
	}

	private static final long serialVersionUID = 1L;
	
	@Override
	public int sumar(int a) throws RemoteException {
		return a + 5;
	}
	@Override
	public int restar(int a) throws RemoteException {
		return a - 5;
	}

}
