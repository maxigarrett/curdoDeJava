package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import modelo.*;
import vista.*;

public class controladorCargaSeccionesYPaises extends WindowAdapter
{
	//para poder cargar el JComboBox que se encuentra dentro de Marco_Aplicacion vamos a necesitar pasarle
	//a esta clase un argumento de tipo Marco_Aplicacion al constructor 
	public controladorCargaSeccionesYPaises(Marco_Aplicacion elMarco) 
	{
		this.elMarco=elMarco;
	}
	
	//vamos hacer que al abrir la aplicacion se cargue los JComboBox metodo perteneciente a la clase WindowAdapter
	public void windowOpened(WindowEvent e) 
	{
		//primero este metodo al abrir la aplicacion tiene que ejecutar la consulta SQL que esta en la clase
		//cargaSecciones y que tiene un metodo que hace este trabajo y se llama ejecutaConsultas()
		obj.ejecutaConsultas();
		
		//recorremos el ResultSet que esta en la clase cargaSecciones dentro del metodo ejecutaConsultas(); va 
		//dentro de un try catch ya que vamos a utilizar un ResultSet
		try 
		{
			//el objeto llamado obj utiliza el ResultSet para poder utilizar el metodo next() de la siguiente forma
			//obj es de tipo cargaSecciones que dentro esta clase esta el ResultSet llamado rs osea el obj nos 
			//permite usar el ResultSet
			while(obj.rs.next()) 
			{
				
				elMarco.secciones.addItem(obj.rs.getString(1));
				
				
			}
			while(obj.rs2.next()) 
			{
				
	
				elMarco.paises.addItem(obj.rs2.getString(1));
			}
		}
		catch(Exception e2) 
		{
			System.out.println("error en clase controladorCargaSeccionesYPaises");
			e2.printStackTrace();
		}
	}

	//instancias para hacer referencia a los objetos que estan dentro de estas clases cargaSecciones
	//y Marco_Aplicacion
	cargaSeccionesYPaises obj=new cargaSeccionesYPaises();
	private Marco_Aplicacion elMarco;
}
