package componenteSwingIntruduTexto;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboBox_menudesplegable 
{

	public static void main(String[] args) 
	{
		MarcoBox mimarco=new MarcoBox();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

//marco
class MarcoBox extends JFrame
{
	public MarcoBox() 
	{
		setBounds(600,200,400,300);
		LaminaBox milamina=new LaminaBox();
		add(milamina);
	}
}



//lamina
class LaminaBox extends JPanel
{
	public LaminaBox()
	{
		setLayout(new BorderLayout());
		texto=new JLabel("munu desplegable...");
		texto.setFont(new Font("Serif",Font.PLAIN,14));
		add(texto,BorderLayout.CENTER);
		
		//agregamos segunda lamina
		LaminacomboBox lamina2=new LaminacomboBox();
		//le damos al comobox el lugar norte despues de agregarlo
		add(lamina2,BorderLayout.NORTH);
	}
	
	//segunda lamina
	private class LaminacomboBox extends JPanel
	{
		public LaminacomboBox()
		{
			//instanciamos unos de los contructore JComboBox
			//agregamos los items al menu desplegable que van a ser un tipo de letra
			//y se lo pasamos por parametro
			micombo=new JComboBox();
			
			//si la letra que se encuentra el usuario quiere buscarla digitabdo dentro del combo
			//lo hacemos con el metodo siguiente
			micombo.setEditable(true);
			
			micombo.addItem("Serif");
			micombo.addItem("SansSerirf");
			micombo.addItem("Monospaced");
			micombo.addItem("Dialog");
			//agregamos lamvariable objeto JComboBox a la lamina
			add(micombo);
			
			//creamos instacias de desencadentantes de eventos y lo ponemos a la escucha
			eventoCombo mievento=new eventoCombo();
			micombo.addActionListener(mievento);
		}
	}
	
	//clase interna ActionListener
	private class eventoCombo implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			//hacemos un casting (String)micombo.getSelectedItem() ya que micombo es un objet
			//y font pide por primer parametro un String
			texto.setFont(new Font((String)micombo.getSelectedItem(),Font.PLAIN,18));
		}
	}
	
	private JLabel texto;
	private JComboBox micombo;
}
