package sokets;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.IOException;
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
			
			//si enviamos un mensaje y volvemos a enviar otro no lo hara porque le dijimos que cierre
			//el Socket en tonces si lo metemos en un bucle infinito siempre quedara dando vueltas 
			while(true) 
			{
				//le decimos que acepte las conexiones que le vengan del exterior con ese metodo accept();
				//y lo almacenamos en una variable de tipo Socket ya que el metodo devuelve un dato de ese
				//tipo
				Socket misocket=servidor.accept();
			
				//creamos flujo de datos de entrada para poder recivir lo que mande por el Socket el cliente
				//este flujo que tenemos que crear es de InputStream para poder ser capas de recoger lo que
				//viene o lo que viaja en el flujo de datos que le ah enviado el cliente 
				//y al constructor le tenemos que indicar porque Socket viaja la informacion de entrada
				DataInputStream flujo_entrada=new DataInputStream(misocket.getInputStream());
			
				//ahora hay que leer lo que biene en ese flujo de entrada 
				String mensaje_texto=flujo_entrada.readUTF();
			
				//y ahora que ya tenemos almacenada en esta variable de tipo String mensaje_texto lo que
				//viene del cliente lo imprimimos o lo pase al area de texto creada metodo append() para que
				//agregue texto y le damos un salto de linea para cada vez que recivamos un mensaje no sea
				//uno pegado del otro y lo que agrega va a ser el mensaje_texto que en esta variable se 
				//almacena lo que esta leyendo lo que le llega del flujo_entrada
				//si establecemos el metodo setText en ves de apped cuando enviemos el mensaje y volvamos
				//a enviar otro lo suplanta en ves de escribirlo abajo 
				areatexto.append("\n" + mensaje_texto);
				
			
				//una ves recivido el mensaje hay que serrar la coneccion del socket para no ocupar 
				//recursos
				flujo_entrada.close();
				misocket.close();
				
			}
			
			
			
			
		} 
		catch (IOException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	private JTextArea areatexto;
}

