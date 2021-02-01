package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Multiples_Oyentes
{

	public static void main(String[] args)
	{
		Marco_principal mimarco=new Marco_principal();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}


class Marco_principal extends JFrame
{
	public Marco_principal()
	{
		setTitle("varios oyentes");
		setBounds(900,200,400,300);
		Lamina_principal milamina=new Lamina_principal();
		add(milamina);
	}
}

class Lamina_principal extends JPanel//fuente
{
	
	public Lamina_principal()
	{
		JButton botonnuevo=new JButton("nuevo");
		cerrarboton=new JButton("cerrar boton");
		add(botonnuevo);
		add(cerrarboton);
		oyenteNuevo mioyente=new oyenteNuevo();//intanciamos oyenteNuevo
		botonnuevo.addActionListener(mioyente);//cada ves q se pulse el boton desencadena el evento y 
												//le decime que aga lo que hay  en la intancia oyenteNuevo
	}
	private class oyenteNuevo implements ActionListener//oyente 
	{
		public void actionPerformed(ActionEvent e) 
		{
			crear_ventana miventana=new crear_ventana(cerrarboton);//intanciamos a crear_ventana
			miventana.setVisible(true);//hacemos visible crear_ventana
		}
	}
	JButton cerrarboton;//lo declaramos afuera del constructor porque lo vamos a utiliza en otras cosas
}


class crear_ventana extends JFrame//creamos otra ventana 
{
	public crear_ventana(JButton botoncerrar) 
	{
		cierratodos oyentecerrar=new cierratodos();
		botoncerrar.addActionListener(oyentecerrar);
		setTitle("ventana "+contador);
		contador++;//cada vez que instanciemos osea creemos nuevas ventanas se incrementara en uno la variable
					//y aparecera como mensaje de titulo ventana 1,creamos otra y sera ventana 2,etc..
		
		setBounds(40*contador,40*contador,300,150);//cada vez que se cree una ventana nueva automaticamente
						//se ira creando en posiciones diferente ya que multiplicara la posicion por contadore
		
	}
	private class cierratodos implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			dispose();//cierra todas las ventanas emergentes pertenece a la clace JFrame
		}
		
	}
	private static int contador=0;//la hacemos estaticas asi todas las instancias creadas utilicen esta 
	                         //variable es decir todos los objetos que instanciemos compartiran la variable
	
	
}

