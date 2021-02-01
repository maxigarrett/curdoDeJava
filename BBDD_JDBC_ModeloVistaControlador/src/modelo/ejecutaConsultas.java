package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controlador.conexion;
import vista.Marco_Aplicacion;

/*esta clase gestionara las consultas es decir si el usuario ah escogido seccion o paises o ambos si escogio ambos
 habrá que hacer un filtrado*/
public class ejecutaConsultas 
{
	public ejecutaConsultas() 
	{
		miConexion=new conexion();
	}
	public ResultSet filtraBBDD(String seccion,String pais) 
	{
		//pruebas="";
		Connection conecta=miConexion.dameConexion();
		rs=null;
		try
		{
			
			if(seccion.equals("todos") && pais.equals("todos"))
			{
				
				JOptionPane.showMessageDialog(null , "no escogiste ninguna opcion");
				obj.resultado.append("por favor escoja una opcion para realizar el filtro");
				//System.out.println("el error ocurre en ejecuta consulta")
				
			}
			
			
			else if(!seccion.equals("todos") && pais.equals("todos")) 
			{
				//pruebas="has escogido seccion";
				enviaConsultaSeccion=conecta.prepareStatement(consultaSeccion);
				
				enviaConsultaSeccion.setString(1, seccion);
				
				rs=enviaConsultaSeccion.executeQuery();
			
			}
			else if(seccion.equals("todos") && !pais.equals("todos")) 
			{
				
				//pruebas="has escogido pais";
				enviaConsultaPais=conecta.prepareStatement(consultaPais);
				enviaConsultaPais.setString(1, pais);
				rs=enviaConsultaPais.executeQuery();
				
				
			}
			
			else if(!seccion.equals("todos") && !pais.equals("todos")) 
			{
				//pruebas="has escogido ambos";
				
				enviaAmbasConsultas=conecta.prepareStatement(consultaAmbas);
				enviaAmbasConsultas.setString(1, seccion);
				enviaAmbasConsultas.setString(2, pais);
				rs=enviaAmbasConsultas.executeQuery();
				
			}
			
		}
		catch(SQLException e) 
		{
			System.out.println("error en ejecutaConsulta del paquete modelo ejecutaConsultas");
			e.printStackTrace();
		}
			return rs;
	}
	
	//private String pruebas;
	JLabel etiqueta;
	public Marco_Aplicacion obj;
	private conexion miConexion;
	private ResultSet rs;
	private PreparedStatement enviaConsultaSeccion,enviaConsultaPais, enviaAmbasConsultas;
	private final String consultaPais="SELECT NOMBREARTÍCULO,SECCIÓN,PRECIO,PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN=?";
	private final String consultaSeccion="SELECT NOMBREARTÍCULO,SECCIÓN,PRECIO,PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=?";
	private final String consultaAmbas="SELECT NOMBREARTÍCULO,SECCIÓN,PRECIO,PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?";
}
