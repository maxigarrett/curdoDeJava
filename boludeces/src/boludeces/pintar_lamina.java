package boludeces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class pintar_lamina
{

	public static void main(String[] args)
	{
		marco3 mimarco= new marco3();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setBounds(600,200,400,300);
		mimarco.setVisible(true);
	}

}

class marco3 extends JFrame
{
	public marco3() 
	{
		
		lamina3 milamina=new lamina3();
		add(milamina,BorderLayout.CENTER);
	}
}

class lamina3 extends JPanel
{
	public lamina3() 
	{
		setLayout(new BorderLayout());
		
		JPanel lam=new JPanel();
		
		crearbotones(lam,"rojo",new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setBackground(color);
				cambiacolor(Color.red);
			}
		});
		
		crearbotones(lam,"amarillo",new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cambiacolor(Color.yellow);
				setBackground(color);
			}
		});
		
		crearbotones(lam,"verde",new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setBackground(color);
				cambiacolor(Color.GREEN);
			}
		});
		add(lam,BorderLayout.SOUTH);
	}
	
	public void crearbotones(Container c,String titulo,ActionListener oyente)
	{
		JButton boton=new JButton(titulo);
		c.add(boton);
		boton.addActionListener(oyente);
		
	}
	public void cambiacolor(Color c) 
	{
		color=c;
	}
	private Color color;
}