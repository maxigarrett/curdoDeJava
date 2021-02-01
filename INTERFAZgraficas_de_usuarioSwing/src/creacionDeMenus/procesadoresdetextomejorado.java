package creacionDeMenus;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;



public class procesadoresdetextomejorado 
{

	public static void main(String[] args)
	{
		marcoprocesador2 mimarco=new marcoprocesador2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setBounds(600,200,400,250);
		mimarco.setVisible(true);

	}

}


class marcoprocesador2 extends JFrame
{
	public marcoprocesador2() 
	{
		laminaprocesador2 milamina=new laminaprocesador2();
		add(milamina);
	}
}


class laminaprocesador2 extends JPanel
{
	public laminaprocesador2() 
	{
		setLayout(new BorderLayout());
		
		//creacion de la barra
		JMenuBar barra=new JMenuBar();
		
		//creamos los botones que van en el interior de la barra
		 fuente=new JMenu("fuente");
		 estilo=new JMenu("estilo");
		 tamaño=new JMenu("tamaño");
		
		//llamamos al metodo para el menu desplegable fuente
		 configuraMenu("Arial","fuente","Arial",9,10);
		 configuraMenu("courier","fuente","Courier",9,10);
		 configuraMenu("verdana","fuente","Verdana",9,10);
		 
		 //creamos el menu desplegable para estilo
		 configuraMenu("negrita","estilo","",Font.BOLD,1);
		 configuraMenu("cursiva","estilo","",Font.ITALIC,1);
		 
		 //creamos el menu desplegable para tamaño
		 
		 configuraMenu("12","tamaño","",9,12);
		 configuraMenu("16","tamaño","",9,16);
		 configuraMenu("20","tamaño","",9,20);
		 configuraMenu("24","tamaño","",9,24);

		 

		//agregamos los botones a la barra
		barra.add(fuente);
		barra.add(estilo);
		barra.add(tamaño);
		
		add(barra,BorderLayout.NORTH);
		
		
		
		//creamos una sona en el centro del frame para el texto
		 area=new JTextPane();
		JScrollPane scrolLamina=new JScrollPane(area);
		add(scrolLamina,BorderLayout.CENTER);
		
		
		
	}
	
	//metodo rotulo especifica el texto que va a tener negrita verdana tamaño,etc
	//menu especifica en que menu ir si es fuente estilo o tamaño
	//tipoletra se encarga de los elementos de tipo fuente especifica el tipo de letra verdana,ect
	//estilo de letra ya que se usa variable estatica en Font.bold(significa negrita y es de tipo entero)
	public void configuraMenu(String rotulo,String menu,String tipoletra,int estilos,int tam)
	{
		//submenu desplegable
		JMenuItem elemento_menu=new JMenuItem(rotulo);
		
		if(menu=="fuente") 
		{
			fuente.add(elemento_menu);
		}
		else 
		{
			if(menu=="estilo") 
			{
				estilo.add(elemento_menu);
			}
			else 
			{
				if(menu=="tamaño") 
				{
					tamaño.add(elemento_menu);
				}
			}
		}
		
		elemento_menu.addActionListener(new gestiona_evento(rotulo,tipoletra,estilos,tam));
	}
	
	//clase interna
	class gestiona_evento implements ActionListener
	{
		String tipo_texto,menu;
		int estilo_letra,tamaño_letra;
		
		public gestiona_evento(String elemento,String texto2,int estilo2,int tamletra) 
		{
			tipo_texto=texto2;
			estilo_letra=estilo2;
			tamaño_letra=tamletra;
			menu=elemento;
		}
		public void actionPerformed(ActionEvent e) 
		{
			//almacenamos en la variable letras de tipo font el tipo de letra tamaño estilo
			letras=area.getFont();
			
			//evaluamos en que menu ah precionado y que cambie solo el menu seleccionado
			//lo demas que mantenga como lo dejamos en caso de no seleccionar nada mas que
			//el tipo de letra
			if(menu=="Arial" || menu=="courier" || menu=="verdana") 
			{
				//guarda estilo_letras y el tamaño y solo modifica el tipo de letra
				estilo_letra=letras.getStyle();
				
				tamaño_letra=letras.getSize();
			}
			
			else if(menu=="cursiva" || menu=="negrita") //menu estilo
			{
				//para que se pueda poner tanto negrita y cursiva
				if(letras.getStyle()==1 || letras.getStyle()==2) 
				{
					estilo_letra=3;
					
				}
				//si hacemos clic en menu donde se encuentra cursiva y negrita modificara
				//solo eso y guardara lo que habia anteriormente seleccionado tipo_texto
				//tamaño_letra
				tipo_texto=letras.getFontName();
				
				tamaño_letra=letras.getSize();
			}
			else if(menu=="12" || menu=="16" || menu=="20" || menu=="24") 
			{
				tipo_texto=letras.getFontName();
				
				estilo_letra=letras.getStyle();
			}
			
			area.setFont(new Font(tipo_texto,estilo_letra,tamaño_letra));
			
			
			
		}
		
		
	}
	
	
	
	
	//variables de clase
	private JTextPane area;
	private JMenu fuente,estilo,tamaño;
	private Font letras;
	
}


