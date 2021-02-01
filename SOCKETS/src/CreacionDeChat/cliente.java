package CreacionDeChat;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*vamos a crear un chat completo  es decir vamos a crear un servido que es el que gestiona todas las 
 comunicaciones un servidor remoto entonces vamos a tener que crear una aplicacion servidor y esta 
 aplicacion servidor estara alojada en un server(en un ordenador servidor) y luego vamos a tener que 
 crear una aplicacion cliente y esa aplicacion cliente la tendremos que instalar despues en un monton
 de ordenadores clientes ¿como va a funcionar esta aplicacion? todos aquellos ordenadores clientes 
 que tengan la parte del cliente van ser capaces de enviar esa informacion a otros clientes utilizando
 el servidor como punto intermedio o gestion del traficode tal forma que un cliente puede enviar
 esa informacion a otro cliente y ese otro cliente cuando reciba la informacion sera capas tambien de
 enviar una informacion diferenteutilizando el servidor como punto intermedio o como puente para hacer
 esta prueba necesitamos un servidor y por lo menos dos clientes y para simular esto tendremos que 
 utilizar maquinas virtuales utilizando virtualBox*/

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
		milamina.setBackground(Color.black);
		add(milamina);
		
	}
}

class LaminaCliente extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	public LaminaCliente()
	{
		//para que aparezca a izquierda y arriba de todo del label agregamos este nick(JTextField)
		//por parametros le damos un ancho
		nick=new JTextField(5);
		add(nick);
		

		//creaamos un label
		JLabel texto= new JLabel("CHAT");
		//lo agregamos a la lamina
		add(texto);
		
		//para que aparezca a la derecha y arriba lo agregamos despues del label y queremos que
		//aparezca la ip con el que chateamos
		ip=new JTextField(10);
		add(ip);
		
		//creamos area de texto primer parametro largo segundo ancho
		campochat=new JTextArea(12,20);
		
		//agregamos el JTextArea
		add(campochat);
		
		//creamos un cuadro chiquito de texto 
		campo1=new JTextField(20);
		//lo agregamos a la lamina
		add(campo1);
		
		//creamos boton
		miboton=new JButton("enviar");
		add(miboton);
		
		
		
		miboton.addActionListener(new EnviaTexto());
		
		
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
			
			try
			{
				Socket misocket=new Socket("192.168.0.120",9999);
				
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
				
				//hacemos lo mismo con la ip y el mensaje
				datos.setIp(ip.getText());
				//ya tenemos todos los datos enpaquetados dentro de el objeto creado de la intacia
				//paqueteEnvios llamado datos
				datos.setMensaje(campo1.getText());
	//----------------------------------------------------------------------------------------------			
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
				flujo_salida.close();
				
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
	
	private JTextField campo1,nick,ip;
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
	
	//campos de clase 
	private String nick,ip,mensaje;
}


