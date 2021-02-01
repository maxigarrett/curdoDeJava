package metodos_genericos_propios;

public class metodosGenericos1 
{

	public static void main(String[] args)
	{
		//construimos un array de String
		String[] nombres= {"jose","maria","pepe"};
		
		//creamos un objeto de tipo String que almacene la longitud del array ya que llamaos a la clase misMatrices
		//y al metodo le pasamos por parametros un array que ese array creado se llama nombres
		String elementos=misMatrices.getElementos(nombres);
		
		//imprimimos y nos va a devolver el return del metodo
		System.out.println(elementos);
		
		//instanciamos Y creamos un array de la calse instanciada Y dentro de las llaves del array instanciamos 
		//directamente la clase empleado con sus datos en los parametros
		clase_empleadoParaUsarConCalseMetodosGenericos1 listaempleados[]={
				new clase_empleadoParaUsarConCalseMetodosGenericos1("juan",45,2500),
				new clase_empleadoParaUsarConCalseMetodosGenericos1("juan",45,2500),
				new clase_empleadoParaUsarConCalseMetodosGenericos1("juan",45,2500),
				new clase_empleadoParaUsarConCalseMetodosGenericos1("juan",45,2500),
				new clase_empleadoParaUsarConCalseMetodosGenericos1("juan",45,2500)
		
		};
		
		//abreviamos paso para imprimir en ves de crear un objeto de tipo String
		/*String ele=misMatrices.getElementos(listaempleados);
		System.out.println(ele);*/
		
		//el array que le pasamos al metodo es de tipo empleado a diferencia del otro que era de tipo String
		System.out.println(misMatrices.getElementos(listaempleados));
	}

}

//esta clase deniminada misMatrices va a ser la que contenga en su interior un metodo generico que va a ser
//una tarea muy sencilla en principio ese metodo generico nos va a devolver un String que nos va a decir
//la longitud que tiene un array  que le pasemos por parametroa ese metodo generico la ventaja al ser un 
//generico es que va a poder recibir cualquier array es decir un array de tipo String,un array de tipo
//Date,empleado,etc... nunca primitivos, siempre nos va a decir la longitud el numero de elementos que tiene
//ese array que le pasemos por parametros
class misMatrices
{
	//para crear metodo generico nos metemos dentro de la clase y lo creamos va a ser estatico para que
	//se convierta en un metodo de clase y de esta forma no necesitamos una instancia y al igual que 
	//al crear las clases genericas los metodos tambien llevan los corchetes angulares dento la letra
	//tipo y a continuacion el tipo de dato que va a devolver String y luego el nombre del metodo y en este 
	//caso como el metodo va a recibir un argumento de tipo array  pues lo tendremos que indicar dentro
	//de los parentesis dentro de ese parametros cuando le pasemos el array tenemos que especificar el tipo
	//de este array y como le vamos a pasar un array generico en principio no sabemos de que tipo si es 
	//String,Date,etc entonces se lo indicamos usando el argumneto de tipo con la letra T indicandole q es
	//generico
	public static <T> String getElementos(T[] a)
	{
		//el length devuelve la longitud del array creado y que le vamos apasar por parametos al metodo
		return "el array tine: "+ a.length + " elementos";
	}
}
