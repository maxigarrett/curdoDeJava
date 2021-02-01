package ventanaEmergenteTipoCuadro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class joptionpane1 
{

	public static void main(String[] args)
	{
		marcoEmergente mimarco=new marcoEmergente();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setBounds(600, 250, 400, 300);
		mimarco.setVisible(true);

	}

}


class marcoEmergente extends JFrame
{
	public marcoEmergente() 
	{
		add(new laminaEmergente());
	}
}

class laminaEmergente extends JPanel
{
	public laminaEmergente() 
	{
		boton1=new JButton("boton1");
		boton2=new JButton("boton2");
		boton3=new JButton("boton3");
		boton4=new JButton("boton4");
		
		boton1.addActionListener(new accion_boton());
		boton2.addActionListener(new accion_boton());
		boton3.addActionListener(new accion_boton());
		boton4.addActionListener(new accion_boton());
		
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);

	}
	
	//clase interna
	private class accion_boton implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource()==boton1) 
			{
				JOptionPane.showMessageDialog(null, "precionaste el boton 1","titulo",JOptionPane.ERROR_MESSAGE);
			}
			
			else 
			{
				if(e.getSource()==boton2) 
				{
					JOptionPane.showInputDialog(null, "introduce mensaje","titulo",JOptionPane.WARNING_MESSAGE);
	
				}
				else 
				{
					if(e.getSource()==boton3) 
					{
						
						JOptionPane.showConfirmDialog(null, "elige opcion","confirmar",2);
					}
					else 
					{
						if(e.getSource()==boton4) 
						{
							Object[] o= {"verde","azul"};
							JOptionPane.showOptionDialog(null, "elige", "titulo", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, o, null);
							
						}
					}
				}
			}
		}
	}
	
	//variables de clase
	private JButton boton1,boton2,boton3,boton4;
}
