package botoneslayout;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class borde_layut2
{

	public static void main(String[] args) 
	{
		marcoborde2 mimarco=new marcoborde2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);


	}

}

//creamos el marco
class marcoborde2 extends JFrame
{
	public marcoborde2()
	{
		//le damos localizacion y dimencion al frame
		setBounds(900,200,400,200);
		
		//instancia de la lamina
		bordelamina milamina=new bordelamina();
		add(milamina,BorderLayout.NORTH);
		
		//instanciamos otra lamina
		bordeslamin milamina1=new bordeslamin();
		add(milamina1,BorderLayout.SOUTH);
		
		
		borde mibordecito=new borde();
		add(mibordecito,BorderLayout.CENTER);
		
		
		
		
	//	BorderLayout borde=new BorderLayout();
	//milamina1.setLayout(borde);
		
		
		//ponemos las laminas en norte y sur porque sino se machacan y parece sola la segunda
	}
}


//creamos la lamina
class bordelamina extends JPanel
{
	public bordelamina()
	{
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//creamos y agregamos los botones a la almina
		JButton boton1=new JButton("amarillo");
		add(boton1);     
		add(new JButton("rojo"));
		
	}
}

class bordeslamin extends JPanel
{
	public bordeslamin()
	{
		BorderLayout borde=new BorderLayout();
		setLayout(borde);
		
		add(new JButton("azul"),BorderLayout.WEST);//oeste
		add(new JButton("verde"),BorderLayout.EAST);//este
		add(new JButton("naranja"),BorderLayout.CENTER);//centro
	}
}


class borde extends JPanel
{
	public borde() 
	{
		BorderLayout bor=new BorderLayout();
		setLayout(bor);
		
		JButton boton=new JButton("botoncentro");
		add(boton,BorderLayout.CENTER);
	}
}