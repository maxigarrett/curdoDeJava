package listasEnlazadas_linkedlist_interfaz_list;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class prueba_LinkedList 
{

	public static void main(String[] args) 
	{
		//creamos la LinkedList es paracedia a la ArrayList pero mejor en temas de eficiencia y 
		//mejor para agregar o borrar elementos con sus respectivos datos e informacion
		//asique vamos a crear una instancia perteneciente a esta clase LiskedList que implementa la
		//interfaz List como tambien la implementa los ArrayList esta linkedlist es generica es decir
		//esta puede recibir cualquier tipo de objetos menos primitivos o pueden resivir datos que esten
		//predefinidas en la API como en este caso un String
		
		List<String> personas=new LinkedList<String>();//creamos la coleccion de tipo list 
		
		//ahora agregamos con metodo add los String que deseemos con el metodo add que implementa esta 
		//clase este linkedlist implementa la interfaz List que permite que se agreguen de forma oredenada
		//es decir se agrega igual a como lo agreguemos nosotros y a la hora de imprimirlos no se
		//desordenan
		personas.add("pepe");
		personas.add("sandra");
		personas.add("ana");
		personas.add("laura");
		
		
		
		//si despues de imprimir los elementos que tiene agregamos uno mas .esta clase agregara  igualmente
		//y en el ultimo lugar es decir en el orden que vallamos agregando se colocaran estos elementos
		
		/*personas.add("juan");*/
		
		//si queremos agregar uno en alguna posicion usamos el otro metodo add que por parametro resive
		//la posicion a colocar y el elemnto este a pesar de que se agrego ultimo le decimos que valla
		//a la posicion 0 es decir al primer lugar sin remplazar al que esta ahi solo se corre al siguiente
		//posicionamiento automaticamente
		
		/*personas.add(0, "Jose");*/
		
		
		//para agregar en una LinkedList muy compleja en java y se realizaron muchisimas operaciones es decir
		//se han agregado muchos elementos  y se an eliminados muchos otros y le han cambiado la posicion y 
		//es mas que probable no saber en que indice deseamos insertar un elemnto pero si sabemos a 
		//continuacion de cual en ese caso hay que trabajar con iteradores pero no con la que ya vimos(Iterator)
		//que implementa los metodos hasnext() next() y remove() que estos sirven para trabajar con HashSet
		//de la interfaz Set porque no llevan orden ninguno y como no lo llevan esos tres metodos sirven
		//pero cuando ya estoy manejando una lista  que si lleva un ordenamiento estos tres metodos no me 
		//sirven  porque a lo mejor queremos movernos hacia atras y la interfaz "Iterator" solo nos permite
		//movernos hacia adelante esta INterfaz nos dice que tambien usa "ListIterator" y esta interfaz
		//si que tiene bastantes metodos mas que permiten mover al siguiente(nextIndex()), moverme al 
		//anterior(previusIndex()), remover algun elemnto(remove()), preguntar si hay algun elemento mas
		//hacia adelante(hashNext()) tambien utiliza metodos de la interfaz Iterator que son ya los tres
		//mencionados
		
		//creamos nuestro ListIterator y ya nos permite usar todos sus metodos , perosonas es el nombre de la 
		//coleccion creada con LinkedList
		ListIterator<String> it=personas.listIterator();
		
		//con esto nos emos desplazado una posicion hacia adelante dentro de nuestra LinkedList es decir
		//nuestra lista consta de 4 elementos y con next() le decimos que se mueva o salte la posicion
		//inicial por lo que estara entre la posicion 0 y 1 entre pepe y sandra
		it.next();
		//entonces  con el objeto creado de listiterator llamado it le decios que ponga a juan entre 
		//la posicion de pepe 0  y sandra 1 por lo que quedara pepe0 juan1 sandra2
		it.add("juan");
		
		
		//para saber la cantidad de elemntos utilisaremos el metodo size() que implementa esta clase 
		//LinkedList
		System.out.println("la cantidad de elementos son: "+personas.size());
				
		//imprimimos los datos
		for (int i=0;i<personas.size();i++) 
		{
			System.out.println("y sus datos son: " +personas.get(i));
			
		}
		//cualquiera de las dos formas es lo mismo 
		/*for (String e : personas) 
		{
			System.out.println("y sus datos son: " +e);
		}*/

	}

}
