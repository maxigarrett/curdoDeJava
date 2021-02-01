package banco;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class banco_sincronizar3_condicinesDeBloqueo 
{

	public static void main(String[] args)
	{
		banco3 mibanco=new banco3();
		
		for(int i=0;i<100;i++) 
		{
			ejecucionTransferencias3 r=new ejecucionTransferencias3(mibanco,i,2000);
			
			Thread t=new Thread(r);
			
			t.start();
		}
		
	}

}

class banco3 
{
	public banco3()
	{
		cuentas=new double[100];
		
		for(int i=0;i<cuentas.length;i++) 
		{
			cuentas[i]=2000;
		}
		//le estamos diciendo que el bloqueo (cierrebanco) tiene que establecerce en base a una 
		//condicion(newCondition) y esa condicion la estamos llamando saldosuficiente.. porque lo creamos en el
		//constructor de la clase banco porque cada ves que creamos un banco ese banco ya ba con una condicion
		//(newCondition) y un bloqueo (cierrebanco) o mejor dicho un bloqueo con una condicion que se almacena
		//en objeto de tipo Condition llamado saldosuficiente  y esto me va a permitir usar ese objeto como 
		//condicion en cualquier metodo que pertenezca a esta clase es decir a la clase banco
		saldosuficiente=cierrebanco.newCondition();
	}
	
	public void transferir3(int cuentaorigen,int cuentadestino,double cantidadtransferir) throws InterruptedException 
	{
		cierrebanco.lock();
		try 
		{
			//se va a repetir indefinidamente siempre que la condicion sea cierta es decir siempre y cuando
			//el saldo de la cuenta sea menor que la cantidad a tranferir
			while(cuentas[cuentaorigen]<cantidadtransferir==true) 
			{
				System.out.println("----- cant insuficiente de la cuenta " + cuentaorigen + " saldo " + cuentas[cuentaorigen] + " transfiere una cant inposible de " + cantidadtransferir);
				
				//le decimos a nuestro codigo que mientras la condicion sea verdad el hilo permanezca a la espera
				//este metodo lanza excepcion ademas estemetodo de poner a la espera al hilo si queire realizar
				//una transferencia mayor a la cantidad de la cuenta hace otra tarea que es liberar el codigo
				//para que otro hilo entre
				saldosuficiente.await();
			}
			
			
				System.out.println("---cant ok de la cuenta " + cuentaorigen + " saldo " + cuentas[cuentaorigen] + " transfiere cantidad de " + cantidadtransferir +" a la cuenta " +cuentadestino);
			
		
			System.out.println(Thread.currentThread());
		
			cuentas[cuentaorigen]-=cantidadtransferir;
			
			System.out.printf("cant de cuenta %10.2f de cuenta %d para cuenta %d " ,cantidadtransferir , cuentaorigen ,cuentadestino );
	
			cuentas[cuentadestino]+=cantidadtransferir;
			
			System.out.printf("totalde la cuenta %10.2f " , damesaldo3());
			
			//cuando entra un hilo despues del que esta a la espera por no poder realizar la tranferencia el
			//siguiente que entra si cumple la la condicion entonces no entra al bucle while y realiza todas 
			//las operaciones y al final con el metodo signalAll despierta a todos los hilos que estan a la espera
			//y avisa que ya realizo la transaccion y que puede entrar el siguiente y quizas el este  hilo que
			//entro saco deniero de una cuenta y la puso donde el primer hilo no puede sacar porque su saldo es 
			//inferior entonces al despertar a todos los hilos este que estaba a la espera se fija en esa cuenta
			//y si puede realizar la transaccion sale del bucle while y hace las operaciones asi no se pierde ningun
			//hilo es decir que ahora todos los hilos hacen tranferencia tarde o temprano pero las hacen si o si
			//y no se pierde ninguno
			saldosuficiente.signalAll();
		}	
		finally 
		{
			cierrebanco.unlock();
			
		}
	}
	
	public double damesaldo3() 
	{
		double dame_cuentas=0;
		
		for(double a:cuentas) 
		{
			dame_cuentas+=a;
		}
		return dame_cuentas;
	}
	
	private Lock cierrebanco=new ReentrantLock();
	private double[]cuentas;
	private Condition saldosuficiente;
}



class ejecucionTransferencias3 implements Runnable
{	
	//crearemos un constructor que permita almacenar 3 datos primero un objeto de tipo banco con esta clase
	//voy a poder utilizar todos los metodos de la clase banco tanto el metodo transferencia como damesaldototal
	//tambien vamos a necesitar la cuenta de la que parte el dinero es decir la cuentaorigen y el tercer
	//parametro que es el saldo a tranferir es decir la cantidad maxima a transferir.. porque? porque no
	//tiene ningun sentido hacer una tranferencia de un inporte superior a dosmil pesos ya que las cuentas
	//tienen un maximo cada una de dosmil pesos iniciales
	public ejecucionTransferencias3(banco3 b,int origen,double max)
	{
		//se almacena en banco lo que le pasemos por parametro y ya con esto podemos utilisar sus metodos
		//de esa clase banco
		banco=b;
		Origen=origen;
		cantidadmax=max;
	}
	
