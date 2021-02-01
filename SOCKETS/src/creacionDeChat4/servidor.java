package creacionDeChat4;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;





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
			
			//creamos ArrayList para almacenar dinamicamente las ip y son ip de tipo String para que
			//machaque a la siguiente ip a conectar lo colocamos en esta posicion si por ejemplo
			//lo pusieramos en el else cada ves que se conecte una ip nueva machacara la anterior
			//es de cir cada ves que se conecte un cliente ahora si vamos al else a rellenar el arrayList
			//para que almacena cada ip nueva que se conecte
			ArrayList<String> listaIp=new ArrayList<String>();
			
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
				
				//si el mensaje que recibimos es diferente de  online es decir el mensaje que envia
				//del cliente es diferente quiere decir que ya se conecto por primera vez y ejecutara
				//el codigo del if.. en caso de que no se ejecutara por primera ves ira al else
				//y iniciara la comunicacion online para mostrar la ip 
				//online es el mensaje que envia autimaticamente una ves se ejecuta la aplicacion 
				//logrado con WindowAdapter en la clase cliente
				if(!mensaje.equals(" online")) 
			{
					
				
				
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
				else 
				{
					//------------------------------- DETECTA ONLINE A LOS CLIENTES----------------------------------------
					/*en el servidor donde nos encontramos le tenemos que decir que se entere de cuando un cliente abre la
			  ventana ,es decir, necesitamos que nada mas abrir la ventana del cliente o ejecutarlo ese cliente
			  envie una señal al servidor y que este servidor sea capas de recepcionar esa sañal y detectar la ip
			  de la persona que habre el cliente o lo ejecuta y tendremos que utilizar algunos metodos que se 
			  encuentran dentro de la clase Socket como getInetAddress() y trabajar con una clase nueva relacionado
			  con las redes que es la clase InetAddress
			  getInetAddress() este metodo devuelve la direccion a la cual el Socket esta conectado es decir que
			  tenemos un cliente y un servidor y creamos un socket para enviar y recibir informacin este metodo
			  nos va a dar la direccion del socket al cual esta conectado el servidor (del cliente) este metodo
			  nos devuelve un objeto de tipo InetAddress y lo que nostros queremos tener en ultima instancia es
			  un String con la direccion ipde la persona que esta conectada (del cliente) y este metodo no nos
			  devuelve el String que queremos pero dentro de la clase InetAdress que es lo que devuelve el metodo
			  esta clase tiene un metodo llamado getMostAddress() que si nos devuelve la ip en String del host
			  al que estamos conectados es decir nos devuelve un String este metodo */
							
							//almacenamos dentro de esta variable la direccion del cliente con el que acabamos de 
							//conectar
							InetAddress localizacion=misocket.getInetAddress();
							
							//este metodo devuelve un String  por eso creamos una variable de ese tipo
							//y pasamos la ip de ser InetAddress a String
							String ipRemota=localizacion.getHostAddress();
							
							//para hacer una prueba en el cliente hay que construir una clase que gestione los
							//eventos de ventana porque si provamos asi dara error de coneccion
							System.out.println(" Online " + ipRemota);
							
							//ya creamos ArrayList ahora hay que rellenar ese ArrayList con cada ip que se valla conectando
							//entoces cada ip que se conecte la obtendremos de ipRemota y tendremos que agregar eso al
							//ArrayList osea cada ves que se conecte un cliente nuevo al ejecutarse el cliente 
							//automaticamente ese envia un un paquete con el nick ip y un mensaje que es online
							//cada ves que se conecte un cliente se ira agregando al ArrayList entonces
							listaIp.add(ipRemota);
							
							//metemos el ArrayList que contengan un cliente conectado como mil al
							//paquete que vamos a enviar despues a todos los clientes y lo metemos al 
							//paquete gracias al setter que creamos de ArrayList en el clienete
							//y lo metemos en el paquete ya creado de tipo paqueteEnvio llamado paquete_recibido
							//el seter de Ips pide como argumento un arraylist y ya lo creamos y lo llamamos
							//listaIp y con esto conseguimos meterlo en el paquete ademas del nick,mensaje,ip
							paquete_recibido.setIps(listaIp);
							
							/*siguiente paso enviar este paquete a los clientes de tal forma que cada ves que se conecte un 
							 cliente nuevo el codigo entra en el else detecta la ip despues imprime online y la ip de turno
							 despues agregamos al ArrayList las ip de los que se van conectando, creamos un paquetedonde 
							 metemos ese ArrayList y lo unico que queda es enviar a cada uno de los clientes ese ArrayList*/
							//para enviar a cada cliente las ip que esten conectadas recorreremos el ArrayList con bucle
							//foreach es decir recorreremos elemnto a elemento de ese array cada una de esas direcciones
							//que se vallan conectado y enviar a cada una de esas direcciones ip su propio ArrayList
							for(String z: listaIp) 
							{
								/*para poder enviar a cada direccion ip las demas que estan conectadas
								 osea ese ArrayList en ves de poner en el Socket la direccion ip
								 pondremos z que es donde se almacena las ip que se van conectando
								 cuando recorra la primera ip enviara todas las ip conectadas, cuando
								 pase o recorra la segunda ip pasara la del primero y demas ip conectadas
								 y haci todas las ip que se conectan o clientes podran saber que ip estan online
								 para chatear*/
								Socket enviaDestinatario=new Socket(z,9090);
								
								//creamos flujo de datos y por parametro le decimos por que socket viajar
								ObjectOutputStream paqueteRernvio=new ObjectOutputStream(enviaDestinatario.getOutputStream());
								
								//escribimos el flujo de salida 
								paqueteRernvio.writeObject(paquete_recibido);
								
								//cerramos flujo
								paqueteRernvio.close();
								enviaDestinatario.close();
								//despues de esto tendremos que preparar al cliente para que reciba el ArrayList
								
								
							}
							
							
							
						//------------------------------FIN DE DETECTA ONLINE-----------------------------------
				}
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
