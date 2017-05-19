package TesteSite;

/**
 * 
 * Classe que representa o Fibonacci contendo o m�todo calcular que recebe da classe teste o atributo
 * X no qual ser� usado pra setar no campo a resposta.
 *
 *
 * @author Andr� Duarte <andre.silva141@fatec.sp.gov.br>
 * @since 17 de mai de 2017 17:18:23
 * @version 1.0
 */

public class Fibonacci{

	public static Integer calcularFibonacci( Integer valorX ) {

		Integer atual = 1;
		Integer anterior = 0;

		for ( int i = 0; i < valorX; i++ ) {
			atual = atual + anterior;
			anterior = atual - anterior;
			valorX = anterior;
		}
		return valorX;
	}

}
