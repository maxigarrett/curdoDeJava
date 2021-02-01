
public class num_aleatorio 
{

	public static void main(String[] args)
	{
		int num[]=new int[150];
		
		for(int i=0;i<num.length;i++) 
		{
			/*se almacenara dentro del num[i] (int) se le dice refundicion pasa un numero decimal originado por el metodo 
			 * Math.random y el Math.round()redondea un numero*/
			num[i]=(int)Math.round(Math.random()*100);
		}
		for(int numeros:num) 
		{
			System.out.print(" " + numeros);
		}

	}

}
