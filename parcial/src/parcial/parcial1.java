package parcial;

import java.util.Scanner;

public class parcial1 
{

	public static void main(String[] args)
	{
		//clase Scanner para ingresar por teclado
		Scanner scanner=new Scanner(System.in);
		
		//ingreso de datos por teclado
		System.out.println("digite el deporte :");
		String dep=scanner.nextLine();
		
		System.out.println("digite el nombre :");
		String nom=scanner.nextLine();
		
		System.out.println("digite el apellido :");
		String ape=scanner.nextLine();
		
		System.out.println("digite la edad :");
		int ed=scanner.nextInt();
		
		//instancia del objeto de tipo Deportista
		Deportista usodeportista=new Deportista(dep,nom,ape,ed);//muestra lo que ingresamos por teclado
		
		Deportista usodeportista1=new Deportista("futbol","maximiliano","garrett",26);
		Deportista usodeportista2=new Deportista("golf","juan","castro",30);
		
		//llamada al metodo creado en clase Deportista
		usodeportista.muestraDeportista();
		usodeportista1.muestraDeportista();
		usodeportista2.muestraDeportista();
		
	}

}


class Deportista 
{
	//variables de clase
	private String deporte;
	private final String nombre;
	private String apellido;
	private int edad;
	
	//metodo constructor
	public Deportista(String deporte,String nombre,String apellido,int edad) 
	{
		//operador this hace referencia a la variable de clase 
		this.deporte=deporte;
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
	}
	
	//metodo para mostrar los valores ingresados
	public void muestraDeportista() 
	{
		System.out.println("deporte: " + deporte + " nombre: " + nombre + " apellido: " + apellido + " edad: " + edad);
	}
}