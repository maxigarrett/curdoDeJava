package treeset_deLaInterfaz_set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class prueba_treeset4_claseAnonimaInterna 
{

	public static void main(String[] args) 
	{
		//intancia de articulos
		Articulo4 primero=new Articulo4(1,"primer articulo");
		Articulo4 segundo=new Articulo4(2,"segundo articulo");
		Articulo4 tercero=new Articulo4(3,"tercer articulo");
		
		//creamos coleccion de tipo TreeSet
		Set<Articulo4> ordenaArticulos=new TreeSet<Articulo4>();
		
		//agregamos a la coleccion las intacias de Articulo4
		ordenaArticulos.add(segundo);
		ordenaArticulos.add(primero);
		ordenaArticulos.add(tercero);
		System.out.println("por orden de articulo");
		for (Articulo4 e : ordenaArticulos)
		{
			System.out.println(e.getDescripcion());
		}
		
		//creamos una clase interna propia para que guarde por orden alfabetico los Articulos
		Set<Articulo4> ordenaArticulos2=new TreeSet<Articulo4>(new Comparator<Articulo4>() 
		{

			//metodo de la interfaz Comparator
			public int compare(Articulo4 o1, Articulo4 o2)
			{
				String descripcionA=o1.getDescripcion();
				String descripcionB=o2.getDescripcion();
				
				return descripcionA.compareTo(descripcionB);
			}
			
		});
		
		
		//agregamos las intancias de Articulo4 a la coleccion nueva que ordena alfabeticamente
		ordenaArticulos2.add(tercero);
		ordenaArticulos2.add(primero);
		ordenaArticulos2.add(segundo);
		
		
		System.out.println();
		System.out.println("orden alfabetico de articulos");
		for (Articulo4 e : ordenaArticulos2)
		{
			System.out.println(e.getDescripcion());
		}
		
		
	}

}



//clase que compara con la interfaz Comparable los numeros de articulo de mayor a menor
class Articulo4 implements Comparable<Articulo4>
{

	public Articulo4(int num,String des) 
	{
		numero_Articulo=num;
		descripsion=des;
	}
	
	public String getDescripcion() 
	{
		return descripsion;
	}
	
	
	public int compareTo(Articulo4 o)
	{
		return numero_Articulo - o.numero_Articulo;
		
	}
	
	private int numero_Articulo;
	private String descripsion;
}
