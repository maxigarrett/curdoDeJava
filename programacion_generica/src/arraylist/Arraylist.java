package arraylist;



public class Arraylist
{
	//constructor que recibe por parametro un tipo entero y que hace el constructor por ejemplo le pasamos
	//un 3le estamos diciendo que el array creado dentro del constructor va a tener 3 elementos
	public  Arraylist(int z) 
	{
		//en el array de onbjetos llamados datosElementos se almacenara lo que pasemos por parametro al 
		//constructor ya que por parametro le pasamos el objeto z de tipo int que se alamaena en array 
		//de objetos
		datosElementos=new Object[z];
	}
	
	//metodo getter que se va a encargar de devolvernos un elemento en concreto de este array ya creado
	//de tal forma que a este metodo por ejemplo le decimos  pues... 1 por parametro, ese 1 se almacena en la i del metodo
	//y nos va a devolver lo que hay almacenado en la posicion  del array datosElementos
	public Object get(int i) 
	{
		return datosElementos[i];
	}
	
	//luego tenemos otro metodo add que va a resivir por parametros un tipo objeto en general  entonces le
	//vamos a pasar un objeto en concreto por parametros y ese objeto se va a alamacenar en un posicion en
	//concreto de ese array
	public void add(Object o) 
	{
		datosElementos[i]=o;
		//utilizamos variable contador que iniciamos en 0 y la vamos incrementando en 1 dentro de este
		//metodo de tal forma que si le pasamos por parametro por ejemplo 4 objetos a este metodo
		//se almacenara en la posicion 0 despues1,2 y 3
		i++;
	}
	
private Object[] datosElementos;
private int i=0;
}
