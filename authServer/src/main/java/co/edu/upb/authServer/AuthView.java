package co.edu.upb.authServer;

import java.rmi.RemoteException;

import co.edu.upb.authServer.controller.ControllerAuth;

public class AuthView {

    private final RMIServer sk;

    public AuthView(int port) throws RemoteException {
        this.sk = new RMIServer(port, new ControllerAuth());
    }

    public void run() {
        sk.listening();
    }

}