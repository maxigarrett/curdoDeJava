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

}/*Recordemos que s es un objeto. Contiene información (la cadena en sí misma) y
los métodos necesarios para manipularla. Entre otros, los métodos toUpperCase y
toLowerCase que utilizamos en este ejemplo para pasar la cadena original a mayúsculas
y a minúsculas respectivamente.*/
