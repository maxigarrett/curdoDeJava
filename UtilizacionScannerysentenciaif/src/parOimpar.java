import java.util.Scanner;
public class parOimpar 
{

	public static void main(String[] args)
	{
		//objeto de tipo scaner
		Scanner numero=new Scanner(System.in);
		System.out.println("ingrese un numero para saber si es par o impar");
		int num=numero.nextInt();
		if(num%2==0) 
		{
			System.out.println("el numer: " + num + " es par");
		}
		else 
		{
			System.out.println("el numer: " + num + " es impar");
		}

	}

}
