package instanciacion;

public class usoContacto2
{

	public static void main(String[] args)
	{
		contactofull micontacto=new contactofull("maxi",1231243);//depende de lo que pasamos por parametro es el 
		micontacto.imprimir();                                                        //constructor que toma
		
		contactofull contacto2=new contactofull("juan",12312312,120403);
		contacto2.imprimir();
		
		contactofull c=new contactofull("jose",122872385,120304,"juan@gmail.com","corrientes 345");
		c.imprimir();
	}

}

class contactofull 
{
	private String nombre;
	private long tel;
	private long fecha_nacimiento;
	private String email;
	private String direccion;
	
	contactofull(String cadena,long numero)
	{
		nombre=cadena;
		tel=numero;
	}
	contactofull(String cadena,long numero,long fecha)
	{
		nombre=cadena;
		tel=numero;
		fecha_nacimiento=fecha;
	}
	contactofull(String nombre,long numero,long fecha,String ema,String dir)
	{
		this.nombre=nombre;
		tel=numero;
		fecha_nacimiento=fecha;
		email=ema;
		direccion=dir;
	}
	public void imprimir() 
	{
		System.out.println(nombre+ " tel: "+ tel+" " +fecha_nacimiento+" "+ email+" "+direccion);
	}
}