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
            	 System.setProperty("java.rmi.server.hostname", "192.168.1.20");
                 
                 
                 LocateRegistry.createRegistry(port);
                 
                 
                 Naming.rebind("//192.168.1.20:" + port + "/auth", service);
                 System.out.println("Service bound to //192.168.1.20:" + port + "/auth");
            } catch (RemoteException | MalformedURLException e) {
                e.printStackTrace();
            
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