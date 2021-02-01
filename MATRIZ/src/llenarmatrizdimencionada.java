import java.util.Scanner;

public class llenarmatrizdimencionada 
{

	public static void main(String[] args)
	{
		//dimencion de matriz
		int matriz[][]=new int[3][4];
		Scanner scanner=new Scanner(System.in);
		for(int f=0;f<3;f++) 
		{
			for(int c=0;c<4;c++) 
			{
				//cargamos la matriz
				System.out.printf("llene la matriz %d %d \n",f,c);
				 matriz[f][c]=scanner.nextInt();
				
			}
		}
		//imprimo matriz
		for(int f=0;f<3;f++) 
		{
			for(int c=0;c<4;c++) 
			{
				System.out.print(" \t "+ matriz[f][c]);
					
			}
			System.out.print("\n");
		}
	}

}
