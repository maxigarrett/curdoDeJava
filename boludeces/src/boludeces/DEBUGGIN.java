package boludeces;

import javax.swing.JOptionPane;

public class DEBUGGIN 
{

	public static void main(String[] args)
	{
		int elemento=Integer.parseInt(JOptionPane.showInputDialog("introduce los elementos de la matriz"));
		
		int num_ale[]=new int[elemento];
		
		for(int i=0;i<num_ale.length;i++) 
		{
			num_ale[i]=(int)(Math.random()*100);
		}
		
		for(int elem: num_ale) 
		{
			System.out.println(elem);
		}

	}

}
