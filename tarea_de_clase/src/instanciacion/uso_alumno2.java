package instanciacion;

import java.util.Scanner;

public class uso_alumno2 
{

	public static void main(String[] args)
	{
		//instancia de clase escanner llamada entrada
		Scanner entrada=new Scanner(System.in);
		
		//instanciamos la clase alumno y le decimos que va almacenarlo en un vector de 3 posiciones
		alumno Lista[]=new alumno[3];
		
		//a cada variable objeto le damos 3 posiciones en el vector
		String nombre[]=new String[3];
		String apellido[]=new String[3];
		int dni[]=new int[3];
		
		for(int i=0;i<3;i++) 
		{
			System.out.printf("ingrese el nombre del alumno [%d] \n", i+1);
			nombre[i]=entrada.nextLine();
			
			
			System.out.printf("ingrese el apellido del alumno [%d] \n", i+1);
			apellido[i]=entrada.nextLine();
			
			System.out.printf("ingrese el DNI del alumno [%d] \n", i+1);
			dni[i]=entrada.nextInt();
			entrada.nextLine();//para limpiar memoria buffer
			
			//almacenamos dentro de la instancia creda las variables ya almacenadas
			Lista[i]=new alumno(nombre[i],apellido[i],dni[i]);
		}
		
		
		
		for(int i=0;i<3;i++) 
		{
			Lista[i].imprimeAlumno();
		}
		
		//cerrar instancia scanner
		entrada.close();
	}

}
