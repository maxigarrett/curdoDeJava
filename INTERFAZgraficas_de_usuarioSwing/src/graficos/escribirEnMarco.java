package graficos;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class escribirEnMarco
{

	public static void main(String[] args) 
	{
		MarcoConTexto mimarco=new MarcoConTexto();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setTitle("ventana con escritura");
		mimarco.setVisible(true);
		
	}

}

class MarcoConTexto extends JFrame
{
	public MarcoConTexto()
	{
		setBounds(400,200,600,450);
		Lamina milamina=new Lamina();//instanciamos la clase lamina
		add(milamina);//con metodo add ponemos los metodos que se guardaron en mi lamina en el frame
		              //sin add no aparece el String dentro de la lamina
		
	}
	
}

class Lamina extends JPanel //hereda de paquete javax.swing
{
	
	//sobreescribe el metodo que hace lo suyo por defecto
	public void paintComponent(Graphics g) //metodo que ereda de la clase JPanel y el parametro de tipo Graphics
	                                         //es del paquete java.awt
	{
        		
		g.drawString("estamos aprendiendo swing", 250, 250);//texto que parece adentro del frame y los numeros
		                                                     //son la ubicacion del texto dentro del marco
		
	}
}