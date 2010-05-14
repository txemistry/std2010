package domain.server;

import java.net.* ;
import domain.util.SocketManager;

public final class CarServer
{
	public static void main(String argv[]) throws Exception
	{
		System.out.println("CarServer working");
		
		// Set the port number.
		int port = 3000;

		ServerSocket wellcomeSocket = new ServerSocket(port);

		while (true)
		{
			//Aceptar la nueva petición y crear el SocketManager para gestionar el Socket obtenido
			SocketManager manager = new SocketManager(wellcomeSocket.accept());
	
			//Crear un objeto HttpRequest para gestionar la petición
			RequestServer rs = new RequestServer(manager);
	
			//Crear un Thread para el objeto HttpRequest
			Thread t = new Thread(rs);

			System.out.println("I have created a requestServer child");
		
			//Arrancar el Thread
			t.start();
			
		}
	}
}
