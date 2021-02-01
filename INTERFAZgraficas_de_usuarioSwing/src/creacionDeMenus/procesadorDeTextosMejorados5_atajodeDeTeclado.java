package creacionDeMenus;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;

public class procesadorDeTextosMejorados5_atajodeDeTeclado
{

	public static void main(String[] args)
	{
		marcoprocesador5 mimarco=new marcoprocesador5();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setBounds(600,200,400,250);
		mimarco.setVisible(true);		

	}

}


class marcoprocesador5 extends JFrame
{
	public marcoprocesador5() 
	{
		laminaprocesador5 milamina=new laminaprocesador5();
		add(milamina);
	}
}


class laminaprocesador5 extends JPanel
{
	public laminaprocesador5() 
	{
		setLayout(new BorderLayout());
		
		//creacion de la barra
		JMenuBar barra=new JMenuBar();
		
		//creamos los botones que van en el interior de la barra
		 fuente=new JMenu("fuente");
		 estilo=new JMenu("estilo");
		 tamaño=new JMenu("tamaño");
		
		//llamamos al metodo para el menu desplegable fuente
		 configuraMenu2("Arial","fuente","Arial",9,10,"");
		 configuraMenu2("Courier","fuente","Courier",9,10,"");
		 configuraMenu2("Verdana","fuente","Verdana",9,10,"");
		 //--------------------------------------------------------------------------------
		 
		 //creamos el menu desplegable para estilo negrita y cursica
		  configuraMenu2("negrita","estilo","",Font.BOLD,1,"src/creacionDeMenus/negrita.jpg");
		  configuraMenu2("cursiva","estilo","",Font.ITALIC,1,"src/creacionDeMenus/cursiva.jpg");
		 
		 //creamos un menuitems(desplegable)pero con checkbox
		/* JCheckBoxMenuItem negrita=new JCheckBoxMenuItem("negrita",new ImageIcon("src/creacionDeMenus/negrita.jpg"));
		 JCheckBoxMenuItem cursiva=new JCheckBoxMenuItem("cursiva",new ImageIcon("src/creacionDeMenus/cursiva.jpg"));
		 
		 negrita.addActionListener(new StyledEditorKit.BoldAction());
		 cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		 
		 estilo.add(negrita);//se agrega a la barra de menu estilo
		 estilo.add(cursiva);//se agrega a la barra de menu estilo*/
		 
		 
		 
		 
		 //-------------------------------------------------------------------------------------------
		 //creamos el menu desplegable para tamaño
		 
		/* configuraMenu2("12","tamaño","",9,12,"");
		 configuraMenu2("16","tamaño","",9,16,"");
		 configuraMenu2("20","tamaño","",9,20,"");
		 configuraMenu2("24","tamaño","",9,24,"");*/
		 
		 
		 //creamons menu de tamaño con radiobuton
		 ButtonGroup tamañogrupo=new ButtonGroup();
		 JRadioButtonMenuItem doce=new JRadioButtonMenuItem("12",false);
		 JRadioButtonMenuItem dieciseis=new JRadioButtonMenuItem("16",false);
		 JRadioButtonMenuItem veinte=new JRadioButtonMenuItem("20",false);
		 JRadioButtonMenuItem veinticuatro=new JRadioButtonMenuItem("24",false);
		 
		 
		 //---------------------------------------------------------------------------------
		 //atajo de teclado para que respondan al tamaño que queremos el texto depende de la tecla
		 //que pulsemos y lo pone como referencia en el menu 
		 //veinticuatro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		//-----------------------------------------------------------------------------------
		 
		 
		 
		 
		 //agregamos los jradiobutton a un solo grupo
		 tamañogrupo.add(doce);
		 tamañogrupo.add(dieciseis);
		 tamañogrupo.add(veinte);
		 tamañogrupo.add(veinticuatro);
		 
		 //ponemos a la escucha a losjradiobutton creados
		 doce.addActionListener(new StyledEditorKit.FontSizeAction("tam_letra",12));
		 dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("tam_letra",16));
		 veinte.addActionListener(new StyledEditorKit.FontSizeAction("tam_letra",20));
		 veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("tam_letra",24));
		 
		 tamaño.add(doce);
		 tamaño.add(dieciseis);
		 tamaño.add(veinte);
		 tamaño.add(veinticuatro);
