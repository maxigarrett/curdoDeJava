package utilisacionDeScanner;
import java.util.Scanner;

public class scanner 
{
	public static void main(String[] args) 
	{
		//al darle ejecutar al programa lee la primera linea y sabe que la variable entrada es de tipo objeto osea de tipo scanner
		Scanner entrada=new Scanner(System.in);/*new scanner contstructor y (system.in)parametro o argumento
		 que toma como origen la consola del sistema que es system pero para introducir informacion que seria System.in*/
		System.out.println("introduce tu nombre");
		String nombre_usuario=entrada.nextLine();/*variable de tipo string llamada nombre_usuario y va a ser igual entrada(objeto perteneciente a la clase Scanner)
		nextLine es el  metodo. es decir que entrada se queda a la espera hasta que introduzcamos el nombre (nextLine) que se almacenara en nombre_usuario*/
		System.out.println("introduzca la edad");
		int edad=entrada.nextInt();
		System.out.println("hola " + nombre_usuario + " el año que viene tendras " + (edad+1) + " años");
	}

}
