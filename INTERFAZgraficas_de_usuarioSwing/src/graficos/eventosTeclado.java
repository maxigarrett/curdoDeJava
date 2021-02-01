package graficos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class eventosTeclado 
{

	public static void main(String[] args) 
	{
		MarcoTeclas mimarco=new MarcoTeclas();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

class MarcoTeclas extends JFrame 
{
	MarcoTeclas()
	{
		setBounds(400,300,400,400);
		EventoDeTeclado evento=new EventoDeTeclado();//le indicamos al marco cual es el objeto ayente
		addKeyListener(evento);//lo ponemos a la escucha a quien??.... a evento que fuel el objeto de instancia
	}	
}

//objeto oyente
class EventoDeTeclado implements KeyListener
{

	
	public void keyTyped(KeyEvent e)
	{
	}

	
	public void keyPressed(KeyEvent e)//metodo que se activa o se invoca cuando se preciona una tecla
	                              //todo sucede dentro de la clase tipo keyevent que esta por parametro
	                              // y se almacena dentro del objeto de ese tipo que es e y con esa letra accedemos a todos los eventos que sucede al precionar esa tecla
	{
		//int codigo=e.getKeyCode();//metodo que busca el codigo de la letra precionada
		//System.out.println("el codigo de la letra es: " + codigo);
		
		char codigo=e.getKeyChar();
		System.out.print(codigo);
	}

	
	public void keyReleased(KeyEvent e) 
	{
	}
	
}