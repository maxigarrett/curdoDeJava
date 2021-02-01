package parcial;

public class clase_paciente
{
	private int nroPaciente;
	private int edad;
	private String nombre;
	private String apellido;
	private String direccion;
	
	
	public clase_paciente(int nroPaciente,int edad,String nombre,String apellido,String direccion) 
	{
		this.nroPaciente=nroPaciente;
		this.edad=edad;
		this.nombre=nombre;
		this.apellido=apellido;
		this.direccion=direccion;
	}
	
	
	public void muestraPaciente() 
	{
		System.out.println("numpaciente: "+ nroPaciente +" edad: " +edad+" nombre :"+nombre+" apellido :"+ apellido+" direccion: "+direccion);
	}

}
