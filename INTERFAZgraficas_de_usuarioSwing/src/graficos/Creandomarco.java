package graficos;

import java.awt.Frame;
import javax.swing.*;

public class Creandomarco 
{

	public static void main(String[] args)
	{
		mimarco marco1=new mimarco();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cierra la aplicacion cuando cierra el frame
		marco1.setTitle("ventana");//metodo para darle nombre a la ventana o frame
		
	}

}

class mimarco extends JFrame
{
	public mimarco() 
	{
		//setSize(500,300);//darle una dimension
		
		
		setBounds(500,300,250,250);//este  metodo dimeciona y ubica la ventana  los primeros dos num ubica
		                           //los otros dos (250,250) dimensiona la ventana
		
		setVisible(true);//hacerlo visible
		
		
		//setLocation(300,300);//ubicacion del frame a la hora de ejecutar cambia de lugar
		
		setResizable(false);//metodo que si es falso no permite agrandar con el raton la ventana o frame
		
		
		setExtendedState(Frame.MAXIMIZED_BOTH);//agranda la pantalla completa
		
		
		
		
		
	}
}