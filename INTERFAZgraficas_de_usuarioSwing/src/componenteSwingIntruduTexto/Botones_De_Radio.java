package componenteSwingIntruduTexto;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Botones_De_Radio 
{

	public static void main(String[] args) 
	{
		MarcoRadio mimarco=new MarcoRadio();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}

//marco
class MarcoRadio extends JFrame
{
	public MarcoRadio() 
	{
		setBounds(600,200,450,300);
		//instancia de lamina
		laminaRadio milamina=new laminaRadio();
		add(milamina);
	}
}


//lamina
class laminaRadio extends JPanel
{
	public laminaRadio() 
	{
		//creamos un ButtonGroup para agrupar la cantidad de botones de radio que necesitemos
		ButtonGroup migrupo1=new ButtonGroup();
		//instancia de clase JRadioButton  por parametros le decimos el nombre y si va a estar
		//marcado el circulo del boton hay otros tipos de constructores tambien
		JRadioButton boton1=new JRadioButton("azul",false);
		JRadioButton boton2=new JRadioButton("rojo",true);
		JRadioButton boton3=new JRadioButton("verde",false);
		
		//agregamos los botones al grupo
		migrupo1.add(boton1);
		migrupo1.add(boton2);
		migrupo1.add(boton3);
		
		//agregamos los botones a la lamina
		add(boton1);
		add(boton2);
		add(boton3);
		
		//creamos segundo grupo
		ButtonGroup migrupo2=new ButtonGroup();
		
		//creamos los botones para el segundo grupo
		JRadioButton botonM=new JRadioButton("masculino",false);
		JRadioButton botonF=new JRadioButton("femenino",false);
		
		//agrupamos los botones
		migrupo2.add(botonM);
		migrupo2.add(botonF);
		
		//agregamos los botones a la lamina
		add(botonM);
		add(botonF);



	}
}