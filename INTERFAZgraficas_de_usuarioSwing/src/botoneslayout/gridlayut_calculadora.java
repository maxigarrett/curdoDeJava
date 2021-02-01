
package botoneslayout;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class gridlayut_calculadora
{

	public static void main(String[] args)
	{
		Marco_calculadora mimarco=new Marco_calculadora();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

class Marco_calculadora extends JFrame
{
	
	public Marco_calculadora()
	{
		//setBounds(700,200,400,300);
		setLocation(700,200);
		setTitle("calculadora");
		laminacalculadora lamina=new laminacalculadora();
		add(lamina);
		
		pack();//le decis que el contenedor es decir el frame se tiene que adaptar al tamaño por defecto de lo q contiene
			   //en su interior y no hace falta el setBounds sino solo us setLocation
	}
}

class laminacalculadora extends JPanel
{
	public laminacalculadora()
	{
		inicio=true;
		BorderLayout borde=new BorderLayout();
		setLayout(borde);
		//es lo mismo decir
		//setLayout(new BorderLayout());
		
		//instancia boton borde norte
		pantalla=new JButton("0");
		add(pantalla,BorderLayout.NORTH);//le decimos al boton creado que debe estar al norte del frame
		pantalla.setEnabled(false);//metodo que desabilita el boton para no ser cliqueado
		
		milamina2=new JPanel();//llamamos a JPanel es mas facil que crear ora clase
		milamina2.setLayout(new GridLayout(4,4));//creamos cuatro fila y 4 columnas en la nueva lamina
		
		
		//agregar botones a la lamina
		/*JButton boton7=new JButton("7");
		milamina2.add(boton7);
		JButton boton8=new JButton("8");
		milamina2.add(boton8);
		JButton boton9=new JButton("9");
		milamina2.add(boton9);
		JButton botondiv=new JButton("/");
		milamina2.add(botondiv);
		
		JButton boton4=new JButton("4");
		milamina2.add(boton4);
		JButton boton5=new JButton("5");
		milamina2.add(boton5);
		JButton boton6=new JButton("6");
		milamina2.add(boton6);
		JButton botonmult=new JButton("*");
		milamina2.add(botonmult);
		
		JButton boton1=new JButton("1");
		milamina2.add(boton1);
		JButton boton2=new JButton("2");
		milamina2.add(boton2);
		JButton boton3=new JButton("3");
		milamina2.add(boton3);
		JButton botonmenos=new JButton("-");
		milamina2.add(botonmenos);
		
		JButton botoncero=new JButton("0");
		milamina2.add(botoncero);
		JButton botonpunto=new JButton(".");
		milamina2.add(botonpunto);
		JButton botonigual=new JButton("=");
		milamina2.add(botonigual);
		JButton botonmas=new JButton("+");
		milamina2.add(botonmas);
		add(milamina2,BorderLayout.CENTER);*/
		
		//llamamos el metodo para crear los botones para crear los botones de manera mas censilla
		
		ActionListener inserta=new InsertaNumero();
		ActionListener orden=new accionorden();
		
		ponerBoton("7",inserta);//lo que pongamos por parametro se almacena en el String del metodo rotulo
		ponerBoton("8",inserta);
		ponerBoton("9",inserta);
		ponerBoton("/",orden);
		
		ponerBoton("4",inserta);
		ponerBoton("5",inserta);
		ponerBoton("6",inserta);
		ponerBoton("*",orden);
		
		ponerBoton("1",inserta);
		ponerBoton("2",inserta);
		ponerBoton("3",inserta);
		ponerBoton("-",orden);
		
		ponerBoton("0",inserta);
		ponerBoton(".",inserta);
		ponerBoton("=",orden);
		ponerBoton("+",orden);
		add(milamina2,BorderLayout.CENTER);//ubicamos los botones en el centro del frame
		ultimaoperacion="=";
	}
	//manera mas sencilla de agregar botones con un metodo
	private void ponerBoton (String rotulo,ActionListener oyente) 
	{
		
		JButton boton =new JButton(rotulo);//con una sola bariable utilisamos para todos los botones
		boton.addActionListener(oyente);//ponemos a la escucha a cada boton
		milamina2.add(boton);//agregamos el boton a la lamina2
	}
	
	
	
	//variables de clase
	private String ultimaoperacion;
	private double resultado;//vamos a ir almacenando los resultados de la operaciones matematicas
	private boolean inicio=false;
	private JButton pantalla;
       private JPanel milamina2;//la ponemos a la instancia creada en el constructor tambien como variable de
	//clase ya que en el metodo no nos deja usar la instancia al estar en el constructor 
       
    
       
       
       
       //clase interna para poner a la escucha a la clase
       private class InsertaNumero implements ActionListener//oyente
       {
    	   public void actionPerformed(ActionEvent e) 
    	   {
    		   
    		   String entrada=e.getActionCommand();//devuelve el String asociado con la accion es decir
    		   										//el String que esta asociado a ese boton 1,2,3,4,=,etc
    		
    		   if(inicio==true) //arriba de todo la lamina esta variable esta puesta en true para que
    			   		//a la condicion y si hay algo en la pantalla lo borre y lo que va a estar por 
    			   			//pantalla es el 0 que lo hicimos en JButton con un String
    		   {
    			   pantalla.setText("");//borra el 0 una vez empesamos a cliquear botones
    			   inicio=false;//para que salga del if y no siga borrando el numero cliqueado
    			   
    		   }
    		   
    		   pantalla.setText(pantalla.getText()+entrada);//permite establecer un texto en el objeto creado de JButton(pantalla)
    		   //por parametro le decimos que va a ser igual al texto que hay en pantalla mas lo que voy a introducir pulsando el boton
    		   //setText:establece texto   getText:captura texto o recupera texto
    	   }
       }
       
       
       //creamos clase interna 
       private class accionorden implements ActionListener
       {
    	   public void actionPerformed(ActionEvent e) 
    	   {
    		   String operacion=e.getActionCommand();//almacenamos el String almacenado en el boton;
    		   
    		   
    		   calcular(Double.parseDouble(pantalla.getText())); //lo q se almacena en pantalla es un texto
    		   												//ya sea u 7,8,etc pero lo pasamos a doble con el cast
    		   
    		   ultimaoperacion=operacion;//almacena las operaciones que el usuario valla realizando
    		   
    		   //resetea el display
    		   inicio=true;//la variable ya creada anteriormente al ponerla aqui una vez que pongamos 
    		   				//un numero y una opercacion matematica se borrara de pantalla al ingresar
    		   		        //otro numero es decir hara lo mismo que lo que hicimos con el if anterior
    	   }
       }
       
       public void calcular(double x) //metodo que le pasamos por parametro un doble para hacer el casteo mas arriba
       {
    	   if(ultimaoperacion.equals("+")) 
    	   {
    		   resultado+=x;//acumula lo que pasamos por parametro si le pasamos un +
    		   
    	   }
  
    	   else 
    	   {
    		   if(ultimaoperacion.equals("="))
    		   {
    			   resultado=x;//acumula en la x que pasamos por parametro si el boton que precionamos es =
    		   }
    		   else 
    		   {
    			   if(ultimaoperacion.equals("-")) 
    			   {
    				   resultado-=x;
    			   }
    			   else 
    			   {
    				   if(ultimaoperacion.equals("*"))
    				   {
    					   resultado*=x;
    				   }
    				   else 
    				   {
    					   if(ultimaoperacion.equals("/"))
    					   {
    						   resultado/=x;
    					   }
    				   }
    			   }
    		   }
    	   }
    	   
    	   pantalla.setText(" " + resultado);//lo concatenamos con comillas ya que el metodo setText pide
    	   //un String y resultado es de tipo double las comillas hace que no aparezca el 0 delante
    	   //y con este metodo muestra dentro de pantalla( que es el boton creado anteriormente) el 
    	   //resultado acumulado depende de lo que pasemos osea un *,-,/,+.
       }
       
       
       
       
}//llave clase principal y que engloba todo

