package colecion_tipo_map;

import java.util.HashMap;
import java.util.Map;

public class pruba_map_tipo_hashmap
{
	/*este ejemplo sencillo va a consistir en un Map que va a almacenar empleador y cada empleado va a
	 * tener su correspondiente clave y lo que tendremos que hacer es construir objetos de tipo empleado*/
	public static void main(String[] args) 
	{
		//construimos la coleccion y va a resivir dos valores la clave(String) y el valor(de tipo Empleado)	
		//la interfaz map recibe por parametro dos argumentos la clave y el valor Map<K,V> K=clave , 
		//V=valor la clase que vamos a utilizar es HashMap
		Map<String,Empleado> personal=new HashMap<String,Empleado>();
		
		//ahora tenemos que introducir objetos de tipo empleado dentro de este Map y para eso
		//utilizaremos el metodo put(K,V) este recive por parametro dos tipos genericos es decie la
		//clave y el valor  y es tan sencillo como introducir una clave K(String) e introducir el 
		//valor V(Empleado) y con esto ya queda el elemnto(Valor String) asociado asociado a su clave
		//K(Empleado) las claves no se pueden repetir porque sino remplazara al de la misma clave osea 
		//el ultimo colocado con la misma clave remplazara a uno mas arriba que tenga la misma
		personal.put("145",new Empleado("Juan"));
		personal.put("146",new Empleado("Sandra"));
		personal.put("147",new Empleado("Jose"));
		personal.put("148",new Empleado("Diana"));
		
		//imprimimos personal osea todo lo que hay dentro de la coleccion Map de tipo HashMap
		System.out.println(personal.toString());
		
		//como removemos objetos de un mapa?si vamos a la interfaz Map dentro de la Api de java veremos
		//en sus metodos que tiene uno  descripto asi: remove(Object key)
		personal.remove("145");
		
		//imprimimos para ver si lo removio
		System.out.println(personal.toString());
		
		//sutituir un elemnto que alla en el Map esta remplazara a Diana la que tiene la clave 148S
		personal.put("148", new Empleado("Pepe"));
		
		System.out.println(personal);
		
		/*hay un metodo de la interfaz Map que es el metodo entrySet() dice que nos devuelve un Set es
		 decir, una coleccion  o una vista de todo lo que hay almacenado en el mapa y esa vista va a 
		 tener forma o vista de coleccion este metodo nos devuelve (Set<Map.Entry<K,V>>) un Set que resive
		 como tipo una interfaz Map.Entry  y esta es la interfaz interna que pertenece a la interfaz Map
		 y esta interfaz interna Map.Entry recibe como parametro dos tipos genericos, la clave y el valor 
		 si pulsamos en lo que devuelvve en Map.Entry en la Api nos lleva a esa interfaz (Map.Entry) y 
		 nos dice que esta interfaz esta incluida dentro de la interfaz Map(Enclosing interface Map<K,V>)
		 y esta interfaz Map.Entry tiene una serie de metodos que nos permite jugar con la informacion
		 que hay almacenada en el mapa por ejemplo tenemos el metodo getKey() que lo que hace es devolvernos
		 la clave correspondiente a la entrada que le indiquemos  y tambien tiene como por ejemplo 
		 getValue() lo que hace es devolvernos el valor correspondiente a la entrada*/
		
		//le estamos diciendo que nos devuelva una coleccion de tipo Set y que nos imprima esa acoleccion
		System.out.println(personal.entrySet());
		System.out.println();
		
		//utilizaremos un bucle for each esta coleccion y que nos devuelva los elemntos en forma de Set
		//primero tipo de dato que estamos trabajando, nombre cualquiera y que recorra la coleccion creada
		//y nos la devuelva con personal.entrySet() concretamente un Set que tiene como argumento un 
		//Set<Map.Entry> y como la Interfaz Map.Entry tiene una serie de metodos nos permite jugar con
		//elloa
		for(Map.Entry<String, Empleado> entrada: personal.entrySet()) 
		{
			//le digo que me almacene en una variable de tipo String a la que llamamos clave pues la clave
			//del elemento que estes evaluando ahora mismo es decir entrada.getKey osea obtendremos la 
			//clave de cada instancia agregada con el metodo put y que le dijimos que la clave iba hacer
			//de tipo String
			String clave=entrada.getKey();
			
			//ahora en una variable de tipo empleado almacename el valor osea como se llaman
			Empleado valor=entrada.getValue();
			
			//imprima la informacion almacenada
			System.out.println("clave: " + clave + " valor " + valor);
		}
		
	}

}

class Empleado 
{
	//recibe por parametros el nombre del empleado
	public Empleado(String n) 
	{
		nombre=n;
		
		//le decimos que el sueldo de todos los empleados va a ser igual a 2000
		sueldo=2000;
	}
	
	//hacemos la informacion visible en consola
	public String toString() 
	{
		return "[Nombre= " + nombre + " , sueldo= " + sueldo + " ]";
		
	}
	
	//campo de clase
	private String nombre;
	private double sueldo;
}