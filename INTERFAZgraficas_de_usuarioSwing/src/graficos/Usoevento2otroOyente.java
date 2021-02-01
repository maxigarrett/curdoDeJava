package graficos;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Usoevento2otroOyente 
{

	public static void main(String[] args)
	{
		marcoboton mimarco=new marcoboton();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}


class marcoboton extends JFrame
{
	marcoboton()
	{
		setTitle("marco color evento");
		setBounds(400,200,500,300);
		laminaboton milamina=new laminaboton();
		add(milamina);
	}
}

class laminaboton extends JPanel
{
	//creamos botones y lo llamamos azul,amarillo,rojo
	JButton botonazul=new JButton("azul");
	JButton botonamarillo=new JButton("amarillo");
	JButton botonrojo=new JButton("rojo");
	
	public laminaboton() 
	{
		//agregamos botones a la lamina
		add(botonazul);
		add(botonamarillo);
		add(botonrojo);
		
		//instancia perteneciente a la clase colorfondo
		colorfondo azul=new colorfondo(Color.BLUE);
		colorfondo amarillo=new colorfondo(Color.YELLOW);
		colorfondo rojo=new colorfondo(Color.RED);
		
		//desencadenante de evento es lo mismo decir hacer clic con metodo ActionListener
		//y pide por parametro al objeto oyente  que seria el nombre de las instancias de la clase que decidimos
		//que fuera la oyente 
		botonazul.addActionListener(azul);
		botonamarillo.addActionListener(amarillo);
		botonrojo.addActionListener(rojo);
		Toolkit.getDefaultToolkit().beep();
	}
	
	
	//clase interna esta dentro de laminaboton y solo esta clase puede acceder a la clase interna
	private class colorfondo implements ActionListener//tranformamos en ayoente ha otra clase no a la lamina
	{  
		private Color color;//variable de tipo Color
		public colorfondo(Color color)//parametro de tipo Color
		{
			this.color=color;//lo que pasemos por parametros se almacenara en la variable color
		}
		public void actionPerformed(ActionEvent e) //metodo obligarorio de la interfaz actionlistener que recibe 
		                                          //por parametros un objeto(e) de tipo (ActionEvent)
		{
			setBackground(color);//pinta la lamina del color que le pacemos por parametro 
		}
	}
}

