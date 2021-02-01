package stringVariosTiposDeUso;

public class substring 
{
	public static void main(String[]args) 
	{
		String frase="hoy es un dia estupendo para aprender a programar en java";
		String frase_resumen=frase.substring(29, 57);//esto quiere decir que valla desde el caracter 29 hasta el 57
		System.out.println("la frase es:   " + frase_resumen);
	}

}
