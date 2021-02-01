package graficos;

import java.awt.GraphicsEnvironment;

import javax.swing.JOptionPane;

public class pruebaDeLetraEnNuestroSistOperativo 
{

	public static void main(String[] args)
	{
		String fuente=JOptionPane.showInputDialog("introduce fuente");
		boolean estalafuente=false;
		
		
		//metodo que en el array de tipo String almacena todas las letras o tipos de fuentes que tengo istaladas en el ordenador
		String[] nombreDeFuentes=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		//recorremos el array de tipo string donde esta almacenado el tipo de letra
		for(String nomdefuente:nombreDeFuentes) 
		{
			if(nomdefuente.equalsIgnoreCase(fuente))
			{
				estalafuente=true;
			}
		}
		if(estalafuente==true) 
		{
			System.out.println("fuente instalada");
		}
		else 
		{
			System.out.println("fuente no encontrada");
		}
	}

}
