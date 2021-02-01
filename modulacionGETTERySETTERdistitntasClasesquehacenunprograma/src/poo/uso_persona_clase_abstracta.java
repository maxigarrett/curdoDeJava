package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class uso_persona_clase_abstracta
{
   public static void main(String[]args) 
   {
	   persona[] laspersonas=new persona[2];
	   laspersonas[0]=new empleado2("Luis Conde",50000,2009,02,25);//empleado2 subclase 
	   laspersonas[1]=new alumno("Ana Lopez","Programador");//alumno clase creada consus metodos
	   
	   for(persona e:laspersonas) //for mejorado
	   {
		 System.out.println(e.dameNombre()+ " "+e.dameDescripcion()); //dameDescripcion sobrescribe a las dos
		 //clases empleado2 y alumno el bucle se encargara de resolver cual es cual para mostrar los datos de la variable
	   }
   }
}
abstract class persona
{
	public persona(String nom)
	{
		nombre=nom;
	}
	public String dameNombre() //GETTER
	{
		return nombre; 
	}
	
	public abstract String dameDescripcion();//metodo abstracto por lo tanto la clase debe ser igual
	                   //un metodo abstracto va sin llaves y con punto y como ademas no se construye solo se define
	private String nombre;
}



 class empleado2 extends persona//empleado2 ereda de persona
{
	
	public empleado2(String nom,double suel,int anio,int mes,int dia) 
	{
		super(nom);//al marcar la herencia con super llamamos al constructor de la superclase y tiene un parametro
		         //de tipo String por lo tanto en super va el nombre de la variable por parametro
		id=idsiguiente;
		idsiguiente++;
		sueldo=suel;
		
		// el objetivo es crear una fecha nada mas osea año mes y dia
		GregorianCalendar calendario=new GregorianCalendar(anio, mes-1,dia);//operador new llamar al constructor de la clase    //da el dia mes y año que le ingreses de tipo entero
		altacontrato=calendario.getTime();//metodo devuelve la fecha con metodo getime() y se almacena en altacontrato
	}
	
	public String dameDescripcion() 
	{
		return"este empleado tiene un id: " + id + " con un sueldo de: " + sueldo;
	}
	
	
	public  String decimeid() 
	{
		return " su id es: " + id;
	}
	
	
	
	public double dameSueldo() //GETTER
	{
		return sueldo;
	}
	public Date dameFechaContrato() //GETTER
	{
		return altacontrato;
	}
	public void subeSueldo(double porcentaje)//SETTER 
	{
		double aumento=sueldo*porcentaje/100;
		sueldo+=aumento;
	}

		
	//variables de clase es lo mismo declararlas a lo ultimo que al principio
	
	private double sueldo;
	private Date altacontrato;
	private int id;
	public static int idsiguiente=1;
}
 
class alumno extends persona
{
	public alumno(String nom,String car) 
	{
	  super(nom);	
	  carrera=car;
	}
	public String dameDescripcion() 
	{
		return "este alumno esta estudiando la carrera: "+ carrera;
	}
	private String carrera;
}