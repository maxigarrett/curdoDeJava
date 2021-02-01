package listasEnlazadas_linkedlist_interfaz_list;

/*ejersicio el programa va a crear dos LinkedList una con paises y otra con capitales correspondientes
 * a los paises creados de la otra lista y luego utilizando los diferentes metodos de ListIterator
 * vamos a ser capases de agregar a la LinkedList de paises los elementos de la LinkedList de capitales
 * de tal forma que al final nos quedara una LinkedList de paises con sus respectivas capitales y para
 * practicar mas vamos veremos si somos capases de borrar las capitales de aquellos elementos que se 
 * encuentran en las posiciones pares y veremos como influye en la LinkedList de capitales y tambien
 * en la de paises ,mas especificos en los elementos que agregamos a los paises en su momento*/
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class prueba_LinkedList2
{

	public static void main(String[] args) 
	{
		//creamos coleccion tipo LinkedList
		LinkedList<String> paises=new LinkedList<String>();
		
		//agregamos los paises a la coleccion con metodo add y el nombre de la lista(paises)
		
		paises.add("España");
		paises.add("Colombia");
		paises.add("Mexico");
		paises.add("Peru");
		
		//escribimos segunda linkedList de sus capitales de los paises de la otra lista enlazada
		List<String> capitales=new LinkedList<String>();
		
		//agregamos capitales a la coleccion con metodo add
		capitales.add("Madrid");
		capitales.add("Bogota");
		capitales.add("D.F");
		capitales.add("Lima");
		//--------------hasta aca ya estas las dos listas enlazadas--------------------------

		//verificamos imprimiendo las dos listas para ver si se agregaron bien
		System.out.println(paises);
		System.out.println(capitales);
		
		//siguiente paso es agregar la lista capitales a la de paises(esta pasa de tener 4 elementos a 8)
		//para eso vamos a crear un ListIterator para poder usar sus metodos y se va a encargar tanto
		//de recorrer cada una de las listas como de añadir elemntos
		ListIterator<String> itpaises=paises.listIterator();
		ListIterator<String> itcapitales=capitales.listIterator();
		
		//ahora para agregar dentro de la primera lista los elementos que tenemos en la segunda osea las
		//capitales utilizaremos el bucle while con un condicional y utilizaremos el metodo hasnext() que
		//comprueva si hay un siguiente elemnto (y devuelve boolean) detro de la lista a evaluar y 
		//tendremos que utilizar el metodo next()devuelve el objeto de la lista que acavamos de sobrepasar
		//o de pasr de largo 
		
		//decimos al while que se fije si hay un siguiente elemento y como arrancamos desde el principio
		//si lo habra y entrara al bucle
		while(itcapitales.hasNext()==true) 
		{
			//con este if preguntamos que mientras hay un siguiente elemnto en capitales que tambien
			//se fije si hay un siguiente elemento en paises que tambien hay y si todo esto es verdad
			//lo que tiene que hacer es: el iterador que se encuentra examinando lo paises es saltar
			//una posicion con next() para ubicarnos despues del primer pais y a continuacion utilizando 
			//el metodo add decirle que agregue a ese primer pais saltado con el iterador el elemento
			//que se encuenta en la primera posicion de las capitales 
			if(itpaises.hasNext()) 
			{
				//saltamos la primer posicion del pais y queda en medio de dos paises entre el primero
				//y el segundo
				itpaises.next();
				
			}
			//una ves saltado el elemento paises le decimos que agrege a ese elemnto que acaba de saltar 
			//la capital que salte  
			itpaises.add(itcapitales.next());
			//cada vuelta de bucle pondra un pasi y agregara una capital asi hasta no haber mas elemntos
			//que eso lo corrobora el hashnext()
		}
		
		//ahora imprimira un pais con una capita correspondiente 
		//recorremos paises porque lo de capitales lo pasamos a paises y ya no contiene 4 elemntos
		//sino 8
		for (String e : paises) 
		{
			System.out.println(e);
		}
		System.out.println();//separacion porque imprimimos lo mismo
		
		//imprimimos lo mismo con for normal
		/*for(int i=0;i<paises.size();i++) 
		{
			System.out.println(paises.get(i));
		}*/
		
		
		//una ves agregados capitales a sus respectivos paises el primer objetivo esta realizado el 
		//paso es eliminar de la LinkedList de capitales las posiciones pares y como? primero hay que
		//recordar que la LinkedList capitales tenia 4 elemntos  y para poder eliminar las posiciones
		//pares vamos a tener que jugar con el iterador  pero la prefunta fundamental es dato fundamental
		//que nos tenemos que dar cuenta es que el iterador de esta lista se encuentra actualmente
		//en el final  o la ultima posicion.¿ y poruq e se encuentra ahi? pues porque hemos estado 
		//utilizando el metodo next varias veces y con eso hemos conseguido que el iterador fuera saltando
		//dentro de las capitales hasta llegar al ultimo lugar y si queremos elminiar las posiciones
		//pares tenemos que agarrar ese iterador y volverlo al principio(subirlo) para una ves ahi 
		//de alguna forma poder comensar otra ves a ir hacia abajo eliminado los pares.
		//pero como? y una forma  sencilla es iniciando de nuevo el iterador es decir ya lo tenemos
		//iniciado y alamacenado en la variable itcapitales entonces ya lo tenemos declarado e iniciado
		//entonces si volvemos a iniciarlo otra vez volvera a su posicion original o inicial
		itcapitales=capitales.listIterator();//cuelve a su posicion inicial
		
		//eliminamos lacapitales pares de esta manera: hacemos devuelta un bucle while y le diriamos
		//oye mira mientras haya un elemento(hashNext) agarras y vas a saltar la siguiente posicion
		//(next) 
		while(itcapitales.hasNext()==true) 
		{
			//le decimos que salte a la siguiente posicion y una ves saltado con un condicional if
			//que evalue despues de haberlo saltado una posicion mas si hay otra posicion
			itcapitales.next();
			
			//le decimos una ves saltada la posicion primera de capitales si hay otra a saltar
			if(itcapitales.hasNext()==true) 
			{
				//le decimos que salte de nuevo y le removemos
				itcapitales.next();
				itcapitales.remove();//removemos y quequeda con los impare osea primer posicion y la 
										//tercera
			}
			
		}
		
		//imprimimos capitales inpares ya que removimos las pares
		for (String e : capitales)
		{
			System.out.println(e);
		}
		
		//vamos a remover el resto de capitales es decir eliminar de esta coleccion las capitales ya que
		//usaremos metodo removeAll() que remueve colecciones (va a eleminar la lista capitales) lo que
		//queda de las capitales ya que removios a las pares (Madrid y Lima)
		paises.removeAll(capitales);
		
		System.out.println(paises);
		
	}

}
