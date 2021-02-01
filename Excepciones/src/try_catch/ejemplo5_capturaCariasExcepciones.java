package try_catch;

import javax.swing.JOptionPane;

public class ejemplo5_capturaCariasExcepciones 
{

	public static void main(String[] args) 
	{
		try 
		{
			division();
		}
		//utilisamos varios catch para capturar los diferentes errores el primer catch es por si el usuario
		//introduce un 0 para divir el primer numero ya introducido y el segundo catch por si introduce un 
		//String cosa que el programa no pide
		catch(ArithmeticException e) 
		{
			System.out.println("no se puede divisir por 0");
			
		}
		catch(NumberFormatException e) 
		{
			System.out.println("no has introducido un numero entero");
			
			//System.out.println(e.getMessage());//informa al usuario lo q introdujo y porque se produjo el error
			
			
			//este metodo devuelve la clase a la que pertenece el error y getName devuelve el nombre
			System.out.println("se ah generado un error de este tipo: " + e.getClass().getName());
			
		}
	}
	
	static void division() 
	{
		int num1=Integer.parseInt(JOptionPane.showInputDialog("introduce el dividendo"));
		int num2=Integer.parseInt(JOptionPane.showInputDialog("introduce el divisor"));
		
		System.out.println("el resultado es: " + num1/num2);
	}

}
