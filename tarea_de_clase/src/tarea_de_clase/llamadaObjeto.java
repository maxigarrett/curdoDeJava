package tarea_de_clase;

public class llamadaObjeto 
{

	public static void main(String[] args)
	{
		orientada_a_objetos objeto =new orientada_a_objetos();
		orientada_a_objetos objeto2=new orientada_a_objetos();
		
		objeto.x=5;
		objeto.y=10;
		objeto.imprimirobjeto();
		objeto2.x=6;
		objeto2.y=8;
		objeto2.imprimirobjeto();
		
		int suma=objeto2.sumar_xy();
		System.out.println("la suma es"+suma);
	}

}
