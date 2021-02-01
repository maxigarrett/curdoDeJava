package arraylist;

import java.io.File;

public class uso_Arraylist 
{

	public static void main(String[] args)
	{
		//vamos a ver si somos capaces de almacenar en principio objetos de tipo String
		//en este ejemplo usamos un ejemplo para saber lo inportante que es la programcion generica y en
		//este caso no la utilizaremos por lo que trae inconvenientes en tiempo de compilacion(a la hora
		//de escribir codigo no marca error)
		
		//el constructor pide por parametro un tipo entero para saber el tipo de dimencion del array
		//y va a contener 5 elemtos de tipo objeto para utilizar cualquier tipo de datos creada en la clase
		//Arraylist
		Arraylist archivos=new Arraylist(5);
		
		//almacenamos dentro de este objeto utilizando la clase add los objetos en este caso de tipo String
		
		archivos.add("juan");//posicion 0
		archivos.add("maria");//posicion 1
		archivos.add("ana");//posicion 2
		archivos.add("sandra");//posicion 3  cinco posiciones
		//como se ve error de compilacion no hay pero este array esta almacenando String y no hicimos el
		//casting para manejar archivos de tipo File pero a la hora de ejecutar el programa caera ya que
		//si le decimos al metodo get que en ves de darnos una posicion donde hay String que nos de la 
		//posicion del File sera el 4 caera porque no hay un castin echo para el file
		archivos.add(new File("gestionpedidos.accdb")); //posicion 4
		
		//creamos una variable de tipo String para almacenar dentro de ese nombre lo que hay en el array
		//como en enste caso son String  y con metodo get le decimos la posicion que queremos ver y lo 
		//imprimimos pero al ser el metodo de tipo Object ya que queremos almacenar cualquier tipo de
		//objetos no puede mostrar el String porque lavariable archivo es de tipo Object y hay que hacer 
		//un casting 
		String nombrepersona=(String)archivos.get(4);
		System.out.println(nombrepersona);
		
		//ahora queremos almacenar un objeto de tipo File
		/*Arraylist archivos2=new Arraylist(1);
		archivos2.add(new File("gestionpedidos.accdb"));//no marca error en tiempo de compilacion
		
		File nombre=(File)archivos2.get(0);
		System.out.println(nombre);
		
		//como vemos la clase puede manejar tanto String como File pero hay que hacer castin a cada 
		//instancia y es molesto y engorroso*/
		
	}

}
