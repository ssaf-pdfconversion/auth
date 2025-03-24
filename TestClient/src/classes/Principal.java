package classes;

public class Principal {

	public static void main(String[] args) {
		
		Client client = new Client("127.0.0.1", 6969);
        client.operation();
	}

}
