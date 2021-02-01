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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class pruebaMia_Maxi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		marcoo mimarco=new marcoo();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setBounds(600, 200, 600, 350);
		mimarco.setVisible(true);
	}

}



class marcoo extends JFrame
{
	public marcoo() 
	{
		
		add(new lamina(),BorderLayout.SOUTH);
	}
}

 class lamina extends JPanel
{
	public lamina() 
	{	
			setLayout(new BorderLayout());
		 boton=new JButton("muestra");
		add(boton,BorderLayout.SOUTH);
		add(new laminaa(),BorderLayout.CENTER);
	}



class laminaa extends JPanel
{
	public laminaa()
	{
		setLayout(new BorderLayout());//con esto hace que al redimensionar el frame siga todo bien hubicado
		setLayout(new GridLayout(2,3));
		
		//creamos box vertical
		Box tipo=Box.createVerticalBox();
		
		 grupo1=new ButtonGroup();
		
		//creamos un grupo de botones de radio
		 Mensaje=new JRadioButton("mensaje",true);
		 Confirmacion=new JRadioButton("confirmacion");
		 Opcion=new JRadioButton("opcion");
		 Entrada=new JRadioButton("entrada");
		// Mensaje.setSelected(true);
		
		//para que quede mas prolijo lo encuadramos
		tipo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "tipo"));
		//lo agregamos al grupo creafo
		grupo1.add(Mensaje);
		grupo1.add(Confirmacion);
		grupo1.add(Opcion);
		grupo1.add(Entrada);
		
		//le decimos que los botones de radio se van agregar de forma vertical
		tipo.add(Mensaje);
		tipo.add(Confirmacion);
		tipo.add(Opcion);
		tipo.add(Entrada);
		//agregamos el box vertical y asi con los demas
		add(tipo);

		
		Box tipo2=Box.createVerticalBox();

		
		 grupo2=new ButtonGroup();
		
		error_mensaje=new JRadioButton("ERROR_MESSAGE",true);
		 informacion_mensaje=new JRadioButton("INFORMATION_MESSAGE");
		 warning_mensaje=new JRadioButton("WARNING_MESSAGE");
		 cuestion_mensaje=new JRadioButton("CUESTION_MESSAGE");
		 plain_mensaje=new JRadioButton("PLAIN_MESSAGE");



		tipo2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "tipo de mensaje"));

		
		grupo2.add(error_mensaje);
		grupo2.add(informacion_mensaje);
		grupo2.add(warning_mensaje);
		grupo2.add(cuestion_mensaje);
		grupo2.add(plain_mensaje);
		
		tipo2.add(error_mensaje);
		tipo2.add(informacion_mensaje);
		tipo2.add(warning_mensaje);
		tipo2.add(cuestion_mensaje);
		tipo2.add(plain_mensaje);
		add(tipo2);
		
		

		Box tipo3=Box.createVerticalBox();

		
		 grupo3=new ButtonGroup();
		
		 cadena=new JRadioButton("cadena",true);
		 icono=new JRadioButton("icono");
		 componente=new JRadioButton("componente");
		 otros=new JRadioButton("otros");
		object=new JRadioButton("Object[]");
		cadena.setSelected(true);
		tipo3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "mensaje"));

		
		grupo3.add(cadena);
		grupo3.add(icono);
		grupo3.add(componente);
		grupo3.add(otros);
		grupo3.add(object);
		
		tipo3.add(cadena);
		tipo3.add(icono);
		tipo3.add(componente);
		tipo3.add(otros);
		tipo3.add(object);
		add(tipo3);
		
		

		Box tipo4=Box.createVerticalBox();

		
		 grupo4=new ButtonGroup();
		
		 defaultt=new JRadioButton("DEFAULT_OPTION",true);
		 yes=new JRadioButton("YES_NO_OPTION");
		 no=new JRadioButton("YES_NO_CANCEL_OPTION");
		 ok=new JRadioButton("OK_CANCEL_OPTION");
		
		tipo4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "confirmar"));
		
		grupo4.add(defaultt);
		grupo4.add(yes);
		grupo4.add(no);
		grupo4.add(ok);
		
		tipo4.add(defaultt);
		tipo4.add(yes);
		tipo4.add(no);
		tipo4.add(ok);
		add(tipo4);
		

		Box tipo5=Box.createVerticalBox();

		
		 grupo5=new ButtonGroup();
		
		 string=new JRadioButton("String[]",true);
		 iicono=new JRadioButton("icono[]");
		 objeto=new JRadioButton("objeto[]");
		
		tipo5.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "opcion"));

		
		grupo5.add(cadena);
		grupo5.add(iicono);
		grupo5.add(componente);
		
		
		tipo5.add(string);
		tipo5.add(iicono);
		tipo5.add(objeto);
		
		add(tipo5);
	
		Box tipo6=Box.createVerticalBox();
		
		 grupo6=new ButtonGroup();
		
		 campo=new JRadioButton("campo de texto",true);
		 combo=new JRadioButton("combo");
		
		tipo6.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "entrada"));

		
		grupo6.add(campo);
		grupo6.add(combo);
		
		tipo6.add(campo);
		tipo6.add(combo);
		
		add(tipo6);
		
		
		
		boton.addActionListener(new accion());
		
	}
	
	
}



