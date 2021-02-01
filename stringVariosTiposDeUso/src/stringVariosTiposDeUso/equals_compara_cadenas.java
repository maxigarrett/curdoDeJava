package stringVariosTiposDeUso;

public class equals_compara_cadenas 
{

	public static void main(String[] args)
	{
		String nombre1,nombre2;
		
		nombre1="david";
		nombre2="David";
		System.out.println(nombre1.equals(nombre2));//equals compara cadenas y dice si son iguales o no tanto en mayusculas o minusculas osea true o false
		System.out.println(nombre1.equalsIgnoreCase(nombre2));//esta ignora si una de las cadenas tiene mayusculas
	}

}
