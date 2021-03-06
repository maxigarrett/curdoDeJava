package creacionDeMenus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;

public class procesadorDeTextooMejorado7_barraDeHerramientas3 
{

	public static void main(String[] args)
	{
		marcoprocesador7 mimarco=new marcoprocesador7();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setBounds(600,200,600,420);
		mimarco.setVisible(true);


	}

}


class marcoprocesador7 extends JFrame
{
	public marcoprocesador7() 
	{
		laminaprocesador7 milamina=new laminaprocesador7();
		add(milamina);
		
	}
}


class laminaprocesador7 extends JPanel
{
	public laminaprocesador7() 
	{
		setLayout(new BorderLayout());
		
		//creacion de la barra
		JMenuBar barra=new JMenuBar();
		
		//creamos los botones que van en el interior de la barra
		 fuente=new JMenu("fuente");
		 estilo=new JMenu("estilo");
		 tama�o=new JMenu("tama�o");
		
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
		 //creamos el menu desplegable para tama�o
		 
		/* configuraMenu2("12","tama�o","",9,12,"");
		 configuraMenu2("16","tama�o","",9,16,"");
		 configuraMenu2("20","tama�o","",9,20,"");
		 configuraMenu2("24","tama�o","",9,24,"");*/
		 
		 
		 //creamons menu de tama�o con radiobuton
		 ButtonGroup tama�ogrupo=new ButtonGroup();
		 JRadioButtonMenuItem doce=new JRadioButtonMenuItem("12",false);
		 JRadioButtonMenuItem dieciseis=new JRadioButtonMenuItem("16",false);
		 JRadioButtonMenuItem veinte=new JRadioButtonMenuItem("20",false);
		 JRadioButtonMenuItem veinticuatro=new JRadioButtonMenuItem("24",false);
		 
		 
		 //---------------------------------------------------------------------------------
		 //atajo de teclado para que respondan al tama�o que queremos el texto depende de la tecla
		 //que pulsemos y lo pone como referencia en el menu 
		 //veinticuatro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		//-----------------------------------------------------------------------------------
		 
		 
		 
		 
		 //agregamos los jradiobutton a un solo grupo
		 tama�ogrupo.add(doce);
		 tama�ogrupo.add(dieciseis);
		 tama�ogrupo.add(veinte);
		 tama�ogrupo.add(veinticuatro);
		 
		 //ponemos a la escucha a losjradiobutton creados
		 doce.addActionListener(new StyledEditorKit.FontSizeAction("tam_letra",12));
		 dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("tam_letra",16));
		 veinte.addActionListener(new StyledEditorKit.FontSizeAction("tam_letra",20));
		 veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("tam_letra",24));
		 
		 tama�o.add(doce);
		 tama�o.add(dieciseis);
		 tama�o.add(veinte);
		 tama�o.add(veinticuatro);
