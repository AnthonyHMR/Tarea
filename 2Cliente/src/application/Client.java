package application;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
	
	public void socket(String mensaje) throws IOException {
		Socket client = new Socket("127.0.0.1", 40000);
		OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());
		writer.write(mensaje);
		writer.flush();
		client.close();
	}
	
}
