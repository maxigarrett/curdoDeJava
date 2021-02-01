package ciclowhile;
import java.util.*;

public class metodoRandom_adivinaNUm 
{

	public static void main(String[] args)
	{
		//ese (int) se le llama refundicion osea que Math.random()*100 va a devolver un decimal entre 0 y 100
		//y lo convierte en un entero ese (int)
		int aleatorio=(int)(Math.random()*100);
		
		Scanner scanner=new Scanner(System.in);
		int num=0,
		intentos=0;
		
		//mientras el numero que el usuario digite sea distinto de el numero aleatorio que se origine se va a seguir repitiendo
		while(num!=aleatorio) 
		{
			//cada ves que no se acierta el numero volvera a entrar al ciclo y aumntara en uno la variable intentos
			intentos++;
			System.out.println("introduce el numero");
			num=scanner.nextInt();
			//dice que si el num que digite el usuario es menor al generado aleatoriamente mostrara un mensaje
			//diciendo mas bajo
			if(aleatorio<num) 
			{
				System.out.println("mas bajo");
			}
			else 
			{
				//mientras el nume que digite el usuario sea mayor que el aleatorio que genero mostrara un mensaje
				if(aleatorio>num) 
				{
					System.out.println("mas alto");
				}
			}
		}
		// si se deja de cumplir la condicion del while y el numero es igual al aleatorio imprimira el un mensaje de tipo JOpt....
		System.out.println("correcto lo  hiciste en " + intentos + " intentos");

	}

}
