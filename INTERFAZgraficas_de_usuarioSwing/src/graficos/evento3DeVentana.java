package graficos;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class evento3DeVentana 
{

	public static void main(String[] args)
	{
		MarcoVentana mimarco=new MarcoVentana();
		mimarco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//si cierro ventana1 la otra sigue abierta
		mimarco.setVisible(true);
		mimarco.setTitle("ventana 1");
		mimarco.setBounds(300,300,500,350);
		
		MarcoVentana mimarco2=new MarcoVentana();
		mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//con este parametro si cerramos la ventana solo se cierra ventana 2
		mimarco2.setVisible(true);
		mimarco2.setTitle("ventana 2");
		mimarco2.setBounds(900, 300, 500, 250);
	}

}

class MarcoVentana extends JFrame
{
	public MarcoVentana()
	{
		//setBounds(400,300,500,400);
		//setTitle("ventana");
		M_Ventana miventana=new M_Ventana();//instancia creada
		addWindowListener(miventana);//pone a la ventana a la escucha para responeder a la accin en la que programamos
		                          //en este caso cuando se minimiza que fue en el metodo que programamos
		Toolkit.getDefaultToolkit().beep();
	}
}

class M_Ventana  implements WindowListener
{
	//todos los metodos obligatorios de la interfaz WindowListener
	public void windowActivated(WindowEvent e) 
	{
		System.out.println("ventana activada");
		Toolkit.getDefaultToolkit().beep();
	}
	public void windowClosed(WindowEvent e) 
	{
		System.out.println("ventana se cerro");
	}
	public void windowClosing(WindowEvent e)
	{
		System.out.println("cerrando ventana");
	}
	public void windowDeactivated(WindowEvent e) 
	{
		System.out.println("ventana desactivada");//cuando ventana esta en segundo plano y abrimos muestra mensaje
	}
	public void windowDeiconified(WindowEvent e)
	{
		System.out.println("ventana restaurada");
	}
	public void windowIconified(WindowEvent e) 
	{//solo voy a usar un solo metodo aunque hay que declararlos todos obligatoriamente
		System.out.println("ventana minimizada");//muestra el mensaje cuando se minimize
		Toolkit.getDefaultToolkit().beep();
	}
	public void windowOpened(WindowEvent e) 
	{
		System.out.println("ventana abierta");
	}
	
}
