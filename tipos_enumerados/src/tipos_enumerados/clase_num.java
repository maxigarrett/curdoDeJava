package tipos_enumerados;

import java.util.Scanner;

public class clase_num
{   // enum talla {MINI,MEDIANO,GRANDE,MUY_GRANDE};
	enum Talla 
	{
		MINI("S"), MEDIANO("M"),GRANDE("L"),MUY_GRANDE("XL");//hay que pasarle al constructor la abreviatura
		                                                     //lo que esta entre parentesis es lo que se almacena en el parametro abreviatura
		private Talla(String abreviatura) //constructor
		{
			this.abreviatura=abreviatura;
		}
		public String dameabreviatura() 
		{
			return abreviatura;
		}
		
		private String abreviatura;	
	}
	
	public static void main(String[] args)
	{
	    Scanner scanner=new Scanner(System.in);
	    
	    System.out.println("escribe una talla MINI MEDIANO GRANDE MUY_GRANDE");
	    String entrada=scanner.nextLine().toUpperCase();//toUperCase si el usuario ingresa minuscula lo pasa a mayuzcula
	                                                   
	    Talla la_talla=Enum.valueOf(Talla.class, entrada);//valueOf devuelve el nombre de la constante enumerada
	                                                   //la variable es entrada
	         //el metodo pide a la case que pertenece y se define el nombre de la clase(Talla) con la palabra class
	    System.out.println("talla: " + la_talla);
	    System.out.println("abreviatura: " +la_talla.dameabreviatura());//muestra lo que esta por parametro depende de lo que elija por consola MINI GRANDE,etc...

	}

}
