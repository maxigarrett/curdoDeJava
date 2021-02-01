package ejersicioCombinandoTodo;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class laminaBotones extends JPanel
{
	public laminaBotones(String titulo,String[] opciones) 
	{
		//para darle borde a los grid layout que utilisa un metodo borderfactory al ser estatico
		//primero va borderfactory.createtittlebordery por parametros pide un tipo borde y un titulo
		//el parametro border hay varios usamos uno para darle un borde senciollo y sin color
		//que es estatico BorderFactory.createEtchedBorder() y el titulo le decimos que es lo q le pasamos
		//por parametro al constructor que es titulo
		
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
		
		//disposicion de tipo caja por parametros hace referencia a el componente padre la lamina y el
		//segundo que va a tener una disposicion vertical por la "Y"
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//creamos grupo de botones
		 grupo=new ButtonGroup();
		
		//recorre lo que pasamos por parametro al contructor que es un array de tipo String
		for(int i=0;i<opciones.length;i++) 
		{
			//creamos un radiobutton y por parametro le decimos que reccora opciones que es el array
			//pasado por parametros de i ya que el for la variable es i y arranca a evaluar de 0
			JRadioButton bot=new JRadioButton(opciones[i]);
			
			//la clase JRadioButton tiene un metodo setActionComand establece la accion de comdo de cualquier
			//boton creado y por parametro pide una accion de comando de tipo String y le pasamos el arrays
			//de tipo String llamado opciones anteriormente en el constructor
			bot.setActionCommand(opciones[i]);
			//agregamos el boton a la lamina
			add(bot);
			//agregamos el boton al grupo
			grupo.add(bot);
			
			//le decimos que el primer boton este seleccionado
			bot.setSelected(i==0);
		}
		
	}
	public String dameSeleccion() 
	{
		//para saber que boton seleccionamos hay que ir a la api de java a la clase BUttonGroup y hay un
		//metodo para saber que boton seleccionamos (getSelection) pero este metodo devuelve un objeto de
		//tipo ButtonModel si le damos clic al ButtonModel hay un metodo que duvuelve un String que es
		//getActionCommand(); que devuelve el String del boton correspondiente seleccionado
		
		ButtonModel miboton=grupo.getSelection();//aca tenemos almacenado el boton o JRadioButton seleccionado
		
		String s=miboton.getActionCommand();//devuelve el String del JRadioButton es decir como lo llamamos y 
											//hemos cliqueado
		return s;
		
		//es lo mismo pero mas simplificado
		//return grupo.getSelection().getActionCommand();
	}
	
	private ButtonGroup grupo;
}
