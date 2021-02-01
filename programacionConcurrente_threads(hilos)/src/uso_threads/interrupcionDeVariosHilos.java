package uso_threads;

import java.awt.BorderLayout;
import java.awt.Component;
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

//vamos a detener varios hilos de ejecucion ya que cuando corre el programa y salen mas de una pelota solo
//podemos detener una sola osea un solo hilo de ejecucion  las demas siguien revotando
public class interrupcionDeVariosHilos 
{

	public static void main(String[] args)
	{
		JFrame marco=new MarcoRebote1();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
		
	}

}


//permite hacer cosas de manera simultanea con la interfaz Runable
class pelotasHilos1 implements Runnable
{
	//el segundo argumento es donde el componente va a revotar es decir la lamina
	//y el primero es la clase pelota y lo que hace
	
	public pelotasHilos1(Pelota1 unaPelota,Component unComponente) 
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
		//hilo que se esta ejecutando ahora mismo, isinterrupted() devuelve boolean  chequea si este hilo a sido interrumpido este metodo
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
			
			try 
			{
				Thread.sleep(4);
			}
			catch (InterruptedException e) 
			{
				//System.out.println("hilo bloquedo imposible su interrupcion");
				//e.printStackTrace();
				//System.exit(0);
				
				//con esta instruccion cuando pulsamos en detener le decimos que interrumpa el actual hilo
				//con el metodo estatico currentThread() lo que estamos haciendo es lo siguiente si nosotros
				//pulsamos en detener como el hilo se encuentra bloqueado por el uso del metodo sleep este
				//lanza una excepcion y que codigo tenemos dentro capturando el error pues el de interrumpir
				//el hilo con lo cual en principio el hilo deberia detenerse solo una pelota es decir la ultima
				//las demas seguiran revotando el metodo sleep hace que valla mas lenta la pelota
				Thread.currentThread().interrupt();
			}

		}
		//al interrumpirlo con el boton detener el while pasa a ser true y se sale del bucle e imprime 
		//un true porque el while dice que se seguira repitiendo mientras la interrupcion sea false
		System.out.println("hilo interrunpido:" + Thread.currentThread().isInterrupted());
	}
	
	
	
	private Pelota1 pelota;
	private Component componente;
}

//Movimiento de la pelota----------------------------------------------------------------------------

class Pelota1
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
class laminaPelotas1 extends JPanel
{
	//medimos pelota a la lamina
	public void add(Pelota1 b) 
	{
		//agregamos la pelota a la lamina
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D) g;
		
		for(Pelota1 b: pelotas) 
		{
			//metodo fill llena o completa algo en este caso la pelota o pintar la pelota y no una pelota
			//sino varias por eso usamos la clase ArrayList
			g2.fill(b.getShape());
		}
	}
	private ArrayList<Pelota1> pelotas=new ArrayList<Pelota1>();
}

