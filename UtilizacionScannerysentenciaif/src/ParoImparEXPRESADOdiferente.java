import java.util.Scanner;

public class ParoImparEXPRESADOdiferente 
{

	public static void main(String[] args) 
	{
		Scanner numero=new Scanner(System.in);
		System.out.println("ingrese un numero");
		int num=numero.nextInt();
		//utilizacion de if in-line
		String ms = (num%2==0) ?"es par": " es impar";
		System.out.println(num +" "+ms);

	}

}
