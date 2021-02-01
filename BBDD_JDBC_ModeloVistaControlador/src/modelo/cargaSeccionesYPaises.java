package modelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controlador.*;
public class cargaSeccionesYPaises 
{
	public cargaSeccionesYPaises() 
	{
		//con esto le damos un estado inicial a esa conexion 
		miConexion=new conexion();
	}
	
	//metodo capas de ejecutar la consulta necesaria para obtener las diferentes secciones que tengo en mi tabla
	//productos para cargar los JComboBox
	public String ejecutaConsultas() 
	{
		productos miProductos=null;
		
		Connection accesoBBDD=miConexion.dameConexion();
		
		try 
		{
			Statement secciones=accesoBBDD.createStatement();
			
			Statement paises=accesoBBDD.createStatement();
			
			rs=secciones.executeQuery("SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS");
			
			rs2=paises.executeQuery("SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS");
			
			miProductos=new productos();
			 
		    miProductos.setSeccion(rs.getString(1));
			
		    miProductos.setpOrigen(rs2.getString(1));
			  
			  rs.close();
			  rs2.close();
			  	  
		}
		
		catch(SQLException e) 
		{
			System.out.println("aqui esta ocurriendo el error en la clase cargaSeccionesypaises");
			e.printStackTrace();
		}
		
		return miProductos.getSeccion();
		
		
	}
	public conexion miConexion;
	public ResultSet rs;//para que sea accesible desde otro paquete en este caso paquete controlador
	public ResultSet rs2;
}
