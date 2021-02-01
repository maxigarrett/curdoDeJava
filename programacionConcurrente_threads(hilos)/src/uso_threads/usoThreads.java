package uso_threads;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class usoThreads
{

	public static void main(String[] args)
	{
		JFrame marco=new MarcoRebote();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
		
	}

}
//permite hacer cosas de manera simultanea con la interfaz Runable
class pelotasHilos implements Runnable
{
	//el segundo argumento es donde el componente va a revotar es decir la lamina
	//y el primero es la clase pelota y lo que hace
	
	public pelotasHilos(Pelota unaPelota,Component unComponente) 
	{
		pelota=unaPelota;
		componente=unComponente;
	}

	//metodo run de la interfaz Runnable en este codigo run tenemos que tener todo el codigo de la tarea
	//queremos que sea simultanea en este caso lo que querramos que sea simultaneo sea la aparicion de mas
	//de una pelota en simultaneo y realizar otras tareas de forma simultaneas como salir cuando esta 
	//corriendo la pelota lamina
	public void run()
	{
		//al principio imprimira por consola que es faalse porque el hilo no esta interrumpido
		System.out.println("hilo interrunpido:" + Thread.currentThread().isInterrupted());
		//for(int i=1;i<=3000;i++)
		//se repetira mientras el revote indefinidas veces mientras no sea interrumpido es lo que hacemos
		// con esta instruccion metodo interrupted chequea si el hilo actual a sido interrumpido
		//while(Thread.interrupted()==false)
		
		//otra forma igual de detenerlo es con isInterrupted pero no es estatico por lo que utilizaremos 
		//un metodo primero estatico llamado currentThread() para decirle al bucle while que detenga el hilo concreto
		//que se esta ejecutando ahora mismo este metdo lo que hce es devolvernos la referencia del hilo que esta
		//ejecutandose en ese instante ademas de ser estatico nos devuelve un objeto de tipo Thread que es el 
		//hilo que se esta ejecutando ahora mismo isinterrupted() devuelve boolean  chequea si este hilo a sido interrumpido este metodo
		//se aplica a un hilo en concreto mientras que interrupted lo podemos aplicar a cualquier hilo
		//currentThread hilo actual
		while(Thread.currentThread().isInterrupted()==false)
		{
			//ponemos el ciclo for donde hace que corra la pelota justo la variable pelota coincide con
			//la variable que construimos pero lamina que es un component no coincide asique le pasamos el
			//nombre que le dimos a Component que es unComonentey se almacena en comonente que es la 
			//variable encapsulada
			pelota.mueve_pelota(componente.getBounds());
			componente.paint(componente.getGraphics());
			
			/*try 
			{
				Thread.sleep(4);
			}
			catch (InterruptedException e) 
			{
				//System.out.println("hilo bloquedo imposible su interrupcion");
				//e.printStackTrace();
				//System.exit(0);
				 
			}*///con esto comeentado la pelota se movera mas rapido pero lo podremos detener

		}
		//al interrumpirlo con el boton detener el while pasa a ser true y se sale del bucle e imprime 
		//un true porque el while dice que se seguira repitiendo mientras la interrupcion sea false
		System.out.println("hilo interrunpido:" + Thread.currentThread().isInterrupted());
	}
	
	
	private Pelota pelota;
	private Component componente;
}

//Movimiento de la pelota----------------------------------------------------------------------------

class Pelota
{
	//mueve la pelota invirtiendo posicion si choca con limite este metodo recibe por parametro un 
	//Rectangle2D concretamente lo que va arecibir este metodo mueve_pelota por parametro es las dimensiones
	//de nuestra lamina esas dimenciones se guardaran en el objeto Rectangle2D y sabiendo las dimenciones 
	//del rectangulo o lamina trabajaremos con formulas matematicas
	public void mueve_pelota(Rectangle2D limites) 
	{
		//incrementa la x 
		x+=dx;
		
		//incrementar la coordenada y con estas dos instrucciones hacemos que la pelota se valla moviendo
		y+=dy;
		
		//luego con una serie de metodos pertenecientes a rectangle2D como getMINX,getMaxX,getMinY,getMaxY
		//seremos capases de detectar cual es el punto maximo y minimo tanto en el ejes de las x como en el
		//de las y o es lo mismo detectar los limites
		if(x<limites.getMinX()) 
		{
			x=limites.getMinX();
			
			//cuando nos encontramos con el limite invertimos los limites con las coordenadas x e y 
			//diciendolle dx=-dx;
			dx=-dx;
		}
		
		if(x + TAMX>=limites.getMaxX()) 
		{
			x=limites.getMaxX() - TAMX;
			dx=-dx;
		}
		
		if(y<limites.getMinY()) 
		{
			y=limites.getMinY();
			dy=-dy;		
		}
		
		if(y + TAMY>=limites.getMaxY()) 
		{
			y=limites.getMaxY() - TAMY;
			dy=-dy;
		}
	}
	
	//forma la pelota en su posicion inicial--------------------------------------------------
	
