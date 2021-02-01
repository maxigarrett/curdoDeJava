import java.util.Scanner;

public class imprimir_por_consola_numAlmacenados
{

	public static void main(String[] args) 
	{
		int num[]=new int[5];
		Scanner scanner=new Scanner(System.in);
		for(int i=0;i<5;i++) 
		{
			System.out.println("llene el vector");
			num[i]=scanner.nextInt();
		}
		for(int j=0;j<5;j++)
		{
			System.out.print(" "+ num[j]);
			
		}
	}

}
