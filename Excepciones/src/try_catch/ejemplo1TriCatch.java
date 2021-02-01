package try_catch;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class ejemplo1TriCatch 
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
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		//el programa termina mal despues de try catch porque lanza un error de tipo nullPointerWxception
		//si no se encuentra la imagen y no ereda de IOException sino de RunTimeException asique le decimos
		//entonces si la variable no esta iniciada se considera nula por lo que el programa se cae asiq
		//aremos un if antes de hacer todo que pinte un mensaje en el marco en caso de no encontrar la imagen
		if(imagen==null) 
		{
			g.drawString("la imagen no se encuentra	", 10, 10);
		}
		//en caso de que se encuentre ponemos lo demas en un else aria lo del try	
		else 
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
		}//el else
	}
	private Image imagen;
}

