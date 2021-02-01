package iteradores;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CuentasUsuario
{

	public static void main(String[] args)
	{
		Clientes cl1=new Clientes("antonio banderas","0001",200000);
		Clientes cl2=new Clientes("penelope cruz","0002",250000);
		Clientes cl3=new Clientes("rafael nadal","0003",300000);
		Clientes cl4=new Clientes("julio iglesias","0004",500000);
		
		//al sobreescribir metodo ecual y hashCode compara el n_cuenats y la clase HashSet no permite
		//duplicados entonces esta cuenta no se agregara ya que tiene el mismo num de cuentas
		Clientes cl5=new Clientes("antonio banderas","0001",200000);
		
		//creamos una coleccion para almacenar las instancias de Cliente
		Set<Clientes>clientesBanco=new HashSet<Clientes>();
		
		clientesBanco.add(cl1);
		clientesBanco.add(cl2);
		clientesBanco.add(cl3);
		clientesBanco.add(cl4);
		clientesBanco.add(cl5);
		
	//	for (Clientes clientes : clientesBanco)
	//	{
			//System.out.println(clientes.getNombre()+" "+clientes.getN_cuentas()+" "+clientes.getSaldo() +" " +clientes.hashCode());
			
			//eliminaremos un elemnto de la coleccion diciendo si el "cliente" que es el nombre de objeto
			//que le dimos para recorrer la coleccion llamada "clientesBanco" .getNombre (es decir si el
			//nombre de este clientes es) .equals(es igual a el nombre que le pasemos ya pusimos getNombre
			//que es el metodo para obtener el nombre del los elementos a recorrer)
		//	if(clientes.getNombre().equals("julio iglesias")) 
		//	{
				//le decimos quela coleccion(clientesbanco) tiene que remover o borrar(remove) lo que 
				//hay en el array que lo llmamos clientes y se lo pasamos por parametros osea elimina
				//al cliente que estamos recorriendo "julio iglesias"
		//		clientesBanco.remove(clientes);
		// }
	//	}
		
		//por eso vamos a eliminar un elemeno u objeto en base a su nombre con un iterador
		/*creamos iterdaor y le decimos que es igual a nuestra coleccion(clientesBanco).iterador()*/
		Iterator<Clientes> it=clientesBanco.iterator();
		
		while(it.hasNext()==true) 
		{
			
			String nombreCliente=it.next().getNombre();
			
			//le decimos si el nombre es igual a el objeto donde se almacena "julio iglesias" y que 
			//que hacer si se cumple la condicion es decir si en alguna instancia se encuentra este nombre
			if(nombreCliente.equals("julio iglesias")) 
			{
				//lo que va a ser es agarrar el objeto que esta examinando ahora mismo el iterador 
				//llamdao "it" y eliminarlo it.remove();
				it.remove();
			}
		}
			
		
		//recorremos elemenot a elemento para imprimir la coleccion y lanzara una excepcion y caera el
		//programa porque no podemos borrar un elemnto mientras lo recorremos  eso quiere decir la 
		//excepcion que lanza por eso para eliminar elementos es mejor usar iteradores
		for (Clientes clientes : clientesBanco) 
		{
			System.out.println(clientes.getNombre()+" "+clientes.getN_cuentas()+" "
		+clientes.getSaldo() +" " +clientes.hashCode());
			
		}
		
		
		//el metodo Iterator devuelve un objeto de tipo iterador asique creamos ese objeto y lo llamamos
		//(it) ahora hay que crear el metodo diciendole que es igual a lo que mi coleccion(clientesBanco)
		//devuelva con el metodo iterator(); 
		//el metodo esta de esta forma en la api: Iterator<E>(dato a devolver y es una intefaz) metodo iterator()
		//esta interfaz Iterator a almacenarla en (it) ya podemosusar sus metodos next(),hasnext() 
		//y remove();
		//Iterator<Clientes> it=clientesBanco.iterator();
		
		//mientras aya un siguiente elemento it es decir mientas aya cosas que recorrer(hasNext())
		//metodo que devuelve boolean si hay objetos que recorrer dara true sino false.es decir si 
		//hay 4 elementos a recorrer en este momento y va por el tercero devolvera true porque queda uno
		//mas a recorrer pero al llegar al 4 ya no hay mas por lo que devolvera false y se saldra del
		//bucle while hasnetx() devuelve false al llegar al elemento 4 porque se fija el siguiente y no
		//hay mas ya que solo creamos 4 elemntos
		//while(it.hasNext()==true) 
		//{
			//en esta variable almacenaremos el nombre del primer elemento con metodo getNombre
			//el metodo next examina el elemento que se salta es decir el que se pasa de largo y si 
			//arranca del pincipio a la primera posicion se la pasa de largo la lee y devuelve lo que hay
			//dento al llamarlo otra ves se salta el segundo elemento y lo lee y nos dice lo que hay 
			//dentro en este caso el nombre que se lo pedios con metodo getName()
			//entoces next() para leer cada elemnto primero se lo pasa de largo y al llegar al ultimo
			//es decir para leer el cuarto elemento se lo tiene que saltar pero al no v haber mas que 4
			//al saltar lanza excepcion pero lo corregimos con el bucle para que no lo lance porque next()
			//se ejecuta mientras aya elementos que recorrer(while(it.hashNext())
			//String nombreCliente=it.next().getNombre();
			
			//imprimira solo los nombre y no el resto de la informacion
			//System.out.println(nombreCliente);
			
			/*si queremos leer el numero de cuentas hacerlo seria de esta forma 
			 * String n_cuentas=it.next().getN_cuentas lo que va a ser es primero lee el string nombre
			 * despues imprime con el siguiente next salta al segundo elemnto por lo cual no va a decir
			 * el numero de cuentas del primer sino del segundo y esto es el inconveniente de usar 
			 * un iterador en este caso*/
			//String n_cuentas=it.next().getN_cuentas();
	//	}
		
		
	}

}
/*anotacion aveces es mas facil recorrer colecciones con bucle for each como aveces es mas facil 
 *recorrerlos con un iterador dependiendo de la operacion que estemos realizando va a convenir una u otra
 *porque si queremos mostrar todos los datos en este caso con el iterador se complica ya que hay que 
 *crear variables para mostrar todos los datos como n_cuentas y saldo  por eso es mas factibel el foreach
 *pero si queremos remover una instancia de esa coleccion necesitamos para hacerlo mas facil con
 *iteradores que contiene el metodo remove() aunque se puede hacer con un foreach pero lanzara excepcion
 * ya que no se puede remover elementos mientras se esta recorriendo entonces ahi entra en juego el iterador
 * entoces si queremos recorrer y ver informacion foreach para borrar un elemento un iterador en este caso */
