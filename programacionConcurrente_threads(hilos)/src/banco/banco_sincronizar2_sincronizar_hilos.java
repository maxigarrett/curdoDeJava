package banco;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//la clase ReentrantLock ayuda a sincronizar tareas complejas que con el joing se haria muy complicado
public class banco_sincronizar2_sincronizar_hilos 
{

	//el saldo total se pierde por que al no sincronizar los hilos porahi 3 hilos acceden al mismo indice
	//o cuenta por lo que se pierde el dinero porque mientras el hilo uno esta haciendo la transaccion
	//el hilo 2 va por detras y se le quita al mismo indice cuando el hilo 1 imprime el saldo total va a 
	//a faltar lo que saco el hilo 2 por eso vamos a usar un clase llamada Reentranlock para controlar 
	//la ejecucion de los hilos porque hacerlo con el metodo join al ser tantos hilos es muy dificil
	//el metodo ReentranLock implementa dos interfaces la interfaz serializable y Lock
	//la interfaz Lock vamos a usar dos metodo look() lo que hace es bloquear un trozo de codigo del programa
	//para que solo pueda ser ejecutado por un hilo  simultaneamente es decir bloquea 5 o 100 lineas de 
	//codigo o las q necesitemos para que esas lineas solamente puedan ser ejecutadas simultaneamnete
	//por un unico hilo..... y el metodo unloock()lo que hace es lo contrario lo que hace es desbloquear
	//esas lineas de codigo para que el sigueinte hilopueda ejecutarse  vamos a bloquear el que hace la 
	//trasferencia  es decir el public void tranferencias1() 
	//esos dos metodos son void es decir no son estaticos y esto quiere decir que para poder utilizar estos
	//metodos necesito crear una instancia perteneciente a la clase ReentranLoock
	public static void main(String[] args)
	{
		banco1 mibanco=new banco1();
		//utilizamos un bucle for para que realice transferencias de la cuenta 0 ala 99
		for(int i=0;i<100;i++) 
		{
			//instanciar la clase que lleva la interfaz runable y arrancar el hilo
			//esta intancia tenia el constructor que pedia tres parametros: 1 el banco, 2cuentaorigen,
			//y la cantidad maxima primer parametro la instancia de la clase banco que la llamamos mibanco
			//el segundo parametro es las cuentas de origen que sos 100 y las recorre el bucle for con la 
			//variable i y eso le pasamos por parametro es decir la i  y la cantidad maxima que se lo 
			//ponemos nosotros que va a ser un maximo de 2000
			ejecucionTransferencias1 r=new ejecucionTransferencias1(mibanco,i,2000);
			
			Thread t=new Thread(r);
			t.start();
		}
	}

}



class banco1
{
	public banco1() 
	{
		//iniciamos el array diciendole que va a tener 100 cuentas 
		cuentas=new double[100];
		
		//cargamos cada cuenta con 2000 pesos con bucle for es decir va arecorrer cada posicion y va a ir 
		//llenando cada posicion con 2000 pesos
		for(int i=0;i<cuentas.length;i++) 
		{
			cuentas[i]=2000;
		}
	}
	
