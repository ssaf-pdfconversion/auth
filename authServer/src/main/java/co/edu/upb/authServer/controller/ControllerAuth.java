package co.edu.upb.authServer.controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import co.edu.upb.authServer.Interfaces.InterfaceAuth;
import co.edu.upb.authServer.Model.RegisterModel;

public class ControllerAuth extends UnicastRemoteObject implements InterfaceAuth {

    private static final long serialVersionUID = 1L;

    public ControllerAuth() throws RemoteException {
    }

    @Override
    public String login(String username, String password) throws RemoteException {
        return username;
    }

    @Override
    public String register(String username, String password, String nombre, String apellido, String email) throws RemoteException {
        try {
            RegisterModel registerModel = new RegisterModel(username, password, nombre, apellido, email);
            boolean isRegistered = registerModel.registerUser();
            
            if (isRegistered) {
                return "User registered successfully.";
            } else {
                return "Registration failed: Unable to register user.";
            }
        } catch (Exception e) {
            
            throw new RemoteException("Registration error: " + e.getMessage(), e);
        }
    }
}
