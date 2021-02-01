package exportablerecursosejecutable;

import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class ejemplo
{

	public static void main(String[] args) 
	{
		marco mimarco=new marco();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setBounds(600, 200, 400, 400);
		mimarco.setVisible(true);

	}

}


class marco extends JFrame
{
	private static final long serialVersionUID = 1L;

	public marco() 
	{
		add(new lamina());
	}
}

class lamina extends JPanel
{
	private static final long serialVersionUID = 1L;

	public lamina() 
	{
		setLayout(new BorderLayout());
		
		area=new JTextPane();
		
		add(new JScrollPane(area),BorderLayout.CENTER);
		
		
		//es para que cuando hacemos el ejecutable los recursos externos como la imagen se 
		//puedan ver con el metodo getResource y por parametro la ruta
		URL boton1=lamina.class.getResource("bolaamarillo.jpg");
		
		JButton boton=new JButton("dale",new ImageIcon(boton1));
		
		add(boton,BorderLayout.SOUTH);
		
	}
	
	private JTextPane area;
}