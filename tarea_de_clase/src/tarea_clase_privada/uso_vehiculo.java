package tarea_clase_privada;

public class uso_vehiculo
{

	public static void main(String[] args)
	{
		vehiculo micarro=new vehiculo();
		
		micarro.configura_ancho(400);
		micarro.configura_motor(1800);
		System.out.println(micarro.dame_ancho()+" "+ micarro.dame_largo()+" "+micarro.dame_ruedas()+
		" "+micarro.dame_motor());
	}

}
