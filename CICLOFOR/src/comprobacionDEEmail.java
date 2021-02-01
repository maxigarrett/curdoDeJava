import javax.swing.JOptionPane;

public class comprobacionDEEmail
{

	public static void main(String[] args) 
	{
		boolean arroba=false;
		String mail=JOptionPane.showInputDialog("introduzca el mail");
		
		//como no sabemos la longitud del email el for tiene que ir hasta menor a la longitud del email diciendole 
		// que i<mail.length() para saber que queremos buscar por ejemplo un @
		for(int i=0;i<mail.length();i++) 
		{
			//comprueba si el email tiene un @ en todas las posiciones
			if(mail.charAt(i)=='@')
			{
				arroba=true;
			}
		}
		//si contine el caracter @ la variable arroba sera true e imprimira el mensaje
		if(arroba==true) 
		{
			System.out.println("el email es correcto");
		}
		
		// de lo contrario imprimira este mensaje
		else 
		{
			System.out.println("email incorrecto");
		}
	}

}
