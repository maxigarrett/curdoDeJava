package creacionDeChat4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class cliente 
{

	public static void main(String[] args) 
	{
		MarcoCliente mimarco=new MarcoCliente();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setBounds(600,200,250,350);
		mimarco.setVisible(true);
	}

}




class MarcoCliente extends JFrame
{
	private static final long serialVersionUID = 1L;

	public MarcoCliente() 
	{
		LaminaCliente milamina=new LaminaCliente();
		//milamina.setBackground(Color.black);
		add(milamina);
		
		
		addWindowListener(new envioOnline());
		
	}
}

//---------------ENVIO DE SEÑAL ONLINE--------------------------------------------------------
//clase que gestione los eventos de ventana ,es decir, nada mas abrir el programa este cliente envie
//un paquete de datos para que se cree el Socket y asi el servidor se de por enterado 
//nada mas se ejecute el programa sin hacer nada esta clase se tiene que encargar de enviar la señal al
//servidor la clase adaptadora implemeta todos los metodos de la interfaz WindowListener por lo
//que no nos obliga implementar todos sus metodos
class envioOnline extends WindowAdapter
{
	//utilizamos uno de sus metodos para que las instrucciones dentro de ella se ejecute apenas abrir
	//la ventana o ejecutar el programa
	public void windowOpened(WindowEvent e) 
	{
		try 
		{
			//el puerto que esta a la escucha en el servidor es el 9999  y tambien con nuestra direccion
			//ip 
			Socket misocket=new Socket("192.168.0.108",9999);
			
			//creamos el paquete donde enviaremos algo para que reciba el servidor y identifique que ip
			//se esta comunicando y vamos a utilizar ya que tenemos una clase para enviar paquete llamada
			//paqueteEnvio
			paqueteEnvio datos=new paqueteEnvio();
			
			//utilizamos este paquete para mandarle un mensaje el metodo pertenece a la clase 
			//paqueteEnvio
			datos.setMensaje(" online");
			
			//creamos flujo de datos
			ObjectOutputStream paquete_datos=new  ObjectOutputStream(misocket.getOutputStream());
			
			//escribimos el flujo de datos
			paquete_datos.writeObject(datos);
			
			//cerramos el Socket
			misocket.close();
		}
		catch(Exception e2) 
		{
			System.out.println(e2.getMessage());
		}
	}
}
//-------------------------------------FIN ENVIO ONLINE------------------------------------


/*como ahora recivira informacion del servidor tendra que hacer varias cosas tanto estar a la escucha 
 *como de recivir informacion y enviar informacioneso lo hacemos con los hilos Threads implementando 
 *la interfaz Runnable entonces la clase de la lamina del cliente vamos hacer que implemente esta 
 *interfaz para que donde se encuentren los componentes de la lamina esten a la escucha */
