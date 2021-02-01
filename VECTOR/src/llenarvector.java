import java.util.Scanner;

public class llenarvector 
{
	public static void main(String[] ars) 
	{
		int vec[]=new int[4];
		Scanner scanner=new Scanner (System.in);
		for(int i=0;i<4;i++) 
		{
			System.out.printf("llene el vector %d\n",i+1);
			vec[i]=scanner.nextInt();
		}
	}

}
