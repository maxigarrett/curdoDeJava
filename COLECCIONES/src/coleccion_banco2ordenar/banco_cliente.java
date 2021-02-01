package coleccion_banco2ordenar;

public class banco_cliente
{
	public banco_cliente(String nombre,String n_cuentas,double saldo) 
	{
		this.nombre=nombre;
		this.n_cuentas=n_cuentas;
		this.saldo=saldo;
	}
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	public String getN_cuentas()
	{
		return n_cuentas;
	}
	public void setN_cuentas(String n_cuentas) 
	{
		this.n_cuentas = n_cuentas;
	}
	public double getSaldo()
	{
		return saldo;
	}
	public void setSaldo(double saldo)
	{
		this.saldo = saldo;
	}
	
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((n_cuentas == null) ? 0 : n_cuentas.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) 
	{
		if(obj instanceof banco_cliente) 
		{
			banco_cliente otros=(banco_cliente)obj;
			if(this.n_cuentas==otros.n_cuentas) 
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		else 
		{
			return false;
		}
	}


	private String nombre;
	private String n_cuentas;
	private double saldo;
}
