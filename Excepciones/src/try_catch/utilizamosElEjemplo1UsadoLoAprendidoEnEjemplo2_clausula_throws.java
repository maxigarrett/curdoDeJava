package try_catch;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class utilizamosElEjemplo1UsadoLoAprendidoEnEjemplo2_clausula_throws 
{

	public static void main(String[] args)
	{
		dibumarco1 mimarco=new dibumarco1();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class dibumarco1 extends JFrame
{
	public dibumarco1()
	{
		setTitle("imagen en marco");
		setSize(500,500);
		setLocation(300,200);
		laminadibu1 milamina=new laminadibu1();
		add(milamina);
		setVisible(true);
	}
}

class laminadibu1 extends JPanel
{
	public laminadibu1() 
	{
		//try significa intentar es decir que intente hacer la linea de codigo puesta dentro
		try 
		{
			//clase ImageIO posee un metodo estatico llamado read que por parametro pide un File un archivo
			//que contenga la direccion  
			imagen=ImageIO.read(new File("bin/try_catch/icono4.jpg"));
		}
		//y si no puedes hacerlo es decir la imagen a buscar no se encuetra hace lo que esta en el catch
		catch(IOException e)
		{
			System.out.println("la imagen no se encuentra");
		}
	}
	public void paintComponent(Graphics g) throws NullPointerException
	{
		super.paintComponent(g);
		
		
		try 
		{
		int anchoimagen=imagen.getWidth(this);//con el this hace referencia al objeto donde me encuentro
                                               //y estamos programando la lamina obtiene el ancho de imagen
		int alturaimagen=imagen.getHeight(this);//altura de imagen
		g.drawImage(imagen, 0, 0, null);//metodo para dibujar
		
		
		for(int i=0;i<500;i++) 
		{
			for(int j=0;j<500;j++) 
			{
			  	g.copyArea(0, 0, anchoimagen, alturaimagen, anchoimagen*i, alturaimagen*j);//metodo para copiar imagen
			  	// los primeros cuatro parametros indica el tamaño y ubicacion de la imagen los otros dos para que
			  	//los copie uno al lado del otro por eso multiplicamos por alto y ancho
			}
		}
		}//cierra llave del try
		catch(NullPointerException e) 
		{
			g.drawString("no se ah podido cargar la imagen", 10, 10);
		}
	}
	private Image imagen;
}


