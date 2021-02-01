package try_catch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ejemplo2_excepcionesNoComprobadas
{

	public static void main(String[] args)
	{
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("que desea hacer elija la opcion");
		System.out.println("1.introducir datos");
		System.out.println("2.salir");
		
		
		int desicion=entrada.nextInt();
		
		if(desicion==1) 
		{
			pedirdatos();
		}
		
		else 
		{
			if(desicion==2) 
			{
				System.out.println("adios");
				System.exit(0);

			}
		}
		entrada.close();
	}
	
//si el usuario ponen en el int que es edad un String causa u error InputMismatchException
	//y con throws lo capturamos  justo en el metodo donde esta el codigo es decir si el programa
	//va bien se ejecutara pero si el usuario se confunde y pone un String en su edad capturaremos
	//el error osea generara un error de tipo Exception de tipo InputMismatchException y lo capturamos
	//con un try catch aunque no nos obligue
static void pedirdatos() throws InputMismatchException
{
	//ponemos dentro del try lo que tiene que hacer si todo va bien
	try 
	{
	Scanner entrada=new Scanner(System.in);
	System.out.println("introduce el nombre");
	String nombre=entrada.nextLine();
	
	System.out.println("introduce la edad, por favor");
	int edad=entrada.nextInt();
	
	System.out.println("hola: " + nombre+" y tu edad el proximo año sera: "+ (edad+1));

	entrada.close();
	}
	//capturamos el error y lo almacenamos en la e.
	//en la jeraquia de herencia esta Exception despuen RunTimeEXception y el error que capturamos
	//es decir si dentro de los parentesis ponemos Exception sigue funcionando
	catch(InputMismatchException e) 
	{
		System.out.println("introduce  la edad con numeros,no cadena de caracteres");

	}
	System.out.println("hemos terminado gracias");
	
}
	
}


