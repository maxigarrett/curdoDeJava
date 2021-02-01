package programacion_generica_herenciaYTipoComodion;

public class jefe extends empleado
{
	public jefe(String nombre, int edad, double salario) 
	{
		super(nombre, edad, salario);
		
	}
	
	double incentico(double inc) 
	{
		return inc;
	}
	

}
