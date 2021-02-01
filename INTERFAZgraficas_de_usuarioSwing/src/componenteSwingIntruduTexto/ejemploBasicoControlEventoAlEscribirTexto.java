package componenteSwingIntruduTexto;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class ejemploBasicoControlEventoAlEscribirTexto 
{

	public static void main(String[] args)
	{
		Marco mimarco=new Marco();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

//marco
class Marco extends JFrame
{
	public Marco()
	{
		setBounds(600,200,400,200);
		lami milamina=new lami();
		add(milamina);
	}
	
}
 

//lamina
class lami extends JPanel
{
	public lami()
	{
		JTextField texto=new JTextField(20);
		
		Document midoc=texto.getDocument();//almacenamos en objeto de tipo document el texto ingresado
		add(texto);
		
		escuchaTexto mitexto=new escuchaTexto();
		midoc.addDocumentListener(mitexto);
	}
	
	
	
	private class escuchaTexto implements DocumentListener
	{

		//inserta texto se activa
		public void insertUpdate(DocumentEvent e) 
		{
			System.out.println("insertaste texto");
		}

		//borrar texto se activo
		public void removeUpdate(DocumentEvent e)
		{
			System.out.println("borraste texto");

			
		}

		//cuando se modifica la propiedad se activa
		public void changedUpdate(DocumentEvent e) 
		{
			// TODO Auto-generated method stub
			
		}
		
	}
}