package ejemploLibroCalificaciones2;

import java.util.Scanner;

public class uso_libroCalificaciones 
{

	public static void main(String[] args)
	{
		Scanner entrada=new Scanner(System.in);
		
		LibroCalificaciones milibro=new LibroCalificaciones();
		
		
		//muestra el valor inicial del nombre del curso es null ya que no digimos el nombre 
		//que queriamos poner ahora mas abajo llamaremos a los metodos para poner el nombre
		//del curso
		System.out.println("bienvenido al libro de calificaciones \n "+ milibro.dameNombreCurso());

		//introducimos el nombre para almacenalrlo en la variable nombre
		System.out.println("introduce el nombre del libro de calificaciones");
		String nombre=entrada.nextLine();
		
		//lammamos a la instancia de tipo LibroCalificaciones y llamamos al metodo
		//para establece el nombre del curso este metodo pide por parametro un String
		milibro.estableceNombreDelCurso(nombre);

		//con la instacia ya creda LibroCalificaciones llamamos al metodo para que muestre los
		//datos almacenados
		milibro.MuestraMensaje();

	}

}
