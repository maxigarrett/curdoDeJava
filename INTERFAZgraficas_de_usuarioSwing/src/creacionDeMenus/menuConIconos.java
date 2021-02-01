package creacionDeMenus;

import java.awt.BorderLayout;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

public class menuConIconos {

	public static void main(String[] args) 
	{
		marcoicono mimarco=new marcoicono();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}


class marcoicono extends JFrame
{
	public marcoicono()
	{
		setBounds(600,200,400,250);
		laminaicono milamina=new laminaicono();
		add(milamina);
	}
}


class laminaicono extends JPanel
{
	public laminaicono() 
	{
		setLayout(new BorderLayout());
		
	
		
		//instanciamos el constructor imageicon y creamos un objeto con su ruta especificada donde esta
		//la imagene y agregamos el objeto en JMenuItem en cortar
		//es mas facil instanciarlo dentro por parametros 
		ImageIcon miimagen=new ImageIcon("src/creacionDeMenus/cortar.gif");
		
		//creamos la barra de menu para colocar el menu
		JMenuBar barra=new JMenuBar();
		
		//colocamos el menu en la barra
		JMenu archivo=new JMenu("archivo");
		JMenu herramientas=new JMenu("herramientas");
		JMenu edicion=new JMenu("edicion");
		JMenu opcion=new JMenu("opcion");
		
		//agregamos los elementos a la barra de menu
		barra.add(archivo);
		barra.add(herramientas);
		barra.add(edicion);
		
		
		//creamos menu desplegable para archivo
		JMenuItem guardar=new JMenuItem("guardar");
		JMenuItem guardar_como=new JMenuItem("guardar como");
		archivo.add(guardar);
		archivo.add(guardar_como);
		
		//agregamos menu desplegable a herramientas
		JMenuItem aumentar=new JMenuItem("aumentar");
		JMenuItem achicar=new JMenuItem("achicar");
		herramientas.add(aumentar);
		herramientas.add(achicar);
		
		//creamos menu desplegable para edicion
		JMenuItem copiar=new JMenuItem("copiar",new ImageIcon("src/creacionDeMenus/copiar.gif"));
		JMenuItem pegar=new JMenuItem("pegar", new ImageIcon("src/creacionDeMenus/pegar.gif"));
		JMenuItem cortar=new JMenuItem("cortar",miimagen);
		cortar.setHorizontalTextPosition(SwingConstants.LEFT);//hacemos aparecer la imagen del otro lado
		copiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));//aparece la sugerencia en el menu
		edicion.add(copiar);
		edicion.add(pegar);
		edicion.add(cortar);
		edicion.addSeparator();
		edicion.add(opcion);
		
		//sub menu desplegable para opcion
		JMenuItem opcion1=new JMenuItem("opcion1");
		JMenuItem opcion2=new JMenuItem("opcion2");
		opcion.add(opcion1);
		opcion.add(opcion2);
		
		
		
	//agregamos la barra a la lamina
		add(barra,BorderLayout.NORTH);
		
	}
}