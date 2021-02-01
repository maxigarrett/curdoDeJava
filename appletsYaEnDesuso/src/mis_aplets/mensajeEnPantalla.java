package mis_aplets;

import javax.swing.JApplet;
import javax.swing.JLabel;

public class mensajeEnPantalla extends JApplet
{
	//para crear una applet no lleva metodo main sino que su ejecucion pasa por un metodo llamado init();
	public void init()
	{
		JLabel rotulo=new JLabel("hola alumnos");
		
		//agregamos el componente en este caso el JLabel al applet
		add(rotulo);	
	}
}
