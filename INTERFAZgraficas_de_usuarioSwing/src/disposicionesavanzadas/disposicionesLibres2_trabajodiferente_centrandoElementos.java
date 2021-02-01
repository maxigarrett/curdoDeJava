package disposicionesavanzadas;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class disposicionesLibres2_trabajodiferente_centrandoElementos 
{

	public static void main(String[] args)
	{
		Marcolibre4 mimarco=new Marcolibre4();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setBounds(800, 300, 400, 300);
		mimarco.setVisible(true);


	}

}




class Marcolibre4 extends JFrame
{
	public Marcolibre4() 
	{
		add(new Laminalibre4());
	}
}

class Laminalibre4 extends JPanel
{
	public Laminalibre4()
	{	
		//con el parametro de columnas que implementa la interfaz el layout se comporta como queremos y
		//programamos
		setLayout(new columnas2());
		JLabel nombre =new JLabel("nombre:");
		JLabel apellido =new JLabel("apellido:");
		JLabel edad=new JLabel("edad");
		JTextField texto3=new JTextField();
		JTextField texto1=new JTextField();
		JTextField texto2=new JTextField();
		
		//le damos ubicacion al label y el texto
		/*nombre.setBounds(20, 20,80, 10);
		texto1.setBounds(100, 19, 110, 20);
		
		apellido.setBounds(20, 40,80, 15);
		texto2.setBounds(100, 39, 110, 20);*/
		
		//agregamos los labels y textos a la lamina
		add(nombre);
		add(texto1);
		add(apellido);
		add(texto2);
		add(edad);
		add(texto3);
		
		
	}
}




class columnas2 implements LayoutManager
{

	
	public void addLayoutComponent(String name, Component comp) 
	{
		
		
	}

	
	public void removeLayoutComponent(Component comp)
	{
		
		
	}

	
	public Dimension preferredLayoutSize(Container parent) 
	{
		
		return null;
	}

	
	public Dimension minimumLayoutSize(Container parent) 
	{
		
		return null;
	}

	//metedo que solo vamos a utilisar 
	public void layoutContainer(Container micontenedor)
	{
		//almacenamos en el objeto d las dimenciones del contenedor o el frame
		int d=micontenedor.getWidth();
		
		//para desplazar a la mitad las coordenadas de las x al medio pero los componentes se ubicaran del
		//lado izquierdo ya que el primer label se pondra en el medio y el cuadro de texto mas al costado
		//y quedara del lado izquierdo por eso hay que hacer una correcion en c.setBounds(x,y,100,20);
		x=d/2;
		//para saber cuantos elementos llevamos agregados
		int contador=0;
		
		//para saber cuantos elementos o componentes agregamos al contenedor
		int n=micontenedor.getComponentCount();
		
		//bucle for
		for(int i=0;i<n;i++) 
		{
			//para saber en cada momento si estamos evaluando el elemento 0,1,2,3,etc
			contador++;
			
			//almacena en el objeto c de tipo componente el primer componente,sea un JLabel JTextField;etc.
			Component c=micontenedor.getComponent(i);
			
			//le decimos que todos los componentes se van ubicar  en cordenadas x ,y ya especificadas en varibles
			//les restamos 100 a x ya que al ubicarse al medio hay que restarle el ancho del label que es el que 
			//ubicamos siempre primero porque sino se desplaza el siguiente componente agregado a la izquierda
			//y queda todo del lado izquierdo
			c.setBounds(x-100, y, 100, 20);
			
			//para que no quede un componente arriba de otro le decimos corre el el componente a 120
			//ya que x vale 20
			x=x+100;
			
			/*cada vez que sea par salta o ubica abajo el otro componente con el if le decimos cada vez que
			 es par que vaje 40 pixeles es decir agregamos el primer componente que vale 1 agreamos el 
			 segundo que vale 2 lo hubica al lado y como es par salta hacia abajo diciendo que y+=40 ya que las 
			 cooordenada y bajan y las x swe corren para el costado si agregamos otro componente vale 3 y 
			 agregamos otro vale 4 lo ubica al lado y el 4 es par asiq salta para abajo */
			if(contador%2==0)
			{
			
				x=d/2;//para que el siguiente componente lo ponga a la mitad de vuelta parejo uno debajo de otro
				y+=40;
			}
		}
		
	}
	
	//variables iniciadas para que aparescan en el frame en esa posicion
	private int x;
	private int y=20;
	
}