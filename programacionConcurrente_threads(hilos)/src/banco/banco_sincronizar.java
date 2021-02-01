package banco;

public class banco_sincronizar 
{
//aplicacion que construye un banco con 100 cuentas que pueden hacer transferencias infinitas entre las
//cuentas de este banco y cada una estaba cargada con 2000 pesos
	
	//el saldo total se pierde por que al no sincronizar los hilos porahi 3 hilos acceden al mismo indice
	//o cuenta por lo que se pierde el dinero porque mientras el hilo uno esta haciendo la transaccion
	//el hilo 2 va por detras y se le quita al mismo indice cuando el hilo 1 imprime el saldo total va a 
	//a faltar lo que saco el hilo 2 por eso vamos a usar un clase llamada Reentranlock para controlar 
	//la ejecucion de los hilos porque hacerlo con el metodo join al ser tantos hilos es muy dificil
	//el metodo ReentranLock implementa dos interfaces la interfaz serializable y Lock
	public static void main(String[] args)
	{
		banco mibanco=new banco();
		//utilizamos un bucle for para que realice transferencias de la cuenta 0 ala 99
		for(int i=0;i<100;i++) 
		{
			//instanciar la clase que lleva la interfaz runable y arrancar el hilo
			//esta intancia tenia el constructor que pedia tres parametros: 1 el banco, 2cuentaorigen,
			//y la cantidad maxima primer parametro la instancia de la clase banco que la llamamos mibanco
			//el segundo parametro es las cuentas de origen que sos 100 y las recorre el bucle for con la 
			//variable i y eso le pasamos por parametro es decir la i  y la cantidad maxima que se lo 
			//ponemos nosotros que va a ser un maximo de 2000
			ejecucionTransferencias r=new ejecucionTransferencias(mibanco,i,2000);
			
			Thread t=new Thread(r);
			t.start();
		}
	}

}


class banco
{
	public banco() 
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
	public void trasferencia(int cuentaorigen, int cuentadestino,double cantidadtransferencia) 
	{
		//vamos a gestionar la transferencia y que el saldo total de esa cuenta sea siempre el mismo es decir
		//hay un fondo acumulado dentro de esas cuentas de 200000 pesos si la cuenta 4 hace una tranferencia
		//de 1000 a la cuenta 40 el saldo total sigue siempre igual porque la cuenta 4 se quedara solo con 
		//1000 pesos y la otra cuenta la 40 se le sumara esos 1000 y tendra un total de 3000 pesos 
		//y vamos a gestionar que si otra ves la cuenta 4 quiere hacer una trasferencia de 2000 tenemos que
		//hacer que no lo pueda hacer ya que supera el resto que le quedaba que es 1000 pesos(aclarar que cada cuenta consta de 2000 pesos)
		
		if(cuentas[cuentaorigen]<cantidadtransferencia) 
		{
			//le decimos return para que devuelva o retorne el flujo de ejecucion dentro del metodo y no 
			//haga nada
			return;
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
		
		System.out.printf("saldo total: %10.2f " , damesaldototal() );
		
	}
	
	public double damesaldototal() 
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
}

//creamos la clase Thread para que haga las tranferencias infinitas osea que ejecute estos Thread y realice
//estas transferencias esta clase implementara la interfaz Runable

class ejecucionTransferencias implements Runnable
{	
	//crearemos un constructor que permita almacenar 3 datos primero un objeto de tipo banco con esta clase
	//voy a poder utilizar todos los metodos de la clase banco tanto el metodo transferencia como damesaldototal
	//tambien vamos a necesitar la cuenta de la que parte el dinero es decir la cuentaorigen y el tercer
	//parametro que es el saldo a tranferir es decir la cantidad maxima a transferir.. porque? porque no
	//tiene ningun sentido hacer una tranferencia de un inporte superior a dosmil pesos ya que las cuentas
	//tienen un maximo cada una de dosmil pesos iniciales
	public ejecucionTransferencias(banco b,int origen,double max)
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
			banco.trasferencia(Origen, paraLaCuentaDestino, cantidad); 
			
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
	private banco banco;
	private int Origen;
	private double cantidadmax;
}