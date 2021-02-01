package disposicionesavanzadas;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class disposicionDeCaja1
{

	public static void main(String[] args) 
	{
		Marcodisp mimarco=new Marcodisp();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
		

	}

}


class Marcodisp extends JFrame
{
	public Marcodisp() 
	{
		setTitle("marco con caja");
		setBounds(600,200,400,300);
		
		
		
		//creamos los dos comoponentes que van a estar en la primera caja
		JLabel rotulo1=new JLabel("nombre");
		JTextField texto1=new JTextField(10);//el 10 es el largo
		
		//establecemos el tamaño maximo que puede tener el texto1 para que no halla problemas
		//para cuando redimencionemos el cudro
		texto1.setMaximumSize(texto1.getPreferredSize());
		
		//creamos un objeto de tipo box que crea una caja horizontal
		Box cajaH1=Box.createHorizontalBox();
		
		//ponemos dentro de la caja creada el label creado
		cajaH1.add(rotulo1);
		
		//metodo que deja espacio que vamos a dejar entre el label y el cuadro de texto
		cajaH1.add(Box.createHorizontalStrut(10));
		//agregamos el texto a la caja
		cajaH1.add(texto1);
		
		//creamos segundo contenedor
		JLabel rotulo2=new JLabel("contraseña");//creamos una label
		JTextField texto2=new JTextField(10);//creamos un cuadro de texto
		
		texto2.setMaximumSize(texto2.getPreferredSize());//dimencionamos al maximo el cuadro de texto
		
		Box cajaH2=Box.createHorizontalBox();//creamos unacaja horizontal
		cajaH2.add(rotulo2);//agregamos a la caja el label
		cajaH2.add(Box.createHorizontalStrut(10));//espacio entre label y cuandro de texto
		cajaH2.add(texto2);//agregamos a la segunda caja el cuadro de texto
		
		JButton boton1=new JButton("OK");
		JButton boton2=new JButton("CANCELAR");
		
		//creamos siguiente contenedor
		Box cajaH3=Box.createHorizontalBox();
		cajaH3.add(boton1);
		cajaH3.add(Box.createGlue());
		cajaH3.add(boton2);
		
		//creamos caja vertical
		Box cajavertical=Box.createVerticalBox();
		//agregamos los contenedores horizontales a un box vertical
		cajavertical.add(cajaH1);
		cajavertical.add(cajaH2);
		cajavertical.add(cajaH3);
		
		add(cajavertical,BorderLayout.CENTER);
	
	
		
	}
}
	

class laminadisp extends JPanel
{
	public laminadisp()
	{
		
	}
}