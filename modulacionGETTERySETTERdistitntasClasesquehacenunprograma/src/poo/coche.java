package poo;

public class coche 
{
	private int ruedas;//encapsulamiento (private) para no modificar el num de la variable desde la otra clase coche2
	private int largo;
	private int ancho;          //todas estas que estan en private son denominadas variables de clase
	private int peso;
	private int motor;
	private int peso_plataforma;
	private String color;
	private int peso_total;
	private boolean asientos_cuero,climatizador;

	//metodo constructor el public permite acceder a la informacion desde otras clases
	public coche()
	{
		ruedas=4;
		largo=2000;
		ancho=300;
		motor=1600;
		peso_plataforma=500;
		
	}
	public String dime_datos_generales() //METODO GETTER muestra el valor de la variable
	{
		return "la plataforma del vehiculo tiene " + ruedas + " ruedas " +
		". mide " + largo/1000 + " metros con un ancho de " + ancho + "cm" +
				" y un peso de plataforma de " + peso_plataforma + "kg";		
	}                            //paso de parametros
	public void configurar_color(String color_coche) //SETTER modifica el valor de la variable
	{
		color=color_coche;
	}
	public String dime_color() //metodo GETTER
	{
		return "el color del coche es " + color;
	}
	//cuando el nombre de la variable a modificar coincide con el parametro se le pone un "this" al nombre de la variable 
	//el que no la tiene hace referencia al argumento
	public void configura_asientos(String asientos_cuero) 
	{
		//si lo que pasamos por parametro es un SI imprime un true que se hace con metodo GETTER mas adelante
		if(asientos_cuero.equalsIgnoreCase("SI"))
		{
			this.asientos_cuero=true;//si ponemos en el metodo main que SI tiene cuero sera true
		}
		else 
		{
			this.asientos_cuero=false;//de lo contrario false 
		}
	}
	public String dime_asientos() 
	{
		if(asientos_cuero==true)
		{
			return "el coche tiene asientos de cuero";//si por parametro pusimos SI es true e imprime este mensaje
		}
		else 
		{
			return "el coche tiene asientos de serie";//de poner no imprime este mensaje por ser false
		}
	}
	public void configura_climatizador(String climatizador) //SETTER
	{
		if(climatizador.equalsIgnoreCase("si")) 
		{
			this.climatizador=true;
		}
		else 
		{
			this.climatizador=false;
		}
	}
	public String dime_climatizador() //GETTER
	{
		if(climatizador==true)
		{
			return "el coche incorpora climatizador";
		}
		else 
		{
			return "el coche no tiene climatizador";
		}
	}
	//metodo no aconsejable utilisaremos metodo getter y setter juntos
	public String dime_peso_coche() 
	{
		int peso_carroceria=500;//variable iniciada en 500
		peso_total=peso_plataforma+peso_carroceria;//el peso total se almacena peso carroceria(500)+plataforma(500)=1000
		if(asientos_cuero==true) //si el coche tiene asientos de cuero se le suman 50 kg si no los tiene no suma nada
		{
			peso_total+=+50;//operacion matematica para sumar 50
		}
		if(climatizador==true)//si el coche tiene climatizador se le suman 20
		{
			peso_total=peso_total+20;//operacion matematica para sumar 20mkg
		}
		return "el peso del coche es " + peso_total;//esta seria la parte del GETTER
	}
	public int precio_coche()
	{
		int precio_final=10000;
		if(asientos_cuero==true) 
		{
			precio_final+=2000;
		}
		if(climatizador==true) 
		{
			precio_final+=500;
		}
		return precio_final;
	}
}

