package creacionDeMenus;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class MenusEmergentes_jpopup
{

	public static void main(String[] args) 
	{
		MarcoEmergente mimarco=new MarcoEmergente();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}


class MarcoEmergente extends JFrame
{
	public MarcoEmergente() 
	{
		setBounds(600,200,400,250);
		add(new LaminaEmergente());
	}
}


class LaminaEmergente extends JPanel
{
	public LaminaEmergente() 
	{
		
		
		//instanciamos la clase JPopupMenu
		JPopupMenu emergente=new JPopupMenu();
		
		//instanciamos un objeto de tipo JMenuItem
		JMenuItem opcion1=new JMenuItem("opcion 1");
		JMenuItem opcion2=new JMenuItem("opcion 2");
		JMenuItem opcion3=new JMenuItem("opcion 3");
		
		//agregamos el JMenuItem  al menu emergente
		emergente.add(opcion1);
		emergente.add(opcion2);
		emergente.add(opcion3);
		
		//metodo hace aparecer las opciones emergentes en la lamina
		setComponentPopupMenu(emergente);
	}
}