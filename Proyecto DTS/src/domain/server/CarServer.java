package domain.server;

import java.net.* ;
import domain.util.SocketManager;

public final class CarServer
{
	public static void main(String argv[]) throws Exception
	{
		System.out.println("servidor padre funcionando");
		
		// Set the port number.
		int port = 3000;//(new Integer(argv[0])).intValue();

		ServerSocket wellcomeSocket = new ServerSocket(port);

		while (true)
		{
			//Aceptar la nueva petición y crear el SocketManager para gestionar el Socket obtenido
			SocketManager manager = new SocketManager(wellcomeSocket.accept());
	
			//Crear un objeto HttpRequest para gestionar la petición
			RequestServer rs = new RequestServer(manager);
	
			//Crear un Thread para el objeto HttpRequest
			Thread t = new Thread(rs);

			System.out.println("he creado un hijo");
		
			//Arrancar el Thread
			t.start();
			
		}
	}
}
