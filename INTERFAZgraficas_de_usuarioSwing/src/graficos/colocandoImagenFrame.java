package graficos;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class colocandoImagenFrame
{

	public static void main(String[] args)
	{
		MarcoImagen mimarco=new MarcoImagen();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setExtendedState(Frame.MAXIMIZED_BOTH);//agranda a tamaño completo la imagen
	}

}

class MarcoImagen extends JFrame
{
	public MarcoImagen() 
	{
		setTitle("imagen en marco");
		//setSize(500,500);
		setLocation(300,200);
		setVisible(true);
		LaminaImagen milamina=new LaminaImagen();
		add(milamina);
	}
}


class LaminaImagen extends JPanel
{
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		
		File miimagen=new File("src/graficos/icono3.JPG");//objeto de tipo file que guarda ruta de la imagen 
		
		try//significa intenta y va a intentar lo que se encuentra entre llaves 
		{
			imagen=ImageIO.read(miimagen);//metodo que lee la imagene que se encuentra en carpeta y pide por parametro un tipo file
		}
		catch(IOException e)//especifica tipo de escepcion que puede ocurrir dentro de los parentesis si no se encuentra
		{                   //el archivo especificado en la sentencia try
			
			System.out.println("la imagen no se encuentra");//imprime en consola si no se encuentra
		}
		
		
		
		g.drawImage(imagen, 0, 0, null);//metodo que permite dibujar la imagen en la lamina   null porque no necesitamos necesitar el observador de como va la imagen cargandose en el frame
	}
	private Image imagen;//almacenamos la imagen guradada en la carpeta
}