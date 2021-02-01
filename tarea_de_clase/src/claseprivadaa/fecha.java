package claseprivadaa;

public class fecha {

	public static void main(String[] args)
	{
		usofecha f1=new usofecha();
		//f1.dia=2;
		//f1.mes=2;
		//f1.año=1972;
		
		//System.out.println("el dia "+f1.dia + " el mes "+f1.mes+ " el año "+ f1.año);

		f1.setDia(12);
		f1.setMes(10);
		f1.setAño(2002);
		
		System.out.println(f1.getDia()+ " "+f1.getMes()+" "+f1.getAño());
	}

}
