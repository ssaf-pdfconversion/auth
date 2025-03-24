package co.edu.upb.authServer.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRMI extends Remote {

	public int sumar(int a) throws RemoteException;
	public int restar(int a) throws RemoteException;

}