package graficos;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class eventoFocoVentana extends JFrame implements WindowFocusListener 
{

	public static void main(String[] args)
	{
		eventoFocoVentana miventana=new eventoFocoVentana();//instanciamos a la clase que engloba todo
		miventana.iniciar();//llamamos al metodo iniciar donde esta la creacion de los marcos

	}
	public void iniciar()//donde vamos a crear los marcos
	{
		marco1=new eventoFocoVentana();
		marco2=new eventoFocoVentana();
		marco1.setVisible(true);
		marco2.setVisible(true);
		marco1.setBounds(100,100,600,350);
		marco2.setBounds(700,100,600,350);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco1.addWindowFocusListener(this);
		marco2.addWindowFocusListener(this);
		
	}

	//metodo que se activa cuando la ventana ganar el foco
	public void windowGainedFocus(WindowEvent e)
	{
		if(e.getSource()==marco1) //getSource quien es el evento del origen ocurrido cual de los dos marcos genero
									//el evento
		{
			marco1.setTitle("tengo el foco");
		}
		else 
		{
			marco2.setTitle("tengo el foco");
		}
	}
	//se activa cuando la ventana pierde 
	public void windowLostFocus(WindowEvent e)
	{
		if(e.getSource()==marco1) //getSource quien es el evento del origen ocurrido cual de los dos marcos genero
									//el evento
		{
			marco1.setTitle("");//al perder foco mostrara una cadena de caracteres vacio como titulo
		}						//es decir no mostrara nada y borrara el titulo de la ventana q pierda el foco
		else 
		{
			marco2.setTitle("");
		}
	}
	
	//variables de tipo objeto declaradas dentro de la clase y puedan utilizarce en cualquier metodo
	eventoFocoVentana marco1;
	eventoFocoVentana marco2;
}
