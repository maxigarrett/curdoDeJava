package programacion_generica_herenciaYTipoComodion;

//como convertimos esta clase normal en generica? y es indicandole a continuacion de la clase creada entre
//corchetes angulares el parametro de tipo  asi le indicamos que esta clase va a manejar un argumento que
//por principios es generico al cual denominamos T. pero a la hora de definir este argumento de tipo se 
//suelen utilizar por parametro letras mayusculas y estas letras ademas suelen ser la T,U y K y con esto ya
//hemos definido nuestra clase generica ahora tenemos que hacer que esta clase funcione y haga algo
public class pareja<T>
{
	//este constructor lo unico que va a ser es darle un estado inicialal campo de clase primero
	public pareja() 
	{
		primero=null;
	}
	
	//creamos un metodo seter es decir vamos a establecer el valor que le querramos dar al campo de clase
	//es decir vamos a cambiar el valor de ese campo primero y por parametros le decimos que va a recibir
	//tambien un valor generico osea de tipo String int u objeto que creemos
	public void setprimero(T nuevovalor) 
	{
		primero=nuevovalor;
	}
	
	//vamos a crear un metodo que imprimaen consola un trabajador es decir un empleado o jefe en concreto
	//y le decimos que va a recivir por parametro un objeto de tipo pareja y si queremos que se pueda
	//utilizar para tipo empleado y jefe hay que incluir un signo de interrogacion dentro de los corchetes
	//angulares y la clausula extends le estamos diciendo a este metod que puede recibir un tipo empleado
	//o cualquier subclase(?) perteneciente a empleado(extends)
	public static void imprimirTrabajador(pareja<? extends empleado> p)
	{
		//le decimos que imprima en consola obteniendo la informacion con get de lo que tengamos por 
		//parametros
		empleado primero=p.getprimero();
		System.out.println(primero);
	} 
	{
		
	}
	
	//greamos metodo geter que va a ser el encargado dedevolvernos el objeto que estemos manejandoen cada
	//ocasion, como es geter tenemos que establecer el tipo de dato que va a devolver y como es generico
	//le pasamos la T va a devolver lo que manejemos en la clase main un String, objeto persona,etc...
	public T getprimero() 
	{
		return primero;
	}
	

	
	//especificamos el dato y como va a ser generico utilizamos la letra con la que estamos trabajando 
	//entre los corchetes angulares <T> de la clase pareja
	//ya que todavia no sabemos con el tipo de dato que vamos a trabajar
	//y lo nombramos primero
	private T primero;
}

