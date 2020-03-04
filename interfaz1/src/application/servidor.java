package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor {
	public static String mensaje;
	
	public void socket() {
		
		boolean active = true;
		try {
			ServerSocket serverSocket = new ServerSocket(40000);
			while (active) {
				System.out.println("Listening...");
				Socket entrante = serverSocket.accept();
				
				BufferedReader lector = new BufferedReader(new InputStreamReader(entrante.getInputStream()));
				mensaje = lector.readLine();
				System.out.println(mensaje);
				entrante.close();
			}
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
}
