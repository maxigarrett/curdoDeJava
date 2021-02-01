package parcial;

import java.util.Scanner;

public class uso_paciente {

	public static void main(String[] args)
	{
		Scanner entrada=new Scanner(System.in);
		
		clase_paciente mipaciente[]=new clase_paciente[3];
		
		int nroPaciente[]=new int[3];
		int edad[]=new int[3];
		String nombre[]=new String[3];
		String apellido[]=new String[3];
		String direccion[]=new String[3];
		
		for(int i=0;i<mipaciente.length;i++) 
		{
			System.out.println("ingrese numero de paciente");
			nroPaciente[i]=entrada.nextInt();
			
			System.out.println("ingrese edad");
			edad[i]=entrada.nextInt();
			entrada.nextLine();
			
			System.out.println("ingrese nombre");
			nombre[i]=entrada.nextLine();
			
			System.out.println("ingrese el apellido");
			apellido[i]=entrada.nextLine();
			
			System.out.println("ingrese direccion");
			direccion[i]=entrada.nextLine();
			
			mipaciente[i]=new clase_paciente(nroPaciente[i],edad[i],nombre[i],apellido[i],direccion[i]);
		}
		
		for(clase_paciente e:mipaciente) 
		{
			e.muestraPaciente();
		}

	}

}
