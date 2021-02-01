import javax.swing.JOptionPane;

public class email_correccionDeSihayMasDeUnaArroba 
{
	//mostar un mensaje si el email tine arroba es correcto y en caso de que no o tenga mas decir incorrecto y si contiene un punto
	//(.)

	public static void main(String[] args)
	{
		boolean punto=false;
		int arroba=0;
		String mail=JOptionPane.showInputDialog("introduzca el mail");
		
		//como no sabemos la longitud del email el for tiene que ir hasta menor a la longitud del email diciendole 
		// que i<mail.length() para saber que queremos buscar por ejemplo un @
		for(int i=0;i<mail.length();i++) 
		{
			//comprueba si el email tiene un @ en todas las posiciones
			if(mail.charAt(i)=='@')
			{
				arroba++;//si contiene una @ incrementa la variable a 1 y lo imprimeremos con otro if
			}
			if(mail.charAt(i)=='.')
			{
				punto=true;
			}
		}
		//si contine el caracter @(solo una) la variable arroba sera true e imprimira el mensaje
		if(arroba==1 && punto==true) 
		{
			System.out.println("el email es correcto");
		}
		
		// de lo contrario imprimira este mensaje(en caso de que aya mas de una o ninguna)
		else 
		{
			System.out.println("email incorrecto");
		}

	}

}