public Object damemensaje() 
{
	if(cadena.isSelected()==true) 
	{
		return Cadena;
	}
	else 
	{
		if(icono.isSelected()==true) 
		{
			return Icono;
		}
		else 
		{
			if(componente.isSelected()==true) 
			{
				return componentemensaje;
			}
			else 
			{
				if(otros.isSelected()==true) 
				{
					return datomensaje;
				}
				else 
				{
					if(object.isSelected()==true) 
					{
						return new Object[] {Cadena,Icono,componentemensaje,datomensaje};
					}
					else 
					{
						return null;
					}
				}
			}
		}
		
	}
	
}//------------------------cierra casilla 3----------------------------------------------


//------------------------------------casilla 2-----------------------------------
public int dameconfirmacion() 
{
	if(error_mensaje.isSelected()==true) 
	{
		return JOptionPane.ERROR_MESSAGE;
	}
	else 
	{
		if(informacion_mensaje.isSelected()==true) 
		{
			return JOptionPane.INFORMATION_MESSAGE;
		}
		else 
		{
			if(warning_mensaje.isSelected()==true) 
			{
				return JOptionPane.WARNING_MESSAGE;
			}
			else 
			{
				if(cuestion_mensaje.isSelected()==true) 
				{
					return JOptionPane.QUESTION_MESSAGE;
				}
				else 
				{
					if(plain_mensaje.isSelected()==true) 
					{
						return JOptionPane.PLAIN_MESSAGE;
					}
					else 
					{
						return 100;
					}
				}
			}
		}
	}
}//-------------------------cierra casilla 2--------------------------


//-------------------------------abre casilla 4---------------------------------

public int confirmar() 
{
	if(defaultt.isSelected()==true) 
	{
		return JOptionPane.DEFAULT_OPTION;
	}
	else 
	{
		if(yes.isSelected()==true) 
		{
			return JOptionPane.YES_NO_OPTION;
		}
		else 
		{
			if(no.isSelected()==true) 
			{
				return JOptionPane.YES_NO_CANCEL_OPTION;
			}
			else 
			{
				if(ok.isSelected()==true) 
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
}//-----------------cierre metodo casilla 4-------------------------------


//------------------casilla 5---------------------------------
public Object[] dameopciones()
{
	if(string.isSelected()==true) 
	{
		return new String[] {"verde","rojo","amarillo"};
	}
	else 
	{
		if(iicono.isSelected()==true) 
		{
			return new Object[] {new ImageIcon("src/graficos/bolaazul.JPG"),new ImageIcon("src/graficos/bolarojo.JPG"),new ImageIcon("src/graficos/bolaamarillo.JPG")};
		}
		else 
		{
			if(objeto.isSelected()==true) 
			{
				return new Object[] {Cadena,Icono,componentemensaje,datomensaje};
			}
			else 
			{
				return null;
			}
		}
	}
}//--------------------------cierra casilla 5--------------

private class accion implements ActionListener
{
	@SuppressWarnings("unlikely-arg-type")
	public void actionPerformed(ActionEvent e) 
	{
		if(Mensaje.isSelected()==true) 
		{
			JOptionPane.showMessageDialog(null, damemensaje(), "titulo", dameconfirmacion());
		}
		else 
		{
			if(Confirmacion.isSelected()==true) 
			{
				JOptionPane.showConfirmDialog(null, damemensaje(), "titulo", confirmar(), dameconfirmacion(), null);
			}
			else 
			{
				if(Opcion.isSelected()==true) 
				{
					
					JOptionPane.showOptionDialog(null, damemensaje(), "titulo", confirmar(), dameconfirmacion(), null, dameopciones(), null);
					
				}
				else 
				{
					if(Entrada.isSelected()==true)
					{
							JOptionPane.showInputDialog(null, damemensaje(),"titulo",dameconfirmacion());
					}
						else 
						{
							
							JOptionPane.showInputDialog(null, datomensaje, "titulo", dameconfirmacion(), null, new String[] {"rojo","azul","verde"}, "azul");
								
						}
						
				}
					
					
				}
			}
		}
		
	}



	private JRadioButton Mensaje,Confirmacion,Opcion,Entrada,error_mensaje,informacion_mensaje,warning_mensaje,cuestion_mensaje,
	plain_mensaje,cadena, icono ,componente, otros,defaultt,yes,no,ok,string,iicono,objeto,campo,combo,object;
	
	private ButtonGroup grupo1,grupo2,grupo3,grupo4,grupo5,grupo6;
	
	private JButton boton;
	
	private String Cadena="mensaje";
	private Icon Icono=new ImageIcon("src/graficos/bolaazul.JPG");
	private Component componentemensaje=new lami();
	private Object datomensaje=new Date();
}
 
 class lami extends JPanel
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
 
