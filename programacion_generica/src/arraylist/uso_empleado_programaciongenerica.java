package arraylist;

import java.util.ArrayList;

public class uso_empleado_programaciongenerica
{

	public static void main(String[] args)
	{
		/*empleado listaempleados[]=new empleado[3];
		
		listaempleados[0]=new empleado("maxi",45,2500);
		listaempleados[1]=new empleado("ana",55,2000);
		listaempleados[2]=new empleado("antonio",25,2600);*/
		
		//permite almacenar objetos pero no datos primitivos int,double
		//va creando posiciones y crece automaticamente a medida que le agreguemos instancias
		ArrayList <empleado> listaempleados=new ArrayList<empleado>();
		
		
		//el constructor por defecto admite hasta 10 elementos pero si agregamos uno mas no pasa nada y otro
		//y no pasa nada pero consume recursos ya que cuando exxede los 10 elementos y va a guardar 100
		//va tener que crear un arraylist nuevo y de 100 elementos y borrar el viejo que solo admitia 10
		//pero si estamos seguro de la cantidad de elementos que vamos a agregar podemos utlizar el metodo
		//ensureCapacity()
		listaempleados.ensureCapacity(5);
		
		
		
		
		//usamos la instancia con el metodo add y por parametro instanciamos la clase empleado
		//o podemos instanciarla aparte y por argumento pasarle el nombre de la instancia
		listaempleados.add(new empleado("maxi",45,2500));
		listaempleados.add(new empleado("ana",55,2000));
		listaempleados.add(new empleado("antonio",25,2600));
		empleado a=new empleado("adjkc",23,22222);
		listaempleados.add(a);
		//listaempleados.add(new empleado("olga",22,2200));
		
		//para ubicar con el metodo set en la posicion que nosotros querramos  el metodo set pide dos 
		//parametros el primero para establecer el lugar o la posicion donde ubicarlo ya sabemos que 
		//cualquier array arranca desde cero... y el segundo parametro la instacia de empleado o un 
		//objeto que contenga almacenado esa instancia este metodo remplaza a el que esta en esa posicion
		listaempleados.set(1, new empleado("olga",22,2200));
		
		//si estamos seguros de que no vamos a agregar mas elementos podemos cerrar el array y cortar
		//el ecceso de memoria con metodo trimToSize()
		listaempleados.trimToSize();
		
		
		
		
		//imprime la cantidad de elementos que tenemos en el arraylist con el metodo size();
		System.out.println("la cantidad de elemtos que hay son "+listaempleados.size());
		
		for(empleado e:listaempleados) 
		{
			System.out.println(e.damedatos());
		}
		
		//el metodo get permite obtener la posicion que le demos por parametro como entero del array
		System.out.println("el empleado que se encuentra en esa posicion es " +listaempleados.get(3).damedatos());
	
		
		System.out.println();
		
		/*otra forma de imprimir el array pero es un poco mas compleja es con un bucle for convencional*/
		for(int i=0;i<listaempleados.size();i++) //el size obtiene todo los arraylist que creamos
		{
			//se almacena en el objeto e de tipo empleado lo que hay en todas las posiciones obtenidas
			//con el metodo get y por parametro la "i" que es la variable del bucle que recorre
			empleado e= listaempleados.get(i);
			
			//imprimimos datos
			System.out.println(e.damedatos());
		}
	
	}

}

class empleado
{
	public empleado(String nombre,int edad,double salario) 
	{
		this.nombre=nombre;
		this.edad=edad;
		this.salario=salario;
	}
	
	public String damedatos() 
	{
		return "el empleado se llama: " + nombre + " tiene: " +edad+ " años" + " y un salario de: " + salario;
	}
	
	private String nombre;
	private int edad;
	private double salario;
}
