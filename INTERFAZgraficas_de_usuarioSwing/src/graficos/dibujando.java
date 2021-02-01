package graficos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class dibujando 
{

	public static void main(String[] args)
	{
		MarcoConDibujo mimarco=new MarcoConDibujo();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoConDibujo extends JFrame
{
	MarcoConDibujo()
	{
		setTitle("prueba de dibujo");
		setSize(400,400);
		setLocation(300,300);
		LaminaConFiguras Lamina =new LaminaConFiguras();
		add(Lamina);
	}
}

class LaminaConFiguras extends JPanel
{
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);//llamamos al metodo de la clase padre(JComponent) es decir llamamos al metodo paintComponent
		                         //de la clase JPanel para que ese metodo haga su trabajo por defecto 
		
		//g.drawRect(80, 80, 200, 200);//g es objeto de tipo Graphics y el metodo drawRect dibuja un rectangulo
		//g.drawLine(20, 20, 30, 40);//dibuja linea los primeros dos num son el primer punto los otros dos num el otro
		//g.drawArc(50, 100, 100,200,120,150);//dibuja un arco
		
		Graphics2D g2=(Graphics2D) g;//casting o refundicion para crear objeto de tipo Graphics2d
		
		Rectangle2D rectangulo=new Rectangle2D.Double(100,100,200,150);//instanciamos la clase rectangle2d.double ya que rectangle2d es abstracta y no se puede instanciar directamente
		g2.draw(rectangulo);//draw significa dibujar si borramos este metodo aparecera la elipse sola
		
		Ellipse2D elipse=new Ellipse2D.Double();//instancia de elipse paara que se pueda usar
		elipse.setFrame(rectangulo);//dibujamos un rectangulo ya definido antes para meter la elipse es decir es el limite
		g2.draw(elipse);//metemos la elipse en el rectangulo
		
		g2.draw(new Line2D.Double(100,100,300,250));//instanciamos directamente la linea dentro del metodo drow
		
		double  centroX=rectangulo.getCenterX();//buscamos el centro del rectangulo coordenadas x
		double centroY=rectangulo.getCenterY();// lo mismo pero coordenadas y
		
		
		
		Ellipse2D circulo= new Ellipse2D.Double();//intanciamos el circulo de tipo elipse
		circulo.setFrameFromCenter(centroX, centroX, centroX, centroY);//parametros del rectangulo del centro para ubicar el circulo
		g2.draw(circulo);
	}
}