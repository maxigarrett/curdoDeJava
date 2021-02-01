/*crear una clase coche cuyos atributos sean: String Fabricante, String Modelo, int año,String color
 
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
		
		//año
		System.out.println("ingrese el año");
		int año=scaner.nextInt();
		System.out.println("ingrese el año 2");
		int año2=scaner.nextInt();
		System.out.println("ingrese el año3");
		int año3=scaner.nextInt();
		
		//intancia
		coche micoche=new coche(fabricante,modelo,año);
		coche micoche2=new coche(fabricante2,modelo2,año2);
		coche micoche3=new coche(fabricante3,modelo3,año3);
	
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
	private int año;
	private String color;
	
	public coche(String fabricante,String modelo,int año) 
	{
		this.fabricante=fabricante;
		this.modelo=modelo;
		this.año=año;
		
	}
	public void MostrarDato() 
	{
		System.out.println("fabricante del vehiculo: " + fabricante + "   modelo:" +  modelo  + "    año:" + año);
	}
}
