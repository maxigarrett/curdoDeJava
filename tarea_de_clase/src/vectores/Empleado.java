package vectores;

public class Empleado extends persona 
{	
	private int legajo;

	public Empleado(String nombre, String apellido, int dni, String direccion, int telefono,int legajo)
	{
		
		super(nombre, apellido, dni, direccion, telefono);
		this.legajo=legajo;
	}
	
	
	public void mostrarempleado() 
	{
		System.out.println(nombre+" "+ apellido+" "+ dni+" "+direccion+" "+telefono+" "+legajo);
	}
	

}
