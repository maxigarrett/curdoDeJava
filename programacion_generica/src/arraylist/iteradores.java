package arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class iteradores 
{

	public static void main(String[] args)
	{
		//permite almacenar objetos pero no datos primitivos int,double
		//va creando posiciones y crece automaticamente a medida que le agreguemos instancias
		ArrayList <empleado1> listaempleados=new ArrayList<empleado1>();
		
		
		//el constructor por defecto admite hasta 10 elementos pero si agregamos uno mas no pasa nada y otro
		//y no pasa nada pero consume recursos ya que cuando exxede los 10 elementos y va a guardar 100
		//va tener que crear un arraylist nuevo y de 100 elementos y borrar el viejo que solo admitia 10
		//pero si estamos seguro de la cantidad de elementos que vamos a agregar podemos utlizar el metodo
		//ensureCapacity()
		listaempleados.ensureCapacity(5);
		
		

		
		//usamos la instancia con el metodo add y por parametro instanciamos la clase empleado
		//o podemos instanciarla aparte y por argumento pasarle el nombre de la instancia
		listaempleados.add(new empleado1("maxi",45,2500));
		listaempleados.add(new empleado1("ana",55,2000));
		listaempleados.add(new empleado1("antonio",25,2600));
		empleado1 a=new empleado1("kiko",23,22222);
		listaempleados.add(a);
		//listaempleados.add(new empleado("olga",22,2200));
		
		//para ubicar con el metodo set en la posicion que nosotros querramos  el metodo set pide dos 
		//parametros el primero para establecer el lugar o la posicion donde ubicarlo ya sabemos que 
		//cualquier array arranca desde cero... y el segundo parametro la instacia de empleado o un 
		//objeto que contenga almacenado esa instancia este metodo remplaza a el que esta en esa posicion
		listaempleados.set(1, new empleado1("olga",22,2200));
		
		//si estamos seguros de que no vamos a agregar mas elementos podemos cerrar el array y cortar
		//el ecceso de memoria con metodo trimToSize()
		listaempleados.trimToSize();
		
		
		
		
		//imprime la cantidad de elementos que tenemos en el arraylist con el metodo size();
		System.out.println("la cantidad de elemtos que hay son "+listaempleados.size());
		
		
		//for each lo vamos a remplazar por un iterador asique comentamos el bucle
		/*for(empleado1 e:listaempleados) 
		{
			System.out.println(e.damedatos1());
		}*/
		
		
		
		//Iterator en el cual tenemos que especificar tambien el tipo de objetoque va a manejar ese iterador
		//este va a ser el encargado de recorrer elemento a elemento la coleccion y tenemos q especificarle
		//que tipo de objeto tenemos en esa coleccion dento de los signos <> y dentro del arrayList
		//tenemos objetos de tipo empleado
		Iterator<empleado1> mi_iterador=listaempleados.iterator();//el metodo iterator devuelve un objeto de
														//tipo iterator y lo estamos almacenando en la 
													//variable de tipo iterator llamada mi_iterator
		
		
		//metodo que permite saber si tenemos mas objetos o no dentro de la coleccion y devuelve un boolean
		//creamos bucle while en el que le preguntamos si este iterador (mi_iterador) que hemos creado mas
		//arriba tiene elementos o no los tiene utilizando el metodo hasNext();
		
		while(mi_iterador.hasNext()==true) 
		{
			//imprimimos datos con metodo next() devuelve el proximo elemento de esa coleccion de objetos
			//digamos que este metodo es el encargado de recorrer esa coleccion de objetos este metodo 
			//examina el objeto que salto osea salta el primer elemento lo lee ,psa de largo el segundo
			//lo lee,pasa el de largo el tercer elemento y lo lee es decir trabaja leyendo los elemento
			//que se paso de largo 
			System.out.println(mi_iterador.next().damedatos1());
			
			//next devuelve un objeto de tipo del que estamos evaluando osea empleado asique tambien
			//se puede expresar de esta manera
			
			/*empleado1 ite=mi_iterador.next();
			 
			//imprimimos datos
			System.out.println(ite.damedatos1());*/
		}
		
		//el metodo get permite obtener la posicion que le demos por parametro como entero del array es decir
		//obtenemos la informacion de lo que hay en esa posicion
		System.out.println("el empleado que se encuentra en esa posicion es " +listaempleados.get(3).damedatos1());
	
		
		
	}

}

//para recorrer informacion es mejor el bucle foreach para modificar algo o remover es mejor usar
//un iterador



class empleado1
{
	public empleado1(String nombre,int edad,double salario) 
	{
		this.nombre=nombre;
		this.edad=edad;
		this.salario=salario;
	}
	
	public String damedatos1() 
	{
		return "el empleado se llama: " + nombre + " tiene: " +edad+ " años" + " y un salario de: " + salario;
	}
	
	private String nombre;
	private int edad;
	private double salario;
}
