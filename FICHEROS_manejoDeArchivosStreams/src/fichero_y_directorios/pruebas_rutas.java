package fichero_y_directorios;

import java.io.File;

public class pruebas_rutas 
{

	public static void main(String[] args) 
	{
		//creamos ruta que no existe para en este caso saber si existe o no con los metodos correspondiente
		//el archivo 
		File archivo=new File("archivo.txt");
		
		//el metodo getAbsolutePath() te indica la ruta absoluta si le damos play al programa imprime la 
		//ruta donde se encuentra este programa porque el archivo no existe ya que la ruta que pusimos 
		//no corresponde a ninguna
		System.out.println(archivo.getAbsolutePath());
		
		//comprobamos con el metodo exist() si la ruta existe o no
		
		System.out.println(archivo.exists());//lanza el false ya que no existe el archivo si existe un true
		
		
		
	}

}


