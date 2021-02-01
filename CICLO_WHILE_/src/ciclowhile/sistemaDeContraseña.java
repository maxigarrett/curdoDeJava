package ciclowhile;

import javax.swing.JOptionPane;

public class sistemaDeContraseña 
{

	public static void main(String[] args)
	{
		//variable de tipo string y la cadena es maxi  se almacena en variable clave
		String clave="maxi";
		//otro string donde almacenaremos caracteres vacios en la variable pass(contraseña)
		String pass="";
		
		/*la condicion dice que clave que tiene el nombre maxi va a ser comparado con el metodo equals(compara cadena de textos)
		 y cuando compara con pass que no va ser por eso es igual igual a false entra al ciclo*/
		while(clave.equals(pass)==false) 
		{
			//la variable pass le reasignamos el valo y va a mostrar una ventana para poner el nombre 
			//despues el condicional if comparara si se cumple la condicion para mostrar el mensaje 
			pass=JOptionPane.showInputDialog("ponga la contraseña");
			//mostrara el mensaje de incorrecto mientras la clave que se ponga sea distinta de maxi
			if(clave.equals(pass)==false) 
			{
				System.out.println("incorrecto");
				
			}
		}
		JOptionPane.showMessageDialog(null,"correcto acceso permitido");
	}

}
