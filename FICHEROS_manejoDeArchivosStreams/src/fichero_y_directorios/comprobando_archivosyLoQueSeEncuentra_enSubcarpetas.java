package fichero_y_directorios;

import java.io.File;

public class comprobando_archivosyLoQueSeEncuentra_enSubcarpetas 
{

	public static void main(String[] args)
	{
		//vamos a buscar en la carpeta creando fichero para acceder desde ajava ahi tengo varios archivos
		//y subcarpeta con mas archivos
		
		
		//apunto a la carpeta que quiero acceder con constructor que pide un String de la ruta
		//el File.separator es para que la ruta sea compatible con cualquier sistema operativo asique
		//en ves de poner la barra invertida ponemos ese metodo estatico
		File ruta=new File("C:" + File.separator +"Users" + File.separator + "usuario" + File.separator + "Desktop"+ File.separator + "creando ficheros para acceder desde java");
		
		//imprimimos la ruta absoluta que pasamos por parametro y corroboramos que sea la misma
		System.out.println(ruta.getAbsolutePath());
		
		//devuelve un array de String de todos los directorios y nombres de archivos que se encuentran en la ruta 
		//especificada con el metodo list()
		String[] nombres_archivos=ruta.list();
		
		//recorremos con bucle for el array creaado para saber los ficheros o directorios que se encuentran
		//en la ruta especificada con File
		for(int i=0;i<nombres_archivos.length;i++) 
		{
			//imprime lo que recorremos
			System.out.println(nombres_archivos[i]);
			
			
			//lo que ya tenemos es almacenada la ruta de la carpeta y sus ficheros y si hay un directorio
			//OSEA otra carpeta y lo que tenemos que hacer es evaluar lo que hay en la carpeta que estamos
			//evaluando y almacenar todo lo de adentro y preguntar si hay un directorio es decir carpeta
			//para eso tendremos que utilizar a otro constructor de la clase File(String padre,String hijo);
			//primer parametro nos da la ruta de la carpeta y segundo parametro lo que hay dentro de carpeta
			File acceso_subcarpeta=new File(ruta.getAbsolutePath(),nombres_archivos[i]);
			
			//con if le decimos si hay un directorio o no con metodo isDirectory()
			if(acceso_subcarpeta.isDirectory()==true) 
			{
				//si hay un directorio que me almacene en un array los archivos que se encuentran dentro
				//de esa subcarpeta o directorio
				String[] archivo_subcarpeta=acceso_subcarpeta.list();
				
				
				//a cada vuelta de bucle evalua lo que hay en archivo_subcarpeta  que es el array de String
				//y que en ese array almacenamos los que hay en acceso_subcarpeta que es la primera carpeta
				//a la que apuntamos y imprimimos si hay una subcarpeta o directorio que evaluamos con un if
				for(int j=0;j<archivo_subcarpeta.length;j++) 
				{
					System.out.println(archivo_subcarpeta[j]);
				}
			}
		
		}
		
		
	}

}
