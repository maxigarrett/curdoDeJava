package creacion_de_clasePropiaGenerica;

public class uso_pareja 
{

	public static void main(String[] args) 
	{
		//ahora instanciamos la clase y como es generica y le especificamos con una T entre corchetes angulares 
		//en la instancia remplazamos esa t por el tipo de dato que querramos utilizar y le damos un 
		//nombre para trabajar con ella y  el valor esta null ya que en la otra clase al constructor le 
		//dijimos que la variable encapsulada de tipo generico va a ser null
		pareja<String> una=new pareja<String>();
		
		//con el metodo seter cambiamos el valor con el que queremos trabajar que en este caso queremos
		//trabajar con String "una" ya esta preparado para recibir o ser modificada de null a String porque
		//al intanciarlo le pasamos entre corchetes angulares un String
		una.setprimero("juan");
		
		//muestra datos
		System.out.println(una.getprimero());
		
		
		//instanciamos clase persona
		persona pers1=new persona("ana");
		
		//ahora es cuando toca crear una segunda instanciade nuestra de clase generica pareja para manejar
		//objetos de tipo persona
		pareja<persona> otra =new pareja<persona>();
		
		//ahora la segunda instacia "otra" esta preparada para recibir un objeto de tipo persona y con el
		//metodo setprimero  recibe por parametros un generico ahora esta esperando un dato de tipo
		//persona ya que lo especificamos en corchetes angulares de la segunda instancia y por parametro
		//le pasamos la instacia pers1 de la clase persona que pide un String
		otra.setprimero(pers1);
		
		System.out.println(otra.getprimero());
	}

}


class persona
{
	public persona(String nombre) 
	{
		this.nombre=nombre;
	}
	
	//devuelve datos almacenados en nombre y que en la instancia de esta clase llamamos ana 
	public String toString()
	{
		return nombre;
	}
	private String nombre;
}
