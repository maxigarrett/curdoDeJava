package treeset_deLaInterfaz_set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class prueba_treeset2 
{

	public static void main(String[] args)
	{
	/*en este programa cremaos una clase articulo  la intanciamos y la agregamos a la coleccion TreeSet de la interfaz Set.
	 * la clase Articulo es la que implementa la interfaz Comparable y el metodo compareTo y ordena de menor a mayor los numeros
	 * de articulo pero que pasa si queremos por un lado ordenar los Articulos por orden de numero de articulo como lo hicimos pero
	 * en ves de seguir ese critierio queremos ordenarlos por descripcion de articulo osea alfabeticamente y otra cosa duda es que
	 * pasa si tenemos que almacenar en un objeto de tipo TreeSet  y ordenar objetos que no implementen la interfaz Comparable y
	 * utilice el metodo correspondiente compareTo pero si no utiliza la interfaz ,tampoco el metodo  ahora vamos a ver como solventar
	 * ese problema y eso lo resolvemos implementando otra interfaz diferente a Comparable.
	 * si vamos a la API y vamos a la clase TreeSet en ves de utilizar el constructor por defecto que estamos utilizando vemos que
	 * tiene sobrecarga de constructores y utilisaremos uno que por parametro recibe un objeto de tipo Comparator y se encuentra 
	 * escrito de esta manera TreeSet(Comparator<? super E> comparator) este constructor construye un nuevo y vacio  arbol(Treeset)
	 * ordenado de acuerdo con el comparador especificado(Comparator<E>) y que es esto de un Comparador?. Si le damos clic a Comparator
	 * vemos que se trata de otra interfaz que admite un generico como argumento y esta interfaz  a su ves un metodo compare(T o1,T o2)
	 * no confundir con metodo compareTo porque son metodos diferentes e interfaces diferentes pero en difiniva van a hacer lo mismo
	 * el metodo compare() por descripcion dice que compara dos argumentos en orden y si le damos clic a el metodo compare nos lleva
	 * a una descripcion mejor y hace exactamente igual que el metodo compareTo devuelve numero negativo si es menor, 0 si son iguales
	 * y un positivo si es mayor al objeto comparado.
	 * gracias a que la clase TreeSet admite por parametros la interfaz comparator y no un comparable podemos crear nosotros un objeto
	 * de tipo Comparator con el metodo con el metodo compare() en su interior que trabaje de acuerdo a nuestras necesidades y pasarle
	 *ese objeto Comparator a nuestra coleccion TreeSet por parametros y de esta forma conseguiremos ordenar nuestro TreeSet de acuerdo
	 *a otro criterio y solventar el problema de que si el objeto que estamos almacenando dentro del TreeSet no implementa Comparable
	 *pues de cuelaquier forma conseguir ordenarlo 
	 *esta primera solucion va a funcionar pero no del todo. Nos daremos cuenta que tampoco es una solucion del todo adecuada porque
	 *no llega a solventar del todo estos problemas que mencionamos y luego depuraremos esa solucion utilizando clases anonimas
	 *internas, pero iremos paso a paso 
	 *este programa solventa el problema de ordenarlos alfabeticamente*/
		
		//intanciamos la clase Articulo
		Articulo1 primero=new Articulo1(1,"primer articulo");
		Articulo1 segundo=new Articulo1(2,"segundo articulo");
		Articulo1 tercero=new Articulo1(3,"tercer articulo");
		
		//almacenar estos objetos de tipo articulo en una coleccion TreeSet e imprimirlos para ver en que
		//orden lo imprimen
		Set<Articulo1> ordenaArticulos=new TreeSet<Articulo1>();
		
		//agregamos elemntos creadosde tipo articulos a esta coleccion es lo mismo en el orden que lo 
		//agreguemos ya que con el metodo compareTo que implementa la clase articulo los ordena por 
		//numero de articulo que le pasemos por parametro
		ordenaArticulos.add(primero);
		ordenaArticulos.add(tercero);
		ordenaArticulos.add(segundo);
		System.out.println("ordenados por numeros de articulos");
		for(Articulo1 e:ordenaArticulos) 
		{
			System.out.println(e.getDescripcion());
		}
		
		//la clase Articulo esta preparada para recibir dos argumentos pero tenemos que crear un objeto
		//de tipo Comparator que es lo que estamos haciendo implementado la interfaz Comparator que es
		//lo que estamos haciendo es decir crear un onjeto de tipo Comparator para despues pasarle este
		//objeto al treeSet por argumento o parametrospero como la clase Articulo esta preparada para
		//recibir dos argumentos y no necesitamos en el objeto Comparator que tenga dos parametros 
		//indicandole el numero y la descripcion porque este objeto unicamente esta destinado a comparar
		//untilizando la interfaz Comparator y el metodo compare entonces por ese motivo dentro de la 
		//la clase Articulo vamos a crear otro constructorpor defecto sin parametros ninguno para que
		//no nos de error cuando instanciamos aca en el main aunque no es la forma mas elegante de 
		//solventar el problema 
				
		//entonces aca tenemos el objeto de tipo Compataror ya que articulo implementa esta Interfaz
		Comparator<Articulo1> comparadorArticulos=new Articulo1();
				
		//creamos la coleccion de tipo TreeSet y le psamos por parametros el objeto de tipo Comparator
		//como vimos en la Api hay sobrecarga de constructores y uno recibe por parametros un objeto
		//de tipo Comparator.
		//¿y que conseguimos con pasarle por parametros esto? lo que conseguimos es decirle a nuestro
		//programa que en este TreeSet los objetos se van almacenar ordenados segun lo que marque
		//el Comparator el comparador o mas bien el objeto de tipo Comparator en definitiva 
		//conseguiremos que los ordene alfabeticamente
		TreeSet<Articulo1> ordenaArticulos2=new TreeSet<Articulo1>(comparadorArticulos);
				
		//agregamos las intancias de articulos ya echos mas arriba que se estaban ordenando por numero
		//de articulo y esos lo agregamos a esta coleccion TreeSet que permite ordenarlos alfabeticamente
		//gracias a lo que le pasamos por parametro por eso que le pasamos por parametro se ira a fijar
		//al metodo compare de la interfaz que lo implementa que es Comparator y al agregarlos a esta
		//coleccion el programa se fijara lo que hay de intruccion en el metodo compare y se fijara ahi
		//porque en el constructor de Articulo no le pasamos nada por parametro por lo que ara por 
		//defecto es fijarse que al no tener parametro no va a ser nada que este relacionado a ese 
		//constructor que es comprar numeros de articulos de la interfaz Comparable con metodo 
		//compareTo  si no hace eso pues hara lo demas por defecto que es lo que implementa la interfaz
		//comparator
		ordenaArticulos2.add(primero);
		ordenaArticulos2.add(segundo);
		ordenaArticulos2.add(tercero);
				
		System.out.println();
		System.out.println("ordenados alfabeticamente");
		for(Articulo1 e: ordenaArticulos2) 
		{
			//este imprime por orden alfabetico
			System.out.println(e.getDescripcion());
		}

	}

}





