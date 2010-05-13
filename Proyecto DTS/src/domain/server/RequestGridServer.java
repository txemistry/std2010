package domain.server;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import DB.DBM;
import domain.util.SocketManager;

final class RequestGridServer implements Runnable
{

	private SocketManager sockManager;
	private String user;
	private int state = 0;
	private DBM DBM = null;
	
	//Constructor
	public RequestGridServer(SocketManager sockMan) throws Exception
	{
		sockManager = sockMan;
		this.DBM = new DBM();
	}

	// Implement the run() method of the Runnable interface.
	public void run() 
	{
		try 
		{
	      processRequest();
	    }
	    catch (Exception e) 
	    {
	      System.out.println(e);
	    }	
	}
	
	  private void processRequest() throws Exception 
	  {
		  while (state != 3)
		  {
			  String requestLine = sockManager.Leer();
			  System.out.println("RequestLine: " + requestLine);
			  
			  //extract the command from the request line
			  StringTokenizer tokens = new StringTokenizer(requestLine);
			  String operation = tokens.nextToken();
			  
			  //Grafo
			  
			  if(operation.equals("QUIT"))
			  {
				  state = 3;
				  sockManager.Escribir("222 Ok Bye" + "\n");
			  }
			  else
			  {
				  switch(state)
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
				  					sockManager.Escribir("201 OK Welcome " + user + "\n");
				  					state = 1;
				  				}
				  				else
				  				{
				  					sockManager.Escribir("401 ERROR, user does not exist" + "\n");
				  				}
				  			}
				  			catch(NoSuchElementException e)
				  			{
				  				sockManager.Escribir("404 ERROR, missing username parameter" + "\n");
				  			}
				  		}
				  		else
				  			sockManager.Escribir("Unknown command" + "\n");
				  		break;
				  }
				  
				  case 1:
				  {
					  if(operation.equals("PASS"))
				  		{
				  			try
				  			{
					  			String pass = tokens.nextToken();
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
					  if(operation.equals("GET_COOR"))
					  {
						  	try
				  			{
					  			String cellID = tokens.nextToken();
					  			boolean verification = DBM.verifyCell(cellID);
					  			if (verification == true)
					  			{
					  				//la celda existe
					  				String coord = DBM.getGPSCoordCell(cellID);
							  		sockManager.Escribir("114 Ok ;"+ coord + "\n");
					  			}
					  			else
					  			{
					  				sockManager.Escribir("417 ERROR Unknown cell" + "\n");
					  			}
						  	}				  			
						  	catch(NoSuchElementException e)
						  	{
						  		sockManager.Escribir("418 ERROR, missing cell_id parameter" + "\n");
						  	}
					  }
					  break;
				  }
			  }
		  }
	  }
		  
		// Close streams and socket.
		  	sockManager.CerrarStreams();
		    sockManager.CerrarSocket();
	}
	 

}
