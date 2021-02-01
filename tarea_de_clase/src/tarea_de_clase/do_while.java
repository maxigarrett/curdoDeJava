package tarea_de_clase;

public class do_while {

	public static void main(String[] args)
	{
		int numero=45888;
		 int digitos=0;
		 do 
		 {
			 numero/=10;
			 digitos++;
		 }
		 while(numero>0);
		 
		 System.out.println(digitos);

	}

}
