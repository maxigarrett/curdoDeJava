package sokets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class cliente
{

	public static void main(String[] args)
	{
		MarcoCliente mimarco=new MarcoCliente();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setBounds(600,200,400,300);
		mimarco.setVisible(true);
	}

}


class MarcoCliente extends JFrame
{
	private static final long serialVersionUID = 1L;

	public MarcoCliente() 
	{
		add(new LaminaCliente());
	}
}

class LaminaCliente extends JPanel
{
	
	private static final long serialVersionUID = 1L;
	public LaminaCliente()
	{
		//creaamos un label
		JLabel texto= new JLabel("cliente");
		//lo agregamos a la lamina
		add(texto);
		
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
				Socket misocket=new Socket("192.168.0.108",9999);
				
				//crear Stream para crear el flujo de datos de salida OutputStream para poder mandar
				//el texto con el boton la clase que vamos a utilizar va a ser DataOutputStream y el
				//constructor pide por parametro un objeto de tipo OutputStream de salida  y le pasamos
				//por parametro el soket creado y dentro de los metodos de la clase Socket hay un metodo
				//que devuelve OutputStream que es el metodo getOutputStream() y si lo indicamos por
				//parametros como se ve, es decir, este constructor pide por parametros por donde va a
				//sircular. Entonces  hemos construido un flujo de datos(flujo_salida) y este flujo de
				//datos de salida va a sircular por el Socket que hemos creado anteriormente(misocket)
				DataOutputStream flujo_salida=new DataOutputStream(misocket.getOutputStream());
				
				//ahora le tenemos que indicar a este OutputStream a este flujo de datos de salida que
				//es lo que va a circular por este dato de flujo de salida y le decimos que circule 
				//lo que capturemos del texto que hay en campo1 del TextField, es decir, le decimos
				//que escriba en el flujo de salida lo que hay en el campo1 y ese flujo circulara por
				//el socket y el socket se esta dirigiendo a ese servidor especificado con ip y con un
				//puerto habierto 9999
				flujo_salida.writeUTF(campo1.getText());
				
				//cerramos el flujo par que no quede abierto ocupando recursos y el soket
				flujo_salida.close();
				misocket.close();
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
	
	private JTextField campo1;
	private JButton miboton;
}



/*ahora hay que ir a la clase servidor y configurarlo ,es decir, a este servidor hay que ponerlo a la
 * escucha y hay que decir le que abra el puerto 9999 lo que hemos echo hasta ahora es crear el puente
 * el socket  pero ahora hay que decirle a este servidor que nos abra una ventana o un puerto que va a 
 * se el 9999 para que puedan entrar los datosa traves de ese puerto y que permanezcan constantemente a
 * la escucha */
 