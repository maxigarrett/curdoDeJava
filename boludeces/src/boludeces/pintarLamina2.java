package boludeces;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class pintarLamina2 
{

	public static void main(String[] args)
	{
		marco2 mimarco=new marco2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setBounds(600, 200, 400, 340);
		mimarco.setVisible(true);

	}

}

class marco2 extends JFrame
{
	public marco2()
	{
		setTitle("pintando marco");
		add(new lamina2());
	}
}

class lamina2 extends JPanel
{
	public lamina2()
	{
		JButton rojo=new JButton("rojo");
		JButton amarillo=new JButton("amarillo");
		JButton verde=new JButton("verde");
		
		add(rojo);
		add(amarillo);
		add(verde);
		
		pinta colorrojo=new pinta(Color.RED);
		pinta coloramarillo=new pinta(Color.YELLOW);
		
		
		rojo.addActionListener(colorrojo);
		amarillo.addActionListener(coloramarillo);
		verde.addActionListener(new pinta(Color.GREEN));
		
		

	}
	
	private class pinta implements ActionListener
	{
		
		public pinta(Color color) 
		{
			this.color=color;
		}
		public void actionPerformed(ActionEvent e) 
		{
			setBackground(color);
			
		}
		
		private Color color;
		
	}
}

