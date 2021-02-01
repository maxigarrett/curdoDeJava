package interfazz;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.Toolkit;
public class pruebatemporizador
{

	public static void main(String[] args)
	{
		reloj mireloj=new reloj(3000,true);
		mireloj.enMarcha();
		JOptionPane.showMessageDialog(null,"pulsa aceptar para terminar");

	}

}

class reloj 
{
	public reloj(int intervalo,boolean sonido)//intervalo cada cuanto tiempo va a imprimir 
	                                          //y sonido si va a tener o no sonido
	{
		this.intervalo=intervalo;
		this.sonido=sonido;//co this hacemos referencia a la variable encapsulada o campo de clase
		
		
	}
	
	public void enMarcha()
	{
		ActionListener oyente=new DameLaHora2();
		Timer mitemporizador=new Timer(intervalo,oyente);
		mitemporizador.start();
	}
	private int intervalo;
	private boolean sonido;
	
	private class DameLaHora2 implements ActionListener //con private la clase principal es la unica que puede acceder
	{                                                  // otra clase creada fuera de la principal no puede
		public void actionPerformed(ActionEvent evento) 
		{
			Date ahora=new Date();
			System.out.println("cada tres segundo tenes la hora " + ahora);
			
			if(sonido==true) 
			{
				Toolkit.getDefaultToolkit().beep();//si es verdadero se ejecuta la instruccion para hecer el sonido
			}
		}
	}
}
