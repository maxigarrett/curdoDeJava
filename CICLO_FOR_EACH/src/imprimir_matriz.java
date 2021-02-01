
public class imprimir_matriz 
{

	public static void main(String[] args) 
	{
		int M[][]= 
			{
				{10,15,18,19,21},
				{5,25,37,41,15},
				{7,19,32,14,90},
				{85,2,7,40,27},
			};
		//declaramos una nueva variable para almacenar la matriz dentro del for each
		for(int[]fila:M) 
		{
			//esta matriz almacenada enfila la volvemos a almacenar en otra variable llamada z
			for(int z:fila) 
			{
				System.out.print(z + "\t ");
			}
			System.out.println();
		}

	}

}
