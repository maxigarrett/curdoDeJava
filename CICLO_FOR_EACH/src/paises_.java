
public class paises_ 
{

	public static void main(String[] args)
	{
		String paises[]=new String[8];
		
		paises[0]="España";
		paises[1]="Mexico";
		paises[2]="Colombia";
		paises[3]="Chile";
		paises[4]="Argentina";
		paises[5]="Peru";
		paises[6]="Venezuela";
		paises[7]="Brazil";
		
		/*for(int i=0;i<8;i++) 
		{
			System.out.println("pais " + (i+1) +" "+ paises[i]);
		}*/
		for(String elemento:paises) //nuevo bucle para trabajar con matrices y te olvidas de donde empieza hatsta donde termina
		{
			System.out.println(elemento);
		}

	}

}
