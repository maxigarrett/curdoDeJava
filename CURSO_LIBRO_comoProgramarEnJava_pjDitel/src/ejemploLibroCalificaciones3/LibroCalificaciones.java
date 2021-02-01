package ejemploLibroCalificaciones3;

public class LibroCalificaciones 
{
	public LibroCalificaciones(String nombre) 
	{
		NombreDelCurso=nombre;
	}
	
	public String DameNombreCurso() 
	{
		return NombreDelCurso;
		
	}
	
	public void MuestraMensaje() 
	{
		System.out.println("el nombre del curso es " + DameNombreCurso());
	}
	
	private String NombreDelCurso;

}
