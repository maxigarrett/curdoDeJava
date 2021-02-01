package try_catch;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class ejemplo6_clausulaFinally
{

	public static void main(String[] args)
	{
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("elige una opcion: \n 1.cuadrado \n 2.rectangulo \n 3.triangulo \n 4.circulo");
		
		try 
		{
			figura=entrada.nextInt();
		//esto permite cerrar la conexion y no consumir recursos pero si esta dentro del try y ocurre un 
		//error ingina el try y por lo tanto tambien entrada.close(); y no cierra la coneccion
		//entonces tenemos que asegurarnos de que esa instruccion se ejecyte siempre tanto si ocurre o no
		//el error
			
		//entrada.close();
		}
		catch(Exception e) 
		{
			System.out.println("ocurrio un error");
			
		}
		//con finally no aseguramos que un codigo se ejecute si osi no importa el error
		//y dentro cerramos la coneccion con consola entrada.close();
		finally 
		{
			entrada.close();
		}
		switch(figura) 
		{
			case 1:
			{
				int lado=Integer.parseInt(JOptionPane.showInputDialog("introduce el lado"));
				System.out.println(Math.pow(lado, 2));

				break;
			}
			
			case 2:
			{
				int base=Integer.parseInt(JOptionPane.showInputDialog("introduce base"));
				int altura=Integer.parseInt(JOptionPane.showInputDialog("introduce a la altura"));
				
				System.out.println("el area del triangulo es: " + base*altura);

				break;
			}
			
			case 3:
			{

				int base=Integer.parseInt(JOptionPane.showInputDialog("introduce base"));
				int altura=Integer.parseInt(JOptionPane.showInputDialog("introduce a la altura"));
				
				System.out.println("el area del triangulo es: " + (base*altura)/2);
				break;
			}
			
			case 4:
			{
				int radio=Integer.parseInt(JOptionPane.showInputDialog("introduce el radio"));
				System.out.println("el area del circulo es: ");
				System.out.println(Math.PI*(Math.pow(radio, 2)));
				break;
			}
			default:
			{
				System.out.println(" la ocion no es correcta");
			}
			
			
		}
		System.out.println("\n");
		//------------------------------------------------------------------------------------------
		int altura=Integer.parseInt(JOptionPane.showInputDialog("introduce tu altura en cm"));
		
		System.out.println("si eres hombre tu peso ideal es: " + (altura-110) + " kg");
		System.out.println("si eres mujer tu peso ideal es: " + (altura-120) + " kg");
	}
	
	private static int figura;
}
