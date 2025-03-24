package classes;

public class Client {

    RMIClient sk;

    public Client(String address, int port) {
        sk = new RMIClient(address, port);
    }

    public void operation() {
        sk.request();
    }
}