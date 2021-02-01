package tarea_de_clase;

import javax.swing.*;

public class joptinpane 
{

	public static void main(String[] args)
	{
		int edad=Integer.parseInt(JOptionPane.showInputDialog("ingrese su edad"));
		String nom=JOptionPane.showInputDialog("introduce el nombre");
		
		JOptionPane.showMessageDialog(null,"tu nombre es: "+ nom + " el año que viene tendras "+(edad+1));
      
	}

}
