package practica_guiadaBBDD;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class creandoAplicacion3_BBDD 
{

	public static void main(String[] args)
	{
		JFrame mimarco=new Marco_Aplicacion2();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mimarco.setVisible(true);

	}

}


class Marco_Aplicacion2 extends JFrame
{
	
	private static final long serialVersionUID = 1L;
	public Marco_Aplicacion2() 
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
		
		botonConsulta.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				ejecutaConsulta1();
			}
		});
		//agregamos el boton a la lamina y lo ponemos al sur de la lamina
		add(botonConsulta,BorderLayout.SOUTH);
		
		
		
		//-----------CONEXION CON BASE DE DATOS-----------------------------------
		
		try
		{
			// CREAMOS CONEXION
			 miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/curso_sql", "root", "");
			
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
	
	//metodo que muestra lo que hay en secciones en la BBDD
	private void ejecutaConsulta1() 
	{
		//creamos un ResultSet para recorrer los resultados que nos devuelva la consulta SQL consultaSeccion
		ResultSet rs=null;
		try 
		{
			//metodo que obtiene lo que selecciono del JCombobox el usuario y hacemos casting porque el metodo
			//devuelve un Object y no un String
			String seccion=(String)secciones.getSelectedItem();
			
			//ya tenemos en dos avriables lo que el usuario escogio  es decir el ComboBox seccion o paises
			String pais=(String)paises.getSelectedItem();
			
			//le decimos que si lo que el usuario escogio es diferente a todos, es decir, que escogio alguna
			//seccion pregunta si es diferente por el signo de interrogacion sin el diria si es igual a todos
			//y tambien preguntamos que si paises es igual a todos osea que todavia no selecciono ningun pais
			//entonces se ejecutara las instrucciones dentro del if es decir si el usuario solo escogio seccion
			//para que muestre por ejemplo deportes,ferreteria,etc
			if(!seccion.equals("todos") && pais.equals("todos"))
			{	
			 //metodo que pide una consulta paremetrisada que la tenemos en una variable encapsulada en los
			 //campos de clase
			 enviaConsultaSeccion=miConexion.prepareStatement(consultaSeccion);
			
			 //lo que escogio el usuario se almacena en seccion como texto le pasamos eso y solo tenemos una
			 //interrogante asique ponemos el numero 1
			 enviaConsultaSeccion.setString(1, seccion);
			
			 //ejecutar la consulta y para ejecutar la consulta necesitamos utilizar el ResultSet y almacenar
			 //ahi la consulta SQL preparada llamada enviaConsulaSeccion
			 rs=enviaConsultaSeccion.executeQuery();
			
			 //para que cada ves que hagamos una consulta resete el area de texto 
			 resultado.setText("");
			}
			//en caso de que no aya escogido seccion y si paises ya que los dos JComboBox muestran la palabra 
			//todos y si esta ves seccion queda en todos y paises es diferente a todos queremos decir que el
			//usuario escogio paises para elegir uno como USA ,China,etc
			else if(seccion.equals("todos") && !pais.equals("todos")) 
			{
				enviaConsultaPais=miConexion.prepareStatement(consultaPais);
				
				enviaConsultaPais.setString(1, pais);
				
				rs=enviaConsultaPais.executeQuery();
				//para que cada ves que hagamos una consulta resete el area de texto 
				 resultado.setText("");
				
			}
			//ahora le preguntamos si los dos JComboBox han sido modificado osea que el usuario ah escogido
			//los dos JComboBox
			else if(!seccion.equals("todos") && !pais.equals("todos")) 
			{	
				enviaConsultaTodos=miConexion.prepareStatement(consultaTodos);
				
				enviaConsultaTodos.setString(1, seccion);
				enviaConsultaTodos.setString(2, pais);
				rs=enviaConsultaTodos.executeQuery();
				
				resultado.setText("");
			}
			//recorrer con un bucle while el ResultSet e ir almacenando en nuestra JTextArea lo que aya en ese 
			//ResultSet si el usuario escogio deportes mostrara precio  nombrearticulo paisedeorigen de la 
			//seccion deportes
			while(rs.next()) 
			{
				//para la primera columna que pertenece a NOMBREARTICULO
				resultado.append(rs.getString(1));
				resultado.append(", ");
				resultado.append(rs.getString(2));//corresponde a SECCION
				resultado.append(", ");
				resultado.append(rs.getString(3));//coresponde a PRECIO
				resultado.append(", ");
				resultado.append(rs.getString(4));//corresponde a PAISDEORIGEN
				
				resultado.append("\n");
			}
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		
	}
	
	private Connection miConexion;
	private JComboBox secciones,paises;
	private JTextArea resultado;
	private PreparedStatement enviaConsultaSeccion;
	private PreparedStatement enviaConsultaPais;
	private PreparedStatement enviaConsultaTodos;
	private final String consultaSeccion="SELECT NOMBREARTÍCULO,SECCIÓN,PRECIO,PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=?";
	private final String consultaPais="SELECT NOMBREARTÍCULO,SECCIÓN,PRECIO,PAÍSDEORIGEN FROM PRODUCTOS WHERE PAÍSDEORIGEN=?";
	private final String consultaTodos="SELECT NOMBREARTÍCULO,SECCIÓN,PRECIO,PAÍSDEORIGEN FROM PRODUCTOS WHERE SECCIÓN=? AND PAÍSDEORIGEN=?";
}

