package programacion_generica_herenciaYTipoComodion;

public class herenciaGenericos
{

	public static void main(String[] args)
	{
		//vamos a recordar el principio de sustitucion es un que permite la herencia
		empleado administrativa=new empleado("elena",45,1500);
		
		jefe directoraComercial=new jefe("ana",27 ,3500);
		
		//ahora vamos a ver el principio de sustitucion que marca la herencia "es un"....
		//ya que un jefe de seccion es un empleado por eso podemos crear un objeto empleado y almacenar
		//dentro de ese objeto la instancia jefe que hicimos y pasa a ser de tipo empleado
		empleado nuevoempleado=directoraComercial;

		//lo que hicimos arriba no es posible en clases genericas
		
		pareja<empleado> administrativa1=new pareja<empleado>();
		
		
		
		pareja<jefe> directoraComercial1=new pareja<jefe>();
	
		
		//ahora si aplicamos el principio de sustitucion no va a funcionar si sacamos el comentario marca
		//el error
		//pareja<empleado> nuevoempleado1=directoraComercial1;
		
		//el metodo que creamos era estatico por eso va el nombre de la clase que creamos primero y despues
		//el metodo y como por argumento pedia un tipo empleado en el metodo de la clase pareja y 
		//administrativa1 es de tipo empleado y jefe no hay problema ya que le metodo imprimirTrabajador
		//esta explicado en clase pareja ese metodo lo que hace
		pareja.imprimirTrabajador(administrativa1);
		pareja.imprimirTrabajador(directoraComercial1);
		
	}

}
