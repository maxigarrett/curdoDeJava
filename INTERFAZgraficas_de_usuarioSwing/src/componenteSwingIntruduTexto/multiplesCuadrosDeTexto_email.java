package componenteSwingIntruduTexto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class multiplesCuadrosDeTexto_email
{

	public static void main(String[] args)
	{
		Marcocontraseña mimarco=new Marcocontraseña();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
		mimarco.getBackground().getBlue();
		

	}

}




class Marcocontraseña extends JFrame
{
	public Marcocontraseña() 
	{
		setBounds(500,22,400,300);
		//instancia de laminacontraseña
		laminacontraseña milamina =new laminacontraseña();
		add(milamina);
		//pack();
		milamina.setBackground(SystemColor.window);
		
	}
}


class laminacontraseña extends JPanel
{
	public laminacontraseña() 
	{
		//para darle orden en los puntos cardinales en el frame lo que creamos
		setLayout(new BorderLayout());
		
		//creamos otra lamina es lo mismo que crear una clase  fuera de esta misma
		
		JPanel lamina_superior=new JPanel();
		lamina_superior.setLayout(new GridLayout(2,2));//usamos la instacia de la segunda lamina para crear	
												//un GridLayout y va a ir en la parte superior con un Border
		add(lamina_superior,BorderLayout.NORTH);
		
		JLabel etiqueta=new JLabel("usuario");//etiqueta de  usuario
		JLabel etiqueta2=new JLabel("contraseña");//etiqueta de contraseña
		 usuario=new JTextField(15);//dispay de usuario
		//instancia de clase
		compruebacontraseña mievento=new compruebacontraseña(); 
		 usuario2=new JPasswordField(15);//display de lo que introduzcamos aparecera con asteriscos
		 // usuario2.getDocument().addDocumentListener(mievento);
		 
		
		 
		Document doc=usuario2.getDocument();
		doc.addDocumentListener(mievento);//es lo mismo que decir lo de arriba
		lamina_superior.add(etiqueta);
		lamina_superior.add(usuario);
		lamina_superior.add(etiqueta2);
		lamina_superior.add(usuario2);
		
		//instancia de accion boton o ollente
		ollente olle=new ollente();
		
		
		JButton enviar=new JButton("enviar");
		
		enviar.addActionListener(olle);
		add(enviar,BorderLayout.SOUTH);
		
		//instancia de la etiqueta para decir si el email es correcto
		  usuarioo=new JLabel();
		  us=new JLabel();
			 add(usuarioo,BorderLayout.CENTER);
			 add(us,BorderLayout.WEST);
		
	}
	
	private class compruebacontraseña implements DocumentListener
	{

		//se activa cuando introduzcamos texto
		public void insertUpdate(DocumentEvent e) 
		
		{
			char [] contraseña=usuario2.getPassword();//almacema una array de caracteres introducidos en contraseña
												//que es usuario2 osea caracter a caracter
			
			if(contraseña.length<=0) 
			{
				usuario2.setBackground(Color.WHITE);
			}
			
			else
			{
				if(contraseña.length<8 || contraseña.length>12)//si contraseña es menor a 8 y mayor a 12 
															//se pondra el display en rojo
				{
					usuario2.setBackground(Color.red);//decimos usuari(es el displey)se pondra en rojo(setBackgraun(Color.c))
					us.setText("contraseña incorrecta");
				}
				else 
				{ 
					
					usuario2.setBackground(Color.GREEN);
					us.setText("contraseña correcta");
				}
			}	
			
		}

		//se activa cuando se borra texto
		public void removeUpdate(DocumentEvent e) 
		{
			char[] contraseña=usuario2.getPassword();
			
			if(contraseña.length<=0) 
			{
				usuario2.setBackground(Color.WHITE);//al borrar y no tener ningun caracter se pne blanco
				us.setText("por favor introduzca la contraseña");

			}
			else 
			{
				if(contraseña.length<8||contraseña.length>12) 
				{
					usuario2.setBackground(Color.RED);//si contiene menor a 8 o mayor a 12 caracteres se pone rojo
				}
				else 
				{
					usuario2.setBackground(Color.GREEN);
				}
			}
	
		}

		
		public void changedUpdate(DocumentEvent e) 
		{
			
		}
		
	}
	
	private class ollente implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//adivina la contraseña
			System.out.println("tu contraseña es ajjaja :");
			System.out.println(usuario2.getPassword());
			
			//comprobamos si el email tiene arroba
			String email=usuario.getText();
			boolean arroba=false;
			int contador=0;
			
			for(int i=0;i<email.length();i++) 
			{
				if(email.charAt(i)=='@') 
				{
					arroba=true;
					contador++;
				}
			}
			if(arroba==true&&contador==1)
			{
				usuario.setBackground(Color.GREEN);
				usuarioo.setText("         email correcto");
			}
			else 
			{
				usuario.setBackground(Color.RED);
				usuarioo.setText("         email incorrecto introduzca arroba");
			}
			
			
		}
	}
	private JPasswordField usuario2;
	private JLabel us;
	private JLabel usuarioo;
	private JTextField usuario;
}



