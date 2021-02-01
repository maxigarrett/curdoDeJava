package graficos;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;

public class CambioDeEstado_Ventana 
{

	public static void main(String[] args)
	{
		MarcoEstado mimarco=new MarcoEstado();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoEstado extends JFrame
{
	public MarcoEstado()
	{
		setBounds(400,200,400,350);
		setVisible(true);
		
		cambiaEstado estado=new cambiaEstado();
		addWindowStateListener(estado);//como la interfaz es otra implementamos el metodo addWindowStateListener 
		                               // a la escucha
		
	}
}

//
class cambiaEstado implements WindowStateListener
{
	//desencadena una accio simplemente al minimizar restaurar y demas en el frame
	public void windowStateChanged(WindowEvent e)
	{
		System.out.println("la ventana a cambiado de estado");
		//System.out.println(e.getNewState());//cuando utilisamos metodos de la clase WindowEvent y un objeto que llamos
		                                  //e para poder utilizar esos metodo necesitamos usar el objeto de ese tipo
		                                  // y llamarlos: e.getNewState esto devolvera un numero que se refiere al
		                                  // estado de la ventana
		
		//los numeros representa los estados de la ventana
		if(e.getNewState()==6) 
		{
			System.out.println("a pantalla completa ");
		}
		if(e.getNewState()==1) 
		{
			System.out.println(" a sido minimizada");
		}
		//constantes estaticas asi que va el nombre de la clase delante Frame.normal
		if(e.getNewState()==Frame.NORMAL) //es lo mismo decir e.getNewState()==0 pero es mas dificil acordarce
			                              //de los numeros asiq con las constantes de clase es mas facil
		{
			System.out.println("a normal");
		}
	}
}