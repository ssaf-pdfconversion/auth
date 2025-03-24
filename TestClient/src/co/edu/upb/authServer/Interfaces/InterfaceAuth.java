package co.edu.upb.authServer.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceAuth extends Remote {

	public String register(String username, String password, String nombre, String apellido, String email) throws RemoteException;
	public String login(String username, String password) throws RemoteException;

}