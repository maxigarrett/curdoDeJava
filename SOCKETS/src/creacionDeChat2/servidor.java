package creacionDeChat2;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*este servidor va a tener que hacer dos tareas por un lado va a tener que recibir en el JTextArea el
 * texto que le mandamos del cliente  y por otro laso va a tener que realizar en segundo plano una 
 * segunda tarea y esa segunda tarea sera permanecer a la escucha constantemente y tener el puerto 9999
 * abierto y ¿como conseguimos que haga dos cosa una en primer plano y la otra en segundo plano? pues 
 * con hilos o llamados threads*/

public class servidor 
{

	public static void main(String[] args)
	{
		MarcoServidor mimarco=new MarcoServidor();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setBounds(600,200,400,300);
		mimarco.setVisible(true);

	}

}





//este servidor o esta clase tiene que estar constantemente a la escucha y lo haremos implementando
//la interfaz Runnable y en el metodo run hara la tarea de abrir el puerto 9999 aceptarlo y 
//crear el flujo de entrada de dato para que entre en este caso el texto
class MarcoServidor extends JFrame implements Runnable
{
	private static final long serialVersionUID = 1L;
	public MarcoServidor()
	{
		//creamos lamina dentro del marco
		JPanel milamina=new JPanel();
		
		//le damos una disposicion a la lamina
		milamina.setLayout(new BorderLayout());
		
		//creamos area de texto
		 areatexto=new JTextArea();
		 
		 //agregamos el area de texto a la lamina
		 milamina.add(areatexto,BorderLayout.CENTER);

		 //agregamos la lamina al marco
		 add(milamina);
		 
		 //le decimos que cree el hilo y por parametro en ves de pasarle el nombre de la clase que 
		 //implementa la interfaz runable le pasamos this porque estamos dentro de la misma clase que
		 //implementa la interfaz
		 Thread t=new Thread(this);
		 t.start();
	}
	
