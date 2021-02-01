package clecciones_banco;

import java.util.HashSet;
import java.util.Set;

public class cuentas_usuarios_main
{

	public static void main(String[] args)
	{
		//creamos los clientes primer paso
		banco_cliente cliente1=new banco_cliente("antonio banderas", "00001", 200000);
		banco_cliente cliente2=new banco_cliente("rafael nadal","00002",250000);
		banco_cliente cliente3=new banco_cliente("penelope cruz","00003",300000);
		banco_cliente cliente4=new banco_cliente("julio iglesias","00004",350000);
		//si agregamos una instancia igual a otra no se impimira porque la interfaz set no permite repetidos
		//pero lo imprimira igual ya que el metodo add encargado de agregar y diferenciar si son iguales o no
		//los agregara poruq epara el son diferentes y vamos a usar la clase libro para entedender porque
		//los imprime igual
		banco_cliente cliente5=new banco_cliente("antonio banderas", "00001", 200000);
		
		//creamos la coleccion tenenmos que crear una coleccion que no permita la repeticion de 
		//clientes ya que la interfaz Collection dispone de diferentes interfaces com 1-list: esta
		//interfaz permite el acceso aleatorio a esas cuentas de clientes,estan ordenadas, pueden
		//añadir o eliminar clientes,ListIterator modifica en cualquier direccion sintaxis similar 
		//al array esta la interfaz 2-set:no permite elementos duplicados,uso sencillo del metodo 
		//add que ademas asegura no elementos duplicados 3-Maps: asociasion clave->valor no claves
		//iguales 4-queues: muy rapida al acceder al primer y ultimo elemento permite crear colas
		//de elementos muy eficientes(LIFO/LIFO) cada interfaz conlleva usa serie de clases que 
		//sirven para mejor lectura otras para escritura , es decir cada clase tiene sus ventajas
		//inconvenirntes , como su utilidad
		
		//utilizaremos interfaz de tipo Set ya que se adecua porque no queremos ordenar la lista de 
		//clientes, la clase que se adecua hasta interfaz ahora es la clase HashSet porque es
		//rapida no permite duplicados, no se permite ordenar, no tiene acceso aleatorio 
		
		//al no poder instanciar una interfaz directamente necesitamos una clase que implemente
		//esta interfaz para poder usarla y la que se adecua como ya mencionamos es HashSet
		//es lo mismo en ves de poner set poner HashSet segundo paso crear coleccion
		Set<banco_cliente> clientes_banco=new HashSet<banco_cliente>();
		
		//esta interfaz set tiene un metodo add(E e) que permite agregar objetos del tipo generico 
		//que le hemos indicado a la interfaz//tercer paso agregar los objetos de tipo banco_clientes
		//a la colleccion banco_clientes
		//es decir agregamos los objetos creados de banco_cliente a la coleccion
		clientes_banco.add(cliente1);
		clientes_banco.add(cliente2);
		clientes_banco.add(cliente3);
		clientes_banco.add(cliente4);
		clientes_banco.add(cliente5);
		//recorrer la coleccion paso 4
		for(banco_cliente cliente: clientes_banco) 
		{	
			//usamos los metodos getters para mostrar la informacion al instancia de la clase banco_cleinte
			System.out.println(cliente.getNombre() + " " + cliente.getN_cuentas()+" "+cliente.getSaldo() );
		}
		
	}

}


