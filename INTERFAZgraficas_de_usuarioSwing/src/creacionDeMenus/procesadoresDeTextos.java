package creacionDeMenus;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class procesadoresDeTextos {

	public static void main(String[] args)
	{
		marcoprocesador mimarco=new marcoprocesador();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setBounds(600,200,400,250);
		mimarco.setVisible(true);

	}

}



class marcoprocesador extends JFrame
{
	public marcoprocesador() 
	{
		laminaprocesador milamina=new laminaprocesador();
		add(milamina);
	}
}


class laminaprocesador extends JPanel
{
	public laminaprocesador() 
	{
		setLayout(new BorderLayout());
		
		//creacion de la barra
		JMenuBar menu=new JMenuBar();
		
		//creamos los botones que van en el interior de la barra
		JMenu fuente=new JMenu("fuente");
		JMenu estilo=new JMenu("estilo");
		JMenu tamaño=new JMenu("tamaño");
		
		
		//creamos menu desplegable para tamaño
		JMenuItem tam12=new JMenuItem("12");
		JMenuItem tam18=new JMenuItem("18");
		JMenuItem tam24=new JMenuItem("24");
		
		tamaño.add(tam12);
		tamaño.add(tam18);
		tamaño.add(tam24);
		
		//menu desplegable y lo insertamos en fuente
		JMenuItem arial=new JMenuItem("arial");
		JMenuItem courier=new JMenuItem("courier");
		JMenuItem verdana =new JMenuItem("verdana");
		
		fuente.add(arial);
		fuente.add(courier);
		fuente.add(verdana);
		
		
		//menu desplegable para estilo
		JMenuItem negrita=new JMenuItem("negrita");
		JMenuItem cursiva=new JMenuItem("cursiva");
		
		estilo.add(negrita);
		estilo.add(cursiva);

		//agregamos los botones a la barra
		
		menu.add(fuente);
		menu.add(estilo);
		menu.add(tamaño);
		
		add(menu,BorderLayout.NORTH);
		
		
		
		//creamos una sona en el centro del frame para el texto
		 area=new JTextPane();
		JScrollPane scrolLamina=new JScrollPane(area);
		add(scrolLamina,BorderLayout.CENTER);
		
		//instanciamos clase oyente y lo ponemos a courier a la escucha
		oyente boton=new oyente();
		courier.addActionListener(boton);
		
		//clase interna anonima es lo mismo que crear una clase privada interna nueva
		//con actionlistener solo que todo se lo pasamos por parametros 
		arial.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				area.setFont(new Font("Arial",Font.PLAIN,12));
			}
		});
		
		//otra clase interna anonima
		verdana.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				area.setFont(new Font("verdana",Font.PLAIN,12));
			}
		});
		
	}
	
	//clase interna que gestiona el evento desencadenante
	private class oyente implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			area.setFont(new Font("courier",Font.PLAIN,12));
		}
	} 
	
	//variables de clase
	private JTextPane area;
}


