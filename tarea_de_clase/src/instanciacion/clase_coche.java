/*crear una clase coche cuyos atributos sean: String Fabricante, String Modelo, int a�o,String color
 
 crear 3 instancias de clase coche y cargar 3 datos aleatorios desde la clase main
 crear un metodo Mostrar dato en la clase coche que muestre los datos de cada una de las tres instancias*/
package instanciacion;

import java.util.Scanner;

public class clase_coche {

	public static void main(String[] args)
	{
		//objeto de tipo Scanner
		Scanner scaner=new Scanner(System.in);
		//fabricante
		System.out.println("ingresa el fabricante");
		String fabricante=scaner.nextLine();
		System.out.println("ingrese el fabricante 2");
		String fabricante2=scaner.nextLine();
		System.out.println("ingrese el fabricante 3");
		String fabricante3=scaner.nextLine();
	//modelo
		System.out.println("ingrese el modelo");
		String modelo=scaner.nextLine();
		System.out.println("ingrese el modelo2");
		String modelo2=scaner.nextLine();
		System.out.println("ingrese el modelo3");
		String modelo3=scaner.nextLine();
		
		//a�o
		System.out.println("ingrese el a�o");
		int a�o=scaner.nextInt();
		System.out.println("ingrese el a�o 2");
		int a�o2=scaner.nextInt();
		System.out.println("ingrese el a�o3");
		int a�o3=scaner.nextInt();
		
		//intancia
		coche micoche=new coche(fabricante,modelo,a�o);
		coche micoche2=new coche(fabricante2,modelo2,a�o2);
		coche micoche3=new coche(fabricante3,modelo3,a�o3);
	
		//imprimo informacion del metodo
		micoche.MostrarDato();
		micoche2.MostrarDato();
		micoche3.MostrarDato();
		
	}

}

class coche
{
	private String fabricante;
	private String modelo;
	private int a�o;
	private String color;
	
	public coche(String fabricante,String modelo,int a�o) 
	{
		this.fabricante=fabricante;
		this.modelo=modelo;
		this.a�o=a�o;
		
	}
	public void MostrarDato() 
	{
		System.out.println("fabricante del vehiculo: " + fabricante + "   modelo:" +  modelo  + "    a�o:" + a�o);
	}
}
