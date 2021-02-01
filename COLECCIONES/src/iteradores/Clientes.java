package iteradores;

public class Clientes 
{
	public Clientes(String nombre,String n_cuentas,double saldo) 
	{
		this.nombre=nombre;
		this.n_cuentas=n_cuentas;
		this.saldo=saldo;
	}

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getN_cuentas() {
		return n_cuentas;
	}
	public void setN_cuentas(String n_cuentas) {
		this.n_cuentas = n_cuentas;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	//------------fin getter y setter--------------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((n_cuentas == null) ? 0 : n_cuentas.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clientes other = (Clientes) obj;
		if (n_cuentas == null) {
			if (other.n_cuentas != null)
				return false;
		} else if (!n_cuentas.equals(other.n_cuentas))
			return false;
		return true;
	}



	private double saldo;
	private String nombre,n_cuentas;
}
