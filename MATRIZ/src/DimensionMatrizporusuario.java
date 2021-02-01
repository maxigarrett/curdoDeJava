import java.util.Scanner;

/*Ejemplo: llena matriz con números aleatorios.
En el siguiente programa, pedimos al usuario que ingrese las dimensiones de una matriz
(fi las y columnas), creamos una matriz de esas dimensiones y la llenamos con números
generados aleatoriamente*/
public class DimensionMatrizporusuario 
{

	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("dimensione las fila de la matriz");
		int f=scanner.nextInt();
		System.out.println("dimensione las columnas  de la matriz");
		int c=scanner.nextInt();
		
		//creo una matriz de f filas por c columnas
		int matriz[][]=new int[f][c];
		
		int nro;
		for(int i=0;i<f;i++) 
		{
			for(int j=0;j<c;j++) 
			{
				//genero un numero aleatorio entre 0 y 1000
				nro=(int)(Math.random()*1000);
				//asigno el nuemero a la matriz
				matriz[i][j]=nro;
			}
		}
		for(int i=0;i<f;i++) 
		{
			for(int j=0;j<c;j++) 
			{
				//imprimo matriz
				System.out.println(matriz[i][j]);
			}
			System.out.println();
		}
		
	}

}
