package vectores;

public class persona
{
	//variable de clases
	String nombre;
	String apellido;
	int dni;
	String direccion;
	int telefono;
	
	//metodo constructor
	public persona(String nombre,String apellido,int dni,String direccion,int telefono) 
	{
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.direccion=direccion;
		this.telefono=telefono;
	}
	
	//metodo para mostrar datos almacenados
	
	public void dameDatos() 
	{
		System.out.println(nombre+" "+ apellido+" "+ dni+" "+direccion+" "+telefono);
	}
	

}
