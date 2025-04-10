package co.edu.upb.authServer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import co.edu.upb.authServer.Interfaces.InterfaceAuth;
import co.edu.upb.authServer.utils.Environment;
import io.github.cdimascio.dotenv.Dotenv;

public class RMIServer {

    private int port;
    private final InterfaceAuth service;

    public RMIServer(int port, InterfaceAuth service) {
        this.service = service;
        this.port = port;
    }

    public void listening() {
        try {
            
            
            String serverIp = Environment.getInstance().getDotenv().get("SERVER_IP");

            
            System.setProperty("java.rmi.server.hostname", serverIp);

            
            LocateRegistry.createRegistry(port);

            
            Naming.rebind("//" + serverIp + ":" + port + "/auth", service);
            System.out.println("Service bound to //" + serverIp + ":" + port + "/auth");
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
