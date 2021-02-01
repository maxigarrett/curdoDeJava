package try_catch;

import javax.swing.JOptionPane;

public class ejemplo4_creamosNuestrasPropiasExcepsionesUtilisandoEjemplo3 
{

	public static void main(String[] args)
	{
		String elEmail=JOptionPane.showInputDialog("introduce el email");
		
		try 
		{
			examinaEmail(elEmail);
		}
		catch(Exception e) 
		{
			System.out.println("la direccion no es correcta");
			
			//con este metodo pasa por consola la pila del error osea donde esta para dar pistas
			// a otro programador donde estamos capturando el error
			e.printStackTrace();
		}
	}

	
	//con throws le decimos que puede llegar a ver un error de tipo miExcepcion la clase que creamos 
		static void examinaEmail(String mail) throws miExcepcion
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
				
				//el mensaje sirve para cuando utilicemos el metodo printStackTrace();
				//para decir que error esta ocurriendo
				//por consola asi si otro programador se puede orientar si tiene que corregir
				//de ahi es porque es mejor con dos constructores un sin mensaje y otro con mensaje
				throw new miExcepcion("el email es demasiado corto, porque tiene menos de 3 caracteres");
				
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

//creamos nuestra propia clase para capturar una excepcion si el usuario pone menos de tres caracteres
		class miExcepcion extends Exception
		{
			//se recomienda usar dos constructores uno estandar y otro con un String
			public miExcepcion() 
			{
				
			}
			//el segundo le pasamos por parametro el String
			public miExcepcion(String msj_error) 
			{
				//llamamos al constructor de la clase padre y le pasamos por parametro lo que se almacena
				//en msj error este segundo cuando coloquemos con throw donde querramos al pasarle por 
				//parametros un mensaje llamara a este constructor y no al otro
				super(msj_error);
			}
		}