	//metodo que va a ejecutar cada hilo es el metodo que va a arrancar cada una de las transferencias
	public void run() 
	{
		//una de las muchas opciones para crear un bucle infinito
		while(true) 
		{
			//vamos hacer que la cuenta de destino sea aleatoria con metodo random y vamos a crear un int
			//ya que cada cuenta va de 0 a 99
			//que es lo que hace Math.random()? va a generar un numero aleatorio entre 0 y 1 pero lo 
			//mulitiplicamos por 100 para que desplace la coma dos lugares y en ves de tener 0,2345
			//tendremos 23,45 pero con el castin (int) lo convertimos a entero definitivo osea 23
			int paraLaCuentaDestino=(int)(100*Math.random());
			
			//determinar la cantidad a tranferir. cantidadmax se lo pasamos por parametro y si la cnatidadmax
			//es de 2000 Math.random() desplazara la coma 3 lugares osea la cantidad de ceros que tenga el 
			//numero que la multiplique
			double cantidad=cantidadmax*Math.random();
				
			//instancia perteneciente a la clase banco	que la llamamos banco en los campos de clase
			//y nos permite utilisar sus metodos este metodo tranferencia hace todos las transacciones 
			//por eso es la mas importante y la ponemos dentro del metodo rum
			try 
			{
				banco.transferir3(Origen, paraLaCuentaDestino, cantidad);
			} 
			catch (InterruptedException e1) 
			{
				
				e1.printStackTrace();
			}
			
			//para que la pausa sea aleatoria tambien
			try
			{
				Thread.sleep((int)(Math.random()*10));
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		
	}
	private banco3 banco;
	private int Origen;
	private double cantidadmax;
	
}



//una condicion en el bloqueo permite el hilo que esta realizando esta o que pretende realizar esta
//tarea. este hilo se pone a la espera, no se pierde como ocurre ahora si no que se pone a la espera
//y se pone a la espera con un metodo await() con lo cual ese hilo se queda esperando pero ademas  de 
//ponerse a la espera realiza otra tarea que es la liberacion del codigo un hilo al entrar al metodo
//tranferencia lo primero que hace con el metodo lock() es bloquear ese codigo para que ningun otro hilo
//entre  pero si el metodo await() solo se limitara a poner el hilo a la espera ningun otro hilo
//podria entrar en el codigo a seguir realizando tranferencias.... entonces este metodo hace dos cosas
//por un lado pone el hilo a la espera y por otro libera el bloqueo de esta forma puede entrar otro hilo
//el segundo hilo que entra lo primero que hace es realizar un ingreso  en una cuenta que puede ser la 27
//entonces ese segundo hilo cuando termina de realizar todas las lineas de codigo tiene que hacer dos cosas
//por un lado liberar nuevamente el codigo de tranferencia y  realizar una segunda tarea que sera avisar 
//a todos los hilos que se encontraban a la espera de que se a realizado un ingreso para ver si ese ingreso
//satisface las condiciones del bloqueo lock() para que se pueda volver a ejecutar el codigo con el hilo que
//se encuentre a la espera es decir el segundo hilo agarra e  informa al hilo a la espera y le dice e 
//echo un ingreso en la 27 te sirve? y el hilo a la espera dira nono si no lo hiciste en el correspondiente
//cuenta donde se encuentra bloqueado porque quiere sacar mas dinero de lo que se encuentra en la cuenta 
//entonces ese hilo que quiere realizar esa transaccion que no puede hacer por el saldo insuficiente 
//continua a la espera y no se pierde
//pero supongamos que el hilo 3 ingresa y al codigo, hace la tranferencia a la cuenta que el primer hilo esta
//a la espera y es suficiente para poder realizar la transaccion que quuiere realiza es decir sacar el dinero
//que antes no podia por ser insuficiente entonces ese tercer hilo desbloquea el codigo e informa a los hilos
//y al primer que se encuentra esperando de que a realizado una tranferencia a esa ceunta del que el hilo
//se encuentra a la espera y no se perdio  y ese hilo que esta esperando dice si mesirve lo que hiciste y puedo
//realizar esa tarea entonces ese hilo que estaba ala espera por no poder hacer la transaccion hace su trabajo
//libera el codigo y entra el siguiente y hece lo mismo todo esto es para que no se pierda ninguna transaccion
//porque como esta el programa echo los hilos se pierden por no poder realizar una tranferencia si el saldo de la 
//cuenta es menor a la tranferencia que desea hacer el programa
//en la clase ReentranLock tiene un metodo que se llama newCondition() este permite crear un bloqueo pero con una 
//condicion este metodo devuelve un objeto de tipo Condition y que es Condition pues una interfaz y echando un 
//vistazo a los metodos de esta interfaz tiene el metodo await() y otro importante que es el signalAll() que es el
//metodo que informa a todos los hilos de que se ah echo una accion para que estos hilos que estan a la espera
//despierten 