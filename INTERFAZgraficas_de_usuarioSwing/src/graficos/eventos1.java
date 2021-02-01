package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class eventos1 
{

	public static void main(String[] args) 
	{
		MarcoBotone mimarco=new MarcoBotone();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoBotone extends JFrame 
{
	public MarcoBotone() 
	{
		setTitle("ventana evento");
		setBounds(500,300,500,300);
		LaminaBotones milamina=new LaminaBotones();
		add(milamina);
	}
}

//la lamina tiene que implementar la interfaz acctionListener porque es la propia lamina quien resiva el evento
class LaminaBotones extends JPanel implements ActionListener
{
	JButton botonazul=new JButton("azul");//creamos boton y en el constructor lo agregamos
	JButton botonamarillo=new JButton("amarillo");
	JButton botonrojo=new JButton("rojo");
	public LaminaBotones()
	{
		add(botonrojo);
		add(botonamarillo);
		add(botonazul);//agregamos boton a la lamina
		botonazul.addActionListener(this);//le decimos al boton que va a desencadenar un evento de tipo clic(actionListener)
		                              //y el objeto que tiene que esta a la escucha es this osea la lamina o la propia clase
	                                 //objeto fueste es botonazul (boton)
		botonrojo.addActionListener(this);
		botonamarillo.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) //metodo que pertenece a la interfaz ActionListener
	{
		//el metodo getSource es un metodo perteneciente a la clase actioevent y devuelve quie es la fuente el origen del evento
		//captura el origen del evento osea quien desencadena la accion que en este caso son tres botos
		
		Object boton= e.getSource();  //la e el el objeto de tipo evento que resivimos por parametro
		if(boton==botonazul) 
		{
			setBackground(Color.BLUE);
		}
		if(boton==botonamarillo) 
		{
			setBackground(Color.YELLOW);
		}
		else 
		{
			setBackground(Color.RED);
		}
	}
	
}
