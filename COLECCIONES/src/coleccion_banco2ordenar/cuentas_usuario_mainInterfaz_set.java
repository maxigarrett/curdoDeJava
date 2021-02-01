package coleccion_banco2ordenar;

import java.util.HashSet;
import java.util.Set;

public class cuentas_usuario_mainInterfaz_set 
{

	public static void main(String[] args)
	{

		banco_cliente cl1=new banco_cliente("antonio banderas","0001",200000);
		banco_cliente cl2=new banco_cliente("rafael nadal","0002",250000);
		banco_cliente cl3=new banco_cliente("penelope cruz","0003",300000);
		banco_cliente cl4=new banco_cliente("julio iglesias","0004",500000);
		//si agregamos una instancia igual a otra no se impimira porque la interfaz set no permite repetidos
		//pero lo imprimira igual ya que el metodo add encargado de agregar y diferenciar si son iguales o no
		//los agregara poruq epara el son diferentes y vamos a usar la clase libro para entedender porque
		//los imprime igual
		//una ves entendido lo de la clase libro hay que ir a banco_clientes y sobreescribir el metodo equals
		//y hasCode y recordar que si podemos tener un nombre igual en la cuenta con un saldo igual pero no
		//que tenga el mismo numero de cuenta por eso solo sobreescribimos el metodo equal y hasCode para esa
		//variable el codigoHascode le vamos a decir que es el numero de cuenta y si sin iguales que no lo 
		//repita asi no saldra esta copia identica
		banco_cliente cl5=new banco_cliente("antonio banderas","0001",200000);
		
		
		
		Set<banco_cliente> clientes_banco=new HashSet<banco_cliente>();
		
		clientes_banco.add(cl1);
		clientes_banco.add(cl2);
		clientes_banco.add(cl3);
		clientes_banco.add(cl4);
		clientes_banco.add(cl5);	
		
		for (banco_cliente cliente : clientes_banco)
		{
			
			System.out.println(cliente.getNombre()+" "+cliente.getN_cuentas()+" "+cliente.getSaldo() +" " +cliente.hashCode());
			
			
		}
		
		System.out.println(cl1.hashCode());
		System.out.println(cl2.hashCode());
		System.out.println(cl3.hashCode());
		System.out.println(cl4.hashCode());
	}

}
