package graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TrabajandoConFuentes 
{

	public static void main(String[] args)
	{
		MarcoConFuente mimarco=new MarcoConFuente();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoConFuente extends JFrame
{
	public MarcoConFuente()
	{
		setTitle("ventana con fuente");
		setSize(400,300);
		setLocation(400,400);
		setVisible(true);
		LaminaConFuente milamina=new LaminaConFuente();
		add(milamina);
		milamina.setForeground(Color.BLUE);//establece el color que escribamos en la lamina
		milamina.setBackground(Color.cyan);
	}
}

class LaminaConFuente extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;
		
		Font mifuente=new Font("courier",Font.BOLD,26);//nombre de tipo de letra estilo de la letra negrita que seria 
		                                 //BOLD al ser estatica lleva el nom de la clase adelante y el tamaño es 26
		
		g2.setFont(mifuente);//metodo hace que permitir establecer el tipo de letra almacenado en mifuente 
		g2.setColor(Color.black);
		g2.drawString("maxi", 100, 100);//escribe mi nombre y en cordenadas 100 100
		
		g2.setFont(new Font("Arial",Font.BOLD,35));
		g2.setColor(new Color(100,34,128).brighter());//nomenclatura rgb 
		g2.drawString("maxi garrett", 100, 150);
	}
}