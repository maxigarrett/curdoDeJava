package botoneslayout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Border_layout
{

	public static void main(String[] args)
	{
		MarcoBorde mimarco=new MarcoBorde();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

//creamos el marco
class MarcoBorde extends JFrame
{
	public MarcoBorde()
	{
		//le damos localizacion y dimencion al frame
		setBounds(900,200,400,200);
		
		//instancia de la lamina
		LaminaBorder milamina=new LaminaBorder();
		add(milamina);
		
	}
}

//creamos la lamina
class LaminaBorder extends JPanel
{
	public LaminaBorder()
	{
		//con borderlayout le decimos en donde ubicar los botones osea al centro,norte,sur,este,oeste
		setLayout(new BorderLayout(10,10));//si pasamos 10,10 por parametro en el constructor llama a otr que hace separar los botones 10 pixeles
		
		//creamos y agregamos los botones a la almina
		JButton boton1=new JButton("amarillo");
		add(boton1,BorderLayout.NORTH);     //ponemos el boton amarillo al norte de la ventana
		add(new JButton("rojo"),BorderLayout.SOUTH);//boton rojo en la parte sur
		add(new JButton("azul"),BorderLayout.WEST);//oeste
		add(new JButton("verde"),BorderLayout.EAST);//este
		add(new JButton("naranja"),BorderLayout.CENTER);//centro
	}
}