class LaminaCliente extends JPanel implements Runnable
{
	private static final long serialVersionUID = 1L;
	public LaminaCliente()
	{
		//preguntar el nombre del nick antes de que inicie el chat y como el Label acepta un String 
		//como parametros creamos una variable String nos va a preguntar el nick con un JOptionPane
		//y con eso ya tenemos almacenado lo que introduzca el usuario dentro de la variable String
		String nick_usuario=JOptionPane.showInputDialog("Nick:");
		
		JLabel n_nick=new JLabel("Nick: ");
		add(n_nick);
		
		//le pasamos por parametros el String almacenado de lo que introduzca el usuario osea su Nick
		nick=new JLabel(nick_usuario);
		add(nick);
		

		//creaamos un label para que diga los que estan online para despues crear un desplegable a su 
		//lado
		JLabel texto= new JLabel(" Online: ");
		//lo agregamos a la lamina
		add(texto);
		
		//para que aparezca a la derecha y arriba lo agregamos despues del label y queremos que
		//aparezca la ip con el que chateamos pero lo aremos con un menu desplegable
		ip=new JComboBox();
		
		//agregamos los usuarios a la ip que es un menu desplegable qeu en un futuro recibira
		//todas las ip que estan conectadas y no esos nombres de usuario 1,2,3 es solo para ir dandole
		//forma
		ip.addItem("usuario 1");
		ip.addItem("usuario 2");
		ip.addItem("usuario 3");
		
		add(ip);
		
		//creamos area de texto primer parametro largo segundo ancho
		campochat=new JTextArea(12,20);
		
		//agregamos el JTextArea
		add(campochat);
		
		//creamos un cuadro chiquito de texto para chatear
		campo1=new JTextField(20);
		//lo agregamos a la lamina
		add(campo1);
		
		//creamos boton
		miboton=new JButton("enviar");
		add(miboton);
		
		
		
		miboton.addActionListener(new EnviaTexto());
		
		//cuando el metodo run arranca empieza fijandose en donde esta la interfaz y comienza por la
		//lamina osea cuando la aplicacion se ejecuta empieza por la lamina entonces por parametros
		//al construir el hilo le pasamos this que hace referencia a la lamina donde nos encontramos
		//si lo hicieramos fuera de la clase de la lamina tendriamos que instanciar la lamina
		//y pasarle como argumento en ves de this esa instancia
		
		Thread mihilo=new Thread(this);
		mihilo.start();
	}
	
	
	
	//clase interna para que el boton responda a eventos
	private class EnviaTexto implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			//imprimimos un system para saber si el boton al hacer clic en el funciona
			/*System.out.println("has pulsado el boton y anda");*/
			//lo que escribimos  se imprime en consola
			/*System.out.println(campo1.getText());*/
			
			//construimos el SOCKETS dentro del actionPerformed  para que directamente al pulsar en 
			//el boton se construya  automaticamente ese socket y empiecen a fluir los datos.
			//Esta clase implementa sockets de cliente (también llamados simplemente "sockets"). 
			//Un zócalo es un punto final para la comunicación entre dos máquinas.
			 //la clase socket tiene sobrecarga de constructores y utilizaremos 
			//uno q se escribe socket(InetAddress address, int port) primer parametro pide una direccion
			//de red especificada y el segundo un puerto especificado.este metodo Crea un socket de flujo y lo conecta 
			//al número de puerto especificado en la dirección IP especificada. la ip para saver la direccion fisica
			//de servidor y el puerto para que esa aplicacion servidor va a abrir y lanza excepcion el 
			//socket. La direccion ip se especifica entre comillas 
			
			//para que se acumule lo que nosotros vaos escriviendo y no solo se vea lo que manda el otro
			//cliente usando la maquina virtual virtualbox
			
			campochat.append("\n" +campo1.getText() );
			
