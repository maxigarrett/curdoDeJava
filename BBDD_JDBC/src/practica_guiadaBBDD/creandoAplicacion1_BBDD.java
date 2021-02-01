package practica_guiadaBBDD;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
//el marco tendra una disposicion BorderLAyout()
/*crearemos una aplicacion que en el norte tenga dos desplegables(JComboBox) en el norte en la zona central
 un JTextArea donde mostrara la informacion de la base de datos y en el sur tendra un boton que diga consulta
 en el primer JComboBox desplegara lo que son la secciones de los articulos como deportes, jugueteria,ferreteria
 ,etc el segundo JComboBox tendra los paises a los que pertenecen los articulos estos desplegables aran un
 filtrado es decir que ponemos una seccion por ejemplo deporte y le damos al boton y mostrara todas las secciones
 de deportes si le damos a paises mostrara todos los paises con sus articulos pero tambien podemos utilizar
 los dos a la ves como poner en seccion deportes y en el otro combobox de paises italia y mostrara los articulos
 de deportes de italia*/
public class creandoAplicacion1_BBDD 
{

	public static void main(String[] args)
	{
		JFrame mimarco=new Marco_Aplicacion();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}


class Marco_Aplicacion extends JFrame
{
	public Marco_Aplicacion() 
	{
		//titulo
		setTitle("consulta BBDD");
		
		//ubicacion y tamaño
		setBounds(800,300,400,400);
	
		//disposicion
		setLayout(new BorderLayout());
		
		//LAMINA
		JPanel menu=new JPanel();
		menu.setLayout(new FlowLayout());
		
		//intanciamos JComboBox
		secciones=new JComboBox();
		
		//para que no se pueda editar el combobox
		secciones.setEditable(false);
		secciones.addItem("todos");
		
		//intancia JComboBox
		paises=new JComboBox();
		paises.setEditable(false);
		paises.addItem("todos");
		
		//instancia JTextArea
		resultado=new JTextArea();
		resultado.setEditable(false);//para que no se pueda escribir
		
		//agregamos a la lamina el JTextArea
		add(resultado);
		
		//agregamos a la lamina los JComboBox
		menu.add(secciones);
		menu.add(paises);
		add(menu,BorderLayout.NORTH);
		add(resultado,BorderLayout.CENTER);//ponemos el JTextArea al centro
		
		//creamos un boton
		JButton botonConsulta=new JButton("Consulta");
		//agregamos el boton a la lamina y lo ponemos al sur de la lamina
		add(botonConsulta,BorderLayout.SOUTH);
		
		
		//-----------CONEXION CON BASE DE DATOS-----------------------------------
		
		try
		{
			// CREAMOS CONEXION
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");
			
			//CREAMOS EL STATEMENT
			Statement sentencia=miConexion.createStatement();
			//-----------CARGAMOS JCOMBOBOX SECCIONES------------
			//construir la sentencia SQL que nos permita extraer las secciones que tenemos en la tabla de 
			//productos que seria deportes,jugueteria,ferreteria,etc y ponerlo al primer JComboBox llamado
			//secciones DISTINCTROW hace que no repita en esa columna de secciones , es decir, que si hay
			//5 articulos con deportes que no diga 5 veces deportes sino solo una vez
			String consulta="SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS ";
			
			//construir el resulset donde almacenar lo que nos devuelve esta consulta para despues recorrerla
			ResultSet rs=sentencia.executeQuery(consulta);
			
			
			//recorremos el resulset y rellenamos el ComboBox
			while(rs.next()) 
			{
				//le indicamos que agregue  a seccines lo que hay almacenado en el Resulset le decimos 
				//getString porque es texto e indicarle la columna de nuestro Resultset y solo tiene una
				//columna 
				secciones.addItem(rs.getString(1));
				
			}
			rs.close();
			//------------FIN CARGA JCOMBOBOX SECCIONES-----------------------------------
			
			
			//------------CARGA JCOMBOBOX PAISES-----------------------------------------------
			
			 consulta="SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS";
			 
			 rs=sentencia.executeQuery(consulta);
			 
			 while(rs.next()) 
			 {
				 paises.addItem(rs.getString(1));
			 }
			 
			 rs.close();
			 //-------------FIN CARGA JCOMBOBOX PAISES--------------------------
		}
		catch (SQLException e)
		{
			System.out.println("NO CONECTA!!");
			e.printStackTrace();
		}
	}
	
	private JComboBox secciones,paises;
	private JTextArea resultado;
}

//primer paso conseguido que es rellenar los JCombobox