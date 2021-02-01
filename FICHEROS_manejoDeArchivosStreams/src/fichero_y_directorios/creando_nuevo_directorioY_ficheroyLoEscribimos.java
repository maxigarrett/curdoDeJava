package fichero_y_directorios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class creando_nuevo_directorioY_ficheroyLoEscribimos 
{

	public static void main(String[] args)
	{
		//vamos a crear nuevo directorio o carpeta  dentro de la carpeta:
		//"creando ficheros para acceder desde java"
		File ruta=new File("C:" + File.separator +"Users" + File.separator + "usuario" + File.separator + "Desktop"+ File.separator + "creando ficheros para acceder desde java" + File.separator + "nuevoDirectorioCreadoDesdeJava");
		
		
		//con este metodo creamos nuevo directorio o carpeta
		ruta.mkdir();
		
		
		
		//creamos archivo 
		File ruta2=new File("C:" + File.separator +"Users" + File.separator + "usuario" + File.separator + "Desktop"+ File.separator + "creando ficheros para acceder desde java" + File.separator +"nuevoDirectorioCreadoDesdeJava"+ File.separator + "nuevoArchivo.txt");
		
		//almacenamos dentro de la variable String la ruta de la carpeta y esa ruta se la pasamos al
		//metodo escribir
		String archivo_destino=ruta2.getAbsolutePath();
		
		try 
		{
			//este metodo crea el archivo especificado en ruta2 siempre y cuando no exista y lanza excepcion
			ruta2.createNewFile();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		escribiendo accede_es=new escribiendo();
		
		//le pasamos por parametro el String que pide el metodo y que ese nombre es donde se almacena la
		//ruta del destino del archivo
		accede_es.escribir(archivo_destino);
	}
	
}

class escribiendo
{
	public void escribir(String ruta_archivo) 
	{
		String frase="esto es un ejemplo";
		
		try 
		{
			FileWriter escritura=new FileWriter(ruta_archivo);
			
			for(int i=0;i<frase.length();i++) 
			{
				escritura.write(frase.charAt(i));
				
				
			}
			escritura.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
}
