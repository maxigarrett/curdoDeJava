package clecciones_banco;


/*vamos a crear un banco o simnlaremos q temos un banco y en ese banco tendremoa los datos de 
 * una serie de clientes  concretamente en este caso vamos a crear 4 clientes cada uno de ellos 
 * con sus caracteristicas  o datos (nombre N° de cuenta saldo) una ves creados estos clientes 
 * deberemos crear una coleccion a la cual vallamos a llamar por ejemplo cuentasclentes
 * donde almacenaremos a esos cuatro clientes  que vamos a crear en este primer ejemplo
 * pasos a seguir 1-crear una clase que construya clientes con sus caracteristicas
 * pas 2- crear una coleccion donde almacenaremos a esos clientes 3-agregar objetos(clientes)
 * a la coleccion con sus metodos correspondientes 4-recorrer coleccion en busca de esos objetos
 * almacenados en su interiror para que de alguna forma podamos verlos por ejemplo en consola*/
public class banco_cliente 
{
	//con el constructor le damos un estado inicial a los campos de clase
	public banco_cliente(String nombre,String n_cuentas,double saldo)
	{
		this.nombre=nombre;
		this.n_cuentas=n_cuentas;
		this.saldo=saldo;
	}
	
		//GETTER-----------
		public String getNombre() 
		{
			return nombre;
		}
	
		public String getN_cuentas() 
		{
			return n_cuentas;
		}
	
		public double getSaldo() 
		{
			return saldo;
		}
		//fin getter----------------------
		//----------------------------------------------------------------
		//setter--------------------
		public void setNombre(String nombre) 
		{
			this.nombre=nombre;
		}
	
		public void setN_cuentas(String n_cuentas) 
		{
			this.n_cuentas=n_cuentas;
		}
	
		public void setSaldo(double saldo) 
		{
			this.saldo=saldo;
		}
		//fin setter------------------------------------------------------
	
	
	
	
		private String nombre;
		private String n_cuentas;//va como string porque no aremos operaciones matematicas
		private double  saldo;
	
}
