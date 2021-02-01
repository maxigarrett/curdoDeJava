package fichero_y_directorios;

import java.io.File;

public class eliminar_archivo 
{

	public static void main(String[] args) 
	{
		File ruta2=new File("C:" + File.separator +"Users" + File.separator + "usuario" + File.separator + "Desktop"+ File.separator + "creando ficheros para acceder desde java" + File.separator + "nuevoArchivo.txt");
		
		ruta2.delete();

	}

}
