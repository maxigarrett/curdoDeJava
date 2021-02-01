package componenteSwingIntruduTexto;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class controldeslizante 
{

	public static void main(String[] args) 
	{
		Marcodeslisante mimarco=new Marcodeslisante();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);
	}

}


class Marcodeslisante extends JFrame
{
	public Marcodeslisante() 
	{
		setBounds(600,200,400,250);
		Laminadeslisante milamina=new Laminadeslisante();
		add(milamina);
	} 
}

//lamina
class Laminadeslisante extends JPanel
{
	public Laminadeslisante()
	{
		//por parametros le decimos que valla de 0 hasta 100 
		//y el 50 es donde tiene que estar posicionado
		JSlider control=new JSlider(0,100,50);
		
		//la orientacion la podemos especificar en el constructor o aparte de este modo
		//control.setOrientation(SwingConstants.VERTICAL);
		
		//marca mayores y menores
		control.setMajorTickSpacing(50);
		control.setMinorTickSpacing(25);
		//imprime las marcas credas
		control.setPaintTicks(true);
		
		//metodo para que aparezcan las marcas creadas
	//	control.setPaintLabels(true);
		
		//le decimos a los numeros que aparecen con font los cambiamos
		control.setFont(new Font("Serif",Font.BOLD,12));
		
		//para que el slider se valla automaticamente a los valores altos y no los pequeños
		control.setSnapToTicks(true);
		
		add(control);
	}
}