	//metodo de la interfaz Runnable
	public void run() 
	{
		//para saber si esta a la escucha  es solo una prueba para saber y en el marco creamos el hilo
		//System.out.println("estoy a la escucha");
		
		
		//ahora programamos para que nos abra el puerto 9999 y este a la escucha y para hacer esto vamos
		//a nececitar una clase que es la clase ServerSocket que como el nombre indica construye un
		//Socket de servidor en cual pondra a la aplicacion a la escucha en un puerto que nosotros le
		//indiquemos que sera el 9999 si vamos a la Api de java a esa clase veremos que tiene un
		//constructor dentro de varios ya que tiene sobrecarga de constructores que se encarga de hacer 
		//ese trabajo ese constructor es el constructor ServerSoket(int port) este crea un Socket de 
		//servidor abierto en el puerto especificado dentro de los parametros del constructor y esta
		//clase ServerSocket tiene un metodo muy inportante que nos devuelve un objeto de tipo Socket que
		//es el metodo accept() este metodo lo que hace es escuchar una conexion y hacer que se acepte
		//esa coneccion, es decir, lo que hace este metodo es poner a la escucha la aplicacion
		
		//primero creamos el ServerSocket 
		try 
		{
			//tenemos el puerto 9999 abierto como especifica el cliente cuando construyo el Socket
			//para recibir en este caso el texto mandado por el cliente
			ServerSocket servidor=new ServerSocket(9999);
			
			//vamos acrear tres variables para poder almacenar la informacion que le llega en ese 
			//paquete por la red llamada datos de la clase cliente
			String nick,ip,mensaje;
			
			/*luego tenemos que crear una intancia de paqueteEnvio de la clase cliente para contruir dentro de
			 un paquete nuevo lo que voy a recivir,es decir, por un lado tenemos el programa cliente por otro 
			 el servidor que es donde estamos ahora mismo y ya conseguimos que el cliente pueda enviar un paquete
			 con la informacion encapsulada(un objeto) al servidor para ello hemos necesitado en la clase del 
			 cliente pues crear una instancia perteneciente a paqueteEnvio donde metiamos la informacion necesesaria
			 y despues serializabamos para que pudiera viajar en bytes ese objeto por la red ¿y que necesitamos en
			 el servidor?, necesitamos crear una nueva instancia perteneciente a paqueteEnvio para poder construir
			 ese objeto serializado que le llega por la red y reconstruir todo esos datos desmenuzados
			entoces crearemos la intancia y almacenar en el los datos ,es decir, el nick el mensaje y ip */
			paqueteEnvio paquete_recibido;	
			
			//si enviamos un mensaje y volvemos a enviar otro no lo hara porque le dijimos que cierre
			//el Socket en tonces si lo metemos en un bucle infinito siempre quedara dando vueltas 
			while(true) 
			{
				//le decimos que acepte las conexiones que le vengan del exterior con ese metodo accept();
				//y lo almacenamos en una variable de tipo Socket ya que el metodo devuelve un dato de ese
				//tipo para abrir un puente donde recivira la informacion
				Socket misocket=servidor.accept();
			
				//para recibir los datos u objetos que envia el cliente necesitamos crear un flujo de 
				//datos de entrada con la clase ObjectInputStream y por parametros al constructor le 
				//pasamos por el socket que va a recibir el paquete
				ObjectInputStream flujo_entrada=new ObjectInputStream(misocket.getInputStream());
			
				
				//ahora tenemos que hacer meter dentro del objeto creado antes de paquete_recibido
				//meter lo que le llega por la red. Como flujo_entrada es de tipo ObjectInputStream
				//no se puede almacenar dentro de un objeto de tipo paqueteEnvio por eso hacemos
				//el casting y el metodo redObject lanza excepcion y lo capturamos en el catch ya 
				//existente
				paquete_recibido=(paqueteEnvio) flujo_entrada.readObject();
			
				//ya recibimos el objeto serializado creando un objeto de la misma clase paqueteEnvio
				//para poder almacenar lo que le llega serializado por la red y ¿ que tenemos que hacer
				//ahora? pues ya que aqui tenemos un objeto un paquete lo que tenemos que hacer es 
				//acceder a la informacion que hay dentro de ese paquete llamado paquete_recibido para
				//obtener el nick,ip y el mensaje y una ves que obtengamos esa informacion vamos a 
				//escribirlo en el area de texto la informacion la obtenemos de la siguiente manera
				//usamos las variables creadas de tipo String y le decimos que sea a igual a 
				//paquete_recibido.getnick(),getIp(),etc osea los GETTERS creados en la clase cliente
				nick=paquete_recibido.getNick();
				ip=paquete_recibido.getIp();
				mensaje=paquete_recibido.getMensaje();
				servidor.close();
				//siguiente paso lo que tengo guardado en estas variables ponerlo en el area de texto
				//si nos envian un mensaje registrado con un nick mostrara el nick con el mensaje y
				//para la ip el destinatario
				areatexto.append("\n" + nick + ": " + mensaje + " para la ip que te lo envia es" + ip);
				
				//--------------finaliza el recivimiento de datos del cliente-----------------------
				
				
				//_----------ahora enviamos informacion---------------------------
				
				//tenemos que crear un socket por donde viaje la informacion para poder enviar mensajes
				//hay que indicar la ip y el puerto para enviar datos una vez resividos el puerto
				//debe cambiar y cuando resive el cliente el texto y demas usara este puerto creando un
				//ServerSocket
				Socket envia_destinatario=new Socket(ip,9090);
				
				
				//crear un flujo de salida de datos OBjectOutputStream y por parametros por que socket
				//viajara la informacion
				ObjectOutputStream paqueteReenvio=new ObjectOutputStream(envia_destinatario.getOutputStream());
				
				
				//una ves indicado que enviaremos ese flujo de datos de salida por el soket, tenemos que 
				//meter la informacion en ese flujo de datos de salida ObjectOutputStream y por parametros 
				//que es lo que va a escribir en el flujo de salida, el paquete que ya recivimos y serializado
				//de tipo paqueteEnvio llamado paquete_recivido
				paqueteReenvio.writeObject(paquete_recibido);
				
				
				//una ves recivido el mensaje hay que serrar la coneccion del socket para no ocupar 
				//recursos
				
				paqueteReenvio.close();
				envia_destinatario.close();
				flujo_entrada.close();
				misocket.close();
				
			}
			
			
			
			
		} 
		catch (IOException | ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	private JTextArea areatexto;
}


/*todo esto funcionaria si usaramos una maquina virtual como virtualbox*/
