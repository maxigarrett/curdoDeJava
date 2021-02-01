package disposicionesavanzadas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class disposicionesLibres2 
{

	public static void main(String[] args) 
	{
		Marcolibre2 mimarco=new Marcolibre2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setBounds(800, 300, 400, 300);
		mimarco.setVisible(true);
		

	}

}


class Marcolibre2 extends JFrame
{
	public Marcolibre2() 
	{
		add(new Laminalibre2());
	}
}

class Laminalibre2 extends JPanel
{
	public Laminalibre2()
	{
		setLayout(null);
		JLabel nombre =new JLabel("nombre:");
		JLabel apellido =new JLabel("apellido:");
		
		JTextField texto1=new JTextField();
		JTextField texto2=new JTextField();
		
		nombre.setBounds(20, 20,80, 10);
		texto1.setBounds(100, 19, 110, 20);
		
		apellido.setBounds(20, 40,80, 15);
		texto2.setBounds(100, 39, 110, 20);
		add(nombre);
		add(apellido);
		add(texto1);
		add(texto2);
		
		
	}
}