			try
			{
				Socket misocket=new Socket("192.168.0.108",9999);
				
				//instanciamos la clase que acabamos de crear que se llama paquete envio
				paqueteEnvio datos=new paqueteEnvio();
				
				//nick es el nombre del JTextField que le hemos dado en la aplicacion del cliente y con
				//el metodo getText() lo que hace es obtener el texto que hay dentro del JTextField y 
				//con eso que no es ni mas ni menos que un String; se lo pasamos al metodo setNick()
				//para que sea capas de almacenar lo que hay en ese cuadro de texto ¿dentro de donde?
				//dentro de la variable  nick que creamos en la clase paqueteEnvios.
				//no confundir los dos nick ya que uno es String donde se almacena el dato y el 
				//otro nick es un JTextField
				datos.setNick(nick.getText());
				
				//como ahora la ip en un ComboBox no sirve el getText() sino que utilizaremos un metodo
				//que se llama getSelectedItem() que pertenece a la clase ComboBox y ese metodo nos
				//dice cual es el componente que tenemos seleccionado en el desplegable pero este
				//metodo devuelve un Objeto y lo que nostros estamos manejando es un String para las
				//ip por eso despues del metodo con toString lo que hacemos es pasar a String  el
				//objeto que devuelve getSelectedItem()  
				datos.setIp(ip.getSelectedItem().toString());
				//ya tenemos todos los datos enpaquetados dentro de el objeto creado de la intacia
				//paqueteEnvios llamado datos
				datos.setMensaje(campo1.getText());
				
				//ahora hay que mandar ese paquete donde esta esa informacion al servidor ya no nos 
				//sirve el DataOutputStream porque no vamos a enviar texto sino un objeto llamado datos
				//entonces tendremos que utilizar la clase ObjectOutputStream para crear un flujo de 
				//datos de salida para poder enviarlos y por parametros le decimos por donde tiene
				//que viajar este flujo de datos y va a ser por el socket
				ObjectOutputStream flujo_salida=new ObjectOutputStream(misocket.getOutputStream());
				
				//ahora hay que escribir en este flujo de salida el paquete que creamos con el mensaje
				//,ip y nick para escribir utilizaremos writeObject() y le indicamos por parametros
				//el objeto a escribir y mandar que se llama datos
				flujo_salida.writeObject(datos);
				misocket.close();
//---------------------------------------envio de informacion terminada----------------------------------------				
				
				
			}
			catch (UnknownHostException e1) 
			{
				e1.printStackTrace();
				
			}
			catch (IOException e1)
			{
				//para en el caso de que ocurra un error a la hora de crear el socket y no pueda acceder
				//o comunicar remotamente con el server nos lanze en consola un mensaje diciendonos
				//cual es el problema
				System.out.println(e1.getMessage());
				
				e1.printStackTrace();
			} 
			
			
		}
	} 
	
	//metodo de la interfaz runnable
	public void run() 
	{
		try 
		{
			//creamos Socket de servidor para abrir el puerto especificado en el servidor que es el
			//puerto 9090
			ServerSocket servidor_cliente=new ServerSocket(9090);
			
			//creamos el puente o canal por donde va a recivir la informacion
			Socket cliente;
			
			//creamos variable de paqueteEnvio nuevo donde va a recibir la informacion es decir 
			//este paquete vacio donde almacenaremos lo que recibira 
			paqueteEnvio paquete_recivido;
			
			//bucle infinito para que este siempre a la escucha y reciba los mensajes aunque serremos 
			//el Socket
			while(true) 
			{
				//de esta forma va a estar aceptando todas las conecciones que le vengan del exterior
				cliente=servidor_cliente.accept();
				
				//ahora hay que crear un flujo de dato de entrada para recibir los datos enviados
				//por parametros le decimos porque socket va a recibir la informacion
				ObjectInputStream flujo_entrada=new ObjectInputStream(cliente.getInputStream());
				
				//ahora este objeto va a recibir por este flujo de entrada, leera lo que hay en su
				//interior y se almacenara en este objeto la ip el nick y el mensaje
				//hacemos casting ya que la variable paquete_recivido es de tipo paqueteEnvio
				paquete_recivido=(paqueteEnvio) flujo_entrada.readObject();
				
				//le decimos que si todavia no recibio el mensaje online al conectarse un cliente 
				//es decir que por ejemplo ya estan chateando y no se conecto ninguno mas entonces
				//tiene que mostrar en el area de texto el nick con el mensaje
				if(paquete_recivido.getMensaje().equals(" online")==false) 
				{
					//ahora escribiremos en el area de texto la informacion llegada  y el area de texto se 
					//llamaba campochat
					campochat.append("\n" + paquete_recivido.getNick() + ": " + paquete_recivido.getMensaje());
					
				}
				//en caso de si se conecta otro mas que muestre la ip del que se conecta
				else 
				{
					//para que muestre el Arrayliste de las ip conectadas
					campochat.append("\n" + paquete_recivido.getIps());
					
					
					//metemos el ArrayList a el JComboBox pero primero creamos un nuevo ArrayList
					ArrayList<String> ipsMenu=new ArrayList<String>();
					
					//ahora tenemos que decir que este ArrayList almacene el ArrayList que el cliente
					//a recibido es decir que en este arraylist creado meteremos lo que le llegue del
					//servidor  que llegue del servido que es el paquete_recivido de tipo paqueteEnvio
					//y utilizamos el metodo getIps para obtener ese ArrayList
					ipsMenu=paquete_recivido.getIps();
					
					//de esta manera funciona pero al conectarse otra ip agrega devuelta la ip que
					//antes con la nueva y en ves de tener dos ip tendrian 3 y asi susecivamente
					//si se conecta otro cliente duplicara las ip ya existentes mas la nueva
					//para que esto no suceda en la clase JComboBox hay un metodo llamad 
					//removeAllItems() no devuelve nada y lo que hace es: vaciar un JComboBox
					//con esto conseguimos que antes de agregar el ArrayList actualizado borre el
					//viejo,es decir, cada ves que se conecte un usuario nuevo entra en el else
					//y antes de poner la direccion ip que estan primero las borra asi despues imprime
					//con el bucle for actualizado
					ip.removeAllItems();
					
					//una ves almacenado reccoremos ese ArrayList con bucle foreach
					for (String s : ipsMenu) 
					{
						//cada elemento recibido lo va a recorrer y agregar al JComboBox llamado ip
						ip.addItem(s);
						
					}
				}	
				
				//cerramos socket y el Stream
					cliente.close();
					servidor_cliente.close();
				
			}
			
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	private JTextField campo1;
	private JComboBox ip;
	private JLabel nick;
	private JButton miboton;
	private JTextArea campochat;
}


/*son bastantes cosas que tenemos que enviar por un lado el nick es decir nuestro nombre , la direccion
 * ip y el mensaje  en ves de enviarle uno por uno seria engorroso por eso crearemos un objeto que tenga
 * tre propiedades o atributos el nicj,ip,y mensaje y de esta forma en ves de enviar las tres cosas por
 * separado lo que hacemos es enviarle al destinatario un objeto y ai se encargara el destinatario de 
 * desmenuzar ese objeto para obtener el nick,ip y mensaje seria como empaquetar todo e eniviarselo
 * asique comensaremos a crear este objeto o clase*/

/*la serializacion es importante cuando queremos enviar un objeto por la red o cuando queremos tene 
acceso a nuestro sistemas de ficheros. la serializacion coinsiste en decirle a una claseque puede
convertirse o los objetos de esa clase convertirse en una serie de bytes para poder ser enviados 
por la red la clase a serializar es la que construye los paquetes que vamos a mandar que contiene
el nick ,ip y mensaje y es la de paqueteEnvios sino hicieramos esto a la hora de ejecutar el programa
al final lanzaria una excepcionde tipo serializable */

class paqueteEnvio implements Serializable
{
	private static final long serialVersionUID = 1L;

	//creamos ggeter y seters tanto para establecer la informacion y almacenarla como para rescatarla
	//y mostrarla
	public String getNick()
	{
		return nick;
	}

	public void setNick(String nick)
	{
		this.nick = nick;
	}

	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public String getMensaje()
	{
		return mensaje;
	}

	public void setMensaje(String mensaje)
	{
		this.mensaje = mensaje;
	}
	

	public ArrayList<String> getIps() {
		return Ips;
	}

	public void setIps(ArrayList<String> ips) {
		Ips = ips;
	}
	
	//campos de clase creamos ArrayList para poder extraer la informacion si lo necesitamos
	//como introducir informacion dentro de este ArrayList si lo necesitamos con esto
	//conseguimos que viaje un paquete con nick,ip,mensaje y un ArrayList
		private String nick,ip,mensaje;
		private ArrayList<String> Ips;
}


