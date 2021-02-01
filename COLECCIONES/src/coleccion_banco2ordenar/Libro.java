package coleccion_banco2ordenar;
/*lo aprendido aca lo trasladaremos a el paquete coleccion_banco2 para poder compara los objetos es decir
 * clientes los detecte y diga cuales son iguales  para que no imprima un repetido*/
public class Libro
{
	public Libro(String titulo,String autor,int ISBN) 
	{
		this.titulo=titulo;
		this.autor=autor;
		this.ISBN=ISBN;
	}
	
	public String getDatos() 
	{
		return "el titulo es: "+titulo+" el autor es: "+autor+" su ISBN es: " + ISBN;
	}
	
	//para sobreescribir el metodo hashCode y que nos de un numero en posicion de memoria
	//si cambiamos el isbn nos dara un hashCode diferente porque estan a puntando a dos memorias de instancia
	//diferentes(Heap) si ponemos el mismo numero apuntara al mismo objeto de intancia en la memoria Heap
	//es decir que al crear una dos intancias de clase se almacenan dos objetos diferentes en la memoria Heap
	//al darle nombre a esa intancia se almacena en la memoria mas rapida llamada Stack la referencia a ese
	//objeto creado o vinculodo y dado el nombre es decir en este ejemplo el objeto de intancia es Libro (se 
	//almacena en la memoria Heap) al darle nombre como libro1 ese se almacena en la memoria Stack y apunta
	//o hace referencia o esta viculado al objeto libro y si cremoa otra instancia hara lo mismo
	//el hasCode que solo estamos utilisando solo lo pusimos para ISBN pero lo podemos utilizar para autor
	//y titulo tambien
	public int hashCode() 
	{
		final int prime=31;
		int result=1;
		result=prime*result + ISBN;
		
		return result;
	}
	
	//el metodo equals de la API de java lo vamos a sobreescribir para que haga los que nosotrs querramos yno
	//lo que hace por defecto que es compara si dos objetos son iguales pero eso lo sabe si esas clases bienen
	//definida en la API pero al crear clases poropias y no estar predefinidas en la api el metodo equals no
	//sabe que comparar y obtendremos una respuesta equibocada preguntandole al if de la clase uso_Libro ya que
	//nosotros queremos comparar y el ISBN de los libros son iguales pero ese codigo  existe en los libros
	//pero no en la API de java y para saber si son Iguales o no hay que sobreescribir el metodo para que
	//haga lo que nosotros querramos osea comparar ese codigo ISBN y no que hago lo que hace por defecto que es
	//compara objetos pero que ya vienen predefinidos enn la API de java
	
	//asi se sobreescribe y devuelve un tipo de dato boolean y recibe por parametros un objeto de tipo Object
	//equal pertenece a la clase Object y como lo escribimos asi esta definodo en la API de java
	public boolean  equals(Object obj) 
	{
		/*le vamos a preguntar si este objeto que le vamos a pasar porparametro(obj) es una instancia de
		 de la calse Libro es decir si pertenece a la clase Libro y una ves que eso se haya comprovado y sea
		 cierto pasaremos a comprovar otras cosas.¿pero como le preguntamos ? pues se lo hacemos preguntando
		 si obj instanceof(este operador nos permite averiguar si un objeto es una instancia de una clase en
		 concreto en este caso de Libro) Libro, es decir en el caso del objeto que te estoy pasando por 
		 parametro que es obj sea una instancia de la clase libro.Que debes hacer?*/
		if(obj instanceof Libro) 
		{
			/*lo que debe hacer es: debemos tener en cuenta que el metodo equal siempre va a comparar dos o
			 * objetos y que estamos comparando el objeto donde nos encontramos ahora mismo 
			 *  con otro objeto que nosotros le pasemos por parametro  y este metodo equals debe de decirnos
			 *  que es true es decir que los objetos son verdad siempre y cuando los ISBN de los dos objetos
			 *  es decir el objeto en el que nos encontamos con el que lo vamos a comparar sean iguales luego
			 *  entonces necesitamos que este objecto que le pasemos por parametro(obj) sea capas de acceder
			 *  a este campo es decir al campo ISBN. este campo o variable pertenece a la clase Libro
			 *  no pertenece a la clase Object  luego entonces para que (obj) pueda acceder a esta variable
			 *  necesito hacer una casting y convertir este objeto(obj) de tipo Object a que sea de tipo Libro
			 * declaramos una variable de tipo libro llamada otros para almacenar el casting */
			Libro otros=(Libro)obj;
			
			/*una ves echo el castin estamos preparados para hacer la comparacion de ISBN entre el objecto
			 * actual y el que te paso por parameto de la sigueinte forma:
			 * con this hacemos referencia a el objeto donde nos encontramos y que sea igual a (otros) que
			 * es donde almacenamos el objeto pasado por parametros que ahora es de tipo libro por el casting
			 * punto(.) ISBN y con esto ya estamos comparando si el ISBN de los dos objetos es o no es igual*/
			//si queremos comparar el autor solo cambiamos de esta forma if(this.autor==otros.autor)
			//en la clase uso_Libro esta el metodo equal comparando dos instancias de esta clase Libro llamada
			//libro1 y libro2 y comparandolos de la siguinte forma if(libro1.equals(libro2)) asi compara
			//y en la clase donde nos encontramos le decimos que compara los ISBN
			if(this.ISBN==otros.ISBN) 
			{
				//en el caso de que sea igual que nos devuelva true
				return true;
			}
			else 
			{
				//si no es igual devuelve falso es decir que los dos libros que estamos comparando tengan
				//diferente ISBN
				return false;
			}
		}
		//en caso de no cumplir con el if si no gregagmos el else con un return tirara error
		//porque el return que espera el metodo es que pasa si no se cumple la condicion del if y nosotros
		//le decimos return false porque este metodo esta diciendo dentro del if obj es una instancia de
		// Libro pero si no lo es(instnciamos una clase que no sea libro por ejemplo) retorname false 
		else 
		{
			return false;
		}
		
		
		//este codigo lo genera al ser tan frecuente el entorno de desarrolo eclipse nos permite generar el
		//codigo automaticamente llendo a source y la opcion generate HashCode y equeals
		/*public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ISBN;
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())//en ves de utilizar intanceof utiliza getClass para saber de q clase biene el objeto
				return false;
			Libro other = (Libro) obj;//casting
			if (ISBN != other.ISBN)
				return false;
			return true;
		}*/
			
	}

	private String titulo,autor;
	private int ISBN;
	
}

/*anotacion a la hora de manejar colecciones es muy inportante saber manejar este metodo equals() y HashCode()
 * ya que el metodo HasCode nos da el codigo de referencia de la posicion en la memoria para clases predefinidas
 * pero no para clases propias nuestras por eso tambien hay que soobreescribirlas como a equals
 * es decir cada ves que sobreescrivimos el metodo equals tambien debemos sobbreescribir el metodo HasCode*/
