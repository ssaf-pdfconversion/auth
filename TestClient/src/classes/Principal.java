package classes;

public class Principal {

	public static void main(String[] args) {
		
		Client client = new Client("192.168.1.20", 6969);
        client.operation();
	}

}
