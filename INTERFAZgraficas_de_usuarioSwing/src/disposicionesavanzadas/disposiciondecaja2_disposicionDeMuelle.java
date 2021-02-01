package disposicionesavanzadas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class disposiciondecaja2_disposicionDeMuelle 
{

	public static void main(String[] args)
	{
		marcoMuelle mimarco=new marcoMuelle();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}


class marcoMuelle extends JFrame
{
	public marcoMuelle() 
	{
		setBounds(300,200,1000,300);
		
		laminaMarco milamina=new laminaMarco();
		add(milamina);
	}
}

class laminaMarco extends JPanel
{
	public laminaMarco() 
	{
		
		
		JButton boton1=new JButton("boton1");
		JButton boton2=new JButton("boton2");
		JButton boton3=new JButton("boton3");
		
		//disposicion de muelle
		SpringLayout midisp=new SpringLayout();
		setLayout(midisp);
		add(boton1);
		add(boton2);
		add(boton3);
		
		//creamos el muelle
		Spring mimuelle=Spring.constant(0, 10, 100);
		
		//hay que colocar los muelles entre los botones empezando antes de el borde del frame
		//pasando al sigiente boton y al siguiente hasta el tercero y el borde del otro extremo del frame
		//este metodo pertenece a SPringLayout por parametro pide String,component,int,String,component
		midisp.putConstraint(SpringLayout.WEST, boton1, mimuelle, SpringLayout.WEST, this);
		midisp.putConstraint(SpringLayout.WEST, boton2, mimuelle, SpringLayout.EAST, boton1);
		midisp.putConstraint(SpringLayout.WEST,boton3, mimuelle, SpringLayout.EAST, boton2);
		midisp.putConstraint(SpringLayout.EAST,this, mimuelle, SpringLayout.EAST, boton3);

	}
}