//marco con lamina y botones
class MarcoRebote1 extends JFrame
{
	public MarcoRebote1() 
	{
		setBounds(600,300,600,350);
		setTitle("Rebotes");
		lamina=new laminaPelotas1();
		add(lamina,BorderLayout.CENTER);
		
		JPanel laminaBotones=new JPanel();
		
		//creamos los botones para arrancar la ejecucion de los hilos
		arranca1=new JButton("hilo1");
		arranca1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evento) 
			{
				comienza_el_juego(evento);
			}
		});
		
		//agregamos primer boton a la lamina
		laminaBotones.add(arranca1);
	
		arranca2=new JButton("hilo2");
		arranca2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evento) 
			{
				comienza_el_juego(evento);
			}
		});
		//agregamos segundo boton a la lamina
		laminaBotones.add(arranca2);
		
		arranca3=new JButton("hilo3");
		arranca3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evento) 
			{
				comienza_el_juego(evento);
			}
		});
		
		//agregamos los boton arranca 3 a la lamina
		laminaBotones.add(arranca3);
		
		//-------------------------------------------------------botones para detener
		//construimos botones para detener el hilo de ejecucion
		detener1=new JButton("detener1");
		detener1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evento) 
			{
				detener(evento);
			}
		});
		laminaBotones.add(detener1);
		
		detener2=new JButton("detener2");
		detener2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evento) 
			{
				detener(evento);
			}
		});
		laminaBotones.add(detener2);
		
		detener3=new JButton("detener3");
		detener3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent evento) 
			{
				detener(evento);
			}
		});
		laminaBotones.add(detener3);
		//agregamos segunda lamina al sur de 
		add(laminaBotones,BorderLayout.SOUTH);
		
		
	}
	
	
	//añade pelota y la bota 10000 veces----------------------------------------
	//cada ves que le damos a dale crea una pelota y el programa lee todo lo que hay en este metodo con lo
	//cual se crea una instancia perteneciente a la clase Thread llamada ty esa instancia es la encargada
	//de comenzar el juego con metodo star() y sale nuestra primera pelota y ese hilo correspondiente a la
	//primera pelota se llama t....y que ocurre si pulsamos dale una segunda vez?, si pulsamos una segunda
	//vez volvera a leer todo el codigo del metodo y eso quiere decir que se vuelve a creear una instancia
	//perteneciente a la clase Thread tambien llamada t y evidentemente no puede haber dos instancias 
	//llamadas con el mismo porque ocasiona q salga una segunda pelota correspondiente al segundo hilo
	//pero esta segunda pelota o segundo hilo tambien se llama t por lo cual el segundo hilo machaca al
	//primero pero el hilo anterior sigue en ejecucionindefinidamente por el while pero ya no se llama t
	//porque ese nombre a sido asignado a la segunda pelota o segundo hilo y entonces tenemos dos pelotas
	//una sin nombre y otra llamda t y si pulsamos en el boton de detener llamamos al metodo detenerel cual
	//tiene la instruccion t.interrupt()es decir interrumpe o deten la ty si tenemos dos pelotas detendra la
	//segunda que es la que tiene ese nombre de instancia y la primera se queda rebotando indefinidamente
	public void comienza_el_juego(ActionEvent e) 
	{
		Pelota1 pelota=new Pelota1();
		lamina.add(pelota);
		
		//creamos instancia de el metodo creado que implementa la interfaz runable al metodo que hace 
		//que comience el juego con el boton dale
		Runnable r=new pelotasHilos1(pelota, lamina);
		
		//preguntamos con un if que voton a sido pulsado 
		if(e.getSource().equals(arranca1)) 
		{
			//el constructor recibe por parametro un objeto de tipo runable
			t1=new Thread(r);
		
			//comienza la ejecucion del hilo
			t1.start();
		}
		else if(e.getSource().equals(arranca2)) 
		{
			t2=new Thread(r);
			t2.start();
		}
		else if(e.getSource().equals(arranca3)) 
		{
			t3=new Thread(r);
			t3.start();
		}
		
	
		
	}
	
	//al igual que el metodo comienza juego le decimos por parametros que tiene que estar preparado para
	//recivir un objeto de tipo ActionEvent para saber que boton fue pulsado ya que en la construccion
	//de los botones a la llamada de estos metodos le pasamos por parametro un objeto de tipo ActionEvent
	public void detener(ActionEvent e) 
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
		
		//con un if preguntamos que boton a sido pulsado
		//le decimos que si el boton seleccionado fue detener1 que detenga el primer hilo que es t1
		if(e.getSource().equals(detener1)) 
		{		
			//interrumpimos el primer hilo metodo interrupt interrumpe este hilo
				t1.interrupt();
		}
		else if(e.getSource().equals(detener2)) 
		{
			t2.interrupt();
		}
		else if(e.getSource().equals(detener3)) 
		{
			t3.interrupt();
		}
	}
	private laminaPelotas1 lamina;
	//creamos tres Thread para poder crear tres pelotas y poder paralas ya que tienen diferentes nombres
	Thread t1,t2,t3;
	//con sus respectivos botones para ejecutar el hilo1,2 y 3
	JButton arranca1,arranca2,arranca3;
	
	//creamos tres botones mas para deter estos hilos
	JButton detener1,detener2,detener3;
	
}


//crear hilos de ejecucion
/*1 crear una clase que implemente la interfaz runabble (metodo run())
*2 escribir el codigo de la tarea dentro del metodo run
3  instanciar la clase creada y almacenar la instancia en variable de tipo runnable
4 crear instancia de la clase Thread pasando por parametro al constructor de de THread el objeto Runnable
anterior
5 poner en marcha el hilo de ejecucion con el metodo star() de la clase Thread*/
