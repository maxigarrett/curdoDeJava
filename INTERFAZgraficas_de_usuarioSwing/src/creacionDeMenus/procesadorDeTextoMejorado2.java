package creacionDeMenus;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;



public class procesadorDeTextoMejorado2 
{

	public static void main(String[] args) 
	{

		marcoprocesador3 mimarco=new marcoprocesador3();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setBounds(600,200,400,250);
		mimarco.setVisible(true);

	}

}



class marcoprocesador3 extends JFrame
{
	public marcoprocesador3() 
	{
		laminaprocesador3 milamina=new laminaprocesador3();
		add(milamina);
	}
}


class laminaprocesador3 extends JPanel
{
	public laminaprocesador3() 
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
		 
		 //creamos el menu desplegable para estilo
		 configuraMenu2("negrita","estilo","",Font.BOLD,1,"src/creacionDeMenus/negrita.jpg");
		 configuraMenu2("cursiva","estilo","",Font.ITALIC,1,"");
		 
		 //creamos el menu desplegable para tamaño
		 
		 configuraMenu2("12","tamaño","",9,12,"");
		 configuraMenu2("16","tamaño","",9,16,"");
		 configuraMenu2("20","tamaño","",9,20,"");
		 configuraMenu2("24","tamaño","",9,24,"");

		 

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
					//dentro del estilo modificamos con la clase StyledEditorKit el color negrita
					elemento_menu.addActionListener(new StyledEditorKit.BoldAction());
				}
				//y si seleccionamos cursica entra en esta condicion que dentro esta la clase
				//que la convierte en cursiva se puede quitar y poner con esta clase el estilo
				else if(estilos==Font.ITALIC)
				{
					elemento_menu.addActionListener(new StyledEditorKit.ItalicAction());

				}
			}
			else 
			{
				if(menu=="tamaño") 
				{
					tamaño.add(elemento_menu);
					//modifica el tamaño de texto seleccionado cambia_tamaño lo ponemos porque lo exige
					//por argumento pero carece de importancia StyleEditorKit clase que permite modificar
					//el texto depende de que pongamos despues del punto uno sirve para tamaño otro negrita,etc
					elemento_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño",tam));
				}
			}
		}
		
		
	}
	
	
		
	
	
	
	
	
	//variables de clase
	private JTextPane area;
	private JMenu fuente,estilo,tamaño;
	private Font letras;
	
}


