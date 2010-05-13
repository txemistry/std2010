package domain.util;

import java.net.*;
import java.io.*;



public class SocketManager {
    private Socket mySocket;

    private DataOutputStream bufferEscritura;
    private BufferedReader bufferLectura;

    public SocketManager(Socket sock) throws IOException {
        this.mySocket = sock;
        InicializaStreams();
    }

    /**
     *
     * @param address InetAddress
     * @param port int numero de puerto
     * @throws IOException
     */
    public SocketManager(InetAddress address, int port) throws IOException {
        mySocket = new Socket(address, port);
        InicializaStreams();
    }

    /**
     *
     * @param host String nombre del servidor al que se conecta
     * @param port int puerto de conexion
     * @throws IOException
     */
    public SocketManager(String host, int port) throws IOException {
        mySocket = new Socket(host, port);
        InicializaStreams();
    }

    /**
     * Inicialización de los bufferes de lectura y escritura del socket
     * @throws IOException
     */
    public void InicializaStreams() throws IOException {
        bufferEscritura = new DataOutputStream(mySocket.getOutputStream());
        bufferLectura = new BufferedReader(new InputStreamReader(mySocket.
                getInputStream()));
    }

    public void CerrarStreams() throws IOException {
        bufferEscritura.close();
        bufferLectura.close();
    }

    public void CerrarSocket() throws IOException {
        mySocket.close();
    }

    /**
     *
     * @return String
     * @throws IOException
     */
    public String Leer() throws IOException {
        return (bufferLectura.readLine());
    }
    
    public byte [] LeerBytes (int tam) throws IOException {
    	byte [] b = new byte [tam] ;
    	int bytesRead =0;
    	
    	while (bytesRead<tam) 
    	{
    		bytesRead += this.mySocket.getInputStream().read(b, bytesRead, ((tam-bytesRead)>=5000)?5000:tam-bytesRead);
    	}
    	
    	return b;
    }

    public void Escribir(String contenido) throws IOException {
        bufferEscritura.writeBytes(contenido);
    }

    public void Escribir(byte[] buffer, int bytes) throws IOException {
        bufferEscritura.write(buffer, 0, bytes);
    }
    
    public void EscribirBytes(byte []buff) throws IOException {
    	this.mySocket.getOutputStream().write(buff);
    }
}