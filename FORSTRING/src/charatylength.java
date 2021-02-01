
public class charatylength 
{

	public static void main(String[] args) 
	{
		String s="esta es mi cadena";
		System.out.println(s.charAt(0));
		System.out.println(s.charAt(5));
		System.out.println(s.charAt(s.length()-1));
		
		char c;
		
		for(int i=0;i<s.length();i++)
		{
			c=s.charAt(i);
			System.out.println(i+"->"+c);
		}
	}

}
//El método charAt retorna al carácter (tipo char) ubicado en una posición determinada.
//El método length retorna la cantidad de caracteres que tiene la cadena.