	public Ellipse2D getShape() 
	{
		return new Ellipse2D.Double(x, y, TAMX, TAMY);
	}
	private static final int TAMX=15;
	private static final int TAMY=15;
	private double x=0;
	private double y=0;
	private double dx=1;
	private double dy=1;
}

//lamina que dibuja las pelotas -------------------------------------------------------
class laminaPelotas extends JPanel
{
	private static final long serialVersionUID = 1L;
	//medimos pelota a la lamina
	public void add(Pelota b) 
	{
		//agregamos la pelota a la lamina
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D) g;
		
		for(Pelota b: pelotas) 
		{
			//metodo fill llena o completa algo en este caso la pelota o pintar la pelota y no una pelota
			//sino varias por eso usamos la clase ArrayList
			g2.fill(b.getShape());
		}
	}
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
}

//marco con lamina y botones
class MarcoRebote extends JFrame
{
	public MarcoRebote() 
	{
		setBounds(600,300,400,350);
		setTitle("Rebotes");
		lamina=new laminaPelotas();
		add(lamina,BorderLayout.CENTER);
		
		JPanel laminaBotones=new JPanel();
		
		ponerBoton(laminaBotones,"dale",new ActionListener()
		{
			public void actionPerformed(ActionEvent evento) 
			{
				comienza_el_juego();
			}
		});
		
		ponerBoton(laminaBotones, "salir", new ActionListener() 
		{
			public void actionPerformed(ActionEvent evento) 
			{
				System.exit(0);
			}
		});
		
		
		ponerBoton(laminaBotones, "detener", new ActionListener() 
		{
			public void actionPerformed(ActionEvent evento) 
			{
				detener();
			}
		});
		//agregamos segunda lamina al sur de 
		add(laminaBotones,BorderLayout.SOUTH);
	}
	
	//ponemos botones metodo para crear botones y dar accion y nombre al boton
	public void ponerBoton(Container c, String titulo, ActionListener oyente) 
	{
		JButton boton=new JButton(titulo);
		
		c.add(boton);
		
		boton.addActionListener(oyente);
	}
	
	//añade pelota y la bota 10000 veces----------------------------------------
	
	public void comienza_el_juego() 
	{
		Pelota pelota=new Pelota();
		lamina.add(pelota);
		
		//creamos instancia de el metodo creado que implementa la interfaz runable al metodo que hace 
		//que comience el juego con el boton dale
		pelotasHilos r=new pelotasHilos(pelota, lamina);
		
		//el constructor recibe por parametro un objeto de tipo runable
		t=new Thread(r);
		
		//comienza la ejecucion del hilo
		t.start();
		
		
	
		//con este bucle for llamamos al metodo mueve_pelota que hace los calculos matematicos para que 
		//revote la pelota 3000 veces de esta forma lo hace muy rapido y como podemos hacer una pausa en 
		//hilo de ejecucion porque este programa hasta ahora es monotarea es decir un unico hilo de
		//ejecucuion y hasta no terminar el programa no podremos salir  por eso hay que convertirlo en 
		//multitarea con la interfaz runnable es decir pasar este bucle al metodo que implemente la interfaz
		/*for(int i=1;i<=3000;i++) 
		{
			pelota.mueve_pelota(lamina.getBounds());
			lamina.paint(lamina.getGraphics());
			
			
			
			try 
			{
				Thread.sleep(4);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}

		}*///todo esto lo pasamos a la interfaz Runnable que hace que ejecute varias tareas a la vez
	}
	
	public void detener() 
	{
		//al interrumpir un hilo en este caso detener la pelota y el metodo sleep lanza una escepcion
		//de la que rodeamos la excepcion en el metodo que implemeta la interfaz runable
		//y el programa no pausara o detendra el moviemiento de la bola porque el hilo se 
		//encuentra bloquedao hasta no terminar la ejecucion una de las multiples posibilidades es pasarle
		//al catch un System.exyt(0) para cuando intente detener el programa lasza la excepcion y se fija
		//lo que hay en el catch  ya al tener esa instruccion saldra automaticamente sino tuviera el metodo 
		//sleep podriamos usar el boton detener para parar el flujo del hilo pero sin sleep la pelota se 
		//a una velosidad muy rapida para poder usar el metodo interrupt() usaremos un cilco while en ves
		// de un for para que se repita indefinidamente hasta ser interrumpido porque con el siclo for no nos
		//tiempo a interruirlo poque si comentamos el sleep el ciclo se cumple muy rapido y no nos da tiempo
		//a pulsar el boton de detener por eso el cilco while para que revote ligero pero indefinidamente
		//para que nos de tiempo de darle al boton detener
		t.interrupt();
	}
	private laminaPelotas lamina;
	Thread t;
}


//crear hilos de ejecucion
/*1 crear una clase que implemente la interfaz runabble (metodo run())
 *2 escribir el codigo de la tarea dentro del metodo run
 3  instanciar la clase creada que implemeta Runable y almacenar la instancia en variable de tipo runnable
 4 crear instancia de la clase Thread pasando por parametro al constructor de de THread el objeto Runnable
 anterior
 5 poner en marcha el hilo de ejecucion con el metodo star() de la clase Thread*/

