package componenteSwingIntruduTexto;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class spinner3_modificacion
{

	public static void main(String[] args)
	{
		Marcoventana mimarco=new Marcoventana();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}



//marco
class Marcoventana extends JFrame
{
	public Marcoventana() 
	{
		setBounds(600,200,400,250);
		add(new laminalamin());
	}
}

//lamina
class laminalamin extends JPanel
{
	public laminalamin() 
	{
										//le pasamos por parametros lo que hace la clase interna
		JSpinner control=new JSpinner(new mimodelo());
		
		Dimension dimension=new Dimension(150,20);
		
		control.setPreferredSize(dimension);
		add(control);
	}
	
	//clase interna
	private class mimodelo extends SpinnerNumberModel
	{
		public mimodelo()
		{
			//llama al constructor de la clase padre que seria SpinnerNumberModel 
			super(5,0,10,1);
				
		}
		
		//sobreescribir y este metodo da por defecto el numero siguiente
		public Object getNextValue() 
		{
			//le decimos lo que tiene que devolver es el numero anterior o previo
			//entonces el metodo en ves de devolver el numero siguiente dara el anteriror
			//llamamos con super un metodo de la clase padre 
			return super.getPreviousValue();
		}
		
		//metodo que devuelve numero anterior
		public Object getPreviousValue() 
		{
			//con este metodo le decimos que haga lo contrario del metodo es decir numsiguiente
			return super.getNextValue();
		}
		
	}
}