import javax.swing.*;
public class pesoIdeal_equals_parse
{

	public static void main(String[] args)
	{
		String genero ="";
		
		do 
		{
			genero=JOptionPane.showInputDialog("introduce tu genero (H/M)");
			
			//condicion que dice que genero (H/M) equalsIgnereCase (esto compara cadena de caracteres pero
			//ingonara si es mayusculas o misnusculas osea que puede ser H/M mayuscula o minuscula) sea false se va a seguir repitiendo(es decir mientras no ponga un H o M)
		}while(genero.equalsIgnoreCase("H")==false && genero.equalsIgnoreCase("M")==false );
		
		int altura=Integer.parseInt(JOptionPane.showInputDialog("introduzca la altura")) ;
		
		int pesoideal=0;
		if(genero.equalsIgnoreCase("H")) 
		{
			pesoideal=altura-110;
		}
		else 
		{
			if(genero.equalsIgnoreCase("M")) 
			{
				pesoideal=altura-120;
			}
		}
		System.out.println("su peso ideal es " + pesoideal);

	}

}
