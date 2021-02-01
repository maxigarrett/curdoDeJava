
public class incremento_de_capitalMATRIZ 
{

	public static void main(String[] args)
	{
		double acumulado;
		double interes=0.10;
		
		double[][] saldo=new double[6][5];
		
		for(int i=0;i<6;i++) 
		{
			saldo[i][0]=10000;//con esto almacena en todas las columna posicion 0 hasta el final el valor 10000
			acumulado=10000;
			
			//j=1 ya que en la posicion 0 esta almacenado el num 10000
			for(int j=1;j<5;j++) 
			{
				acumulado=acumulado+(1.2f* acumulado*interes);//incrementa el saldo con interez correspondiente y se almacena en acumulado
				saldo[i][j]=acumulado;//el acumulado se almacena en la matriz
			}
			
			interes=interes+0.1;
		}
		for(int i=0;i<6;i++) 
		{
			for(int j=0;j<5;j++) 
			{
				System.out.print("\t  " + saldo[i][j]);
				
			}
			System.out.println();
		}

	}

}
