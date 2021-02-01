package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class MultiplesFuenteDeEventos
{

	public static void main(String[] args) 
	{
		MarcoAccion mimarco=new MarcoAccion();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
		

	}

}

class MarcoAccion extends JFrame
{
	public MarcoAccion()
	{
		setBounds(400,50,800,400);
		PanelAccion panel=new PanelAccion();
		add(panel);
	}
}

class PanelAccion extends JPanel //fuente desencadena accion
{
	public PanelAccion() 
	{
		//llamamos al constructor de la clase Accioncolor y le pasamos por parametros lo que hay en el constructor
		Accioncolor accionamarillo=new Accioncolor("amarillo",new ImageIcon("src/graficos/bolaamarillo.JPG"),Color.yellow);
		Accioncolor accionrojo=new Accioncolor("rojo ",new ImageIcon("src/graficos/bolarojo.JPG"),Color.RED);
		Accioncolor accionazul=new Accioncolor("azul ",new ImageIcon("src/graficos/bolaazul.JPG"),Color.BLUE);
		
		/*creamos los botones pero llamamos a otro constructor para almacenar otras variables 
		JButton botonamarillo=new JButton(accionamarillo);
		add(botonamarillo);
		JButton botonrojo=new JButton(accionrojo);
		add(botonrojo);
		JButton botonazul=new JButton(accionazul);
		add(botonazul);*/
		
		//de forma mas simplificada
		add(new JButton(accionamarillo));
		add(new JButton(accionazul));
		add(new JButton(accionrojo));
		
		/*como los botones van en la lamina se crean aca en la lamina
		JButton botonamarillo=new JButton("amarillo");
		JButton botonrojo=new JButton("rojo");
		JButton botonazul=new JButton("azul");
		
		agregamos los botos a la lamina
		add(botonamarillo);
		add(botonrojo);
		add(botonazul);*/
		
		//creamos accion de teclado para que pinte de color la lamina con alguna tecla que asignemos nosotros
		//creamos el objeto imputmap       //el metodo getImputMap devuelve objeto de tipo ImputMap 
		InputMap mapaentrada=getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);//paso1 intanciamos constructor
		                                          //cuando tenga el foco de la ventana o boton
		
		//creacion de combinacion de teclas
		KeyStroke teclaAmarillo=KeyStroke.getKeyStroke("ctrl A");//paso2
		KeyStroke teclaroja=KeyStroke.getKeyStroke("ctrl R");
		KeyStroke teclaazul=KeyStroke.getKeyStroke("ctrl B");
		
		mapaentrada.put(teclaazul, "fondo_azul");
		mapaentrada.put(teclaroja, "fondo_rojo");
		mapaentrada.put(teclaAmarillo, "fondo_amarillo");//paso3//asignar la combinacion de teclas que es teclaAmarillo a un objeto
		                                               //que es fondo_amarillo put pertenece a la clase imputmap
														//utilisamos nombre de instancia para invocarlo que es mapaentrada
		
		
		//CREAMOS MAPA DE ACCION
		ActionMap mapaaccion=getActionMap();//paso4 devuelve un objeto de tipo ActionMap vincula la combinacion de tecla con la accion del constructor creada accionamarillo
		mapaaccion.put("fondo_amarillo", accionamarillo);//utilizamos metodo put para asignar el objeto creado mapaaccion a la combinacion de teclas
		mapaaccion.put("fondo_azul",accionazul);
		mapaaccion.put("fondo_rojo", accionrojo);
		
		
	}
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
			
			putValue("color de fondo",colorboton);
		}
		
		public void actionPerformed(ActionEvent e) //se invoca cuando ocurre una accion que seria al precionar
		        // el boton y esa informacion de boton se almacena el la variable e de tipo ActionEvent(accion)
		{
			
			//se hace el casting porque no se puede almacenar un string en una variable color
			
			Color c=(Color) getValue("color de fondo");//metodo pertenece ala interfaz action o abtractAction permite rescatar del objeto 
			setBackground(c);			                //del evento el valor correspondiente a una clave
				
				System.out.println("nombre "+ getValue(AbstractAction.NAME));//muestra por consola
										//lo que rescatamos de lo que hay almacenado en AbstractAction.NAME
		}
		
	}
}


