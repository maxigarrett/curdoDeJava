package leyendo_Y_escribiendo_fichero;

import java.io.FileWriter;
import java.io.IOException;

public class escribirFichero 
{

	public static void main(String[] args)
	{
		escribiendo acceso=new escribiendo();
		acceso.escribir();
	}

}

class escribiendo
{
	public void escribir() 
	{
		String frase=" esto es una prueb de escritura2 ";
		
		try 
		{
			//intancia de constructor que pide un destino para crear el fichero con el String ya creado arriba pero si agregamos un true
			//en los parametros de destino podemos agregar texto donde ya hay escrito algo una ves le dimos para compilar se crea el fichero
			// despues cambiamos el String donde se almacena la frase en la variable frase se escibe en el archivo ya creado y cada ves que compilemos
			//o le demos play se agrega mas texto al ya creado y si le sacamos el true solo se sobreescribe una sola frase
			
			FileWriter escritura=new FileWriter("C:/Users/usuario/Desktop/creando ficheros para acceder desde java/texto_donde_escribodesdejava.txt",true);
			
			//hacemos un bucle for para que valla escribiendo caracter a caracter del archivo creado va a evaluar frase que ya escribimos una frase
			//y cada vuelta de bucle for que escriba el caracter que se encuentre
			for(int i=0;i<frase.length();i++) 
			{
				//escritura(que es el numero del stream) el fichero creado Write para escribir fichero  frase.charAt(i) evalua caracter a caracter con el bucle
				//en ves de escribir una frase write le pasamos por parametro la frase creada
				escritura.write(frase.charAt(i));
			}
			
			escritura.close();//cerramos conexion 
		}
		
		catch(IOException e) 
		{
			
			e.printStackTrace();
		}
	}
}
