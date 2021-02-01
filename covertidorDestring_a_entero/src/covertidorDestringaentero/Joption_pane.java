package covertidorDestringaentero;

import javax.swing.JOptionPane;

public class Joption_pane
{
	public static void main (String[] args) 
	{
		String nombre_usuario=JOptionPane.showInputDialog("introduzca el nombre");//este metodo devuelve siempre un String
		//almacenar la edad se usa string ya que con Int da error porque devuvlve siempre un entero JOptionPne
		String edad=JOptionPane.showInputDialog("introduzca la edad");
		//convertidor de variable edad tipo String a INT dentro de la variable edad1
		int edad1=Integer.parseInt(edad);
		//imprimimos mensaje con los datos almacenados en las variables                                                               //muestra un icono
		JOptionPane.showMessageDialog(null, "tu nombre es " + nombre_usuario + " el año que viene tendras " + (edad1+1) + JOptionPane.INFORMATION_MESSAGE);
		
	}
	

}
