package poo;

import java.util.*;
public class uso_empleado_sobrecargaDeConstructor
{

	

	public static void main(String[] args)//metodo main
	{
		//clase empleado,  empleado1 variable,   new empleado() llama al constructor que se llama empleado ya que tiene que tener el mismo nombre que la clase
		/*empleado empleado1=new empleado("MAXI GARRET ", 85000,1990,12,17);
		empleado empleado2=new empleado("PEPE MORENO ", 95000,1998,06,02);
		empleado empleado3=new empleado("JOSE MARTIN ", 105000,2002,03,15);
		
		empleado1.subeSueldo(15); //incremento del sueldo 
		empleado2.subeSueldo(15);
		empleado3.subeSueldo(15);
		
		System.out.println("NOMBRE :" + empleado1.dameNombre() + " su sueldo es de: " + empleado1.dameSueldo()
		+ "fecha de ingreso a la empresa " + empleado1.dameFechaContrato());
		System.out.println("NOMBRE :" + empleado2.dameNombre() + " su sueldo es de: " + empleado2.dameSueldo()
		+ "fecha de ingreso a la empresa " + empleado2.dameFechaContrato());
		System.out.println("NOMBRE :" + empleado3.dameNombre() + " su sueldo es de: " + empleado3.dameSueldo()
		+ "fecha de ingreso a la empresa " + empleado3.dameFechaContrato());*/
		
		//almacenamos a los empleados dentro de un array yla herencia de jefe_empleado
		jefe_empleado jefe_RRHH=new jefe_empleado("juan rupero",55000,20006,9,7);//instanciacion de clase jefe_empleado
		jefe_RRHH.configura_insentivo(2570);//incentivo echo en la clase jefe_empleado
		
		empleado[] misEmpleados=new empleado[6];//almacenaremos los datos en array(vector)
		misEmpleados[0]=new empleado("MAXY GARRETT",85000,1990,12,17);//primera posicion del array
		misEmpleados[1]=new empleado("PEPE MORENO",95000,1998,06,02);//segunda
		misEmpleados[2]=new empleado("JOSE MARTIN",105000,2002,03,15);//tercera
		misEmpleados[3]=new empleado("maria jose");//lo demas aparece por defecto esta echo en segundo constructor
		misEmpleados[4]=jefe_RRHH;                  //polimorfismo.principio de sustitucion
		misEmpleados[5]=new jefe_empleado("jesefa lalo",95000,2000,02,04); //si el polimorfismo esto no anda ademas solo aumenta el sieldo del primer trabajador
		//convertimos un tipo en otro
		//lo que hay en misEmpleados[5] lo convertimos en la clace jefe_empleado
		//para poder usar el metodo configura_incentivo y aumentarle a el nuevo objeto creado //para que pueda umentar este tambien hay que usar refundicion
        jefe_empleado jefe_finanzas=(jefe_empleado) misEmpleados[5];                          //double num1=7.1;
		jefe_finanzas.configura_insentivo(55000);                                             //int num2=(int) num1 asi es refundicion
		
		//principio de sustitucion
		/*empleado director_comercial=new jefe_empleado("sandra",85000,2012,05,05);
		Comparable ejemplo=new empleado("oscar",95000,2011,06,07);//instancia perteneciente a la interfaz
		                                                      //pero a la hs de instanciar tiene que ser de tipo empleado
		                                                      //porque no se puede instanciar una interfaz directamente
		
		//preguta con instanceof si pertenece al tipo de intancia ya echa
		if(director_comercial instanceof empleado) 
		{
			System.out.println("director_comercial: es de tipo jefe_empleado");
		}
		if(ejemplo instanceof empleado) 
		{
			System.out.println("ejemplo: implementa la interfaz Comparable");
		}*/
		
		
		/*for(int i=0;i<misEmpleados.length;i++) 
		{
			misEmpleados[i].subeSueldo(15);
		}*/
		
		System.out.println(jefe_finanzas.tomar_decisiones("dar mas dias de vacaciones a los empleados"));
		System.out.println("el jefe "+ jefe_finanzas.dameNombre() + " tiene un bonus de: "+jefe_finanzas.establece_bonus(500));
		System.out.println(misEmpleados[3].dameNombre()+" tiene un bonus de "+ misEmpleados[3].establece_bonus(200));
		//bucle for each se puede usar en ves de el bucle for tradicional
		for(empleado e: misEmpleados) 
		{
			e.subeSueldo(15);   
		}
		/* for(int i=0;i<misEmpleados.length;i++) 
		{
			System.out.println("NOMBRE: " + misEmpleados[i].dameNombre() + "USELDO: " + 
		misEmpleados[i].dameSueldo() + "FECHA DE INGRESO A LA EMPRESA: " + misEmpleados[i].dameFechaContrato());
		} */
		
		Arrays.sort(misEmpleados);//metodo que permite ordenar objetos de un arrays y este arrays se llama misEmpleados
		
		for(empleado a:misEmpleados)//caundo recorra el vector y llegue al polimorfismo el porcentaje
		{                          //del sueldo de empleado(dameSueldo) pasara a hacer el incentivo del jefe_empleado 
			                       //y como se da cuenta el bucle for de a cual llamar es porque java lo hace 
			                       //automaticamente(enlazado dinamico)
			System.out.println("NOMBRE: " + a.dameNombre() + " SUELDO: " + 
			a.dameSueldo() + " FECHA DE INGRESO A LA EMPRESA: " + a.dameFechaContrato() +
			a.decimeid());
					
		}

	}

}
//nombre de clase empleado
class empleado implements Comparable,travajadores//todos los empleados o elementos del array implementan interfaz Comparable
{                                   //es decir obliga a usarla                       
	
	
	// se pone public para que se pueda acceder al constructor a la informacion desde otras clases 
	//lo que esta en parentesis son las variables o mejor dicho los parametros o argumentos
	public empleado(String nom,double suel,int anio,int mes,int dia) //si la clase es empleado el constructor tambien tiene que llevar el mismo nombre
	{
		id=idsiguiente;
		idsiguiente++;
		nombre=nom;
		sueldo=suel;
		
		// el objetivo es crear una fecha nada mas osea año mes y dia
		GregorianCalendar calendario=new GregorianCalendar(anio, mes-1,dia);//operador new llamar al constructor de la clase    //da el dia mes y año que le ingreses de tipo entero
		altacontrato=calendario.getTime();//metodo devuelve la fecha con metodo getime() y se almacena en altacontrato
	}
	public  String decimeid() 
	{
		return " su id es: " + id;
	}
	public empleado(String nom) //sobrecarga de constructor otro igual creado abajo pero no debe
	{                        //llevar los mismos parametros que el primero asi java puede distinguir
		                        //cual esta utilizando
		this(nom,3000,2000,01,01);
		//lo que hace el this en este caso es llamar al otro constructos y le pasamos
		//un parametro estandar por si solo conocemos el nombre
		//no causa error porque por parametro solo hay un String asique sabe el programa a q constructor
		//se refiere
		
		
		
	}
	
	public String dameNombre()//GETTER 
	{
		return nombre;
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
	public int compareTo(Object miObjeto) //comparar este objeto con otro especificado por orden
	{                                     //compara empleados entre si
		
		empleado otroEmpleado=(empleado) miObjeto;//casting o refundicion para pasar miObjeto a tipo empleado
		                                          //asi poder compara sus sueldos y ordenarlos
		if(this.sueldo<otroEmpleado.sueldo) 
		{
			return -1;
		}
		if(this.sueldo>otroEmpleado.sueldo) 
		{
			return +1;
		}
		return 0;
	}
	
	public double establece_bonus(double gratificacion) 
	{
		return travajadores.bonus_base+gratificacion;
	}

		
	//variables de clase es lo mismo declararlas a lo ultimo que al principio
	private final String nombre;
	private double sueldo;
	private Date altacontrato;
	private int id;
	public static int idsiguiente=1;
}
