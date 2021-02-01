package componenteSwingIntruduTexto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class pruebaEmail
{

	public static void main(String[] args)
	{
		email marco=new email();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);

	}

}

//marco
class email extends JFrame
{
	public email() 
	{
		setBounds(600,200,400,300);
		laminaEmail lamina=new laminaEmail();
		add(lamina);
	}
}



//lamina
class laminaEmail extends JPanel
{
	public laminaEmail() 
	{
		setLayout(new BorderLayout());
		 texto1=new JLabel(" ", JLabel.CENTER);//creamos otra etiqueta para mostrar si el email es correcto o incorrecto
		 add(texto1,BorderLayout.CENTER);//segundo  y se pone al lado del display
		 
		
		
		Dametexto2 mitexto=new Dametexto2();
		add(mitexto,BorderLayout.NORTH);
	}
	private class Dametexto implements ActionListener
	{
		//cuando hagamos clic se desencadenara lo que hay en el metodo
		public void actionPerformed(ActionEvent e) 
		{
			boolean correcto=false;
			int a=0;
			
			String email=campo1.getText().trim();//capturamos lo que introducimos en el cuadro de texto y almacenamos
										//en una variable de tipo String
			for(int i=0;i<email.length();i++) 
			{
				if(email.charAt(i)=='@') //busca y extrae o devuelve el caracter que especifiquemos en este 
										//caso un @ con el metodo charAt(i); con la i recorre 
				{
					a++;//cuando aya un @ incrementa la variable a en 1 si hay mas de un arroba dera incorrecto
					correcto=true;
				}
			}
			if(correcto==true&&a==1) 
			{
				texto1.setText("correcto");//establecemos texto si es correcto con metodo seTText();
			}
			else 
			{
				texto1.setText("incorrecto");
			}
			
		}
	}
	
	//segunda lamina
	private class Dametexto2 extends JPanel
	{
		public Dametexto2()
		{
			setLayout(new FlowLayout());
			JLabel texto=new JLabel("E-mail: ");//agrega un texto fuera del cuadro de dialogo es decir una etiqueta
			add(texto);  //a los JLabel se les puede cambiar la posicion donde aparece
			
			campo1=new JTextField(20);
			add(campo1);//primero se pone el texto
			
			 JButton boton=new JButton("comprobar");
				
				Dametexto mievento=new Dametexto();
				boton.addActionListener(mievento);
				
				
				add(boton);//a la derecha del todo se pone el boton ya q es el ultimo y por ubicacion por defecto
				
		}
	}
	
	private JTextField campo1;
	private JLabel texto1;
}

