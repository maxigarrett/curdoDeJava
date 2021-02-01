package metodos_genericos_propios;

import java.util.Date;
import java.util.GregorianCalendar;

public class metodosGenericos2 
{

	public static void main(String[] args) 
	{

		//construimos un array de String
		String[] nombres= {"jose","maria","pepe"};
		
	
		//vamos hacer que nos devuelva el elemento menor del array que le pasemos por argumento al metodo
		System.out.println(misMatrices1.getElementos(nombres));
		
		
		GregorianCalendar[] fechas= {new GregorianCalendar(2018-1,12,4),new GregorianCalendar(2019,2,7),new GregorianCalendar(2019,3,2)
		};
		
		
		
		System.out.println(misMatrices1.getElementos(fechas).getTime());
	}
		
		

}




class misMatrices1 
{
	//este metodo va a ser publico estatico y que va a recibir un argumento de tipo osea generico
	//sin envargo no va a devolver un String osea no va a devolver un mensaje. Lo que va a devolver es
	//el elemento del array que sea menor. y es un dato de que tipo? el elemento seria nombres osea el 
	//argumento generico que le estamos pasando por parametro al metodo es de tipo T ya que podemos asi
	//crear array de cualquier tipo de datos que querramos menos primitivos si cramos una array de tipo
	//Date devolvera un Date,si es un String sera un String,etc
	//al comparar arrays usaremos el metodo compareTo que implementa la interfaz Comparable
	//entonces dentro del dato generico le ponemos extends Comparable ademas si hacemos un array creada por
	//nosotros de tipo empleado es decir un array de clase empleado no implementa esta interfaz y no podemos
	//utilizar compareTo pero String si la implementa como Date o gregoriancalendar con esos si podemos
	//por eso debemos hacer el array ese extends es para que nos marque un error si usamos array de objetos
	//que no implementan la interfaz como por ejemplo un array de una clase creada por nosotros
	public static <T extends Comparable> T getElementos(T[] a)
	{
		//si el array que creamos no tiene elementos dentro nos devuelve un null es decir nada
		//para evitarnos posibles erroes de pasar arrays vacios
		if(a==null || a.length==0) 
		{
			return null;
		}
		
		//usaremos o utilisaremos el metodo compareTo que lo que hace es comparar los elementos de un array
		//unos con otros para devolvernos cual es el menor si son iguales o si es mayor este metodo pertenece
		//a la interfaz Comparable<T>
		
		T elementomenor=a[0];
		
		//empesamos a recorrerlo desde 1 porque la posicion 0 ya la tengo almacenada en la variable generica
		//elementomenor
		for(int i=1;i<a.length;i++) 
		{
			//le decimos si elementomenor compara a[0] y cuando entra al bucle compara a[i] es decir a[1] con
			//a[0] ya declarado fuera del bucle y nos da un numero positivo quiere decir que a[i] es menor
			//y asi se lo decimos elemntomenor=a[i] y a cada vuelta de bucle for va a ir comparando es decir
			//a[1] que ya esta almacenado en elemntomenor sale del bucle y entra empiesa a comparar a
			//a[1] con la posicion a[2]
			if(elementomenor.compareTo(a[i])>0) 
			{
				elementomenor=a[i];
			}
		}
		return elementomenor;
	}
}
