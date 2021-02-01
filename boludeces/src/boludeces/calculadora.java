package boludeces;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class calculadora 
{

	public static void main(String[] args)
	{
		Marco mimarco=new Marco();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setLocation(600, 400);
		mimarco.setVisible(true);

	}

}

class Marco extends JFrame
{
	public Marco() 
	{
		setTitle("calculadora");
		add(new laminacalculadora());
		pack();
	}
}


class laminacalculadora extends JPanel
{
	public laminacalculadora() 
	{
		inicio=true;//como es true establece el cero que muestra en nada de texto establecido por el if
		setLayout(new BorderLayout());
		 miarea=new JTextArea("0");
		 add(miarea,BorderLayout.NORTH);
		
		 
		 //segunda lamina
		 lamina2=new JPanel();
		 lamina2.setLayout(new GridLayout(4,4));
		 
		 insertanumero insertar=new insertanumero();
		 accionorden accion=new accionorden();
		 
		 botonescalculadora("9",insertar);
		 botonescalculadora("8",insertar);
		 botonescalculadora("7",insertar);
		 botonescalculadora("/",accion);
		 
		 botonescalculadora("6",insertar);
		 botonescalculadora("5",insertar);
		 botonescalculadora("4",insertar);
		 botonescalculadora("*",accion);
		 
		 botonescalculadora("3",insertar);
		 botonescalculadora("2",insertar);
		 botonescalculadora("1",insertar);
		 botonescalculadora("-",accion);
		 
		 botonescalculadora(".",insertar);
		 botonescalculadora("0",insertar);
		 botonescalculadora("+",insertar);
		 botonescalculadora("=",accion);
		 ultimaoperacion="=";//para que no aparezca ningun otro signo ponemos igual asi no muestra
		 //nada y permite resetear el display
		 add(lamina2,BorderLayout.CENTER);
	}
	
	public void botonescalculadora(String titulo, ActionListener oyente) 
	{
		JButton boton=new JButton(titulo);
		boton.addActionListener(oyente);
		lamina2.add(boton);
	}
	private JPanel lamina2;
	JTextArea miarea;
	private boolean inicio=false;
	private String ultimaoperacion;
	public double resultado;

//----------------------------------------------------------------
private class insertanumero implements ActionListener
{
	public void actionPerformed(ActionEvent e) 
	{
		//metodo que devuelve la accion del String cliqueado osea 1,2,3,4=/,etc
		String entrada=e.getActionCommand();
		
		if(inicio==true) 
		{
			miarea.setText("");//si es true borra el 0 y deja en bblanco
			
			inicio=false;//sale del if
		}
		
		//el texto que borra el cero ahora va a a establece(set) lo que capture(get)  y entrada  
		//captura la accion echa osea el boton cliqueado que lo busca por como esta nombrado String
		miarea.setText(miarea.getText() + entrada);
			
	}
	
}

private class accionorden implements ActionListener
{
	public void actionPerformed(ActionEvent e) 
	{
		String operacion=e.getActionCommand();
		
		calcular(Double.parseDouble(miarea.getText()));//lo que almacena en pantalla lo pasa a doble
		
		ultimaoperacion=operacion;//almacena las operaciones que el usuario valla realizando
		
		//resetea el display
		inicio=true;
	}
}

public void calcular(double x) 
{
	if(ultimaoperacion.equals("+")) 
	{
		resultado+=x;
	}
	else 
	{
		if(ultimaoperacion.equals("/")) 
		{
			resultado/=x;
		}
		else 
		{
			if(ultimaoperacion.equals("*")) 
			{
				resultado*=x;
			}
			else 
			{
				if(ultimaoperacion.equals("-")) 
				{
					resultado-=x;
				}
				else 
				{
					if(ultimaoperacion.equals("=")) 
					{
						resultado=x;
					}
				}
			}
		}
	}
	//set pone en blaco la pantalla con las comillas es decir borra el cero
	miarea.setText(" "+ resultado);
}

}
