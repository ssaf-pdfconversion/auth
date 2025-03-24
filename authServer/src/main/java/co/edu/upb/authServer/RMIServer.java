package co.edu.upb.authServer;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


import co.edu.upb.authServer.Interfaces.InterfaceAuth;

public class RMIServer {

    private int port;
    private final InterfaceAuth service;

    public RMIServer(int port, InterfaceAuth service) {
        this.service = service;
        this.port = port;
    }

    public void listening() {
        try {
            LocateRegistry.createRegistry(6969);
            try {
                Naming.rebind("//127.0.0.1:6969/auth", service);
            } catch (RemoteException | MalformedURLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}