package interfasgraficaSuma;

import javax.swing.JOptionPane;  //importa clase JOptionPane
public class sumadenum
{
	public static void main(String[] args) 
	{
		String primerNum, //primer cadena introducida por el usuario
			   segundoNum; //segunda cadena introducida por el usuario
		int numero1, //primer num a suma
		    numero2,//segundo num a sumar
		    suma;//suma  de num1 y num2
		//lee el primer numero del usuario como una cadena
		primerNum =
				JOptionPane.showInputDialog("introduzca el primer numero");
		//lee elsegundo numdero del usuario
		segundoNum =
				JOptionPane.showInputDialog("introduzca segundo numero");
				
		//convierte los num de tipo String en tipo int
		numero1 = Integer.parseInt(primerNum);
		numero2 = Integer.parseInt(segundoNum);
		
		//suma de num
		suma = numero1 + numero2;
		
		//despliega los resultados
		JOptionPane.showMessageDialog(null,"la suma es:"+ suma,"resultado:",JOptionPane.PLAIN_MESSAGE );
		System.exit(0);
	}

}
