package graficos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class pintandoDibujo
{

	public static void main(String[] args)
	{
		pintandoMarco mimarco=new pintandoMarco();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class pintandoMarco extends JFrame 
{
	public pintandoMarco()
	{
		Toolkit mipantalla=Toolkit.getDefaultToolkit();
		setTitle("pintando el frame");
		setBounds(400,300,500,400);
		setVisible(true);
		La_Lamina milamina=new La_Lamina();
		add(milamina);
		Image Imagen=mipantalla.getImage("src/graficos/icono2.JPG");
		setIconImage(Imagen);
		milamina.setBackground(SystemColor.window);//metodo establece el color de fondo (no en la figura) 
	}                                             //y por parametro le das el color por defecto de windows se aplica para cualquier otro sistema operativo
}

class La_Lamina extends JPanel
{
	public void paintComponent(Graphics g) //sobreescribe
	{
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D) g;
		
		Rectangle2D rectangulo=new Rectangle2D.Double(100,100,200,150);
		g2.setPaint(Color.WHITE);
		g2.draw(rectangulo);
		g2.setPaint(Color.BLUE);//metodo para establecer color
		g2.fill(rectangulo);//cambiar el draw por fill para rellenar de color con draw solo pinta la linea
		
		
		Ellipse2D elipse=new Ellipse2D.Double();
		elipse.setFrame(rectangulo);//le digo con este metodo que la elipse debe estar dentro del rectangulo
		//Color micolor=new Color(124,32,49);
		//g2.setPaint(micolor);//es lo mismo que lo de de abajo
		
		g2.setColor(new Color(124,32,45).brighter());//constructor que pide tres parametros de tipo int que depende
		        // el num de esos tres es el color va de 0 a 255 (RGB) son los tres colore que mezcla red gree y blue
		
		g2.fill(elipse);
		
	}
	//el metodo brighter(); que esta dentro del constructor color (y ademas hay vario tipos de constructores
	//de ese metodo) aclara el color en este caso de la elipse
	//el metodo darker(); hace lo contrario osea oscurece
}