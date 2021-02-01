package poo;
import javax.swing.*;
class clase_principal_coche2
{

	public static void main(String[] args) //clase principal
	{
		/*coche renault=new coche();
		
		System.out.println(renault.dime_datos_generales());
		//System.out.println(renault.ruedas) no se puede hay que usar getters
		
		renault.configurar_color(JOptionPane.showInputDialog("introduce color"));
		System.out.println(renault.dime_color());
		
		renault.configura_asientos(JOptionPane.showInputDialog("¿tiene asiento de cuero?"));
		System.out.println(renault.dime_asientos());
		
		renault.configura_climatizador(JOptionPane.showInputDialog("¿tiene climatizador?"));
		System.out.println(renault.dime_climatizador());
		
		System.out.println(renault.dime_peso_coche());
		
		System.out.println("el precio final del coche es " + renault.precio_coche());*/
		
		//vamos a instanciar la clase coche y furgoneta
		
		coche micoche1=new coche();//crea objeto de clase coche
		micoche1.configurar_color("rojo");
		
		erenciadeCOCHE_FURGONETA mifurgoneta1=new erenciadeCOCHE_FURGONETA(580,7);//paso parametro
		                                                           //echo en furgoneta al constructor que son asientos 7 y carga 580
		mifurgoneta1.configurar_color("amarillo");/*ya que esta todo vinculado ciche y con furgoneta
		podemos usar los setter de coche para configurar el color y demas a la nueva clase furgoneta
		es mas bien conocida como herencia es decir va a heredar todos los metodos de coche*/
		mifurgoneta1.configura_asientos("si");
		mifurgoneta1.configura_climatizador("si");
		
		System.out.println(micoche1.dime_datos_generales() +" "+micoche1.dime_color());//muestra datos generales creados en clase coche
		System.out.println("furgoneta: "+mifurgoneta1.dime_datos_generales()+" "+mifurgoneta1.dime_furgoneta());
	}

}
