package co.edu.upb.authServer.controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import co.edu.upb.app.domain.models.AppResponse;
import co.edu.upb.authServer.Interfaces.InterfaceAuth;
import co.edu.upb.authServer.Model.RegisterModel;

public class ControllerAuth extends UnicastRemoteObject implements InterfaceAuth {

    private static final long serialVersionUID = 1L;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
    
    
    public ControllerAuth() throws RemoteException {
    }

    @Override
    public AppResponse<String> login(String username, String password) throws RemoteException {
        return null;
    }

    @Override
    public AppResponse<String> register(String username, String password, String nombre, String apellido, String email) throws RemoteException {
        try {
        	
        	
            RegisterModel registerModel = new RegisterModel(username, password, nombre, apellido, email);
            boolean isRegistered = registerModel.registerUser();
            
            if (isRegistered) {
            	 ZonedDateTime now = ZonedDateTime.now();
            	AppResponse<String> response = new AppResponse<String>(true, "Registro exitoso a las "+ now.format(formatter), "Prueba");
                return response;
            } else {
            	 ZonedDateTime now = ZonedDateTime.now();
            	AppResponse<String> response = new AppResponse<String>(false, "Registro fallido a las "+ now.format(formatter), "Prueba");
                return response;
            }
        } catch (Exception e) {
            
            throw new RemoteException("Registration error: " + e.getMessage(), e);
        }
    }

	@Override
	public AppResponse<Boolean> validateJWT(String JWT) {
		
		return null;
	}
    
    
}
