package co.edu.upb.authServer.controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import co.edu.upb.app.domain.models.AppResponse;
import co.edu.upb.authServer.Interfaces.InterfaceAuth;
import co.edu.upb.authServer.Model.LoginModel;
import co.edu.upb.authServer.Model.RegisterModel;
import co.edu.upb.authServer.Model.ValidateModel;

public class ControllerAuth extends UnicastRemoteObject implements InterfaceAuth {

    private static final long serialVersionUID = 1L;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
    
    
    public ControllerAuth() throws RemoteException {
    }

    @Override
    public AppResponse<String> login(String username, String password) throws RemoteException {
    	
    	System.out.println("Server app envió solicitud de login");
    	
    	LoginModel loginModel = new LoginModel(username, password);
    	String token = loginModel.loginUser();
    	
    	if (token != null) {
			ZonedDateTime now = ZonedDateTime.now();
			AppResponse<String> response = new AppResponse<String>(token, "Login exitoso a las: "+ now.format(formatter), true);
			System.out.println(response.getMessage().toString());
			System.out.println(response.getData().toString());
			return response;
		} else {
			ZonedDateTime now = ZonedDateTime.now();
			AppResponse<String> response = new AppResponse<String>("No token", "Login fallido a las: "+ now.format(formatter) +" error con las credenciales.", false);
			System.out.println(response.getMessage().toString());
			return response;
		}
    	
    	
    }

    @Override
    public AppResponse<String> register(String username, String password, String nombre, String apellido, String email) throws RemoteException {
        try {
        	
        	
        	System.out.println("Server app envió solicitud de registro.");
            RegisterModel registerModel = new RegisterModel(username, password, nombre, apellido, email);
            boolean isRegistered = registerModel.registerUser();
            
            if (isRegistered) {
            	 ZonedDateTime now = ZonedDateTime.now();
            	AppResponse<String> response = new AppResponse<String>("Prueba", "Registro exitoso a las "+ now.format(formatter), true);
            	System.out.println(response.getMessage().toString());
                return response;
            } else {
            	 ZonedDateTime now = ZonedDateTime.now();
            	AppResponse<String> response = new AppResponse<String>("Prueba", "Registro fallido a las "+ now.format(formatter), false);
            	System.out.println(response.getMessage().toString());
                return response;
            }
        } catch (Exception e) {
           
            throw new RemoteException("Registration error: " + e.getMessage(), e);
        }
    }

	@Override
	public AppResponse<Boolean> validateJWT(String JWT) {
		
		System.out.println("Server app envió solicitud de validación de token.");
		ValidateModel validateModel = new ValidateModel();
		boolean isValid = validateModel.validateJWT(JWT);
		if (isValid) {
			ZonedDateTime now = ZonedDateTime.now();
			System.out.println("Token válido a las: "+ now.format(formatter));
			AppResponse<Boolean>  response = new AppResponse<Boolean>(true, "Token válido a las: "+ now.format(formatter), true);
			return response;
		} else {
			ZonedDateTime now = ZonedDateTime.now();
			System.out.println("Token inválido a las: "+ now.format(formatter));
			AppResponse<Boolean>  response = new AppResponse<Boolean>(false, "Token inválido a las: "+ now.format(formatter), false);
			return response;
		}
		 
		 
	}
    
    
}
