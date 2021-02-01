package try_catch;

import javax.swing.JOptionPane;

public class ejemplo3_clausula_throw
{

	public static void main(String[] args) 
	{
		String elEmail=JOptionPane.showInputDialog("introduce el email");
		
		//capturamos el error
		try 
		{
			examinaEmail(elEmail);
		}
		catch(ArrayIndexOutOfBoundsException e) 
		{
			System.out.println("la direccion tiene menos de tres caracteres");
		}
	}
	
	//con throws le decimos que puede llegar a ver un error de tipo Exception
	static void examinaEmail(String mail) throws ArrayIndexOutOfBoundsException
	{
		int arroba=0;
		boolean punto=false;
		
		//creamos nuestra escepcion porque el programa pide que el email tenga punto y coma pero si solo
		//en el email poneos un punto y una coma funciona y no tiene sentido porque el email lleva mas q eso
		
		if(mail.length()<=3) 
		{
			//ahora creamos el error si el email es menor a tres caracteres ese error de tipo excepcion
			//tiene que exixstir pero falta capturar el error el error se crea con trow que crea el error
			//donde querramos que ocurra osea en un lugar en concreto a diferencia de trows
			throw new ArrayIndexOutOfBoundsException();
			
			//es lo mismo hacer esto
			/*ArrayIndexOutOfBoundsException miEsepcion=new ArrayIndexOutOfBoundsException
			throw miEsepcion;*/		
		}
		//si todo sale bien lo encerramos en el else
		else 
		{
		for(int i=0;i<mail.length();i++) 
		{
			if(mail.charAt(i)=='@') 
			{
				arroba++;
			}
			if(mail.charAt(i)=='.') 
			{
				punto=true;
			}
		}
		if(arroba==1&&punto==true) 
		{
			System.out.println("email correcto");
		}
		else 
		{
			System.out.println("email incorrecto");

		}
	}//else
	}
}


