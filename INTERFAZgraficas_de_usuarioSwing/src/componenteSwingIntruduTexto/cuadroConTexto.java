package componenteSwingIntruduTexto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class cuadroConTexto 
{

	public static void main(String[] args)
	{
		MarcoTexto mimarco=new MarcoTexto();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

class MarcoTexto extends JFrame
{
	public MarcoTexto()
	{
		setBounds(600,200,400,200);
		LaminaTexto milamina=new LaminaTexto();
		add(milamina);
		
	}
}



class LaminaTexto extends JPanel
{
	public LaminaTexto()
	{
		//creamos una instancia para llamar a uno de los constructore de JTextField
		 campo1=new JTextField(20);//el 20 es el ancho en columnas es decir el ancho
		//agregamos a la lamina el cuadro de texto
		add(campo1);
		
		//System.out.println(campo1.getText().trim());//imprimimos lo que hay en el cuadro de texto y lo capturamos
									        //con el metodo getText y el metodo trim le quita los espacios adicionales en consola
		JButton miboton=new JButton("dale");
		
		DameTexto mievento=new DameTexto();
		miboton.addActionListener(mievento); //cuando apretemos el voton desencadena lo que hay en mievento
		add(miboton);//agregamos el boton a la lamina
	}
	
	//clase interna
	private class DameTexto implements ActionListener
	{
		//caundo aprete el boto desencadenara la accion de imprimir por consola lo que hay en el caudro de texto

		public void actionPerformed(ActionEvent e)
		{
			System.out.println(campo1.getText().trim());//captura el texto del cuadro de texto
		}
		
	}
	
	private JTextField campo1;
}

