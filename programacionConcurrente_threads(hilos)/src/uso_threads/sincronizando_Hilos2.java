package uso_threads;

public class sincronizando_Hilos2 
{

	public static void main(String[] args)
	{

		//intancia de la clase que implementa la clase para manejar los  hilos
		hilosVarios1 hilo1=new hilosVarios1();
		
		//por parametros al constructor le pasamos el hilo1 que es la primer instancia y le decimos en la 
		//clase que hasta que no termine las tareas del hilo1 no comience con la otra
		hilosVarios2 hilo2=new hilosVarios2(hilo1);
		
		//aunque le indiquemos primero hilo2 para que comience no lo va a ser hasta que ejecute el hilo1
		hilo2.start();
		
		//comienza la ejecucion del hilo
		hilo1.start();
	
		
		//ahora el main quedo libre y se imprimira primero este mensaje y despues se ejecutaran los hilos
		//esto quiere decir que liveramos el hilo del main y puede ejecutar la instruccion del System mientras
		//sincroniza los hilos es decir puede hacer tareas simultaneas
		System.out.println("termino las tareas de hilo 1");

	}

}



//otra forma de manejar hilos ademas de implementar la interfaz Runnable es crear una clase  que herede de
//Thread y nos permite utilizar todos sus metodos incluso el run que implementa la interfaz
//una ves creda la clase hay que soobreescribir el metodo run
class hilosVarios1 extends Thread
{
	public void run() 
	{
		for(int i=0;i<15;i++) 
		{
			//este getName me dara el nombre que por defecto le da a un hilo que se esta ejecutando
			//si hicimos dos instancias sera hilo 0 y hilo1 y asi sucesivamente dependiendo de las intancias
			//al no sincronizar los hilos cuando se ejecutan se van intercalando se ejecuta hilo1 y puede ir
			//intercalado con dos hilos 0 y asi hasta completar el bucle for es decir sin terminar de ejecutar
			//un hilo ejecuta el otro y sin terminar el segundo sigue por el primero
			System.out.println("ejecutando hilo " + getName());
			
			//para que se ejecute de manera mas lenta y al metodo sleep le pasamos que se ejecute un hilo
			//cada 700 milisegundos
			try
			{
				Thread.sleep(400);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			
		}
	}
}

class hilosVarios2 extends Thread
{
	public hilosVarios2(Thread hilo) 
	{
		this.hilo=hilo;
	}
	
	public void run() 
	{
		//le vamos a decir que esta tarea no comience hasta que el hilo que le hemos pasado por parametro
		//al constructor no haya terminado 
		
		try 
		{
			hilo.join();
		} catch (InterruptedException e1)
		{
			e1.printStackTrace();
		}
		
		for(int i=0;i<15;i++) 
		{
			System.out.println("ejecutando hilo " + getName());
			
			try 
			{
				Thread.sleep(400);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
	private Thread hilo;
}