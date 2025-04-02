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
    	ZonedDateTime now = ZonedDateTime.now();
		 
		 AppResponse<String>  response = new AppResponse<String>("Holis", "Servidor autenticación respondió a las: "+ now.format(formatter), true);
		 return response;
    }

    @Override
    public AppResponse<String> register(String username, String password, String nombre, String apellido, String email) throws RemoteException {
        try {
        	
        	
            RegisterModel registerModel = new RegisterModel(username, password, nombre, apellido, email);
            boolean isRegistered = registerModel.registerUser();
            
            if (isRegistered) {
            	 ZonedDateTime now = ZonedDateTime.now();
            	AppResponse<String> response = new AppResponse<String>("Prueba", "Registro exitoso a las "+ now.format(formatter), true);
                return response;
            } else {
            	 ZonedDateTime now = ZonedDateTime.now();
            	AppResponse<String> response = new AppResponse<String>("Prueba", "Registro fallido a las "+ now.format(formatter), false);
                return response;
            }
        } catch (Exception e) {
           
            throw new RemoteException("Registration error: " + e.getMessage(), e);
        }
    }

	@Override
	public AppResponse<Boolean> validateJWT(String JWT) {
		ZonedDateTime now = ZonedDateTime.now();
		 System.out.println("Server app envió solicitud a las:  "+ now.format(formatter));
		 AppResponse<Boolean>  response = new AppResponse<Boolean>(false, "Servidor autenticación respondió a las: "+ now.format(formatter), true);
		 return response;
	}
    
    
}
