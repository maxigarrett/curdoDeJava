package componenteSwingIntruduTexto;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class controldeslizante2 
{

	public static void main(String[] args)
	{
		MarcoSlider mimarco=new MarcoSlider();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
		
	}

}

class MarcoSlider extends JFrame
{
	public MarcoSlider() 
	{
		setBounds(600,200,400,250);
		
		LaminaSlaider milamina=new LaminaSlaider();
		add(milamina);
	}
}

class LaminaSlaider extends JPanel
{
	public LaminaSlaider() 
	{
		setLayout(new BorderLayout());
		rotulo=new JLabel("en un camino largo...");
		add(rotulo,BorderLayout.CENTER);
		
		//instancia de segunda lamina
		LaminaSlider2 lamina=new LaminaSlider2();
		add(lamina,BorderLayout.NORTH);
	}
	
	//clase interna para crear el JSlider
	class LaminaSlider2 extends JPanel
	{
		public LaminaSlider2()
		{

			//creamos el Slider
			control=new JSlider(8,60,12);
			control.setMajorTickSpacing(25);
			control.setMinorTickSpacing(5);
			control.setPaintTicks(true);
			control.setPaintLabels(true);
			control.setFont(new Font("Serif",Font.ITALIC,10));
			add(control);//agregamos el slider a la lamina
			
			LaminaSlider3 evento=new LaminaSlider3();
			control.addChangeListener(evento);
		}
	}
	
	//clase interna para poner el slider a la escucha y desencadenar el evento
	
	private class LaminaSlider3 implements ChangeListener
	{
		public void stateChanged(ChangeEvent e) 
		{
			//System.out.println("te estas moviendo "+ control.getValue());
			
			
			//por tamaño le decimos control(es el JSlider).getvalue(devuelve el valor en donde
			//se encuentra posicionado) 
			rotulo.setFont(new Font("Serif",Font.PLAIN,control.getValue()));
		}
		
	}
	//variables de clase
	private JLabel rotulo;
	private JSlider control;
}
