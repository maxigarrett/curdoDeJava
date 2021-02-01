package tarea_de_clase;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class clase_scanner 
{

	public static void main(String[] args)
    {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("ingrese su edad ");
		int i=scanner.nextInt();
		
		scanner.nextLine();
		System.out.println("ingrese su nombre ");
		String a=scanner.nextLine();
		
		JOptionPane.showMessageDialog(null," la edad que tendra el año que viene tendra " + (i+1) + " años "
				+ " y su nombre " + a + JOptionPane.INFORMATION_MESSAGE);
		
		
	}

}
