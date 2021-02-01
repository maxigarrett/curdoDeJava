package componenteSwingIntruduTexto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class areasDeTexto 
{

	public static void main(String[] args) 
	{
		MarcoArea mimarco=new MarcoArea();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}


class MarcoArea extends JFrame
{
	public MarcoArea()
	{
		setBounds(600,200,400,300);
		LaminaArea milamina=new LaminaArea();
		add(milamina);
	}
}


class LaminaArea extends JPanel
{
	public LaminaArea() 
	{
		JButton boton =new JButton("dale");
		miarea=new  JTextArea(8,20);//constructor que por parametro tiene ancho y largo
											//y creamos un area de texto dentro de la lamina
		
		add(miarea);//agreagamos en la lamina el area de texto creada 
		
		//instanciamos la segunda lamina creada
		laminaarea lamina=new laminaarea();
		add(lamina);
		miarea.setLineWrap(true);//permite que cuando llegye al limite del area de texto haga un salto de linea
		
		add(boton);
		
		gestionArea miarea=new gestionArea();
		boton.addActionListener(miarea);
		//es lo mismo decir : boton.addActionListener(new gestionArea());
	
	}
	
	//clase a la escucha del boton
	private class gestionArea implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			System.out.println(miarea.getText());
		}
	}
	
	private class laminaarea extends JPanel//segunda lamina
	{
		public laminaarea()
		{
	//creamos un SCroll o barra deslizante para que el cuadro de texto no se agrande si llegamos al limite
			JScrollPane areas=new JScrollPane(miarea);//le pasamos por parametro las dimensiones de el area ya creada
			add(areas);
		}
	}
	JTextArea miarea;
}

