package uso_threads;

public class sincronizando_Hilos 
{

	public static void main(String[] args)
	{
		//intancia de la clase que implementa la clase para manejar los  hilos
		hilosVarios hilo1=new hilosVarios();
		
		hilosVarios hilo2=new hilosVarios();
		//comienza la ejecucion del hilo
		hilo1.start();
		//el metodo join le dice que ejecute este hilo y hasta que no muera o termine que no ejecute el otro
		//en algunos programas complejos por ahi vamos a querer que se ejecute completamente un hilo y despues
		//otro este metodo join lanza excepcion
		try 
		{
			hilo1.join();
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		System.out.println("termino hilo 0" );
		//ejecuta el segundo hilo
		hilo2.start();
		
		try
		{
			hilo2.join();
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		//como en el main este sistem como el otro tambien es un hilo y si no lo sincronizamos aparecera 
		//intercalado con el hilo2 por eso hilo dos tambien le vamos a poner un join
		System.out.println("termino las tareas de hilo 1");
		
	}

}


//otra forma de manejar hilos ademas de implementar la interfaz Runnable es crear una clase  que herede de
//Thread y nos permite utilizar todos sus metodos incluso el run que implementa la interfaz
//una ves creda la clase hay que soobreescribir el metodo run
class hilosVarios extends Thread
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