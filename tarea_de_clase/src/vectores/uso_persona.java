package vectores;

import java.util.Scanner;

public class uso_persona
{

	public static void main(String[] args)
	{
		Scanner entrada=new Scanner(System.in);
		
		//instancia de clase persona
		persona miclase []=new persona[3];
		
		String nombre[]=new String[3];
		String apellido[]=new String[3];
		int dni[]=new int[3];
		String direccion[]=new String[3];
		int telefono[]=new int[3];
		
		for(int i=0;i<3;i++) 
		{
			System.out.print("ingrese el nombre");
			 nombre[i]=entrada.nextLine();
			
			System.out.println("ingrese el apellido");
			 apellido[i]=entrada.nextLine();
			
			System.out.println("ingrese el dni");
			 dni[i]=entrada.nextInt();
			 entrada.nextLine();
			
			System.out.println("ingrese el direccion");
			 direccion[i]=entrada.nextLine();
			
			System.out.println("ingrese el telefono");
			 telefono[i]=entrada.nextInt();
			entrada.nextLine();
			
			miclase[i]=new persona(nombre[i],apellido[i],dni[i],direccion[i],telefono[i]);
		}
		
		for(persona e:miclase) 
		{
			e.dameDatos();
		}

	}

}
