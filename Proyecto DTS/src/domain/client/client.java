package domain.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import domain.util.SocketManager;

public class client {
	
	final static String CRLF = "\r\n";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try 
		{
			Socket clientSocket = new Socket("127.0.0.1", 3000);
			SocketManager manager = new SocketManager(clientSocket);
			
			//enviamos el usuario
			System.out.println("COMANDO USER");
			manager.Escribir("USER Itzi \n");
			String resultado = manager.Leer();
			System.out.println(resultado);
			System.out.println();
			System.out.println();
			
			//enviamos la contraseña
			System.out.println("COMANDO PASS");
			manager.Escribir("PASS 12345" + "\n");
			resultado = manager.Leer();
			System.out.println(resultado);
			System.out.println();
			System.out.println();

			//enviamos la ip
			System.out.println("COMANDO CONNECT");
			manager.Escribir("CONNECT 127.0.0.1" + "\n");
			resultado = manager.Leer();
			System.out.println(resultado);
			System.out.println();
			System.out.println();
			
			System.out.println("COMANDO LISTSENSOR");
			manager.Escribir("LISTSENSOR" + "\n");
			System.out.println(manager.Leer());
			int size = Integer.parseInt(manager.Leer());
			for(int i=1;i<=size;i++)
			{
				resultado = manager.Leer();
				System.out.println(resultado);
			}
			System.out.println(manager.Leer());
			System.out.println();
			System.out.println();
			
			
			System.out.println("COMANDO OFF/ON");
			manager.Escribir("ON 2" + "\n");
			System.out.println(manager.Leer());
			System.out.println();
			System.out.println();
			
			System.out.println("COMANDO HISTORYLOG");
			manager.Escribir("HISTORYLOG 3" + "\n");
			System.out.println(manager.Leer());
			int size2 = Integer.parseInt(manager.Leer());
			for(int i=1;i<=size2;i++)
			{
				resultado = manager.Leer();
				System.out.println(resultado);
			}
			System.out.println(manager.Leer());
			System.out.println();
			System.out.println();
			
			System.out.println("COMANDO GET_CURVALUE");
			manager.Escribir("GET_CURVALUE 2" + "\n");
			System.out.println(manager.Leer());
			System.out.println();
			System.out.println();
			
			
			System.out.println("COMANDO RETURN");
			manager.Escribir("RETURN" + "\n");
			System.out.println(manager.Leer());
			System.out.println();
			System.out.println();

			System.out.println("COMANDO OFF/ON del GPS");
			manager.Escribir("GPSOFF" + "\n");
			System.out.println(manager.Leer());
			System.out.println();
			System.out.println();
			
			
			
			
			System.out.println("COMANDO GET_PIC + GET_LOC");
			manager.Escribir("GET_PIC" + "\n");
			
			System.out.println(manager.Leer());
            int tam =Integer.parseInt(manager.Leer());
            byte[] array = manager.LeerBytes(tam);
            FileOutputStream fos = new FileOutputStream("data/fotoNueva3.jpg");
            fos.write(array);
            System.out.println(manager.Leer());
			
			
			
			
			System.out.println("comando get loc");
			manager.Escribir("GET_LOC" + "\n");
			System.out.println(manager.Leer());
			System.out.println();
			System.out.println();
			
				
			System.out.println("COMANDO QUIT");
			manager.Escribir("QUIT" + "\n");
			System.out.println(manager.Leer());
			System.out.println();
			System.out.println();
			
			manager.CerrarStreams();
			manager.CerrarSocket();
		} 
		
		catch (UnknownHostException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
