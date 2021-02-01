package graficos;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class multiplicadorDeImagen 
{

	public static void main(String[] args)
	{
		dibumarco mimarco=new dibumarco();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class dibumarco extends JFrame
{
	public dibumarco()
	{
		setTitle("imagen en marco");
		setSize(500,500);
		setLocation(300,200);
		laminadibu milamina=new laminadibu();
		add(milamina);
		setVisible(true);
	}
}

class laminadibu extends JPanel
{
	public laminadibu() 
	{
		try 
		{
			imagen=ImageIO.read(new File("src/graficos/icono4.JPG"));
		}
		catch(IOException e)
		{
			System.out.println("imagen no encontrada");
		}
	}
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		
		
		int anchoimagen=imagen.getWidth(this);//con el this hace referencia al objeto donde me encuentro
                                               //y estamos programando la lamina obtiene el ancho de imagen
		int alturaimagen=imagen.getHeight(this);//altura de imagen
		g.drawImage(imagen, 0, 0, null);
		
		
		for(int i=0;i<500;i++) 
		{
			for(int j=0;j<500;j++) 
			{
			  	g.copyArea(0, 0, anchoimagen, alturaimagen, anchoimagen*i, alturaimagen*j);//metodo para copiar imagen
			  	// los primeros cuatro parametros indica el tamaño y ubicacion de la imagen los otros dos para que
			  	//los copie uno al lado del otro por eso multiplicamos por alto y ancho
			}
		}
	}
	private Image imagen;
}