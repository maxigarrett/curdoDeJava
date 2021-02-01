package componenteSwingIntruduTexto;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

public class spinerBotonesParaIncrementarYDecrementar
{

	public static void main(String[] args) 
	{
		MarcoSpiner mimarco=new MarcoSpiner();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}

class MarcoSpiner extends JFrame
{
	public MarcoSpiner() 
	{
		setBounds(600,200,400,250);
		
		//instancia de lamina
		LaminaSpiner milamina=new LaminaSpiner();
		add(milamina);
	}
}

//lamina

class LaminaSpiner extends JPanel
{
	public LaminaSpiner() 
	{
		//String lista[]= {"enero","febrero","marzo","abril"};
		
		
		//almacenamos en el arrays lista todas las fuentes o tipos de letras que tiene el sistema
		String lista[]=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		JSpinner control=new JSpinner(new SpinnerListModel(lista));//new SpinnerDateModel());
		
		
		//para dimensionar el cuadro de texto y entre los nombre o numeros
		Dimension dimension=new Dimension(130,20);
		//metodo para agregar las dimensiones al JSpinner
		control.setPreferredSize(dimension);
		add(control);
	}
}
