package vectores;

import java.util.Scanner;

public class uso_empleado 
{

	public static void main(String[] args) 
	{
		Scanner entrada=new Scanner(System.in);
		
		Empleado[] miempleado=new Empleado[2];
		
		String[] nombre=new String[2];
		String[] apellido=new String[2];
		int [] dni=new int[2];
		String[] direccion=new String[2];
		int[] telefono=new int[2];
		int[] legajo=new int[2];
		
		
		for(int i=0;i<miempleado.length;i++) 
		{
			System.out.println("ingrese el nombre");
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
			
			System.out.println("ingrese el legajo");
			legajo[i]=entrada.nextInt();
			entrada.nextLine();
			
			miempleado[i]=new Empleado(nombre[i],apellido[i],dni[i],direccion[i],telefono[i],legajo[i]);
		}
		
		for(Empleado e:miempleado) 
		{
			e.mostrarempleado();
			
		}

	}

}
