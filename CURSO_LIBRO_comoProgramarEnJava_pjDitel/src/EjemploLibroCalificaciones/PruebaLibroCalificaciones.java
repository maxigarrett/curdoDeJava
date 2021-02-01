package EjemploLibroCalificaciones;

import java.util.Scanner;

public class PruebaLibroCalificaciones
{

	public static void main(String[] args)
	{
		Scanner entrada=new Scanner(System.in);
		LibroCalificaciones milibro=new LibroCalificaciones();
		
		//milibro.MuestraMensaje();
		
		//milibro.MuestraMensaje1("curso 1A ");
		
		System.out.println("escriba el nombre del curso");
		
		String nombredelcurso=entrada.nextLine();
		
		System.out.println();
		
		milibro.MuestraMensaje1(nombredelcurso);
		
	}

}
