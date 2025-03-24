package co.edu.upb.authServer.Interfaces;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



public class InterfaceAuth extends UnicastRemoteObject implements InterfaceRMI {
	
	public InterfaceAuth() throws RemoteException {
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
