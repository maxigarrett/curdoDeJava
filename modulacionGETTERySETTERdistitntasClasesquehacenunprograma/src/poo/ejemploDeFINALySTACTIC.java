package poo;

public class ejemploDeFINALySTACTIC
{

	public static void main(String[] args)
	{
		//clase    variable      constructor y el new llama al constructor
		trabajadores trabajador1=new trabajadores("maxi");
		trabajadores trabajador2=new trabajadores("paco");
		trabajadores trabajador3=new trabajadores("yack");
		
		trabajador1.configura_seccion("RR.HH");
		
		System.out.println(trabajador1.dame_datos());
		System.out.println(trabajador2.dame_datos());
		System.out.println(trabajador3.dame_datos());
		System.out.println(trabajadores.dameidsiguiente());
                          //clase         variable estatica 
	}

}


class trabajadores
{
	
	public trabajadores(String nom)//constructor con un parametro 
	{
		nombre=nom;
		seccion="administracion";
		id=id_siguiente;//id va a valer 1 ya que a id_siguiente le di ese valor
		id_siguiente++;//y con id_siguiente va a ir aumnetando de 1 en 1 automaticamnente
		               //cada ves que creamos un trabajador aumentara su id
	}
	
	
	public void configura_seccion(String seccion) //SETTER
	{
		this.seccion=seccion;//coincide el parametro con la variable entonces la variable va con un this
	}
	
	
	public String dame_datos() //GETTER
	{
		return "el nombre " + nombre + " y la seccion donde trabaja es " + seccion + " id: " + id;
	}
	
	
	
	public static String dameidsiguiente() //estatico asique pertenece a la clase trabajadores
	{
		return "la id siguiente es " + id_siguiente;
	}
	
	private final String nombre;//con private final no se puede modificar el nombre inicial no siquiera con un setter
	private String seccion;
	private int id;
	private static int id_siguiente=1; /*static permite que la variable creada no va a pertenecer
	a ningun objeto sino que es una variable de clase que es en este caso trabajadores
	es decir todos los objetos comparten la misma variable y las demas variables sin static se hace
	una copia para cada variable*/
}