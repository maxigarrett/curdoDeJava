package conectando_BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class conecta_pruebas1 
{
	/*conectar con base de datos mySQL 1_primer paso crear conexion 2_ segundo paso crear un objeto
	 Statement  3_tercer paso ejecutar la instruccion SQL  4_cuarto paso recoorer el Resulset*/

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
			
			//paso 3 ejecutar instruccion SQL y para ejecutar el SQL vamos a necesitar el objeto de tipo
			//Statement en la interfaz Connection vamos al metodo createStatement() que devuelve un 
			//objeto de tipo Statement y si pulsamos en Statement vemos que es una interfaz y esta tiene
			//un metodo que es executQuery(String url) este ejecuta la sentencia SQL proporcionada
			//la cual devuelve un objeto de tipo Resulset asi que creamos este objeto y con el objeto
			//de tipo Statement llamar al metodo mencionado y pasarle por parametro una instruccion SQL
			//que sera la que nos devuelva los articulos de la tabla productos
			
			//creamos objeto de tipo Resulset por parametros hay que pasrle la instruccion que nos 
			//devuelva la tabla de productos evidentemente hay que conocer el lenguaje de acceso a datos
			//SQL... la sentencia para devolver todos los articulos de la tabla de productos es 
			//SELECT * para que nos devuelva todos los campos que alla y despues FROM PRODUCTOS con FROM
			//se refiere a como se llama la tabla y SELECT es para seleccionar el campo que queremos 
			//acceder en la consulta entonces ahora tenemos almacenado en la variable creada toda la
			//informacion es decir la consulta SQL que hacemos por parametros 
			ResultSet miResultset=miStatement.executeQuery("SELECT * FROM PRODUCTOS");
			
			//paso 4 recorrer el Resultset(tabla virtual llena de datos) este Resultset es una interfaz
			//que contiene una serie de metod para movernos dentro de esta tabla como por ejemplo
			//le metodo first() mueve el cursor al primer registro de la tabla... el curso al crear esta
			//tabla virtual esta en la primera fila preparado para leer cual es primer articulo por eso
			//este metod si estamos ubicados en otro sitio nos permite volver al primer registro o a la
			//primer fila....tambien contiene el metodo next() nos permite mover el cursor a la sigueinte
			//fila 
			//con este bucle le decimos si el objeto de tipo Resultset hay un siguiente ya que esta ubicado
			//en la primer fila y pregunta si hay una segunda... moviendolo con un metodo al llegar al 
			//ultimo comprobara que no hay mas y se saldra del bucle
			while(miResultset.next()) 
			{
				//esta interfaz Resultset tiene un metodo que por parametro le pasamos el nombre de la
				//columna de la tabla que queremos que nos devuelva especificandole el nombre o el
				//numero de la columna que queremos ver
				System.out.println(miResultset.getString("NOMBREARTÍCULO") + " " + miResultset.getString("CÓDIGOARTÍCULO") + " " + miResultset.getString("PRECIO"));
			}
		}
		catch(Exception e) 
		{
			System.out.println("no conecta");
			e.printStackTrace();
		}

	}

}
