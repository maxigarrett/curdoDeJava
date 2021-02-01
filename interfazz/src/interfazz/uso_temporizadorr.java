package interfazz;
import java.awt.Toolkit;
//el metodo timer lo comparten tres paquetes diferentes si ubiese inportado java.awt.*;y javax.swing*;
//si especificar el paquete de cual timer queremos usar el programa no sabria cual utilizar 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;



public class uso_temporizadorr 
{

	public static void main(String[] args)
	{   //ActionListener oyente=new damelahs();    de esta manera tambien se instacia
		
		damelahs oyente=new damelahs();//llama constructor por defecto
		Timer miTemporizador= new Timer(5000,oyente);//cada 5 segundos ejecuta la accion metodo timer segundo 
		                                          //parametro de tipo interfaz llamado ayente(objeto) para instanciar
		                                            //la interfaz por parametro es actionlistener		
		
		miTemporizador.start(); //con esto comienza a ejecutar  el temporizador                 
		JOptionPane.showMessageDialog(null,"pulse aceptar para salir");//cuando empiese el programa se dentendra
		//en menos de un segundo por eso con esta ventana de tipo JOptionpane no se saldra asta darle aceptar y se
		//ejecutara el programa cada 5 segundo 
		System.exit(0);
	}

}

class damelahs implements  ActionListener //interfaz predefinida y hay que usar su metodo actionperformed
{
	public void actionPerformed(ActionEvent e) //metodo de la interfaz se invoca cuando ocurre una accion
	{
		Date ahora=new Date();// almacenamos en la variable objeto ahora la hora cada 5 seg especificado en timer
		
		System.out.println("te pongo la hs cada 5 sg "+ahora);
		Toolkit.getDefaultToolkit().beep();//sirve para que cada vez que se ejecute la instruccion haga un sonido
	}
}

