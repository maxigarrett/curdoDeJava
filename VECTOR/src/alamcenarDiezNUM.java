import java.util.Scanner;

public class alamcenarDiezNUM 
{

	public static void main(String[] args) 
	{
		//defino un arrays de 10 posiciones
		int vector[]=new int [10];
		
		// el sacanner para leer por teclado
		Scanner scanner=new Scanner(System.in);
		System.out.println("digite los valores");
		int v=scanner.nextInt();
		int i=0;
		// mientras que i sea distinto de 0 y o and i sea menor a v(numero digitado por el usuario)
		while(v!=0&&i<10) 
		{
			//asigna v en vector[i] y luego incrementa el valor i
			vector[i++]=v;
			//leo el siguiente valor
			System.out.println("digite los valores");
			 v=scanner.nextInt();
			
		}
		for(int j=0;j<i;j++) 
		{
			System.out.println(vector[j]);
		}

	}

}
