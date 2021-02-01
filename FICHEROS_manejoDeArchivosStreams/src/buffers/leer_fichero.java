package buffers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class leer_fichero
{

	public static void main(String[] args) 
	{

		leer_fichero1 fichero=new  leer_fichero1();
		try 
		{
			fichero.lee1();//llammos al metodo creado en la clase 
		} 
		catch (miExcepcion e)
		{
			
			e.printStackTrace();
		}
		
	}

}


class leer_fichero1 
{
	public void lee1() throws miExcepcion
	{
		try 
		{
			FileReader entrada=new FileReader("C:/Users/usuario/Desktop/creando ficheros para acceder desde java/ejemplo.txt");
			
			//creamos el buffer para acceder a archvos que contengan muchas lineas de caracteres
			//por parametros pide un objeto de tipo Reader que ya lo tenemos y se almacena entrada
			BufferedReader mibuffer=new BufferedReader(entrada);
			
			String linea="";
		
			//se saldra si ya no hay lineas de caracteres osea null
			while(linea!=null) 
			{
				//le decimos que linea es igual a mibuffer( lo que hay almacenado en el buffer es decir
				//el fichero externo creado anteriormente con Filereader) entonces la primera ves que entra
				//en el bucle lo primero que va hacer es almacenar en linea(String vacio) la primera linea
				//readLine() que se encuentre en el buffer
				linea=mibuffer.readLine();
				
				if(linea!=null) //para q no imprima el null al final de todo
				{
					System.out.println(linea);
				}	
			}
			
			entrada.close();
		} 
		
		catch (IOException e) 
		{
			System.out.println("no se ah encontrado el archivo");
			throw new miExcepcion("el caracter lo cambiaste");
			
			
		}	
		
		
	}
}


//creamos nuestra propia clase para capturar una excepcion si el usuario pone menos de tres caracteres
		class miExcepcion extends IOException
		{
			//se recomienda usar dos constructores uno estandar y otro con un String
			public miExcepcion() 
			{
				
			}
			//el segundo le pasamos por parametro el String
			public miExcepcion(String msj_error) 
			{
				//llamamos al constructor de la clase padre y le pasamos por parametro lo que se almacena
				//en msj error este segundo cuando coloquemos con throw donde querramos al pasarle por 
				//parametros un mensaje llamara a este constructor y no al otro y se imprimira como error
				//en consola para orientar al programador
				super(msj_error);
			}
		}