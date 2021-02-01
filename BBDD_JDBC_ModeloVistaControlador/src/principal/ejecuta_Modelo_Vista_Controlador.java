package principal;



import javax.swing.JFrame;

import vista.*;//importamos el paquete creado para a la hora de intanciar no de error

/*lo mismo que hicimos en el proyecto BBDD_JDBC en el paquete practica_guiadaBBDD pero lo dividimos en tres
 partes lo que seria modelo vista controlador... en el Modelo se programar todo lo relacionado con los datos
 y su encapsulacion referido a BBDD...en Vista va programado todo lo que hace referencia a la vistaes decir a
 la interfaz grafica.... y en el Controlador hay que programar la interaccion que hay entre esa Vista y ese 
 Modelo es decir la conexion que existe entre la parte grafica y la BBDD y los eventos que hay que manejar a la
 hora de manejar la aplicacion osea el Controlador va a manejar los eventos*/
public class ejecuta_Modelo_Vista_Controlador 
{

	public static void main(String[] args)
	{
	 		
		JFrame mimarco=new Marco_Aplicacion();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
		
		
	}

}
