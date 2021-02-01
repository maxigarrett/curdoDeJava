package botoneslayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class posiciondeBotones
{

	public static void main(String[] args) 
	{
		Marco_Layout mimarco=new Marco_Layout();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

class Marco_Layout extends JFrame
{
	public Marco_Layout() 
	{
		setBounds(700,200,600,400);
		Panel_layout mipanel=new Panel_layout();
		
		//intaciamos Flowlayout para utilizar un constructor que aline a la izquierda
		
		/*FlowLayout alineacion=new FlowLayout(FlowLayout.LEFT);//parametros para que aline a la izquierda
		
		mipanel.setLayout(alineacion);//utilizamos el objeto creado de Panel_layout donde llamamos a 
	 	                        //los botones y le pasamos por parametros la alineacion que ya construimos
		
		//intanciarlo mas abreviado
		  mipanel.setLayout(new FlowLayout(FlowLayout.LEFT));*/
		
		
		
		//otro constructor  //ceparacion horizontal(100) entre botones y el marco y vertical(50) entre botones y marco
		mipanel.setLayout(new FlowLayout(FlowLayout.CENTER,100,50));
		
		//agregamos lamina al marco
		add(mipanel);
		
		//el metodo setLayout sirve para ver que dispocicion va a tener el boton osea un flowlayout,
		//borderlayout,etc
	}
}


class Panel_layout extends JPanel
{
	public Panel_layout()
	{
		//se puede modificar las posiciones de los botones directamente en la lamina
		setLayout(new FlowLayout(FlowLayout.CENTER,100,50));
		JButton boton1=new JButton("amarillo");
		add(boton1);
		//de otra forma para crear y agregar botones
		add(new JButton("rojo"));
		add(new JButton("azul"));
	}
}