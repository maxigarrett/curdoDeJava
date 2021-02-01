package covertidorDestringaentero;

import javax.swing.JOptionPane;

public class convertidor_StringaDouble
{

	public static void main(String[] args) 
	{ 
		//duvulve un string
		String num1=JOptionPane.showInputDialog("introduzca un numero");
		// pasamos el String a double o decimal
		double num2=Double.parseDouble(num1);
		System.out.print("la raiz de "+ num2 + "es ");
		// imprime por consoa la raiz de num2 que se expresa como math.sqrt(num2) la clase math es estatico por eso va adelante del metodo
		System.out.printf(" %1.2f", Math.sqrt(num2));

	}

}
