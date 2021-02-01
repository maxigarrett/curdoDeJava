package treeset_deLaInterfaz_set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class prueba_treeset3
{

	public static void main(String[] args) 
	{
		Articulo3 primero=new Articulo3(1,"primer articulo");
		Articulo3 segundo=new Articulo3(2,"segundo articulo");
		Articulo3 tercero=new Articulo3(3,"tercer articulo");

		Set<Articulo3> ordenaArticulos= new TreeSet<Articulo3>();
		
		ordenaArticulos.add(primero);
		ordenaArticulos.add(tercero);
		ordenaArticulos.add(segundo);
		
		for (Articulo3 e : ordenaArticulos) 
		{
			System.out.println(e.getDescripcion());
		}
		
		
		//intanciamos clase que implementa la interfaz Comparator
		comparador micomparador=new comparador();
		
		Set<Articulo3> ordenaArticulos2= new TreeSet<Articulo3>(micomparador);
		
		ordenaArticulos2.add(primero);
		ordenaArticulos2.add(segundo);
		ordenaArticulos2.add(tercero);
		
		System.out.println();
		System.out.println("imprime por orden alfabetico los articulos");
		for(Articulo3 e:ordenaArticulos2) 
		{
			System.out.println(e.getDescripcion());
		}
		
	}

}

//clase que compara con la interfaz Comparable los numeros de articulo de mayor a menor
class Articulo3 implements Comparable<Articulo3>
{

	public Articulo3(int num,String des) 
	{
		numero_Articulo=num;
		descripsion=des;
	}
	
	public String getDescripcion() 
	{
		return descripsion;
	}
	
	
	public int compareTo(Articulo3 o)
	{
		return numero_Articulo - o.numero_Articulo;
		
	}
	
	private int numero_Articulo;
	private String descripsion;
}

//clase que implementa la interfaz Comparator para compara de menor a mayor alafabeticamente los String
//o descripcion de cada articulo 
class comparador implements Comparator<Articulo3>
{
	public int compare(Articulo3 a1, Articulo3 a2) 
	{
		String descripcionA=a1.getDescripcion();
		String descripcionB=a2.getDescripcion();
		
		return descripcionA.compareTo(descripcionB);
	}
}