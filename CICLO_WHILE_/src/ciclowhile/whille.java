package ciclowhile;

import java.util.Scanner;

public class whille {

	public static void main(String[] args) 
	{
		/*Ejemplo: muestra n�meros naturales.
El siguiente programa utiliza un while para mostrar los primeros n n�meros naturales.
El usuario ingresa el valor n por teclado.*/
		Scanner scanner=new Scanner(System.in);
		System.out.println("ingrese un numero");
		int n=scanner.nextInt();
		int x=1;
		while(x<=n) 
		{
			System.out.println(x);
			x++;
		}
		

	}

}
