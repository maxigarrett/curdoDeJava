package stringVariosTiposDeUso;

public class UBICARCcaracteresIndexof_subindexof 
{

	public static void main(String[] args) 
	{
		String s = "Esto Es Una Cadena de caracteres";
		int pos1 = s.indexOf('E');//esta en posicion 0 porque indexof busca la posicion de la primer letra que encuentre que el usuario digite
		int pos2 = s.lastIndexOf('s');//esta busca la ultima letra que encuentre que el usuario digite esta en pos 31
		int pos3 = s.indexOf('x');//no existe esta letra retorna un valor negativo
		System.out.println(pos1);
		System.out.println(pos2);
		System.out.println(pos3);

	}

}/*El m�todo indexOf retorna la posici�n de la primera ocurrencia de un car�cter dentro
del string. Si la cadena no contiene ese car�cter entonces retorna un valor negativo.
An�logamente, el m�todo lastIndexOf retorna la posici�n de la �ltima ocurrencia del
car�cter dentro del string o un valor negativo en caso de que el car�cter no est� contenido
dentro de la cadena.*/
