package instanciacion;

public class alumno 
{
	String nombre;
	String apellido;
	int dni;
	
	public alumno(String nombre,String apellido,int dni) 
	{
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
	}

	
	public void imprimeAlumno() 
	{
		System.out.println(nombre+" "+apellido+" "+dni);

	}
}
