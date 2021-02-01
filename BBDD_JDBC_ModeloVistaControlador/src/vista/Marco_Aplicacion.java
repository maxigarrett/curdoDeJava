package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controlador.ControladorBotonEjecuta;
import controlador.controladorCargaSeccionesYPaises;


public class Marco_Aplicacion extends JFrame
{
	
	private static final long serialVersionUID = 1L;
	public Marco_Aplicacion() 
	{
		
		//titulo
		setTitle("consulta BBDD");
				
		//ubicacion y tamaño
		setBounds(800,150,400,400);
			
		//disposicion
		setLayout(new BorderLayout());
				
		//LAMINA
		JPanel menu=new JPanel();
		menu.setLayout(new FlowLayout());
				
		//intanciamos JComboBox
		secciones=new JComboBox();
				
		//para que no se pueda editar el combobox
		secciones.setEditable(false);
		secciones.addItem("todos");
				
		//intancia JComboBox
		paises=new JComboBox();
		paises.setEditable(false);
		paises.addItem("todos");
				
		//instancia JTextArea
		resultado=new JTextArea();
		deslizante=new JScrollPane(resultado);
		resultado.setEditable(false);//para que no se pueda escribir
				
		//agregamos a la lamina el JTextArea
		add(deslizante);
				
		//agregamos a la lamina los JComboBox
		menu.add(secciones);
		menu.add(paises);
		add(menu,BorderLayout.NORTH);
		add(deslizante,BorderLayout.CENTER);//ponemos el JTextArea al centro
				
		//creamos un boton
		JButton botonConsulta=new JButton("Consulta");
		add(botonConsulta,BorderLayout.SOUTH);
		botonConsulta.addActionListener(new ControladorBotonEjecuta(this));
		
		addWindowListener(new controladorCargaSeccionesYPaises(this));
		
		
	}
	private Connection miConexion;
	public JComboBox secciones;//para que podamos acceder a este campo desde otro paquete en este caso controlador
	public JComboBox paises;
	public JTextArea resultado;
	public JScrollPane deslizante;
}
