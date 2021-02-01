package componenteSwingIntruduTexto;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class botonesDeRadio2 
{

	public static void main(String[] args)
	{
		Marco_conRadio mimarco=new Marco_conRadio();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}



class Marco_conRadio extends JFrame
{
	public Marco_conRadio() 
	{
		setBounds(600,200,450,250);
		LaminaConRadio milamina=new LaminaConRadio();
		add(milamina);
	}
}



class LaminaConRadio extends JPanel
{
	public LaminaConRadio() 
	{
		setLayout(new BorderLayout());
		
		//creamos etiqueta con nombre  en el centro con JLabel
		texto=new JLabel("hola a todos...",JLabel.CENTER);
		//le decimos al texto que va a tener por defecto lo que pasemos por Font
		texto.setFont(new Font("Serif",Font.PLAIN,12));
		add(texto,BorderLayout.CENTER);
		
		//agregamos segunda lamina
		laminaconradio lamina=new laminaconradio();
		add(lamina,BorderLayout.SOUTH);
		
		
		


	}
	private class laminaconradio extends JPanel
	{
		public laminaconradio()
		{
			//agrupamos los botones de radio
			ButtonGroup migrupo1=new ButtonGroup();
			
			//creamos los botones de radio
			
			boton1=new JRadioButton("pequeño",false);
			boton2=new JRadioButton("mediano");
			boton3=new JRadioButton("grande",false);
			boton4=new JRadioButton("muy grande",false);
			boton5=new JRadioButton("estandar",false);
			boton2.setSelected(true);
			//agregamos los botones al grupo
			migrupo1.add(boton1);
			migrupo1.add(boton2);
			migrupo1.add(boton3);
			migrupo1.add(boton4);
			migrupo1.add(boton5);
			
			//agregamos botones a la lamina
			add(boton1);
			add(boton2);
			add(boton3);
			add(boton4);
			add(boton5);
			
			//instancia de ActionListener
			gestionEvento mievento=new gestionEvento();
			boton1.addActionListener(mievento);
			boton2.addActionListener(mievento);
			boton3.addActionListener(mievento);
			boton4.addActionListener(mievento);
			boton5.addActionListener(mievento);
			
		}
	}
	
	private class gestionEvento implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			//metodo getSource() que busca el origen del evento es decir quien desencadena el evento
			//que seria el boton1
			if(e.getSource()==boton1) 
			{
				//si pulsamos boton1 el texto agregado se pondra pequeño
				texto.setFont(new Font("Serif",Font.PLAIN,10));
			}
			else 
			{
				if(e.getSource()==boton2) //si el desencadenante de evento es el boton2 hace esto
				{
					texto.setFont(new Font("Serif",Font.PLAIN,15));
				}
				else 
				{
					if(e.getSource()==boton3) 
					{
						texto.setFont(new Font("Serif",Font.PLAIN,20));
					}
					else 
					{
						if(e.getSource()==boton4) 
						{
							texto.setFont(new Font("Serif",Font.PLAIN,30));
						}
						else 
						{
							if(e.getSource()==boton5) 
							{
								texto.setFont(new Font("Serif",Font.PLAIN,12));
							}
						}
					}
				}
			}
		}
	}
	
	//variables de clase
	private JLabel texto;
	private JRadioButton boton1,boton2,boton3,boton4,boton5;
}