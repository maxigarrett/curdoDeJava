package poo;

                                                   
final public class jefe_empleado extends empleado implements jefes//con el final hace que no se puedan agregar mas clases se corta la herencia
{
	public jefe_empleado(String nom,double suel,int anio,int mes, int dia)
	{
		
		//como el constructor tiene parametros el super tambien hay que pasarle el nombre de las variables
		//del constructor y como hay dos en la otra clase depende de la cantidad de variables es al que
		//va a llamar
		super(nom, suel, anio, mes, dia);
	}
	public double dameSueldo() //el triangulo verde significa que esta sobreescribiendo la variable con el mismo nombre en clse empleado 
	{
		double sueldojefe=super.dameSueldo();//con el super le decis que llame a dameSueldo de la calase padre(empleado) y sumamos el incentivo
		                                     //es decir que no llame a dameSueldo de la clase jefe_empleado sino al de el metodo construido de empleado.
		
		return sueldojefe + insentivo;//suma de incentivo
	}
	
	
	public void configura_insentivo(double b) 
	{
		insentivo=b;
	}
	public String tomar_decisiones(String decision) //metodo abtracto creado en interfaz jefe
	{
		return "un miembro de  la direccion ha tomado la decision de: " + decision;
	}
	public double establece_bonus(double gratificacion) 
	{
		double prima=2000;
		return travajadores.bonus_base+gratificacion+prima;
		
	}
   private double insentivo;
}
