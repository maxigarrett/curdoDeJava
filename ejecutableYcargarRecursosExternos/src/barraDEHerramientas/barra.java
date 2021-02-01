package barraDEHerramientas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;





public class barra
{

	public static void main(String[] args) 
	{

		Marco_barra mimarco=new Marco_barra();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
		
		
	}

}



class Marco_barra extends JFrame
{
	public Marco_barra()
	{
		setTitle("menu con barra");
		setBounds(400,50,800,400);
		
		lamina=new JPanel();
		add(lamina);
		
		//para hacer un ejecutable necesitamos un metodo para extraer los recursos externos como las
		//imagenes que le agregamos en este caso ala barra de herramientas
		
		
		//llamamos al constructor de la clase Accioncolor y le pasamos por parametros lo que hay en el constructor
		Action accionamarillo=new Accioncolor("amarillo",new ImageIcon("src/graficos/bolaamarillo.JPG"),Color.yellow);
		Action accionrojo=new Accioncolor("rojo ",new ImageIcon("src/graficos/bolarojo.JPG"),Color.RED);
		Action accionazul=new Accioncolor("azul ",new ImageIcon("src/graficos/bolaazul.JPG"),Color.BLUE);
		
		
		//creamos un boton para salir de la barra de herramientas
		Action accionsalir=new AbstractAction("salir",new ImageIcon("src/creacionDeMenus/cerrar.png")) 
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);//hacemos que el boton creado cierre la ventana
			}
		};
		//creamos un menu
		JMenu menu=new JMenu("color");
		//un metod de add que porparametro recibe la accion
		menu.add(accionamarillo);
		menu.add(accionrojo);
		menu.add(accionazul);
				
		//creamos barra de mennu
		JMenuBar barramenu=new JMenuBar();
		
		//agregamos a la barra de menu el menu que contiene las acciones del metodo
		barramenu.add(menu);
				
		//metodo perteneciente a JFrame que permite agregar la barra de menu creada al marco
		setJMenuBar(barramenu);
		
	//---------------------------------------------------------------------------------------------	
		//construccion de la barra de herramientas con la clase JToolBar
		JToolBar barra=new JToolBar();
		
		//agregamos a la barra los botones de las acciones
		barra.add(accionazul);
		barra.add(accionamarillo);
		barra.add(accionrojo);
		barra.addSeparator();
		barra.add(accionsalir);
		
		//agregamos la barra de herramientas creada y diciendole que disponga de un borderlayout
		//nos permite arrastrarla
		add(barra,BorderLayout.NORTH);
	}



	
	//clase privada
	private class Accioncolor extends AbstractAction//oyente   recibe la accion y la desencadena
	{
		//le paso al constructor por parametro el tipo de informacion que quiero rescatar
		public Accioncolor(String nombre,Icon icono,Color colorboton) 
		{
			      //String clave       //OBject valor
			putValue(AbstractAction.NAME,  nombre);       //putValue pide string y un objeto
											//es estatico las constantes NAME y es la clave usada para
									        //almacenar el nombre de la aacion en este caso el boton
			
			
			putValue(AbstractAction.SMALL_ICON,icono);//almacenamos el icono del boton
			
			putValue(AbstractAction.SHORT_DESCRIPTION,"poner la lamina de color "+nombre);//almacena una descripcion que le pasamos
													//que al dejar el raton quieto en el boton saldra un mensaje
			
			putValue("color",colorboton);//lo que tiene que hacer la accion
		}
		
		
		
		public void actionPerformed(ActionEvent e) //se invoca cuando ocurre una accion que seria al precionar
		        // el boton y esa informacion de boton se almacena el la variable e de tipo ActionEvent(accion)
		{
			
			//se hace el casting porque no se puede almacenar un string en una variable color
			
			Color c=(Color) getValue("color");//metodo pertenece ala interfaz action o abtractAction permite rescatar del objeto 
			lamina.setBackground(c);			                //del evento el valor correspondiente a una clave
				
				System.out.println("nombre "+ getValue(AbstractAction.NAME));//muestra por consola
										//lo que rescatamos de lo que hay almacenado en AbstractAction.NAME
		}
		
	}
	private JPanel lamina;
	
}