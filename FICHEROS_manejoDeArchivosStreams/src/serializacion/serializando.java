package serializacion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class serializando
{

	public static void main(String[] args)
	{
		
		administrador jefe=new administrador("maxi",80000,2005,12,5);
		
		jefe.setincentivo(5000);
		
		//creamos una arrayque va a tener tres elementos que es de tipo empleado
		empleado[] personal=new empleado[3];
		personal[0]=jefe;
		personal[1]=new empleado("ana",25000,2008,10,1);
		personal[2]=new empleado("luis",18000,2012,9,15);
		
		try 
		{
			//crea un flujo de datos para transferir un objeto desde dentro hacia fuera del programa java
			ObjectOutputStream  escribiendoFichero=new ObjectOutputStream(new FileOutputStream("C:/Users/usuario/Desktop/serializacion/empleado.dat"));
			
			//ahora hay que escribir este objeto que queremos guardar ¿y como se llama el objeto que que
			//queremos llevar al exterior? es personal que es el objeto de la clase empleado que 
			//implementa la interfaz
			//este metodo que pide por parametro el objeto al que vamos a escribir y serializar
			escribiendoFichero.writeObject(personal);
			
			escribiendoFichero.close();
			
			//justo despues de cerrar el flujo de datos hacia el exterior creamos un objeto de tipo
			//ObjectInputStream para rescatar todos esos datos enviados en forma de bytes
			ObjectInputStream recuperandoFichero=new ObjectInputStream(new FileInputStream("C:/Users/usuario/Desktop/serializacion/empleado.dat"));
			
			//cuando leemos los bytes de esos datos del objeto se transforma en un array y una ves estemos
			//leyendo ese array de bytes lo tendremos que almacenar para recorrerlo y eso objeto es de tipo
			//del q estamos tratando que es de tipo empleado
			empleado[]personalrecuperado=(empleado[])recuperandoFichero.readObject();//hacemos un casting y pasamos recuperandoFichero que es un objeto y lo convertimos en array 
																					//y se almacena en el array creado personalrecuperado
			
			recuperandoFichero.close();
			
			//for each le decimos el tipo de dato que es "empleado" le damos un nombre que es de objeto "e" y le 
			//decimos que recorra personalrecuperado
			for(empleado e:personalrecuperado) 
			{
				System.out.println(e);
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}

	}

}

//vamos a serializar un bojeto y tenemos que saber cual es y el que queremos es el objeto empleado
//por eso va a implementar la interfa Serializable osea le decimos a esta claseque los objetos dentro de
//ella son subsebtibles a ser serializados es decir pasados a bytes
class empleado implements Serializable
{
	//
	private static final long serialVersionUID = 1L;
	public empleado(String n,double s, int agno,int mes,int dia) 
	{
		nombre=n;
		sueldo=s;
		
		GregorianCalendar calendario=new GregorianCalendar(agno,mes,dia);
		
		fechacontrato=calendario.getTime();
	}
	
	public String getnombre() 
	{
		return nombre;
	}	
	
	public double getsueldo() 
	{
		return sueldo;
	}
	
	public Date getfechacontaro() 
	{
		return fechacontrato;
	}
	
	
	//lo que le pasemos a este metodo por parametros servira para hecar la formula matematica 
	//para darle el incetivo y subir el sueldo de algun empleado
	public void subirsueldo(double porcentaje) 
	{
		double aumento=sueldo*porcentaje/100;//se almacena en aumento el incentivo un poco mas del sueldo
		
		sueldo+=aumento; //le agregamos al sueldo basico el incentivo creado anteriormente,un poco mas de dinero
	}
	
	//este metodo es muy inportante toString() y pertenece a la clase Object
	//el metodo toString() se utiliza para especificar una descrpcion de nuestra clase. Es como 
	//vervalizar que es lo que hace nuestra clase o pasar a texto que es lo q hace nuestra clase hasta
	//ahora no la habiamos utilizado porque recurriamos a System.out.prinln("nombre" + nombre + ,etc);
	public String toString() 
	{
		return "nombre= " + nombre + " sueldo= " + " , fecha de contrato=" + fechacontrato;
	}
	
	private String nombre;
	private double sueldo;
	private Date fechacontrato;
}

//-------------------------------------------------------------------------------------------------------


class administrador extends empleado
{
	//cuando serializamos objetos y lo mandamos por la red java autamaticamente genera una version del
	//echo por eso con esta clase cuando actualicemos el programa y lo mandemos a un receptor remoto
	//lo podra leer si cambiamos algo como una variable metodo,etc sin esto cuando lo mandemos y se genere
	//el archivo en la carpeta y depues cambiamos una variable y le ponemos otro nombre no lo podra leer
	
	private static final long serialVersionUID = 1L;

	public administrador(String n,double s,int agno,int mes, int dia) 
	{
		super(n,s,agno,mes,dia);
		
		incentivo=0;
	}
	
	
	//para ver el sueldo del administrador
	public double getsueldo() 
	{
		double sueldobase=super.getsueldo();
		
		return sueldobase + incentivo; 
	}
	
	public void setincentivo(double b) 
	{
		incentivo=b;
	}
	
	
	//para dar una descripcion de lo que hace esta clase
	public String toString() 
	{
		return super.toString() + " incentivo= " + incentivo;
	}
	
	private double incentivo;
}
	