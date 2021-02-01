package disposicionesavanzadas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class disposicionesLibres 
{

	public static void main(String[] args)
	{
		marcolibre mimarco=new marcolibre();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

class marcolibre extends JFrame
{
	public marcolibre() 
	{
		setBounds(600,200,400,250);
		add(new laminalibre());
	}
} 


class laminalibre extends JPanel
{
	public laminalibre() 
	{
		setLayout(null);
		JButton boton1=new JButton("boton");
		boton1.setBounds(50, 50, 150, 50);
		add(boton1);
	}
}