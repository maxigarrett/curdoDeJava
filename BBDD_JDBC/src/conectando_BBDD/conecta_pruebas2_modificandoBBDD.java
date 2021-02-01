package conectando_BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conecta_pruebas2_modificandoBBDD
{

	public static void main(String[] args)
	{
		//primer paso crear la conexion y vamos a necesitar un objeto de tipo conection y tambien
		//vamos a necesitar la clase DriverManager que es el servicion basico para manejar JDBC driver
		// esta clase tiene un metodo llamado getConnection(String url,String user,String pansword)
		//primer parametro pide una ruta de la base de datos segundo el usuario y por tercer parametro
		//la contraseña todas las bases de datos MYSQL tienen un usuario y contraseña por defecto el
		//usuario es root y la contraseña va en blanco osea no hay que poner nada ose "" este metodo
		//nos devuelve un objeto de tipo Connection entonces vamos a necesitar una variable de tipo
		//Connection para poder utilizar el metodo getConnection() y si pulsamos en la API en Connection
		//nos dice que es una interfaz 
		try 
		{
			//creamos objeto de tipo Connection la ruta para el driver mysqul lo pide por primer 
			//parametro el driver es jdbc:mysql:// a continuacion la ruta para trabajar en local va
			//localhost: y el puerto que abre la base de datos mysql para que conecte con ella y por
			//defecto si no se ah modificado es el puerto 3306 y despues del puerto el nombre de la base
			//de datos que se llama curso_sql despues el usuario que por defecto es root y contraseña
			//va cadena vacia por defecto tambien para saber el puerto que por defecto tiene mysql
			//vamos al gestor de BBDD myqls si por casualidad no es el 3306, una ves entramos al gestor
			//vamos a la pestaña SQL y escribir en la consola lo siguiente SHOW VARIABLES WHERE 
			//VARIABLE_NAME IN('hostname','port') con esto vamos ah tener el hostname de nuestra base
			//de datos y el puerto que tiene abierto.
					
			//ya hemos creado la conexxion (paso 1)
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");
					
			//paso 2 crear un objeto Statement para posteriormente poder ejecutar una consulta SQL si 
			//vamos a la API  de java la interfaz Connection(ya tenemos creado un objeto de este tipo)
			//esta interfaz tiene un metodo que es createStatement() lo que hace es crear un objeto de
			//tipo Statement para enviar consultas SQL a la base de datos
					
			//creamos objeto de tipo Statement
			Statement miStatement=miConexion.createStatement();
			
			//no vamos a utilisar Resulset ya que no queremos ver una tabla virtual ni recorrerla
			//con el while sino que vamos a modificarla
			//vamos a insertar registros en una tabla que estamos trabajando llamda productos
			//para insertar tenemos que usar la sentencia SQL INSER INTO PRODUCTOS que esto indica en que
			//tabla vamos a insertar o introducir informacion que es la tabla PRODUCTOS y entre los 
			//parentesis le indicamos a esta intruccion SQL que campos son donde vamos a introducir la
			//informacion y ya sabemos que nuestra base de datos tiene CODIGOARTÍCULO ,PRECIO,etc y son
			//de tipo varchar(para SQL) osea un String o cadena de texto despues sigue la clausula VALUE
			//y entre parentecis lo que tenemos que especificar son los valores que van a ir dentro de
			//cada uno de esos campos en el mismo orden que lo especificamos como son de tipo texto en
			//VALUE hay que especificarlos entre comillas pero como ya estamos entre comillas las 
			//siguientes hay que especificarlas con comillas simples indicando que las dobles son las
			//comillas padres y las simples las hijas o al reves empesas con simples y despues con dobles
			//si el campo precio no fuera tambien de tipo varchar osea tipo double o int no lleva comillas
			//simples
			
			String instruccionSql="INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, NOMBREARTÍCULO,PRECIO) VALUE ('AR77','PANTALON','78,30')";
			
			//una ves tenemos la instruccion SQL ahora tenemos que decirle a nuestro programa que ejecute
			//esta instruccion SQL como estamos trabajando con objeto de tipo Statement tenemos un metodo
			// de esta interfaz que permite ejecutar esta sentencia hay varios pero uno que destaca
			//para lo que queremos hacer es el metodo executeUpdate(String sql) y lo que hace es ejecuta
			//el SQL establecido en el Statement el cual puede ser de tipo INSERT UPDATE O DELETE
			
			//entonces utilizamos nuestro objeto de tipo Statement y utilizamos el metodo y por parametro
			//le pasamos el objeto String con la instruccion SQL que es insertar un nuevo articulo con su
			//codigo y precio
			miStatement.executeUpdate(instruccionSql);
			
			System.out.println("datos insertados correctamente ");
		}
		catch(Exception e) 
		{
			System.out.println("NO CONECTA!!");
			e.printStackTrace();
		}


	}

}
