package ejersicioCombinandoTodo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class marcoDialogo extends JFrame
{
	public marcoDialogo()
	{
		setBounds(600,400,500,350);
		
		JPanel cuadricula=new JPanel();
		cuadricula.setLayout(new GridLayout(2,3));
		
		//construimos un array donde los componentes vallan en la primera caja
		String primero[]= {"mensaje","confirmar","opcion","entrada"};
		
		//instanciar nuestra lamina botones y le pasamos por parametro el titulo y el array creado arriba
		laminaTipo=new laminaBotones("tipo",primero);
		
		//hacemos lo mismos que arriba de crear el string e intanciar pero todo en un solo paso
		laminatipomensaje=new laminaBotones("tipo demensaje",new String[] 
				{
						"ERROR_MESSAGE","INFORMATION_MESSAGE","WARNING_MESSAGE","QUESTION_MESSAGE","PLAIN_MESSAGE"
				});
		
		laminamensaje=new laminaBotones("Mensaje",new String[] 
				{
						"cadena","icono","componente","otros","Object[]"
				});
		
		laminatipoopcion=new laminaBotones("confirmar",new String[]
				{
						"DEFAULT_OPTION","YES_NO_OPTION","YES_NO_CANCEL_OPTION","OK_CANCEL_OPTION"
				});
		
		laminaopciones=new laminaBotones("opcion",new String[] 
				{
						"String[]","Icon[]","Object[]"
				});
		
		laminaentrada=new laminaBotones("entrada",new String[] 
				{
					"campo de texto","combo"	
				});
		
	//para al redimencionar la ventana no se corra nada 
		setLayout(new BorderLayout());
		
		//lo agregamos a lamina cuadricula todas las instancias
		cuadricula.add(laminaTipo);
		cuadricula.add(laminatipomensaje);
		cuadricula.add(laminamensaje);
		cuadricula.add(laminatipoopcion);
		cuadricula.add(laminaopciones);
		cuadricula.add(laminaentrada);
		//agregamos la lamina creada al marco
		add(cuadricula,BorderLayout.CENTER);
		
		JPanel lamina=new JPanel();
		JButton boton=new JButton("mostrar");
		boton.addActionListener(new accionmostrar());
		lamina.add(boton);
		add(lamina,BorderLayout.SOUTH);
	}
	//--------------------------metodo para mostrar lo de la 3 casilla------------------------------------------
	
	
	public Object damemensaje() 
	{
		String s= laminamensaje.dameSeleccion();
		if(s.equals("cadena")) 
		{
			return cadenamensaje;
		}
		else 
		{
			if(s.equals("icono")) 
			{
				return iconomensaje;
			}
			else 
			{
				if(s.equals("componente")) 
				{
					return componentemensaje;
				}
				else 
				{
					if(s.equals("otros")) 
					{
						return objetomensaje;
					}
					else 
					{
						if(s.equals("Object[]")) 
						{
							return new Object[] {cadenamensaje,iconomensaje,componentemensaje,objetomensaje};
						}
						else 
						{
							return null;//por si no se cimple ninguna opcion de las demas tiene que haber un retur
						}				//aunque hay que elegir sisi una opcion pero el compilador no lo sabe
					}
				}
			}
		}
	}
	
	
	//------------------------------------cierra metodo de tercer casilla--------------------------------------------------
	
	
	
	
	
	
	//----------------------------------metodo para mostrar icono de mensaje segunada casilla--------------------------------
	
	public int dameIcono() //son constantes estaticas por mas que sean oalabras se definen con numeros
	{
		String s=laminatipomensaje.dameSeleccion();
		
		if(s.equals("ERROR_MESSAGE")) 
		{
			return JOptionPane.ERROR_MESSAGE; //es lo mismo decir return 0;
		}
		else 
		{
			if(s.equals("INFORMATION_MESSAGE")) 
			{
				return JOptionPane.INFORMATION_MESSAGE;//1
			}
			else 
			{
				if(s.equals("WARNING_MESSAGE")) 
				{
					return JOptionPane.WARNING_MESSAGE;
				}
				else 
				{
					if (s.equals("QUESTION_MESSAGE")) 
					{
						return JOptionPane.QUESTION_MESSAGE;
					}
					else 
					{
						if (s.equals("PLAIN_MESSAGE")) 
						{
							return JOptionPane.PLAIN_MESSAGE;
						}
						else 
						{
							return -100;
						}
					}
				}
			}
		}
	}//--------------------------cierra metdo dameIcono capsula2----------------------------------
	
	
	//--------------abre metodo dameInstrucciones que gestiona casilla 4
	public int dameInstrucciones() 
	{
		String s=laminatipoopcion.dameSeleccion();//dameSeleccion muestra el boton seleccionado y almacena
													//en s 
		if(s.equals("DEFAULT_OPTION")) 
		{
			return JOptionPane.DEFAULT_OPTION;
		}
		else 
		{
			if(s.equals("YES_NO_OPTION")) 
			{
				return JOptionPane.YES_NO_OPTION;
			}
			else 
			{
				if(s.equals("YES_NO_CANCEL_OPTION")) 
				{
					return JOptionPane.YES_NO_CANCEL_OPTION;
				}
				else 
				{
					if(s.equals("OK_CANCEL_OPTION")) 
					{
						return JOptionPane.OK_CANCEL_OPTION;
					}
					else 
					{
						return 1000;
					}
				}
			}
		}
	}//-------------------cierra metodo dameInstrucciones que va en JOptionPane.showConfirmDialog---------------------
	
	
	//-----------------------abre metodo dameopciones capsula5 metdo--------------------------------
	public Object[] dameopciones() 
	{
		String s=laminaopciones.dameSeleccion();
		
		if(s.equals("String[]")) 
		{
			return new String[] {"amarillo","verde","azul"};
		}
		else 
		{
			if(s.equals("Icon[]"))
			{
				return new Object[] {new ImageIcon("src/graficos/bolaazul.JPG"),new ImageIcon("src/graficos/bolarojo.JPG"),new ImageIcon("src/graficos/bolaamarillo.JPG")};
			}
			else 
			{
				if(s.equals("Object[]")) 
				{
					return new Object[] {cadenamensaje,iconomensaje,componentemensaje,objetomensaje};
				}
				else 
				{
					return null;
				}
			}
		}
	}//------------------------------------cierra metodo dameopciones capsula 5--------------
	
	
	
	
	
	
	
	//----------------------------gestiona eventos de raton--------------------------------------------------------------------------
	private class accionmostrar implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			//System.out.println(laminaTipo.dameSeleccion());
			
			if(laminaTipo.dameSeleccion().equals("mensaje")) 
			{
				JOptionPane.showMessageDialog(null, damemensaje(), "titulo", dameIcono());
			}
			else 
			{
				if(laminaTipo.dameSeleccion().equals("confirmar")) 
				{
					JOptionPane.showConfirmDialog(null,damemensaje(),"titulo",dameInstrucciones(),dameIcono());
				}
				else 
				{
					if(laminaTipo.dameSeleccion().equals("entrada")) 
					{
						//significa si el usuario escoje campo de texto que la deje como esta
						//con el metodo dameseleccion y con equals le decimos que campo seleciona y si
						//elige combo evaluamos con otro esle para hacer otro JOptionPane que permite hacer
						//un combox 
						if(laminaentrada.dameSeleccion().equals("campo de texto")) 
						{
							JOptionPane.showInputDialog(null, damemensaje(), "titulo", dameIcono());
						}
						else 
						{																				//pide objeto de array para el combobox    //indica el valor que tiene que estar seleccionado en principio para mostrar
							JOptionPane.showInputDialog(null, damemensaje(), "titulo", dameIcono(), null,new String[] {"amarillo","azul","rojo"}, "azul");
						}
					}
					else 
					{
						if(laminaTipo.dameSeleccion().equals("opcion")) 
						{
							
							JOptionPane.showOptionDialog(null,damemensaje(), "titulo", JOptionPane.YES_NO_CANCEL_OPTION, dameIcono(), null, dameopciones(), null);
						}
					}
				}
			}
		}
	}
	private laminaBotones laminaTipo,laminatipomensaje,laminamensaje,laminatipoopcion,laminaopciones,laminaentrada;
	private String cadenamensaje="mensaje";
	private Icon iconomensaje=new ImageIcon("src/graficos/bolaazul.JPG");
	private Object objetomensaje=new Date();
	private Component componentemensaje=new laminaejemplo();
}

class laminaejemplo extends JPanel
{
	public void  paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		//casting para crear el rectangulo
		Graphics2D g2=(Graphics2D) g;
		
		//creamos el rectangulo
		Rectangle2D rectangulo=new Rectangle2D.Double(0,0,getWidth(),getHeight());
		
		//le decimos que pinte de color amarillo
		g2.setPaint(Color.yellow);
		
		//pinta de amarillo el rectangulo
		g2.fill(rectangulo);
	}
}
