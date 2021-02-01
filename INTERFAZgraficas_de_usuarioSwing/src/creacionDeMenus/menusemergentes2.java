package creacionDeMenus;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;

public class menusemergentes2
{

	public static void main(String[] args) 
	{
		MarcoEmergente1 mimarco=new MarcoEmergente1();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);


	}

}


class MarcoEmergente1 extends JFrame
{
	public MarcoEmergente1() 
	{
		setBounds(600,200,400,250);
		add(new LaminaEmergente1());
	}
}


class LaminaEmergente1 extends JPanel
{
	public LaminaEmergente1() 
	{
		setLayout(new BorderLayout());
		
		//creamos una lamina dentro de de la misma lamina ya creada
		JPanel lamina=new JPanel();
		
		//creamos la barra de menu
		JMenuBar mibarra=new JMenuBar();
		
		//creamos los elemenos que ban a ir en la barra de menu
		JMenu fuente=new JMenu("fuente");
		JMenu estilo=new JMenu("estilo");
		JMenu tamaño=new JMenu("tamaño");
		mibarra.add(fuente);
		mibarra.add(estilo);
		mibarra.add(tamaño);
		lamina.add(mibarra);//agregamos la barra a la segunda lamina creada
		
		add(lamina,BorderLayout.NORTH);//le damos disposicion a la lamina al norte donde va la barra
		
		//creamos un area de texto en la lamina principal creada que seria laminaemergente
		JTextPane miarea=new JTextPane();
		add(miarea,BorderLayout.CENTER);
		//-------------------------------------------------------------------------------------
		
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
		//si no ponemos delante mi area las opciones no saldran ya que esta esperando que hagamos
		//clic en la lamina pero esta por encima un JTextPane llamado miarea por eso hay que especificar
		//lo que esta por encima de la lamina
		miarea.setComponentPopupMenu(emergente);
	}
}