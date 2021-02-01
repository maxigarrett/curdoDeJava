package stringVariosTiposDeUso;
import javax.swing.JOptionPane;
public class TareaStringlengthcharrAT 
{
	public static void main(String[] arg) 
	{
		
		String nombre="maximiliano";
		//se acumula el numero de caracteres que existe arranca de 1 hasta la cantidad de caracteres
		int nombre2= nombre.length();
		//el metodo charAt busca el caracter que el susario quiera por medio de un numero
		// pero alamcene la cantidad de caracteres en el metodo length y como chsarAt arranca de 0 hay que restarle uno a la
		//variable nombre2 que esta acumulado la cantidad de caracteres
		JOptionPane.showMessageDialog(null,"la ultima letra de nombre es:  " + nombre.charAt(nombre2-1));
		
		
	}

	

}
