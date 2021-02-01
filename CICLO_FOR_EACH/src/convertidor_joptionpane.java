import javax.swing.JOptionPane;

public class convertidor_joptionpane 
{

	public static void main(String[] args) 
	{
		String paises[]=new String[8];
		
		for(int i=0;i<8;i++) 
		{
			paises[i]=JOptionPane.showInputDialog("introduce el nombre del pais"+ (i+1));
		}
		for(String elemento:paises) 
		{
			System.out.println(elemento);
		}

	}

}
