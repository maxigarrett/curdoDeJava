package stringVariosTiposDeUso;

public class touppercaseYtolowercase 
{

	public static void main(String[] args)
	{
		String s = "Esto Es Una Cadena de caracteres";
		String sMayus = s.toUpperCase();
		String sMinus = s.toLowerCase();
		System.out.println("Original: "+s);
		System.out.println("Mayusculas: "+sMayus);
		System.out.println("Minusculas: "+sMinus);

	}

}/*Recordemos que s es un objeto. Contiene informaci�n (la cadena en s� misma) y
los m�todos necesarios para manipularla. Entre otros, los m�todos toUpperCase y
toLowerCase que utilizamos en este ejemplo para pasar la cadena original a may�sculas
y a min�sculas respectivamente.*/
