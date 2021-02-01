package matrices;

public class matriz1
{

	public static void main(String[] args) 
	{
		//creamos una matris de 3 filas y 3 columnas
		int [][] matriz=new int[3][3];
		
		matriz[0][0]=10;
		matriz[0][1]=20;
		matriz[0][2]=30;
		
		matriz[1][0]=40;
		matriz[1][1]=50;
		matriz[1][2]=60;
		
		matriz[2][0]=70;
		matriz[2][1]=80;
		matriz[2][2]=90;

		for(int i=0;i<3;i++) 
		{	
			for(int j=0;j<3;j++) 
			{
				System.out.print(matriz[i][j]);
			}
			System.out.println();

		}
		

	}

}
