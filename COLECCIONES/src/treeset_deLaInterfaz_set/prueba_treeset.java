package treeset_deLaInterfaz_set;


import java.util.Set;
import java.util.TreeSet;

public class prueba_treeset 
{

	public static void main(String[] args) 
	{
		
		
		//intanciamos la clase Articulo
		Articulo primero=new Articulo(1,"primer articulo");
		Articulo segundo=new Articulo(2,"segundo articulo");
		Articulo tercero=new Articulo(3,"tercer articulo");
		
		//almacenar estos objetos de tipo articulo en una coleccion TreeSet e imprimirlos para ver en que
		//orden lo imprimen
		Set<Articulo> ordenaArticulos=new TreeSet<Articulo>();
		
		//agregamos elemntos creadosde tipo articulos a esta coleccion es lo mismo en el orden que lo 
		//agreguemos ya que con el metodo compareTo que implementa la clase articulo los ordena por 
		//numero de articulo que le pasemos por parametro
		ordenaArticulos.add(primero);
		ordenaArticulos.add(tercero);
		ordenaArticulos.add(segundo);
		
		for(Articulo e:ordenaArticulos) 
		{
			System.out.println(e.getDescripcion());
		}
		
		
		
	}
}

//creamos clase propia para evaluar objetos creados por nosotros y no que esten defenidos en la api y 
//ordenarlos....La interfaz comparable recibe por parametros ungenerico por lo que le pasamos el objeto
//creado
class Articulo implements Comparable<Articulo> 
{
	public Articulo() 
	{
		
	}

	//num porque el articulo va a enumerarse y des porque van a tener una descripcion que sera el nombre
	//del articulo
	public Articulo(int num,String des) 
	{
		numero_articulo=num;
		descripcion=des;
		
	}
	
	//metodo capas de devolver la descripcion del articulo
	public String getDescripcion() 
	{
		return descripcion;
	}
	
	//devuelve por defecto un num negativo si es menor al objeto comparado , 0 si es igual al objeto
	//comparado, num positivo si es mayor al objeto comparado
	public int compareTo(Articulo o) 
	{
		/*devuelve el numero del articulo (que es el numero del articulo que le pasemos por parametro al
		 constructor 1,3,5,6,cualquiera) menos(-) o.numero_articulo(el numero del articulo que pueda tener
		 otro objeto) de tal forma lo que va a hacer el compareTo por defecto es ordenar los articulos
		 en funcion del numero de articulos ... exactamente igual que lo que hace la clase String pero en
		 ves de ordenarlos por orden alfabetico,los ordena por numero de articulo */
		return numero_articulo - o.numero_articulo;
	}
	
	
	private int numero_articulo;
	private String descripcion;
}
