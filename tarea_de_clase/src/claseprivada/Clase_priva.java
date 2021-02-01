package claseprivada;

public class Clase_priva
{

	public static void main(String[] args)
	{
		clasepriv miclase=new clasepriv();
		
		System.out.println(miclase.damedatos());
		System.out.println(miclase.dameentero());
		
		miclase.configuracadena("maxi");
		System.out.println(miclase.damedatos());
	
		
	}

}
