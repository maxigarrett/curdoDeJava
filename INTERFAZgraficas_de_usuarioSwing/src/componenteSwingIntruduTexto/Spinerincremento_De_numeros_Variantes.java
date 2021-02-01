package componenteSwingIntruduTexto;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Spinerincremento_De_numeros_Variantes 
{

	public static void main(String[] args)
	{
		Marcoventata mimarco=new Marcoventata();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}



class Marcoventata extends JFrame
{
	public Marcoventata() 
	{
		setBounds(600,200,400,250);
		add(new laminalamina());
	}
}


class laminalamina extends JPanel
{
	public laminalamina() 
	{
									//por parametro le pasamos un metodo para decirle a los numeros de donde arrancar
									//donde empezar ,valor maximo a ir de cuanto en cuanto ir
		JSpinner control=new JSpinner(new SpinnerNumberModel(5,0,10,2));
		
		Dimension dimension=new Dimension(150,20);
		
		control.setPreferredSize(dimension);
		add(control);
	}
}