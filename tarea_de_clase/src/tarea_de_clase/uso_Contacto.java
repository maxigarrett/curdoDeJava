package tarea_de_clase;

public class uso_Contacto 
{

	public static void main(String[] args)
	{
		contacto micontacto=new contacto("maxi",26);
		contacto micontacto2=new contacto("jorge",27);//instancia de segundo objeto de tipo contacto 
		
		micontacto.imprimir();//imprime primer parametros
		micontacto2.imprimir();//imprime segundo parametro
	}

}

class contacto 
{
	//variables de clase
	private final String nombre;
	 private int edad;
	 
	 //metodo constructor
	public contacto(String nombre,int edad) //parametros
	{
		this.nombre=nombre;//con la palabra reservada this hace referencia a la variable y se pone cuando
		                   //cuando el nombre de paramtro y la de la variable son iguales
		this.edad=edad;
	}
	
	
	//metodo que imprime los valores almacenados por parametros
	public void imprimir() 
	{
		System.out.println(nombre+"edad: "+ edad);
	}
}
