package tarea_de_clase;

public class condicional {

	public static void main(String[] args) {
		int num1=14;
		int num2=10;
		int res=0;
		char operacion='+';
		
		if(operacion=='+') 
		{
			res=num1+num2;
		}
		else 
		{
			if(res=='-') 
			{
				res=num1-num2;
			}
			else 
			{
				if(res=='*') 
				{
					res=num1*num2;
				}
				else 
				{
					if(res=='/') 
					{
						res=num1/num2;
					}
				}
			}
		}
		System.out.println("el resultado es " + res);
		// TODO Auto-generated method stub

	}

}
