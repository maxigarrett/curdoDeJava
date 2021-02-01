package componenteSwingIntruduTexto;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class checkBox_casillasDeVerificacion 
{

	public static void main(String[] args)
	{
		MarcoVerificacion mimarco=new MarcoVerificacion();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

//marco
class MarcoVerificacion extends JFrame
{
	public MarcoVerificacion()
	{
		setBounds(600,200,450,300);
		
		//instancia de la lamina
		Laminachek milamina=new Laminachek();
		add(milamina);
		
	}
}



//lamina

class Laminachek extends JPanel
{
	public Laminachek() 
	{
		setLayout(new BorderLayout());
		
		//clase font para poner el texto con determinado tipo de letra,tamaño...
		Font miletra=new Font("Serif",Font.PLAIN,24);
		texto=new JLabel("hola cambiame la letra con los botones...",JLabel.CENTER);
		//le decimos al texto que cambia al tipo de letra indicado con font
		texto.setFont(miletra);
		//agregamos el texto a el centro de la lamina
		add(texto,BorderLayout.CENTER);
		
		//instanciamos la segunda lamina interna
		laminachek lamina=new laminachek();
		//le decimos que las casillas van a ir al sur del frame
		add(lamina,BorderLayout.SOUTH);
		
	}
	
	
	
	
	//segunda lamina clase interna
	private class laminachek extends JPanel
	{
		public laminachek() 
		{
			//crea la casilla y la palabra negrita al lado
			casilla1=new JCheckBox("negrita");
			casilla2=new JCheckBox("cursiva");
			add(casilla1);
			add(casilla2);
			//instancia de la clase ActionListener
			manejacasilla micasilla=new manejacasilla();
			//ponemos a la escucha a las casillas o cheks creados
			casilla1.addActionListener(micasilla);
			casilla2.addActionListener(micasilla);
			
		}
	}
	
	
	
	
	//clase interna privada que desencadena la accion de las casillas
	private class manejacasilla implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			//usamos objeto tipo entero porque la constante de clase Bold son enteros
			int tipo=0;
			//evaluamos si la casilla esta seleccionada incrementa en uno la variable tipo
			//si no esta seleccionado la variable pasa a valer 0 y no entra al if y vuelve 
			//al estado original ya creado anteriormente
			if(casilla1.isSelected()==true) 
			{
				//aumenta en uno si la casilla esta marcada y pone la letra en negrita(Bold)
				tipo+=Font.BOLD;//constante de tipo entera que vale 1
			}
			
			//la variable tipo vale 2 si esta la segunda casilla marcada o 3 si estan las 2
			//y cuando no aya nada marcado vuelve a 0 y no entra a ningun if y pone la letra a
			//su estado original 
			if(casilla2.isSelected()==true) 
			{
				tipo+=Font.ITALIC;//constante entera que vale 2 en la api de java
			} 
			
			Font miletra2=new Font("serif",tipo,24);
			texto.setFont(miletra2);
			
			//es lo mismo decir 
			//texto.setFont(new Font("serif",tipo,24));
		
		}
	}
	
	
	
	//variables de clase
	private JLabel texto;
	private JCheckBox casilla1;
	private JCheckBox casilla2;
}