//--------------------------------------------------------------------------------------------------
		//agregamos los botones a la barra
		barra.add(fuente);
		barra.add(estilo);
		barra.add(tamaño);
		
		add(barra,BorderLayout.NORTH);
		
		
		
		//creamos una sona en el centro del frame para el texto
		 area=new JTextPane();
		JScrollPane scrolLamina=new JScrollPane(area);
		add(scrolLamina,BorderLayout.CENTER);
		//-----------------------------------------------------------------
		//creamos un menu emergente para negrita y cursiva y hacemos que se desencadene el evento
		JPopupMenu emergente=new JPopupMenu();
		JMenuItem negritaE=new JMenuItem("negrita");
		JMenuItem cursivaE=new JMenuItem("cursica");
		
		
		//ponemos a la escucha a negrita y cursica para que desencadenen el evento
		 negritaE.addActionListener(new StyledEditorKit.BoldAction());
		 cursivaE.addActionListener(new StyledEditorKit.ItalicAction());
		emergente.add(negritaE);
		emergente.add(cursivaE);
		area.setComponentPopupMenu(emergente);
		
		
	}
	
	//metodo rotulo especifica el texto que va a tener negrita verdana tamaño,etc
	//menu especifica en que menu ir si es fuente estilo o tamaño
	//tipoletra se encarga de los elementos de tipo fuente especifica el tipo de letra verdana,ect
	//estilo de letra ya que se usa variable estatica en Font.bold(significa negrita y es de tipo entero)
	public void configuraMenu2(String rotulo,String menu,String tipoletra,int estilos,int tam,String icono)
	{
		//submenu desplegable
		JMenuItem elemento_menu=new JMenuItem(rotulo,new ImageIcon(icono));
		
		if(menu=="fuente") 
		{
			fuente.add(elemento_menu);
			
			if(tipoletra=="Arial") 
			{
				//con este metodo de la clase StyledEditorKit cambiamos el tipo de letra cambialetra lo exige
				//por argumnto pero carece de importancia solo es inportante el tipo de letra que le pasemos
				elemento_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambialetra", "Arial"));
			}
			else if(tipoletra=="Courier") 
			{
				elemento_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambialetra", "Courier"));
				
			}
			else if(tipoletra=="Verdana") 
			{
				elemento_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambialetra", "Verdana"));

			}
		}
		else 
		{
			if(menu=="estilo") 
			{
				estilo.add(elemento_menu);
				
				if(estilos==Font.BOLD) 
				{
					//ponemos atajo del teclado para para precionar una tecla y poner el texto
					//en negrita
					elemento_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
					
					//dentro del estilo modificamos con la clase StyledEditorKit el color negrita
					//y permite quitar y sacar color negrita
					elemento_menu.addActionListener(new StyledEditorKit.BoldAction());
				}
				//y si seleccionamos cursica entra en esta condicion que dentro esta la clase
				//que la convierte en cursiva se puede quitar y poner con esta clase el estilo
				else if(estilos==Font.ITALIC)
				{
					elemento_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));

					elemento_menu.addActionListener(new StyledEditorKit.ItalicAction());

				}
			}
		}
			/*else 
			{
				if(menu=="tamaño") 
				{
					tamaño.add(elemento_menu);
					//modifica el tamaño de texto seleccionado cambia_tamaño lo ponemos porque lo exige
					//por argumento pero carece de importancia StyleEditorKit clase que permite modificar
					//el texto depende de que pongamos despues del punto uno sirve para tamaño otro negrita,etc
					elemento_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño",tam));
				}
			}*/
	}
		
		
	
	
	
		
	
	
	
	
	
	//variables de clase
	private JTextPane area;
	private JMenu fuente,estilo,tamaño;
	private Font letras;
	
}

