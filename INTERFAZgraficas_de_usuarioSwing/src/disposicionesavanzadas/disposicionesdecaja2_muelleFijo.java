package disposicionesavanzadas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class disposicionesdecaja2_muelleFijo 
{

	public static void main(String[] args) 
	{
		marcoMuelle2 mimarco=new marcoMuelle2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);


	}

}



class marcoMuelle2 extends JFrame
{
	public marcoMuelle2() 
	{
		setBounds(300,200,1000,300);
		
		laminaMarco2 milamina=new laminaMarco2();
		add(milamina);
	}
}

class laminaMarco2 extends JPanel
{
	public laminaMarco2() 
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
		
		//construimos muelle rigido solo de un valor es decir los dos extremos solo se estiran 
		//y al de parametros de uno solo junta la separacion de botones y deja los extemos en este caso
		// elasticos ya que  los dos metodos el primero y ultimo lo dejamos con el primer muelle
		Spring muelleRigido=Spring.constant(80);
		
		//hay que colocar los muelles entre los botones empezando antes de el borde del frame
		//pasando al sigiente boton y al siguiente hasta el tercero y el borde del otro extremo del frame
		//este metodo pertenece a SPringLayout por parametro pide String,component,int,String,component
		midisp.putConstraint(SpringLayout.WEST, boton1, mimuelle, SpringLayout.WEST, this);
		midisp.putConstraint(SpringLayout.WEST, boton2, muelleRigido, SpringLayout.EAST, boton1);
		midisp.putConstraint(SpringLayout.WEST,boton3, muelleRigido, SpringLayout.EAST, boton2);
		midisp.putConstraint(SpringLayout.EAST,this, mimuelle, SpringLayout.EAST, boton3);

	}
}