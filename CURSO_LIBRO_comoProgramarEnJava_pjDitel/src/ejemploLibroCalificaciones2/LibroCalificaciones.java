package ejemploLibroCalificaciones2;

public class LibroCalificaciones
{
	public void estableceNombreDelCurso(String nombre) 
	{
		this.nombre=nombre;
	}
	
	public String dameNombreCurso() 
	{
		return nombre;
	}
	
	public void MuestraMensaje() 
	{
		System.out.println("bienvenido al libro de calificaciones \n" + dameNombreCurso());

	}
	
	String nombre;
}
