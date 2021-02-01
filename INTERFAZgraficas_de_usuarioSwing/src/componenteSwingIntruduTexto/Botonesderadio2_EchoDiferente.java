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

public class Botonesderadio2_EchoDiferente
{

	public static void main(String[] args) 
	{
		Marco2 mimarco=new Marco2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}


class Marco2 extends JFrame
{
	public Marco2()
	{
		setBounds(600,200,450,300);
		//instancia de lamina
		Lamina milamina=new Lamina();
		add(milamina);
	}
}




//lamina
class Lamina extends JPanel
{
	public Lamina() 
	{
		setLayout(new BorderLayout());
		texto=new JLabel("hola a todos....",JLabel.CENTER);
		texto.setFont(new Font("Serif",Font.PLAIN,12));
		add(texto,BorderLayout.CENTER);
		
		
		
		Laamina lamina=new Laamina();
		migrupo=new ButtonGroup();//instanciamos el grupo pero el boton esta agregado en la lamina secundaria
		lamina.colocar_botones("pequeño", false, 10);
		lamina.colocar_botones("mediano", true, 15);
		lamina.colocar_botones("grande", false, 19);
		lamina.colocar_botones("muy grande",false, 26);
		lamina.colocar_botones("estandar", false, 12);



		add(lamina,BorderLayout.SOUTH);
		
	}
	
	
	//segunda clase interna
	private class Laamina extends JPanel
	{
		
	
		//creamos metodo para poner botones de radio
		public void colocar_botones(String nombre,boolean seleccionado,int tamaño) 
		{
			//instanciamos boton de radio
			 boton=new JRadioButton(nombre,seleccionado);
			migrupo.add(boton);
			add(boton);
		
			//intanciamos la interfaz ActionListener
			ActionListener mievento=new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					texto.setFont(new Font("Serif",Font.PLAIN,tamaño));
				}
			};
			boton.addActionListener(mievento);
		}
	
	}
	//variables de clase
	private JLabel texto;
	private ButtonGroup migrupo;
	private JRadioButton boton;
}
