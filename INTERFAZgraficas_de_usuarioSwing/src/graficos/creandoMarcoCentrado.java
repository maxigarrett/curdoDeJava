package graficos;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class creandoMarcoCentrado 
{

	public static void main(String[] args)
	{
		marcocentrado mimarco=new marcocentrado();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
		mimarco.setTitle("ventana");
		
	}

}
class marcocentrado extends JFrame
{
	public marcocentrado() 
	{
		//se comunica con el sistema nativo de ventana
			Toolkit mipantalla= Toolkit.getDefaultToolkit();
			Dimension tamañopantalla=mipantalla.getScreenSize();//almacenamos la resolucion de pantalla donde se ejecuta el programa
			
			int altura= tamañopantalla.height;//campos de clase que permite obtener la altura de la pantalla
			int ancho=tamañopantalla.width;//ancho
			
			setSize(ancho/2, altura/2);//mitad de altura y mitad de ancho de la pantalla es el frame
			setLocation(ancho/4,altura/4);//coloca en el centro
			Image miicono=mipantalla.getImage("src/graficos/icono.JPG");//metodo para buscar ubicacion de imagen
			                                                       //admite formato jpg,gif
			setIconImage(miicono);//coloca la imagen en el frame
			
	}
}