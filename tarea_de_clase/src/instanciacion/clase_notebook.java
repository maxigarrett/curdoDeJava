/*crear una instancia de la clase notebook y cargar 3 datos aleatorios desde clase main una de las instancias
 * cargarlas por teclado
 * crear un metodo Mostrarotebook en la clase notebool que muestre los datos de cada 
 * una de las tres instancias*/
package instanciacion;

import java.util.Scanner;

public class clase_notebook
{

	public static void main(String[] args)
	{
		//ingresamos por teclado el fabricante
		Scanner scanner=new Scanner(System.in);
		System.out.println("ingrese el fabricante");
		String fabri=scanner.nextLine();
		
		//instancia de constructor
		Notebook pc=new Notebook(fabri,4,"corei7");
		Notebook pc2=new Notebook("lenovo",6,"corei3");
		Notebook pc3=new Notebook("HP",10,"corei8");
		
		//metodo para mostrar informacion
		pc.Mostrarnotebook();
		pc2.Mostrarnotebook();
		pc3.Mostrarnotebook();
	}

}


class Notebook 
{
	//variables de clase
	private String fabricante;
	private int ram;
	private String modelo;
	private String procesador;
	//constructor              //parametros
	public Notebook(String fabricante,int ram, String procesador)
	{
		this.fabricante=fabricante;
		this.ram=ram;
		this.procesador=procesador;
	}
	
	//metodo que imprime los valores almacenados en los parametros
	public void Mostrarnotebook() 
	{
		System.out.println("fabricante: "+fabricante + " " + " GB de ram: "+ram+" procesador: "+procesador );
	}
}

