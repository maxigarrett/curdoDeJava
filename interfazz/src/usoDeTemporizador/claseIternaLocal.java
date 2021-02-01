package usoDeTemporizador;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;



import java.awt.Toolkit;


public class claseIternaLocal 
{

	
	
	public static void main(String[] args)
	{
		reloj mireloj=new reloj();
		mireloj.enMarcha(3000,true);//lo que se almacena en los parametros intervalo y sonido
		JOptionPane.showMessageDialog(null,"pulsa aceptar para terminar");

	}


}


class reloj 
{
	
	
	public void enMarcha(int intervalo,final boolean sonido)//como accedemos a una varable local de una clase
	{                                              //interna va como modificador de acceso final solo en sonido ya
		                                            //a la otra variable no accedemos
		class DameLaHora2 implements ActionListener 
		{
			public void actionPerformed(ActionEvent evento) 
			{
				Date ahora=new Date();
				System.out.println("cada tres segundo tenes la hora " + ahora);
				
				if(sonido==true) 
				{
					Toolkit.getDefaultToolkit().beep();
				}
			}
		}
		
		ActionListener oyente=new DameLaHora2();
		Timer mitemporizador=new Timer(intervalo,oyente);
		mitemporizador.start();
	}
	
	
}