	//metodo que se encarga de manejar las tranferencias de una cuenta de origen, destino y la cuenta a
	//tranferir y para eso necesita manejar esos tres argumentos
	public void trasferencia1(int cuentaorigen, int cuentadestino,double cantidadtransferencia) 
	{
		//ya bloqueamos el codigo y hasta que no termine de ejecutarlo el primer hilo el segundo
		//no se ejecuta es decir cuando entra al metodo lo primero que hace es bloquear el codigo 
		//para que solo lo lea el hilo uno termina ejecuta el finally que lo que hace es desbloquear
		//el codigo y entra hilo dos asi infinitas veces porque icimos un bucle infinito
		cierrebanco.lock();
		//encerramos todo el codigo dentro de un try y al final del try ponemos la clausula finally
		//para que una ves lea el codigo dentro de la clausula finally si o si ejecute la instruccion que
		//hay dentro no importa si no se cumple lo del try
		try 
		{
			//vamos a gestionar la transferencia y que el saldo total de esa cuenta sea siempre el mismo es decir
			//hay un fondo acumulado dentro de esas cuentas de 200000 pesos si la cuenta 4 hace una tranferencia
			//de 1000 a la cuenta 40 el saldo total sigue siempre igual porque la cuenta 4 se quedara solo con 
			//1000 pesos y la otra cuenta la 40 se le sumara esos 1000 y tendra un total de 3000 pesos 
			//y vamos a gestionar que si otra ves la cuenta 4 quiere hacer una trasferencia de 2000 tenemos que
			//hacer que no lo pueda hacer ya que supera el resto que le quedaba que es 1000 pesos(aclarar que cada cuenta consta de 2000 pesos)
		
			if(cuentas[cuentaorigen]<cantidadtransferencia) 
			{
				//que imprima por consola si el saldo es insuficiente para realizar la transferencia y que 
				//imprima que cuenta esta realizando la tranferencia que saldo tiene y cual es la cantidad a 
				//tranferir de esa cuenta 
				System.out.println("------ cantidada insuficiente de la cuenta: " + cuentaorigen+" saldo: "+cuentas[cuentaorigen]  + " transfiere una cantida imposible de: "+ cantidadtransferencia);
				
				//le decimos return para que devuelva o retorne el flujo de ejecucion donde se hizo la llamada
				//al metodo y no haga nada si tranfiere mas de lo q tiene la cuenta y no realizara lo que sigue
				//debajo por lo cual el hilo se pierde y seguira bloqueado por eso esta la clausula finally que
				//hace que ese hilo ejecute si o si ese desbloquea asi accede el otro hilo que lo prosigue
				return;
				
			}
			else 
			{
				System.out.println("------ cantidada correcta de la cuenta: " + cuentaorigen+" saldo: "+cuentas[cuentaorigen]  + " transfiere una cantida de: "+ cantidadtransferencia);

			}
		
			//vamos a imprimir por consola el hilo que va a hacer esa transferencia metodo estatico significa
			//hilo actual el currenThread Devuelve una referencia al objeto de hilo que se está ejecutando 
			//actualmente.
			System.out.println(Thread.currentThread());
			
			//si ya hicimos la transferencia y todo salio bien hay que descontar la cuenta de origen la cantidad
			//que tranfirio
		
			cuentas[cuentaorigen]-=cantidadtransferencia;
		
			//queremos que en consola nos informe cual es la cuentaorigen y cual es la cuentadestino y cual es
			//la cantidad que se va a tranferir y para esto vamos a utlizar un metodo que ya vimos en el curso
			//la instruccion pirintf %10.2f le indicamos que va a tener 2 decimales
		
			System.out.printf("%10.2f de la cuenta %d parala cuenta %d ",cantidadtransferencia,cuentaorigen,cuentadestino);
		
			//ahora la cuentadestino tiene que incrementar su saldo ya que recibe la transferencia de la 
			//cuentaorigen
			cuentas[cuentadestino]+=cantidadtransferencia;
		
			//quiero que este metodo me informe del saldo total porque primero me infroma del hilo que se ejecuta
			//despues restade la cuenta origen la cantidadtranferencia, despues imprime lo que se hizo osea que 
			//monto se tranfirio de que cuenta y hacia que cuenta y suma la cantidadd tranferida a cuentadestino
			//y ahora quiero ver el saldo total y para ver el saldo total vamos a crear otro metodo
		
			System.out.printf("saldo total: %10.2f " , damesaldototal1() );
		}
		//tanto si ocurre o no ocurre la excepcion tendra que ejecutar lo que hay en esta instruccion
		//finally
		finally 
		{
			cierrebanco.unlock();//desbloquea el codigo una ves se ejecute el primer hilo
		}
		
	}
	
	public double damesaldototal1() 
	{
		double suma_cuentas=0;
		
		//recooremos el array cuentas que ya a hecho sus transaferenciasque va de la cuenta 0a99 y cada una
		//de ellas con un saldo y  en a estamos almacenando el valor del array osea en posicion[0]=1500
		//posicion[1]=3000 asi hasta llegar a la posicion 99 y suma todas y obtenemos el total
		for(double a: cuentas) 
		{
			suma_cuentas+=a;
		}
		
		//le decimos que devuelva lo que hay almacenado en suma_cuentas
		return suma_cuentas;
	}
	
	private final double[] cuentas;
	
	//intancia de la clase ReentrantLock ya con esto podemos utilizar el objeto cierrebanco para llamar
	//al metodo loock y unloock
	private Lock cierrebanco=new ReentrantLock();
}

//creamos la clase Thread para que haga las tranferencias infinitas osea que ejecute estos Thread y realice
//estas transferencias esta clase implementara la interfaz Runable

class ejecucionTransferencias1 implements Runnable
{	
	//crearemos un constructor que permita almacenar 3 datos primero un objeto de tipo banco con esta clase
	//voy a poder utilizar todos los metodos de la clase banco tanto el metodo transferencia como damesaldototal
	//tambien vamos a necesitar la cuenta de la que parte el dinero es decir la cuentaorigen y el tercer
	//parametro que es el saldo a tranferir es decir la cantidad maxima a transferir.. porque? porque no
	//tiene ningun sentido hacer una tranferencia de un inporte superior a dosmil pesos ya que las cuentas
	//tienen un maximo cada una de dosmil pesos iniciales
	public ejecucionTransferencias1(banco1 b,int origen,double max)
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
			banco.trasferencia1(Origen, paraLaCuentaDestino, cantidad); 
			
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
	private banco1 banco;
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
// y al primer que se encuentra esperando de que a realizado una tranferencia a esa ceunta del que el hilo
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