package tarea_de_clase;

public class clase_switch 
{
	public static void main(String[] args) 
	{
		float num1=14;
		float num2=10;
		
		float resultado=0;
		char op='-';
		
		switch(op) 
		{
		case '+':
			resultado=num1+num2;
			break;
		case '-':
			resultado=num1-num2;
			break;
		case '/':
			resultado=num1/num2;
			break;
		case '*':
			resultado=num1*num2;
		break;
		}
		System.out.println("el resultado es " + resultado);
		
	}

}
