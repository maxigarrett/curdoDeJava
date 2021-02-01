package distrivucionBotones;

import java.awt.Button;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.JFrame;

public class ventana3 extends JFrame
{
	private Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
	
	public ventana3()
	{
		super("ventana 3");
		setLayout(new GridLayout(3,3));//metodo que divide los botones o celdas de n columnas por m filas(3,3)
		
		b1= new Button("boton 1");
		add(b1);
		
		b2= new Button("boton 2");
		add(b2);
		
		b3= new Button("boton 3");
		add(b3);
		
		b4= new Button("boton 4");
		add(b4);
		
		b5= new Button("boton 5");
		add(b5);
		
		b6= new Button("boton 6");
		add(b6);
		
		b7= new Button("boton 7");
		add(b7);
		
		b8= new Button("boton 8");
		add(b8);
		
		b9= new Button("boton 9");
		add(b9);
		
		setSize(300,300);
		setVisible(true);
	
	}
	public static void main(String[] args) 
	{
		ventana3 v3=new ventana3();
		v3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v3.setLocation(300,300 );
		v3.setTitle("botones");
	}
}
