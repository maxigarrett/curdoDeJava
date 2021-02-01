package metodos_genericos_propios;

public class clase_empleadoParaUsarConCalseMetodosGenericos1
{
	
	public clase_empleadoParaUsarConCalseMetodosGenericos1(String nombre,int edad,double salario) 
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
private double salario;
}
