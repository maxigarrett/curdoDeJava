package programacion_generica_herenciaYTipoComodion;

public class empleado 
{
	public empleado(String nombre,int edad, double salario) 
	{

		this.nombre=nombre;
		this.edad=edad;
		this.salario=salario;
		
	}
	
	public String dameDatods() 
	{
		return "el empleado se llama: " + nombre + " tiene " + " años " + " y su salario es " + salario;
	}
	
	private String nombre;
	private int edad;
	private  double salario;
}
