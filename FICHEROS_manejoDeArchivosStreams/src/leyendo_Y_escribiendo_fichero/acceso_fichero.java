package leyendo_Y_escribiendo_fichero;

import java.io.FileReader;
import java.io.IOException;

public class acceso_fichero 
{

	public static void main(String[] args) 
	{
		leer_fichero fichero=new  leer_fichero();
		try 
		{
			fichero.lee();//llammos al metodo creado en la clase 
		} 
		catch (miExcepcion e)
		{
			
			e.printStackTrace();
		}
		
	}

}

//clase que leer el fichero externo y tendremos que utilizar la clase Reader y escribir se utiliza Writer
//la clase que hereda de reader es inputstreamreader y tiene una subclase llamada filereader 
class leer_fichero 
{
	public void lee() throws miExcepcion
	{
		try 
		{
			FileReader entrada=new FileReader("C:/Users/usuario/Desktop/creando ficheros para acceder desde java/ejemplo.txt");
			//con esto le decimos que guarde dentro de un entero el codigo del primer caracter que se encuentra
			//dentro del fichero
			int c=entrada.read();
			
			
			//el metodo read devuelve -1 cuando llega al final asique se seguira repitiendo mientras sea
			//distinto de -1
			while(c!=-1) 
			{
				//guarde nuevamente en c el caracter que este evaluando a cada momento
				c=entrada.read();
				
				char letra=(char) c;//casting para pasar de intero a caracter para ser legible
				
				System.out.print(letra);
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
			
			private static final long serialVersionUID = 1L;
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