package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DBM {
	
	private Connection con;
	
	//***************************************************************************************//
	
	public DBM()
	{
		//Driver load and Connection with the DataBase
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:CarDB","", "");
		}
		catch(Exception e)
		{ 
			System.out.println("Cannot load the JDBC-ODBC Driver"); 
		}
	}
	
	//***************************************************************************************//
	
	public void disconnectDB()
	{
		try
		{
			this.con.close();
		}
		catch(SQLException se) 
		{
			System.out.println("Cannot disconnect the Data base");
		}
	}
	
	//***************************************************************************************//
	
	public boolean checkUser(String user) 
	{
		Statement sentSQL = null;
		String query = null;
		ResultSet result = null;
		boolean verifycation=false;
		
		//Create the Statement
		

		//Define the query
		query = "SELECT * FROM USER WHERE USER = '" + user + "'";
		
		//Check user in the dataBase
		try 
		{
			sentSQL = con.createStatement();
			result = sentSQL.executeQuery(query);
			verifycation = result.next();
			sentSQL.close();
		} 
		catch (SQLException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return verifycation;	
	}
	
	//***************************************************************************************//
	
	public boolean checkPass(String user, String pass)
	{
		Statement sentSQL = null;
		String query = null;
		ResultSet rs = null;
		boolean verifycation=false;

		//Define the query
		query = "SELECT * FROM USER WHERE PASS = '" + pass + "' AND USER = '" +user + "'";
		
		//Check user in the dataBase
		try 
		{
			sentSQL = con.createStatement();
			rs = sentSQL.executeQuery(query);
			verifycation=rs.next();
			sentSQL.close();
		} 
		catch (SQLException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();
		}
	
		return verifycation;	
	}
	
	//***************************************************************************************//
	
	public boolean checkSensorID(String sensorID)
	{
		//verifica si un sensorID existe, sin importarnos el coche en el que este alojado.
		
		Statement sentSQL = null;
		String query = null;
		ResultSet rs = null;
		boolean verifycation=false;

		//Define the query
		query = "SELECT * FROM 	SENSOR WHERE SENSORID = '" + sensorID + "'";
		
		//Check state in the dataBase
		try 
		{
			sentSQL = con.createStatement();
			rs = sentSQL.executeQuery(query);
			verifycation = rs.next();
			sentSQL.close();
		} 
		catch (SQLException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();	
		}
		
		return verifycation;	
	}
	
	//***************************************************************************************//
	
	public boolean verifySensor(String sensorID, String ip)
	{
		
		//comprueba si un sensor id pretenece al coche en el que estamos conectados,
		//para ello, primero verificamos que el sensorID exista sin importarnos a que coche pertenece.
		//si existe, comprobamos que pertenece al coche al que estamos conectados
		
		boolean result = false;
		Statement sentSQL = null;
		String query = null;
		ResultSet rs = null;
		
		try
		{
			boolean sensorIDExists = checkSensorID(sensorID);
			if(sensorIDExists == false)
				result = false;
			else
			{
				sentSQL = con.createStatement();
				query = "SELECT IP FROM VEHICLE WHERE VEHICLEID = (SELECT VEHICLEID FROM SENSOR WHERE SENSORID = '" + sensorID + "')";
				rs = sentSQL.executeQuery(query);
				rs.next();
				if(ip.equals(rs.getString(1)))
						result = true;
				sentSQL.close();
			}
		}
		catch (SQLException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();	
		}
		return result;
	}
	
	//***************************************************************************************//
	
	public void switchONSensor(String sensorID)
	{
		Statement sentSQL = null;
		String query = null;
		

		//Define the query
		query = "UPDATE SENSOR SET STATE = '" + "ON" + "' WHERE SENSORID ='" + sensorID + "'";
		
		try 
		{
			sentSQL = con.createStatement();
			sentSQL.executeUpdate(query);
			sentSQL.close();
		} 
		catch (SQLException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();	
		}
	}
	
	//***************************************************************************************//
	
	public void switchOFFSensor(String sensorID)
	{
		Statement sentSQL = null;
		String query = null;


		//Define the query
		query = "UPDATE SENSOR SET STATE = '" + "OFF" + "' WHERE SENSORID ='" + sensorID + "'";
		
		try 
		{
			sentSQL = con.createStatement();
			sentSQL.executeUpdate(query);
			sentSQL.close();
		} 
		catch (SQLException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();	
		}

	}
	
	//***************************************************************************************//
	
	public Vector<String> getListSensors(String ip)
	{
		Vector<String> listSensors=new Vector<String>();
		Statement sentSQL = null;
		String query = null;
		ResultSet rs = null;
		String id=null;

		//Obtain the ID from IP
		id=getId(ip);
		
		//Define the query
		query = "SELECT * FROM SENSOR WHERE VEHICLEID='" + id + "'";
		
		//Check user in the dataBase
		try 
		{
			sentSQL = con.createStatement();
			rs = sentSQL.executeQuery(query);
			
			//Convert resultSet into a Vector
			while(rs.next())
			{
				listSensors.add(rs.getString("SENSORID") + ";;" + rs.getString("DESCRIPTION") + ";;" + rs.getString("STATE"));
			}
			sentSQL.close();
		} 
		catch (SQLException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();
		}
		
		return listSensors;
		
	}
	
	//***************************************************************************************//
	
	public Vector<String> getListMeasurements(String id)
	{
		Vector<String> listMeasurements=new Vector<String>();
		Statement sentSQL = null;
		String query = null;
		ResultSet rs = null;
	
		
		//Define the query
		query = "SELECT * FROM MEASUREMENT WHERE SENSORID='" + id + "'";
		
		//Check user in the dataBase
		try 
		{
			sentSQL = con.createStatement();
			rs = sentSQL.executeQuery(query);                         
			
			//Convert resultSet into a Vector
			while(rs.next())
			{
				listMeasurements.add(rs.getString("DATE") + ";" + rs.getString("TIME") + ";" + getCoord(rs.getString("COORD")) + ";" + rs.getString("VALUE"));
			}
			sentSQL.close();
		} 
		catch (SQLException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();
		}
		
		return listMeasurements;
		
	}
	
	//***************************************************************************************//
	
	private String getId(String ip)
	{
		Statement sentSQL = null;
		String query = null;
		ResultSet rs = null;
		String id=null;

		//Define the query
		query = "SELECT * FROM VEHICLE WHERE IP = '" + ip + "'";
		
		//Check user in the dataBase
		try 
		{
			sentSQL = con.createStatement();
			rs = sentSQL.executeQuery(query);
			rs.next();
			id=rs.getString(1);
			sentSQL.close();
		} 
		catch (SQLException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();
			
		}

		return id;
	}
	
	//***************************************************************************************//
	
	public boolean getSensorState(String id)
	{
		String state;
		boolean state2 = false;
		Statement sentSQL = null;
		String query = null;
		ResultSet rs = null;
		
		//Define the query
		query = "SELECT STATE FROM SENSOR WHERE SENSORID='"+id+"'";
		
		//Check user in the dataBase
		try 
		{
			sentSQL = con.createStatement();
			rs = sentSQL.executeQuery(query);
			rs.next();
			state= rs.getString("STATE");
			
			if(state.equals("ON"))
				state2 = true;
			else state2 = false;
			
			sentSQL.close();
		} 
		catch (SQLException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();	
		}
		return state2;
	}
	
	//***************************************************************************************//
	
	public boolean getGPSState(String ip)
	{
		String state = null;
		boolean result = false;
		Statement sentSQL = null;
		String query = null;
		ResultSet rs = null;
		String id=null;
		
		//Obtain the ID from IP
		id=getId(ip);
		
		//Define the query
		query = "SELECT STATE FROM GPS WHERE VEHICLEID='"+id+"'";
		
		//Check user in the dataBase
		try 
		{
			sentSQL = con.createStatement();
			rs = sentSQL.executeQuery(query);
			rs.next();
			state = rs.getString(1);
			if(state.equals("ON"))
				result = true;
			else result = false;
			sentSQL.close();
		} 
		catch (SQLException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();
			
		}
		return result;
	}
	
	//***************************************************************************************//
	
	public void switchONGPS(String ip) 
	{
		Statement sentSQL = null;
		String query = null;
		
		
		try
		{
			sentSQL = con.createStatement();
			String vehicleID = getId(ip);
			query = "UPDATE GPS SET STATE = '" + "ON" + "' WHERE VEHICLEID ='" + vehicleID + "'";
			sentSQL.executeUpdate(query);
			sentSQL.close();
		} 
		catch (SQLException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();	
		}

	}
	
	//***************************************************************************************//

	public void switchOFFGPS(String ip) 
	{
		Statement sentSQL = null;
		String query = null;
		
		
		try
		{
			sentSQL = con.createStatement();
			String vehicleID = getId(ip);
			query = "UPDATE GPS SET STATE = '" + "OFF" + "' WHERE VEHICLEID ='" + vehicleID + "'";
			sentSQL.executeUpdate(query);
			sentSQL.close();
		} 
		catch (SQLException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();	
		}
	}
	
	//***************************************************************************************//

	public String getSensorValue(String sensorID) 
	{
		String value = null;
		Statement sentSQL = null;
		String query = null;
		ResultSet rs = null;
		
		
		try
		{
			sentSQL = con.createStatement();
			query = "select curValue from sensor where sensorID = '" + sensorID + "'";
			rs = sentSQL.executeQuery(query);
			rs.next();
			value = rs.getString(1);
			sentSQL.close();
		}
		catch (SQLException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();	
		}
		
		return value;
	}
	
	//***************************************************************************************//

	public String getSensorCoord(String sensorID)
	{
		String coord = null;
		Statement sentSQL = null;
		String query = null;
		ResultSet rs = null;
		
		
		try
		{
			sentSQL = con.createStatement();
			query = "SELECT VAL FROM COORD WHERE COORD =(SELECT COORD FROM GPS WHERE GPSID = (SELECT GPSID FROM VEHICLE WHERE VEHICLEID = (SELECT VEHICLEID FROM SENSOR WHERE SENSORID = '" + sensorID + "')))";
			rs = sentSQL.executeQuery(query);
			rs.next();
			coord = rs.getString(1);
			sentSQL.close();
		}
		catch (SQLException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();	
		}
		
		return coord;
	}
	
	
	//***************************************************************************************//

	
	public String getCoord(String coorID)
	{
		Statement sentSQL = null;
		String query = null;
		ResultSet rs = null;
		String coord = null;
		
		try
		{
			sentSQL = con.createStatement();
			query = "select val from coord where coord = '" + coorID + "'";
			rs = sentSQL.executeQuery(query);
			rs.next();
			coord = rs.getString(1);
			sentSQL.close();
		}
		catch (SQLException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();	
		}
		return coord;
		
	}
	
	
	//***************************************************************************************//

	
	public String getActualGrid(String ip)
	{
		Statement sentSQL = null;
		String query = null;
		ResultSet rs = null;
		String grid = null;
		
		try
		{
			sentSQL = con.createStatement();
			query = "SELECT ACTUALGRID FROM VEHICLE WHERE IP = '" + ip + "'";
			rs = sentSQL.executeQuery(query);
			rs.next();
			grid = rs.getString(1);
			sentSQL.close();
		}
		catch (SQLException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();	
		}
		return grid;
	}
	
	
	//***************************************************************************************//
	
	
	public boolean verifyCell(String cellID)
	{
		Statement sentSQL = null;
		String query = null;
		ResultSet rs = null;
		boolean result = false;
		
		try
		{
			sentSQL = con.createStatement();
			query = "SELECT * FROM GRID WHERE GRIDID = '" + cellID + "'";
			rs = sentSQL.executeQuery(query);
			result = rs.next();
			sentSQL.close();
		}
		catch (SQLException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();	
		}
		return result;
	}
	
	
	//***************************************************************************************//
	
	
	public String getGPSCoordCell(String cellID)
	{
		Statement sentSQL = null;
		String query = null;
		ResultSet rs = null;
		String coord = null;
		
		try
		{
			sentSQL = con.createStatement();
			query = "SELECT COORD FROM GRID WHERE GRIDID = '" + cellID + "'";
			rs = sentSQL.executeQuery(query);
			rs.next();
			coord = rs.getString(1);
			coord = getCoord(coord);
			sentSQL.close();
		}
		catch (SQLException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();	
		}
		return coord;
	}
	
	
	//***************************************************************************************//

	public String getGPSCoord(String ip)
	{
		String coord = null;
		Statement sentSQL = null;
		String query = null;
		ResultSet rs = null;
		
		
		try
		{
			sentSQL = con.createStatement();
			query = "SELECT COORD FROM GPS WHERE VEHICLEID = (SELECT VEHICLEID FROM VEHICLE WHERE IP = '" + ip + "')";
			rs = sentSQL.executeQuery(query);
			rs.next();
			coord = rs.getString(1);
			coord = getCoord(coord);
			sentSQL.close();
		}
		catch (SQLException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();	
		}
		
		return coord;
	}
	
	//***************************************************************************************//

	public boolean checkIP(String ip)
	{
		boolean validation = false;
		Statement sentSQL = null;
		String query = null;
		ResultSet rs = null;
		
		try
		{
			sentSQL = con.createStatement();
			query = "SELECT * FROM VEHICLE WHERE IP = '" + ip + "'";
			rs = sentSQL.executeQuery(query);
			validation = rs.next();
			sentSQL.close();
		}
		catch (SQLException e) 
		{
			// Auto-generated catch block
			e.printStackTrace();	
		}
		return validation;
	}
	
}