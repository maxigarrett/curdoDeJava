package graficos;

import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class eventosDeFoco 
{

	public static void main(String[] args)
	{
		MarcoFoco mimarco=new MarcoFoco();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

class MarcoFoco extends JFrame
{
	public MarcoFoco() 
	{
		setBounds(400,300,400,400);
		add(new LaminaFoco());//agregamos la lamina
	}
}

class LaminaFoco extends JPanel//creacion de lamina
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		setLayout(null);//anulamos(null) la posicion por defecto de laubicacion de lo que coloquemos en el frame
		
		marco1=new JTextField();//posee varios constructores por eso hay que instanciar uno que necesitamos y que no tiene parametros
		marco2=new JTextField();
		
		//le damos dimencion y ubicacion a los cuadros creados
		marco1.setBounds(120,10,150,20);
		marco2.setBounds(120,50,150,20);
		
		//agregamos los cuadros a la lamina
		add(marco1);
		add(marco2);
		oyentefoco mifoco=new oyentefoco();//instanciamos clase interna oyentefoco
		marco1.addFocusListener(mifoco);//ponemos a la escucha a cuadro1
		
		
	}
	
	//clase oyente e interna y puede acceder a las variables de la clase que engloba esta
	private class oyentefoco implements FocusListener
	{
		//se invoca al ganar foco
		public void focusGained(FocusEvent e)
		{
			
		}
		//metodo que se activa al perder el foco
		public void focusLost(FocusEvent e)
		{
			System.out.println("has perdido el foco");//al estar solo marco1 a la escucha cuando lo dejamos
													//de seleccionar y pasa a vista secundaria dara el mensaje
		
			String email=marco1.getText();//permite capturar el texto que se almacenara en marco1 y se guarda
								          //en la variable email el metodo pertenece a JTexfiled
			
			boolean comprobacion=false;
			
			for(int i=0;i<email.length();i++)//recorremos todos los caracteres almacenados en email 
			{
				if(email.charAt(i)=='@') //si se encuentra el arroba en el cuadro de marco1 secambia la
					                   //variable a true metodo getchaAt(i)recorre y evalua todos los caracteres posicion a posicion
				{
					comprobacion=true;
				}
			}
			if(comprobacion==true)
			{
				System.out.println("usuario correcto");
			}
			else 
			{
				System.out.println("usuario incorrecto");
			}
		}
		
	}
	
	//JTextField agrega un cuadro de texto en la lamina
	JTextField marco1;  
	JTextField marco2;
}


