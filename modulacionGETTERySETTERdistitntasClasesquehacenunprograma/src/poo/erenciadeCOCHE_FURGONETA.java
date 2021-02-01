package poo;

public class erenciadeCOCHE_FURGONETA extends coche/*erenciadecoche furgoneta ereda las variables
de coche con la palabra reservada extends y el nombre de la clase que seria coche  a la clase 
furgoneta se le llama subclase y coche superclase ya que la clase superior es clase coche
 y furgoneta ereda las variables de coche*/
{
	private int capacidad_carga;
	private int asientos_extras;
	
	public erenciadeCOCHE_FURGONETA(int capacidad_carga,int asientos_extras)
	{
		super();//llama al constructor de la clase padre que seria coche pero hay que llamrla antes con el
		//extends anteriormente echo 
		
		this.capacidad_carga=capacidad_carga;
		this.asientos_extras=asientos_extras;
	}
	
	public String dime_furgoneta()
	{
		return"la capacidad de carga es " + capacidad_carga + " y sus asientos extras son "+asientos_extras;
	}

}
