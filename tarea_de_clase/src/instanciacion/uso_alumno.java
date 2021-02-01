package instanciacion;

public class uso_alumno 
{

	public static void main(String[] args)
	{
		alumno[] vector=new alumno[3];
		
		vector[0]=new alumno("maxi "," garrett ",36361180);
		vector[1]=new alumno("Juan","Perez",5566);
		vector[2]=new alumno("pepe","alvarez",134891);
		
		//recorremos con un for y mostramos la informacion
		
		for(int i=0;i<3;i++) 
		{
			//imprimimos lo almacenado por parametros en el metodo
			vector[i].imprimeAlumno();
		}


		


	}

}
