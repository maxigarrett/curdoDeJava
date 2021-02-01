package coleccion_banco2ordenar;

public class uso_Libro 
{

	public static void main(String[] args) 
	{
		//lo que va a defirenciar si los libros son iguales o no es el codigo ISBN que es un int ya que cada
		//libro distinto de otro posee un ISBN diferente y un original con sus copias son originales
		Libro libro1=new Libro("p en java","maxi",25);
		
		Libro libro2=new Libro("p en java","maxi",25);
		
		//apuntara la dos referencias de la meoria Stack a un solo objeto de la memora Heap
		//esto quiere decir que si ejecutamos el codigo los dos libros tendran el mismo codigo sino comentamos
		//esta instruccion las dos instancias al no ser iguales cada una de ellas aputa a un objeto de instancia
		//diferente de la memoria Stack a la memoria donde se encuentran las instncias de los objetos Libros osea
		//la memoria Heap y etas dos referencias al apuntar a dos objetos diferentes tendran un hashCode 
		//diferente pero si dejamos esta instruccion sin comentar y cambiar los valores de las instacias seguira
		//diciendo que son iguales y no nos sirve
		//libro1=libro2;
		 
		
		//el metodo equals compara objetos y estamos diciendo que si libro1 es igual a libro2 a pesar de serlo
		//ya que tienen la misma informacion dira que es false porque este metodo sirve para comprar datos
		//que ya estan predefinidas en la API de java cono String o Date pero el metodo equals no sabe nada de
		//codigo ISBN que tiene el libro que es lo que nos interesa en este caso pero equals() no sabe nada de ISBN
		//por eso dira que no son iguales ya que los toma como dos objetos diferentes a libro1 y libro 2
		//el metodo equals no sabe nada porque no es una clase predefinida en la API sino que la creamos nosotros
		//y cual es la solucion y es ir a la clase Libro y redefinir o reescribir el metodo equals() para
		//que no haga lo que hace por defecto sino que haga lo que nosotros querramos y que es que sea capas
		//de distinguir que es un ISBN y lo pueda comparar
		if(libro1.equals(libro2)) 
		{
			//nos tira el codigo de libro1 de la posicion en la memoria de cada uno de los libros
			System.out.println("HashCode de libro1: "+libro1.hashCode());
			System.out.println("HashCode de libro2: "+libro2.hashCode());
			System.out.println("los libros son iguales");
		}
		else 
		{
			System.out.println("HashCode de libro1: "+libro1.hashCode());
			System.out.println("HashCode de libro2: "+libro2.hashCode());
			System.out.println("los libros no son iguales");
		}
	}

}
