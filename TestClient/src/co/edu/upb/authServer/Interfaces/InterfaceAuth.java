package co.edu.upb.authServer.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import co.edu.upb.app.domain.models.AppResponse;

public interface InterfaceAuth extends Remote {

	public AppResponse<String> register(String username, String password, String nombre, String apellido, String email) throws RemoteException;
	public AppResponse<String> login(String username, String password) throws RemoteException;
	public AppResponse<Boolean> validateJWT(String JWT) throws RemoteException;

}