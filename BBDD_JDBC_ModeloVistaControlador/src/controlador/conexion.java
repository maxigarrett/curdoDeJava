package controlador;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion 
{
	public conexion() 
	{
		
	}
	
	public Connection dameConexion() 
	{
		try
		{
			// CREAMOS CONEXION
			 miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");
	
		}
		catch(SQLException e) 
		{
			System.out.println("NO CONECTA!!");
			e.printStackTrace();
		}
		return miConexion;
	}
	private Connection miConexion;
}