//creamos clase propia para evaluar objetos creados por nosotros y no que esten defenidos en la api y 
//ordenarlos....La interfaz comparable recibe por parametros ungenerico por lo que le pasamos el objeto
//creado
class Articulo1 implements Comparable<Articulo1>, Comparator<Articulo1>
{
	//para que haga por defecto lo de la interfaz Comparator
	public Articulo1() 
	{
		
	}

	//num porque el articulo va a enumerarse y des porque van a tener una descripcion que sera el nombre
	//del articulo
	public Articulo1(int num,String des) 
	{
		numero_articulo=num;
		descripcion=des;
		
	}
	
	//metodo capas de devolver la descripcion del articulo
	public String getDescripcion() 
	{
		return descripcion;
	}
	
	//devuelve por defecto un num negativo si es menor al objeto comparado , 0 si son igual al objeto
	//comparado, num positivo si es mayor al objeto comparado
	public int compareTo(Articulo1 o) 
	{
		/*devuelve el numero del articulo (que es el numero del articulo que le pasemos por parametro al
		 constructor 1,3,5,6,cualquiera) menos(-) o.numero_articulo(el numero del articulo que pueda tener
		 otro objeto) de tal forma lo que va a hacer el compareTo por defecto es ordenar los articulos
		 en funcion del numero de articulos ... exactamente igual que lo que hace la clase String pero en
		 ves de ordenarlos por orden alfabetico,los ordena por numero de articulo */
		return numero_articulo - o.numero_articulo;
	}
	
	
	//metodo Compare de la interfaz Comparator hace lo mismo que el metodo compareTo de la interfaz
	//Comparable
	public int compare(Articulo1 a1, Articulo1 a2) 
	{
		//creamos variable String y lo que pasemos por parametro a a1 se almacenara en descripcionA 
		//a1.getDescripcion obtenemos la descripcion del articulo
		String descripcionA=a1.getDescripcion();
				
		//segundo objeto de tipo String y con esto ya tenemos dos variables con la descripcion almacenada
		String descripcionB=a2.getDescripcion();
				
		//devolvernos un entero negativo si es menor al objeto comparado 0 si es igual o positivo si es mayor 
		//con esto comparamos por nombre de articulo y lo ordena de menor a mayor en orden alfabetico
		//y ahora vamos a la clase main a crear un objeto de tipo Comparator
		return descripcionA.compareTo(descripcionB);
		
	}
	private int numero_articulo;
	private String descripcion;
}

