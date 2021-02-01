import javax.swing.*;
public class for_factorialdeunNumero 
{

	public static void main(String[] args) 
	{
		int  resultado=1;
		int numero=Integer.parseInt(JOptionPane.showInputDialog("introduce un numero"));
		
		for(int i=numero;i>0;i--) 
		{
			resultado=resultado*i;
		}
		System.out.println("el factorial de " + numero + " es " + resultado);
	}
	

}
