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

}/*El método indexOf retorna la posición de la primera ocurrencia de un carácter dentro
del string. Si la cadena no contiene ese carácter entonces retorna un valor negativo.
Análogamente, el método lastIndexOf retorna la posición de la última ocurrencia del
carácter dentro del string o un valor negativo en caso de que el carácter no esté contenido
dentro de la cadena.*/
