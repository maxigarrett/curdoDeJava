package creacionDeMenus;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class menuDeslegable {

	public static void main(String[] args) 
	{
		marco mimarco=new marco();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}


class marco extends JFrame
{
	public marco() 
	{
		setBounds(600,200,400,250);
		add(new lamina());
	}
}

class lamina extends JPanel
{
	public lamina() 
	{
		//crear barra de menu instaciando la clase JMenuBar
		JMenuBar menu=new JMenuBar();
		
		//creacion de de items o elementos de la barra creada 
		JMenu mimenu=new JMenu("archivo");
		JMenu mimenu2=new JMenu("herramientas");
		JMenu mimenu3=new JMenu("edicion");
		JMenu opcion=new JMenu("opcion");
		//agregamos los elementos creados a la barra creada
		menu.add(mimenu3);
		menu.add(mimenu2);
		menu.add(mimenu);
		
		//creamos un menu desplegable para edicion que es mimenu3
		JMenuItem copiar=new JMenuItem("copiar");
		JMenuItem pegar=new JMenuItem("pegar");
		JMenuItem cortar=new JMenuItem("cortar");
		
		
		//agregamos un submenu a archivo
		JMenuItem guardar=new JMenuItem("guardar");
		JMenuItem guardar_como=new JMenuItem("guardar como");
		
		//agregamos menu desplegable a herramientas
		JMenuItem aumentar=new JMenuItem("aumentar");
		JMenuItem achicar=new JMenuItem("achicar");
		mimenu2.add(aumentar);
		mimenu2.add(achicar);


		
		
		
		//agregamos un sub menu al menu desplegable 
		JMenuItem opcion1=new JMenuItem("opcion 1");
		JMenuItem opcion2=new JMenuItem("opcion 2");
		opcion.add(opcion1);
		opcion.add(opcion2);
		
		
		

		
		
		
		//lo agrgamos a elemento del menu archivos que es mimenu
		mimenu.add(guardar);
		mimenu.add(guardar_como);
		


		//agregamos el sub menu desplegable al elemento o item ya creado que querramos
		mimenu3.add(copiar);
		mimenu3.add(pegar);
		mimenu3.add(cortar);
		mimenu3.addSeparator();//separa los items similares con otro que no tenga nada que ver
		mimenu3.add(opcion);

		
		//agregamos la barra a la lamina
		add(menu);
		
		
	}
}
