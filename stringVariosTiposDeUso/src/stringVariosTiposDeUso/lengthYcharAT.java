package stringVariosTiposDeUso;

public class lengthYcharAT {

	public static void main(String[] args) {
		String nombre="maxi";
		int ultima_letra;
		ultima_letra=nombre.length();// length se guarda la cantidad de letra que hay que seria 4 y lo alamaceno en la variable
		//ultima_letra 
		System.out.println("la ultima letra del nombre es: " + nombre.charAt(ultima_letra-1));//otra forma de usar charAT
		//en vez de poner dentro del charAt el num 3 que seria la i utilice una variable anteriror para darle todas las posiciones de las letras
		//y dentro del charAt pongo el nombre de la variable y un -1 ya que en charAT cuanta de 0 y la letra i esta en la posicion 3

	}

}
