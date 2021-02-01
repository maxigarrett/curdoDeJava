import java.util.Scanner;

public class mayoromenor
{

	public static void main(String[] args)
	{
		Scanner entero=new Scanner(System.in);
		System.out.println("ingrese la edad");
		int edad=entero.nextInt();
		if(edad>=21) 
		{
			System.out.println("usted tiene " + edad + " de edad y es mayor o igual a 21");
		}
		else 
		{
			System.out.println("su edad es menor a 21");
		}

	}

}
