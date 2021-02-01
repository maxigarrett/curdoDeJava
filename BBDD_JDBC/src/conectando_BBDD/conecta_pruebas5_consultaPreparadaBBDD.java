package conectando_BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class conecta_pruebas5_consultaPreparadaBBDD
{

	public static void main(String[] args) 
	{
		
		try
		{
			//1 crear conexion con base de datos
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql","root","");
			
			//2 preparar la consulta preparada metodo prepareStatement recive por parametro una consulta sql y
			//devuelve un objeto de tipo PreparedStatement que es una interfaz 
			PreparedStatement miSentencia=miConexion.prepareStatement("SELECT NOMBREARTÍCULO,SECCIÓN,PAÍSDEORIGEN"
					+ " FROM PRODUCTOS WHERE SECCIÓN =? AND PAÍSDEORIGEN=? ");
			
			//3 establecer los parametros de consulta que seria las interrogantes (?)el primer parametro de 
			//este metodo perteneciente a la interfaz PreparedStatement pide el orden que se van a establecer 
			//dentro de la consulta SQL como en este caso tenemos dos interrogantes ? ponemos el 1 o 2 para 
			//saber donde ubicarlos hay que tener en cuenta que tipo de dato es SECCIOM y PAISDEORIGEN
			//en este caso es de tipo String por eso usamos setString() el segundo parametro es el texto a 
			//establecer que quedara SECCION=DEPORTES
			miSentencia.setString(1, "deportes");
			miSentencia.setString(2, "USA");//quedara PAISDEORIGEN=USA ya que pusimos un 2 y hace referencia
											//a la segunda interrogante
			
			//4 ejecutar y recorrer la consulta
			ResultSet rs=miSentencia.executeQuery();
			
			while(rs.next()) 
			{
				//en los parametros el 1 pertenece a como lo declaramos en la consulta sql a NOMBREARTÍCULO el 2
				//SECCIÓN  y 3 PAÍSDEORIGEN
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			rs.close();
			
			
			
			//reutilizacion de consulta SQL
			System.out.println();
			System.out.println("ejecucion segunda consulta ");
			
			miSentencia.setString(1, "cerámica");
			miSentencia.setString(2, "China");
			
			rs=miSentencia.executeQuery();
			
			while(rs.next()) 
			{
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			rs.close();
			
			
		}
		catch (SQLException e)
		{
			System.out.println("NO CONECTA!!");
			e.printStackTrace();
		}

	}

}
