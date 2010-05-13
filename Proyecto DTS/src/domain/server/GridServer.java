package domain.server;

import java.net.ServerSocket;

import domain.util.SocketManager;

public class GridServer {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("servidor padre grid funcionando");
		
		// Set the port number.
		int port = 3001;//(new Integer(argv[0])).intValue();

		ServerSocket wellcomeSocket = new ServerSocket(port);

		while (true)
		{
			//Aceptar la nueva petición y crear el SocketManager para gestionar el Socket obtenido
			SocketManager manager = new SocketManager(wellcomeSocket.accept());
	
			//Crear un objeto HttpRequest para gestionar la petición
			RequestGridServer rs = new RequestGridServer(manager);
	
			//Crear un Thread para el objeto HttpRequest
			Thread t = new Thread(rs);

			System.out.println("he creado un hijo de tipo Grid");
		
			//Arrancar el Thread
			t.start();
			
		}
	

	}

}
