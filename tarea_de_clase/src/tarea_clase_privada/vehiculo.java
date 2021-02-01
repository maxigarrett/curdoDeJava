package tarea_clase_privada;

public class vehiculo
{
	public vehiculo() 
	{
		ruedas=4;
		largo=200;
		ancho=300;
		motor=1600;
		peso=500;
	}
	
	//metodos SETTER
	public void configura_ruedas (int ruedas) 
	{
		this.ruedas=ruedas;
	}
	
	public void configura_largo(int largo) 
	{
		this.largo=largo;
	}
	
	public void configura_ancho(int ancho) 
	{
		this.ancho=ancho;
	}
	
	public void configura_motor(int motor) 
	{
		this.motor=motor;
	}
	
	public void configura_peso(int peso) 
	{
		this.peso=peso;
	}
	
	// metodos GETTER
	public int dame_ruedas() 
	{
		return ruedas;
	}
	
	public int dame_largo() 
	{
		return largo;
	}
	
	public int dame_ancho() 
	{
		return ancho;
	}
	
	public int dame_motor() 
	{
		return motor;
	}
	
	public int dame_peso() 
	{
		return peso;
	}
	//atributos o variables de clase
	private int ruedas;
	private int largo;
	private int ancho;
	private int motor;
	private int peso;

}
