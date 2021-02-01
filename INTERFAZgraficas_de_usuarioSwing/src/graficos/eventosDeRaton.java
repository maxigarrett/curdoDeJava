package graficos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class eventosDeRaton
{

	public static void main(String[] args)
	{
		MarcoRaton mimarco=new MarcoRaton();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	
	}

}


class MarcoRaton extends JFrame//objeto fuente
{
	public MarcoRaton() 
	{
		setBounds(400,300,300,400);
		EventoRaton raton=new EventoRaton();
		addMouseListener(raton);
		
		EventoRaton raton1=new EventoRaton();
		addMouseMotionListener(raton1);
	}
}

class EventoRaton extends MouseAdapter implements MouseMotionListener//implements MouseListener//objeto ayente obliga a implementar todos los metodos
{
	//metodo de la interfaz MouseMotionListenner
	public void mouseDragged(MouseEvent e) 
	{
		System.out.println("estas arrastrando");
	}
	//metodo de la interfaz MouseMotionListenner
	public void mouseMoved(MouseEvent e) 
	{
		System.out.println("estas moviendo el raton");
	}
	
	
	
	/*public void mouseClicked(MouseEvent e)
	{
		//System.out.println("has echo clic");
		int X=e.getX();//marca la posicion de x en el frame al hacer clic
		int Y=e.getY();//marca las y
		System.out.println("coordenadas "+X+" "+Y);//imprime coordenadas
		
		System.out.println(e.getClickCount()+" cilc");//imprime cantidad de clics
	}*/
	

	
	public void mousePressed(MouseEvent e)
	{
		//System.out.println(e.getModifiersEx());//marca el valor de la constante es decir al hacer clic 
		                                        //derecho o izquiero o girar la rueda del mause
		
		if(e.getModifiersEx()==1024) //al ser dificil el numero puede ir con el nombre de la clase
		{                            //y su campo de clase que seria MauseEventBUTTON1_DOWN_MASK es estatico
			
			System.out.println("has echo clic izquierdo");
		}
		else 
		{
			if(e.getModifiersEx()==MouseEvent.BUTTON3_DOWN_MASK) 
			{
				System.out.println("has echo clic derecho");
			}
		}
	}
	
	
	
	
	
	
	
	

	/*public void mouseReleased(MouseEvent e)
	{
		System.out.println("has soltado ");
	}

	
	public void mouseEntered(MouseEvent e)
	{
		System.out.println("has entrado a la ventana");
		
	}

	public void mouseExited(MouseEvent e)
	{
		System.out.println("has salido");
		
	}*/
	
}