package componenteSwingIntruduTexto;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;



public class spiner4_conClaseInternaAnonima 
{

	public static void main(String[] args)
	{
		Marcoventana2 mimarco=new Marcoventana2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}




//marco
class Marcoventana2 extends JFrame
{
	public Marcoventana2() 
	{
		setBounds(600,200,400,250);
		add(new laminalaminn());
	}
}

//lamina
class laminalaminn extends JPanel
{
	public laminalaminn() 
	{
		//clase interna anonima ya que en ves de crear una clase le pasamos por parametro
		//la clase que ibamos a instancias con sus metodos para modificar las teclas para
		//incrementar o decrementar los numeros
		JSpinner control=new JSpinner(new SpinnerNumberModel(5,0,10,1)) 
		{
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
		};
		
		Dimension dimension=new Dimension(150,20);
		
		control.setPreferredSize(dimension);
		add(control);
	}
	
	//clase interna
	/*private class mimodelo1 extends SpinnerNumberModel
	{
		public mimodelo1()
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
		
	}*/
}