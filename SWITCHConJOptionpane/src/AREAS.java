import java.util.*;
import javax.swing.*;
public class AREAS 
{

	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("elige una opcion: \n1:cuadrado\n2:rectangulo\n3:triangulo\n4:circulo\n");
		int op=scanner.nextInt();
		
		switch(op) 
		{
			case 1:
			{
					//clase Integer metodo parseInt
				int lado=Integer.parseInt(JOptionPane.showInputDialog("introduce el lado"));
				JOptionPane.showMessageDialog(null,"el area del cuadrado es " + Math.pow(lado,2) + JOptionPane.INFORMATION_MESSAGE);
				break;
			}	
			case 2:
			{
				int base=Integer.parseInt(JOptionPane.showInputDialog("introduce base"));
				int altura=Integer.parseInt(JOptionPane.showInputDialog("introduce altura"));
				System.out.println("el area del rectangulo  es " + base*altura);
				break;
			}
			case 3:
			{
				int base=Integer.parseInt(JOptionPane.showInputDialog("introduce base"));
				int altura=Integer.parseInt(JOptionPane.showInputDialog("introduce altura"));
				JOptionPane.showMessageDialog(null,"el area del triangulo es " + (base*altura)/2);
				break;
			}
			case 4:
			{
				int radio=Integer.parseInt(JOptionPane.showInputDialog("introduce el radio"));
				System.out.print("el area del circulo es ");
				System.out.printf("%1.2f", Math.PI*(Math.pow(radio, 2)));
			}
		
		}

	} 

}