//--------------------------------------------------------------------------------------------------
		//agregamos los botones a la barra
		barra.add(fuente);
		barra.add(estilo);
		barra.add(tama�o);
		
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
		//-----------------------------------------------------------------------------------
		
		//construimos barra de herramientas para cursiva y negrita y cambiar de color las letras
		/*JToolBar mibarra=new JToolBar();
		JButton negritabarra=new JButton(new ImageIcon("src/creacionDeMenus/negrita.jpg"));
		JButton cursivabarra=new JButton(new ImageIcon("src/creacionDeMenus/cursiva.jpg"));
		JButton subrrayado=new JButton(new ImageIcon("src/creacionDeMenus/subrrayado.png"));
		//creamos botones para los colores
		JButton azulbarra=new JButton(new ImageIcon("src/graficos/bolaazul.JPG"));
		JButton rojobarra=new JButton(new ImageIcon("src/graficos/bolarojo.JPG"));
		JButton amarillobarra=new JButton(new ImageIcon("src/graficos/bolaamarillo.JPG"));
		
		//botones para la alineacion de los botones
		JButton a_derecha=new JButton(new ImageIcon("src/creacionDeMenus/derecha.png"));
		JButton a_izquierda=new JButton(new ImageIcon("src/creacionDeMenus/izquierda.jpg"));
		JButton a_justificado=new JButton(new ImageIcon("src/creacionDeMenus/justificado.png"));
		JButton a_centrado=new JButton(new ImageIcon("src/creacionDeMenus/centrado.png"));
		
		//ponemos a la escucha los botones creados a negritabarra y cursiva barra
			negritabarra.addActionListener(new StyledEditorKit.BoldAction());
			cursivabarra.addActionListener(new StyledEditorKit.ItalicAction());
			subrrayado.addActionListener(new StyledEditorKit.UnderlineAction());//para subrrallar letra
				
		//los ponemos a la escucha para poner los colores  a las letras el primer parametro es obligatorio
		//porque lo exige pero lo que importa es el colo que le pasemos por parametro
		azulbarra.addActionListener(new StyledEditorKit.ForegroundAction("colorazul", Color.BLUE));
		rojobarra.addActionListener(new StyledEditorKit.ForegroundAction("colorrojo", Color.RED));
		amarillobarra.addActionListener(new StyledEditorKit.ForegroundAction("coloramarillo", Color.YELLOW));
		
		//ponemos a las alineaciones de el parrafo creado a la escucha
		a_derecha.addActionListener(new StyledEditorKit.AlignmentAction("derecha", 2));
		a_izquierda.addActionListener(new StyledEditorKit.AlignmentAction("izquierda", 0));
		a_justificado.addActionListener(new StyledEditorKit.AlignmentAction("justificado", 3));
		a_centrado.addActionListener(new StyledEditorKit.AlignmentAction("centrado", 1));
		//agregamos el boton a la barra de herramientas  creada
		mibarra.add(negritabarra);
		mibarra.add(cursivabarra);
		mibarra.add(subrrayado);
		mibarra.add(azulbarra);
		mibarra.add(rojobarra);
		mibarra.add(amarillobarra);
		mibarra.add(a_izquierda);
		mibarra.add(a_derecha);
		mibarra.add(a_justificado);
		mibarra.add(a_centrado);*/
		
		mibarra=new JToolBar();
		
		configurabarra("src/creacionDeMenus/negrita.jpg").addActionListener(new StyledEditorKit.BoldAction());
		configurabarra("src/creacionDeMenus/cursiva.jpg").addActionListener(new StyledEditorKit.ItalicAction());
		configurabarra("src/creacionDeMenus/subrrayado.png").addActionListener(new StyledEditorKit.UnderlineAction());
		mibarra.addSeparator();
		configurabarra("src/graficos/bolaazul.JPG").addActionListener(new StyledEditorKit.ForegroundAction("colorazul", Color.BLUE));
		configurabarra("src/graficos/bolarojo.JPG").addActionListener(new StyledEditorKit.ForegroundAction("colorazul", Color.red));
		configurabarra("src/graficos/bolaamarillo.JPG").addActionListener(new StyledEditorKit.ForegroundAction("colorazul", Color.YELLOW));
		mibarra.addSeparator();
		configurabarra("src/creacionDeMenus/izquierda.jpg").addActionListener(new StyledEditorKit.AlignmentAction("derecha", 0));
		configurabarra("src/creacionDeMenus/centrado.png").addActionListener(new StyledEditorKit.AlignmentAction("derecha", 1));
		configurabarra("src/creacionDeMenus/derecha.png").addActionListener(new StyledEditorKit.AlignmentAction("derecha", 2));
		configurabarra("src/creacionDeMenus/justificado.png").addActionListener(new StyledEditorKit.AlignmentAction("derecha", 3));
		
		//como por defecto los iconos o elementos de la barra aparecen un al lado del otro y si mas
		//ponemos menos area de texto queda por eso llamos un metodo para poner los iconos de forma
		//vertical pasandole por parametro el num 1 ya que el 0 significa que van horizontal
		mibarra.setOrientation(1);
		
		//agregamos la barra a la lamina
		add(mibarra,BorderLayout.WEST);
		
		
	}
	
	//creamos barra de herramientas con un metodo parta simplificar codigo
	//le queremos pasar las rutas de las imagenes por eso como argumento ponemos un String
	//como el metodo es public JButton este metodo crea un boton y hay que programarlo con su retutrn
	public JButton configurabarra(String ruta) 
	{
		JButton boton=new JButton(new ImageIcon(ruta));
		
		mibarra.add(boton);//agregamos el boton a la barra llamada mibarra cada vez que instanciemos
		
		return boton;//lo devuelve al objeto de tipo JButton con el objetivo de ponerlo a la escucha
					//con addActionListener
	}
	
	//metodo rotulo especifica el texto que va a tener negrita verdana tama�o,etc
	//menu especifica en que menu ir si es fuente estilo o tama�o
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
				if(menu=="tama�o") 
				{
					tama�o.add(elemento_menu);
					//modifica el tama�o de texto seleccionado cambia_tama�o lo ponemos porque lo exige
					//por argumento pero carece de importancia StyleEditorKit clase que permite modificar
					//el texto depende de que pongamos despues del punto uno sirve para tama�o otro negrita,etc
					elemento_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tama�o",tam));
				}
			}*/
	}
		
		
	
	
	
		
	
	
	
	
	
	//variables de clase
	private JTextPane area;
	private JMenu fuente,estilo,tama�o;
	private Font letras;
	private JButton negritabarra,cursivabarra,subrrayado,azulbarra,rojobarra,amariyobarra,a_izquierda,
	a_centrado,a_derecha,a_justificado;
	private JToolBar mibarra;
}