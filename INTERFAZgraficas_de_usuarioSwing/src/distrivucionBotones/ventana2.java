package distrivucionBotones;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

import javax.swing.JFrame;
public class ventana2 extends JFrame //ventana ereda los metodos de Frame
{
	private Button bNorte,bSur,bOeste,bEste,bCentro;
	
	public ventana2() 
	{
		super("esta es la ventana");
		setLayout(new BorderLayout());//posiciona los botones en las sinco regiones n,s,e,o,y cento
		
		bNorte=new Button("norte");
		add(bNorte,BorderLayout.NORTH);
		
		bSur=new Button("sur");
		add(bSur,BorderLayout.SOUTH);
		
		bEste=new Button("este");
		add(bEste,BorderLayout.EAST);
		
		bOeste=new Button("oeste");
		add(bOeste,BorderLayout.WEST);
		
		bCentro= new Button("centro");
		add(bCentro,BorderLayout.CENTER);
		
		setSize(300,300);
		setVisible(true);
		
		
	}
   
	public static void main(String[] args) 
     {
    	 ventana2 v2=new ventana2();
    	v2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
}
