package graficos;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class evento4clasesAdaptadoras 
{
	public static void main(String[] args) 
	{
		MarcoVentana2 mimarco=new MarcoVentana2();
		mimarco.setTitle("ventana 1");
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mimarco.setBounds(100,300,500,400);
		
		MarcoVentana2 mimarco2=new MarcoVentana2();
		mimarco2.setTitle("ventana 2");
		mimarco2.setVisible(true);
		mimarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mimarco2.setBounds(700,300,500,400);
	}
}


class MarcoVentana2 extends JFrame
{
	public MarcoVentana2()
	{
		
		/*M_Ventanav miventana=new M_Ventanav();//instancia creada
		addWindowListener(miventana);//pone a la ventana a la escucha para responeder a la accin en la que programamos
		                          //en este caso cuando se minimiza que fue en el metodo que programamos
		Toolkit.getDefaultToolkit().beep();*/
		
		//es lo mismo que lo que esta arriba del codigo pero mas simplificado
		addWindowListener(new M_Ventanav());
	}
}

class M_Ventanav  extends WindowAdapter//clase adaptadora
{
	//al heredar y no implemetar la interfaz con sus metodos obligatorios te permite utilizar el metodo que deseas
	// ya que los estas heredandos todos lo contrario esta echo la clase evento3DeVentana
	
	
	public void windowIconified(WindowEvent e) 
	{//solo voy a usar un solo metodo aunque hay que declararlos todos obligatoriamente
		System.out.println("ventana minimizada");//muestra el mensaje cuando se minimize
		Toolkit.getDefaultToolkit().beep();
	}
	
}
