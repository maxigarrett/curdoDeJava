package distrivucionBotones;

import java.awt.*;

public class ventana1 extends Frame
{
	//defino tres botones
	private Button b1,b2,b3;
	
	public ventana1() 
	{
		//el constructor padre recibe el titulo de la ventana
		super("esta es la ventana 1");
		
		//define un layout que va a tener la ventana1: FlowLayout
		
		setLayout(new FlowLayout());//muestra los botones centrados
		
		//instanciamos el primer boton y lo agrego al container
		
		b1=new Button("boton 1");
		add(b1);//Para que un interfaz sea útil, no debe estár compuesto solamente por Contenedores, éstos deben tener Componentes en su interior. 
		        //Los Componentes se añaden al Contenedor invocando al método add() del Contenedor
		
		//instancio el segundo boton y lo agrego al container(ventana)
		
		b2=new Button("boton 2");
		add(b2);
		
		//instancio el tercer boton y lo agrego al container
		
		b3=new Button("boton 3");
		add(b3);
		
		
		setSize(300,300);//metodo para dimencionar el frame
		setVisible(true);//metodo para hacer visible el frame
		
		
	}
	
 public static void main(String[] args) 
 {
	 ventana1 v1=new ventana1();
 }	
}
