package stream_enviar_recibirInformacionBytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class lecturaEscritura_deBytes
{

	public static void main(String[] args)
	{
		int contador=0;
		
		//almacenamos los bytes que nos dice que tiene nuestra foto con la variable contador cada vuelda de ciclo
		// y le pasamos ese numero al array
		int datos_entrada[]=new int[64418];
		
		try 
		{
			//creamos la instacia de la clase fileinputstream lo cual crea un acanal abierto para 
			//leer los bytes del el archivo que en este caso es una imagen 
			FileInputStream archivo_lectura=new FileInputStream("C:/Users/usuario/Desktop/imagen para leer en bytes desde java/galaxia.jpg");
			
			boolean final_ar=false;
			
			//creamos bucle while para ir leyendo  con el metodo read(); byte a byte
			while(final_ar==false) 
			{
				
				
				//este metodo read lee byte a byte la imagen almacenada en archivo lectura y todo esto se almacena
				//en un objeto de tipo entero porque read devuelve entero y cuando termina devuelve un -1 
				//significa que ya no hay mas texto
				int byte_entrada=archivo_lectura.read();
				
				if(byte_entrada!=-1) 
				{
					//le decimos que imprima todos los datos en bytes menos el -1 que indica que llego al final
					//ese array creado anteriormente se almacenara cada vuelta de bucle lo q hay en contador
					//que cada vuelta aumenta en 1 hasta llegar al ultimo byte que contiene la imagen 
					//diciensole al array que es igual a byte_entrada que esta almacenando el archico
					datos_entrada[contador]=byte_entrada;
				}
				
				else
				{
					//si llega al final i es igual a -1 la variable boleana se vuelve true y sale del ciclo
					final_ar=true;
				}
				
			
				
				//imprimea cada vuelta de bucle en consola el byte que va leyendo del archivo 
				//le decimos que imprima lo que esta almacenado en el array
			System.out.println(datos_entrada[contador]);
				contador++;//cada vuelto de bucle valdra un en cada posicion del array
			}
		archivo_lectura.close();	
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println("cantidad de bytes"+contador);//muestra todos los bytes que contiene la imagen para pasarselo al array
		
		//llamamos al metodo que va a crear una copia de la imagen y por parametros le pasamos los mismos
		//bites de la imagen que queriamos leer almacenada en el array dato_entrada
		
		creaFichero(datos_entrada);
	}
	
	//este metodo pide por parametro un array que se lo pasamos en la instancia del main como datos_entrada
	//que tiene alamacenado los bytes de la imagen para poder hacer la copia
	static void creaFichero(int datosnuevofichero[]) 
	{
		try 
		{
			//para escribir bytes en un archico que creamos nosotros dandole la direccion
			//por parametros con la clase FileOutputStream
			FileOutputStream fichero_nuevo=new FileOutputStream("C:/Users/usuario/Desktop/imagen para leer en bytes desde java/galaxia_copia.jpg");
		
			for(int i=0;i<datosnuevofichero.length;i++) 
			{
				//utilizamos el stream creado antes, con su metodo write que permite crear o escribir un 
				//fichero nuevo de bytes en este caso y vamos a utilizar la informacion almacenada en
				//cada posicion del array de datosnuevofichero
				fichero_nuevo.write(datosnuevofichero[i]);
			}
			fichero_nuevo.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}

}


