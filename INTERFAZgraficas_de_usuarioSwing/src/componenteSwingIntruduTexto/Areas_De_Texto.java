package componenteSwingIntruduTexto;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Areas_De_Texto 
{

	public static void main(String[] args)
	{
		MarcoPruebaAreas mimarco=new MarcoPruebaAreas();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

//marco
class MarcoPruebaAreas extends JFrame
{
	public MarcoPruebaAreas() 
	{
		setTitle("prueba areas de texto");
		setBounds(600,200,500,300);

		LaminaPruebaAreas milamina=new LaminaPruebaAreas();
		add(milamina);
	}
}


//lamina
class LaminaPruebaAreas extends JPanel
{
	public LaminaPruebaAreas() 
	{
		//decimos que la lamina va disponer de un borderlayout
		setLayout(new BorderLayout());
		
		//instancia laminabotones
		LaminaBotones lamina=new LaminaBotones();
		add(lamina,BorderLayout.SOUTH);
		
		//creamos la instancia del area de texto y la agregamos a la lamina
		areaTexto=new JTextArea(8,20);
		scrolLamina=new JScrollPane(areaTexto);
		add(scrolLamina,BorderLayout.CENTER);
		
		
		
	}
	//clase interna
	private class LaminaBotones extends JPanel
	{
		public LaminaBotones()
		{
			//los dos botones van a estar uno al lado del otro ya que tiene 0 lineas y 2 columnas
			setLayout(new GridLayout(0,2));
			
			//creamos dos botones
			 botoninsertar=new JButton("insertar");
			 saltolinea=new JButton("salto de linea");
			//agregamos los botones a la lamina
			add(botoninsertar);
			add(saltolinea);
			
			
			//instancia de oyentebotones
			oyenteBotones mioyente=new oyenteBotones();
			botoninsertar.addActionListener(mioyente);
			
			//instancia de botonsalto
			botondesalto bb=new botondesalto();
			saltolinea.addActionListener(bb);
		}
	}
	
	//segunda clase interna oyente o que esta a la escucha del evento clic
	private class oyenteBotones implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			//cada vez que precionemos el boton insertar establece este texto con el metodo
			//append a diferencia de gettext que superpone el texto este pone uno despues de otro
			areaTexto.append("kjahkljcahslkjckas");
			
			
		}
	}
	
	private class botondesalto implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			//almacenamos dentro de la variable saltar un objeto de tipo boolean y le decimos
			//que es lo contrario de lo que hay dento del area de texto
			//metodo getlinewrap(captura salto de linea si es que hay )
			//si no hay saltos de linea se almacena un true
			boolean saltar=! areaTexto.getLineWrap();
			
			
			//como no hay saltos de linea porque no lo establecimos y por parametros le pasamos
			//un true que se almacena en el objeto saltar ese true hace el salto de linea
			areaTexto.setLineWrap(saltar);
			
			//evaluamos si hay salto de linea o no y cambia el nombre de botones
			if(saltar==true) 
			{
				saltolinea.setText("quitar salto");//pone en boton saltolinea el texto definido
			}
			else 
			{
				saltolinea.setText("poner salto");
			}
			
			//otra forma de usar el if else se llama terneareo
			
			//con el signo de pregunta finaliza la prueba logica del if y ponemos la opercion
			//despues con los dos puntos seria un else y ponemos la operacion que seria el String
			
			saltolinea.setText(saltar==true ? "quitar salto" : "poner salto");
		}
	}
	//variables de clase
	private JButton botoninsertar;
	private JTextArea areaTexto;
	private JButton saltolinea;
	private JScrollPane scrolLamina;
}

