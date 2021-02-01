import java.util.Scanner;

public class vectorString 
{

	public static void main(String[] args)
	{
		//mostar dia de la semana usando un array
		String dias[]= {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("ingrese el dia de la semana (numero): ");
		int dia=scanner.nextInt();
		if(dia<=dias.length)
		{
			//los arrays se enumeran desde 0
			System.out.println(dias[dia-1]);
		}
		else 
		{
			System.out.println("dia incorrecto");
		}

	}

}
