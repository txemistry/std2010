package domain.server;

import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.Vector;

import DB.DBM;
import domain.util.SocketManager;


final class RequestServer implements Runnable {

  private SocketManager sockManager;
  private String user;
  private String pass;
  private String ip;
  private int state = 0;
  private DBM DBM = null;
  
  // Constructor
  public RequestServer(SocketManager sockMan) throws Exception {
    sockManager = sockMan;
    this.DBM = new DBM();
  }

  // Implement the run() method of the Runnable interface.
  public void run() {
    try {
      processRequest();
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }

  private void processRequest() throws Exception {
	  
	  while (state != 6 )
	  {
		  String requestLine = sockManager.Leer();
		  System.out.println("RequestLine: " + requestLine);
		  
		  //Extract the command from the request line.
		  StringTokenizer tokens = new StringTokenizer(requestLine);
		  String operation = tokens.nextToken();
		  
		  //Grafo
		  
		  if(operation.equals("QUIT"))
		  {
			  state = 6;
			  sockManager.Escribir("208 OK Bye" + "\n");
		  }
		  else
		  {
			  switch (state)
			  {
			  	case 0:
				{
					if(operation.equals("USER"))
					{
						try
						{
							user = tokens.nextToken();
							boolean validation = DBM.checkUser(user);
							if(validation == true)
							{
								sockManager.Escribir("201 OK Welcome " + user + '\n');
								state = 1;
							}
							else
							{
								sockManager.Escribir("401 ERROR user does not exist" + '\n');
							}
						}
						catch(NoSuchElementException e)
			  			{
			  				sockManager.Escribir("408 ERROR, missing username parameter" + "\n");
			  			}
					}
					else
						sockManager.Escribir("Unknown Command" + "\n");
					break;
				}
				
			  	case 1:
			  	{
			  		if(operation.equals("PASS"))
			  		{
			  			try
			  			{
				  			String pass = tokens.nextToken();
				  			this.pass = pass;
				  			boolean validation = DBM.checkPass(user,pass);
				  			if(validation == true)
					  		{
					  			sockManager.Escribir("202 OK Welcome to the system" + "\n");
					  			state = 2;
					  		}
					  		else
					  		{
					  			sockManager.Escribir("402 ERROR autentification error" + "\n" );
					  			state = 0;
					  		}
				  		}
			  			
			  			catch(NoSuchElementException e)
			  			{
			  				sockManager.Escribir("408 ERROR, missing password parameter" + "\n");
			  			}
			  		}
					else
						sockManager.Escribir("Unknown Command" + "\n");
			  		break;
			  	}
			  	
			  	case 2:
			  	{
			  		if(operation.equals("CONNECT"))
			  		{
			  			try
			  			{
			  				ip=tokens.nextToken();
			  				//comprobar que existe un servidor con esa ip
			  				boolean validation = DBM.checkIP(ip);
			  				if(validation == true)
			  				{
			  					//hay un servidor con esa ip
			  					sockManager.Escribir("214 OK Connection with the server stabished" + "\n");
			  					state = 3;
			  				}
			  				else
			  				{
			  					//no hay ningun servidor con esa ip
			  					sockManager.Escribir("444 ERROR, The server is not available o does not exist" + "\n");
			  					//si esta mal que no me cambie el estado, que me mantenga el user y el pass
			  					// y me deje introducir una nueva IP
			  				}
			  			}
						catch(NoSuchElementException e)
			  			{
			  				sockManager.Escribir("408 ERROR, missing Server IP parameter" + "\n");
			  			}
			  		}
					else
						sockManager.Escribir("Unknown Command" + "\n");
			  		break;
			  	}
			  	
			  	//METER EN CADA IF UN ELSE IF PARA PODER AL FINAL HACER UN  ELSE PARA EL COMANDO DESCONOCIDO
			  	case 3:
			  	{
			  		if (operation.equals("LISTSENSOR"))
			  		{
			  			sockManager.Escribir("112 OK start of sensor list" + "\n");
			  			Vector<String> listSensors=DBM.getListSensors(ip);
			  			int size=listSensors.size();
			  			//Ahora deberiamos decirle oie, el vector tiene x elementos, y pasarselos
			  			sockManager.Escribir(size + "\n");
			  			for(int i = 0; i<size; i++)
			  			{
			  				sockManager.Escribir(listSensors.elementAt(i) + "\n");
			  			}

			  			sockManager.Escribir("212 OK end of sensor list" + "\n");
			  			state = 4;
			  		}
			  		
			  		if( operation.equals("GPSON"))
			  		{
			  			boolean GPSState = DBM.getGPSState(ip);
			  			if(GPSState == true)
			  			{
			  				sockManager.Escribir("409 ERROR GPS already activated" + "\n");
			  			}
			  			else
			  			{
			  				DBM.switchONGPS(ip);
			  				sockManager.Escribir("205 OK GPS activated" + "\n");
			  			}
			  		}
			  		
			  		if( operation.equals("GPSOFF"))
			  		{
			  			boolean GPSState = DBM.getGPSState(ip);
			  			if(GPSState == false)
			  			{
			  				sockManager.Escribir("420 ERROR GPS already deactivated" + "\n");
			  			}
			  			else
			  			{
			  				DBM.switchOFFGPS(ip);
			  				sockManager.Escribir("206 OK GPS deactivated" + "\n");
			  			}
			  		}
			  		
			  		
			  		
			  		if(operation.equals("GET_PIC"))
			  		{		
			  			
			  			/*String fileName = "data/images/street/imagen1.jpg";
                        File originalPhoto = new File(fileName);
                        FileInputStream stream = new FileInputStream(originalPhoto);
                        byte[] buffer = new byte[1024];
                        long totalSize = originalPhoto.length();
                        sockManager.Escribir("206 OK Loading image [" + Long.toString(totalSize)+ "] bytes..." + "\n");
                        sockManager.Escribir(Long.toString(totalSize)+ "\n");
                        int read = 0;
                        for(read = stream.read(buffer); read !=-1; read = stream.read(buffer))
                        {
                                sockManager.EscribirBytes(buffer);
        
                        }
                        
                        sockManager.Escribir("\n" + "Photo transmited..." + "\n");
                        state = 5;*/
                        
                        
			  			 String fileName = "data/images/street/imagen1.jpg";
                         File originalPhoto = new File(fileName);
                         FileInputStream stream = new FileInputStream(originalPhoto);
                         byte[] buffer = new byte[(int)originalPhoto.length()];
                         sockManager.Escribir("206 OK Loading image [" + buffer.length+ " bytes]" + "\n");
                         long fileSize = originalPhoto.length(); 
                         sockManager.Escribir(fileSize + "\n");
                         stream.read(buffer);
                         sockManager.EscribirBytes(buffer);
                         sockManager.Escribir("photo transmited" + "\n");
                         state = 5;
			  		
			  		}
			  		
			  		if(!operation.equals("GET_PIC") && !operation.equals("GPSON") && !operation.equals("GPSOFF") && !operation.equals("LISTSENSOR"))
			  		{
			  			sockManager.Escribir("Unknown Command" + "\n");
			  		}
			  		break;
			  	}
			  	
			  	case 4:
			  	{
			  		if (operation.equals("HISTORYLOG"))
			  		{
			  			try
			  			{
			  				String sensorID = tokens.nextToken();
			  				//tenemos que comprobar si el id del sensor, corresponde a un sensor
			  				//del coche al que estamos conectados eso lo hace verifysensor
			  				boolean validation = DBM.verifySensor(sensorID, ip);
			  				
			  				if (validation == true)
			  				{
			  					sockManager.Escribir("113 OK Start of measurement list" + "\n");
			  					Vector<String> listMeasurements=DBM.getListMeasurements(sensorID);
					  			int size=listMeasurements.size();
				  				sockManager.Escribir(size + "\n");
				  				if(size == 0)
					  			{
					  				sockManager.Escribir("Ups, there aren't measurements for this sensor" + "\n");
					  			}
					  			else
					  			{
					  				for(int i = 0; i < size; i++)
					  				{
					  					sockManager.Escribir(listMeasurements.elementAt(i) + "\n");
					  				}
					  				sockManager.Escribir("212 OK End of measurement list" + "\n");
					  			}
			  				}
			  				else
			  				{
			  					sockManager.Escribir("414 ERROR unknown sensorID" + "\n");
			  				}
			  				
			  			}
			  			catch(NoSuchElementException e)
			  			{
			  				sockManager.Escribir("408 ERROR, missing sensorID parameter" + "\n");
			  			}
			  		}
			  		
			  		if (operation.equals("ON"))
			  		{
			  			try
			  			{
				  			String sensorID = tokens.nextToken();
				  			boolean validation = DBM.verifySensor(sensorID, ip);
				  			if( validation == true)
				  			{
				  				boolean sensorState = DBM.getSensorState(sensorID);
				  				if(sensorState == true)
				  				{
				  					sockManager.Escribir("418 ERROR Sensor already activated" + "\n");
				  				}
				  				else
				  				{
				  					DBM.switchONSensor(sensorID);
				  					sockManager.Escribir("203 OK Sensor activated" + "\n");
				  				}
				  			}
				  			else
				  			{
				  				sockManager.Escribir("417 ERROR unknown sensorID" + "\n");
				  			}
			  			}
			  			
			  			catch(NoSuchElementException e)
			  			{
			  				sockManager.Escribir("415 ERROR, missing sensor parameter" + "\n");
			  			}
			  		}
			  		
			  		if (operation.equals("OFF"))
			  		{
			  			try
			  			{
				  			String sensorID = tokens.nextToken();
				  			boolean validation = DBM.verifySensor(sensorID, ip);
				  			if( validation == true)
				  			{
				  				boolean sensorState = DBM.getSensorState(sensorID);
				  				if(sensorState == false)
				  				{
				  					sockManager.Escribir("419 ERROR Sensor already deactivated" + "\n");
				  				}
				  				else
				  				{
				  					DBM.switchOFFSensor(sensorID);
				  					sockManager.Escribir("204 OK Sensor deactivated" + "\n");
				  				}
				  			}
				  			else
				  			{
				  				sockManager.Escribir("417 ERROR unknown sensorID" + "\n");
				  			}
			  			}
			  			catch(NoSuchElementException e)
			  			{
			  				sockManager.Escribir("420 ERROR, missing sensor parameter" + "\n");
			  			}
			  		}
			  		
			  		if( operation.equals("GET_CURVALUE"))
			  		{
			  			try
			  			{
			  				String sensorID = tokens.nextToken();
			  				boolean validation = DBM.verifySensor(sensorID, ip);
			  				if (validation == true)
			  				{
			  					//el sernsor pertenece al coche al que estamos conectados
			  					boolean sensorState = DBM.getSensorState(sensorID);
			  					if(sensorState == true)
			  					{
			  						//el gps esta encencido y podemos dar sus datos
			  						//obetener los datos de la lectutra y enviarselos: DATE+TIME+COORDINATES+VALUE
			  						String value = DBM.getSensorValue(sensorID);
			  						String coord = DBM.getSensorCoord(sensorID);
			  						
			  						//cogemos la fecha, esto es un poco rebuscado:
			  						Calendar c = Calendar.getInstance();
			  						String day = Integer.toString(c.get(Calendar.DATE));
			  						String month = Integer.toString(c.get(Calendar.MONTH));
			  						String year = Integer.toString(c.get(Calendar.YEAR));
			  						
			  						//cogemos la hora actual:
			  						String hour =Integer.toString(c.get(Calendar.HOUR_OF_DAY));
			  						String minutes = Integer.toString(c.get(Calendar.MINUTE));
			  						String seconds =Integer.toString( c.get(Calendar.SECOND));
			  						
			  						sockManager.Escribir("114 OK; " + day + "/" + month + "/" + year + "; " + hour + ":" + minutes + ":" + seconds + "; " + coord + "; " + value + "\n");
			  					}
			  					else
			  					{
			  						//el gps esta apagado y no podemos dar sus datos
			  						sockManager.Escribir("416 ERROR Sensor is not activated" + "\n");
			  					}	
			  				}
			  				else
			  				{
			  					//el sensor o no existe, o no pertenece al coche en el que estamos
			  					sockManager.Escribir("414 ERROR Unknown sensorID" + "\n");
			  				}
			  			}
			  			catch(NoSuchElementException e)
			  			{
			  				sockManager.Escribir("415 ERROR, missing sensor parameter" + "\n");
			  			}
			  		}
			  		
			  		if( operation.equals("RETURN"))
			  		{
			  			state = 3;
			  			sockManager.Escribir("Coming back to the main menu..." + "\n");
			  		}
			  		
			  		if(!operation.equals("HISTORYLOG") && !operation.equals("ON") && !operation.equals("OFF") && !operation.equals("GET_CURVALUE") && !operation.equals("RETURN"))
			  		{
			  			sockManager.Escribir("Unknown Command" + "\n");
			  		}
			  		break;
			  	}
			  	
			  	case 5:
			  	{
			  		if(operation.equals("GET_LOC"))
			  		{
			  			//tenemos que comprobar si el GPS esta activado, si lo esta devolveremos las coordenadas,
			  			//si esta descativado llamamos al servidor Grid
			  			
			  			System.out.println("estoy dentro de get loc");
			  			boolean GPSState = DBM.getGPSState(ip);
			  			System.out.println(GPSState);
			  			if(GPSState == true)
			  			{
			  				//el GPS esta encendido
			  				String coord = DBM.getGPSCoord(ip);
				  			sockManager.Escribir("114 OK ;" + coord + "\n");
			  			}
			  			else
			  			{
			  				//el GPS esta apagado: Llamamos al Grid Server
			  				Socket gridSocket = new Socket("127.0.0.1", 3001);
			  				SocketManager manager = new SocketManager(gridSocket);
			  				manager.Escribir("USER " + user + "\n");
			  				System.out.println(manager.Leer());
			  				manager.Escribir("PASS " + pass + "\n");
			  				System.out.println(manager.Leer());			  				
			  				String cell = DBM.getActualGrid(ip);
			  				manager.Escribir("GET_COOR " + cell + "\n");
			  				sockManager.Escribir(manager.Leer() + "\n");
			  				manager.Escribir("QUIT" + "\n");
			  				manager.Leer();
			  				manager.CerrarSocket();
			  				manager.CerrarStreams();
			  			}
			  			
			  			state = 3;
			  		}
			  		
			  		
			  		else
			  		{
			  			sockManager.Escribir("Unknown Command" + "\n");
			  		}
			  		break;
			  	}
			  	
			  	default:
			  	{
			  		System.out.println("I'm getting crazy!!!!!!");
			  	}
			  }
		  }
	  }
	  
	  
	  
	  

    // Close streams and socket.
    sockManager.CerrarStreams();
    sockManager.CerrarSocket();
  }
  



}