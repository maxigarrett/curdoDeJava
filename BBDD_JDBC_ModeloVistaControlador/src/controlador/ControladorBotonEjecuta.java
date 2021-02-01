package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.ejecutaConsultas;
import vista.*;


/*esta clase gestiona los eventos de la consultas a base de datos para eso importamos el paquete modelo que es donde
 que tiene la clase ejecutaConsultas que verifica si el usuario escogio uno de los JComboBox o los dos y para poder
 trabajar con el boton tendremos que importar el paquete vista que contiene el boton creado para poder trabajar con
 el*/
public class ControladorBotonEjecuta implements ActionListener 
{
	/*lo que aremos va a ser instanciar dentro del paquete vista la clase en la que estamos ControladorBotonEjecuta
	 y al instanciar esta clase le tendremos que pasar el propio marco por parametro y ese marco se almacenara en
	 este parametro llamado elMarco que a su ves hace que se almacene en el campo de clase llamado de la misma
	 forma elMarco y utilizando este campo de clase ya podemos acceder a todo lo que hay dentro del marco y dentro
	 esta los desplegables de secciones y paises y el boton para gestionar las consultas */
	public ControladorBotonEjecuta(Marco_Aplicacion elMarco) 
	{
		this.elMarco=elMarco;
	}
	public void actionPerformed(ActionEvent e) 
	{
		//almacenamos en estas variables lo que el usuario escogio en los JComboBox
		String seleccionSeccion=(String)elMarco.secciones.getSelectedItem();
		String seleccionPais=(String)elMarco.paises.getSelectedItem();
		
		resultadoConsulta=obj.filtraBBDD(seleccionSeccion, seleccionPais);
		
		try 
		{
			elMarco.resultado.setText("");
			while(resultadoConsulta.next()) 
			{
				elMarco.resultado.append("\n");
				elMarco.resultado.append(resultadoConsulta.getString(1));
				elMarco.resultado.append("\n");
				elMarco.resultado.append(resultadoConsulta.getString(2));
				elMarco.resultado.append("\n");
				elMarco.resultado.append(resultadoConsulta.getString(3));
				elMarco.resultado.append("\n");
				elMarco.resultado.append(resultadoConsulta.getString(4));
				elMarco.resultado.append("\n");
				
			}
			
			
		} 
		catch (SQLException e1)
		{
			System.out.println("el error ocurre en el paquete controlador en la clase ControladorBotonEjecuta");
			e1.printStackTrace();
		}
	}
	private Marco_Aplicacion elMarco;
	private ejecutaConsultas obj=new ejecutaConsultas();
	private ResultSet resultadoConsulta;
}
