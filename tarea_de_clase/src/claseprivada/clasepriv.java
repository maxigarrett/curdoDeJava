package claseprivada;

public class clasepriv 
{
	private String cadena="mi cadenaaa";
	private  int a=12;

	public void metodo1() 
	{
		System.out.println("metodo privado");
	}
	
	public String damedatos() //metodo getter
	{
		return cadena;
		
	}
	public int dameentero() //metodo getter
	{
		return a;
	}
	
	public void configuracadena(String cadena) //setter
	{
		this.cadena=cadena;
	}
}
