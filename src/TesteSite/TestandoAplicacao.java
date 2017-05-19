package TesteSite;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * Classe teste.
 * Pode-se melhorar muito a codificação e utilizar padrões de programação, por conhecer pouco sobre a ferramenta selenium com java
 * tentei desenvolver um código legível e que pudesse atender ao teste, há algumas coisas que não estão funcionando por exemplo na hora de navegar
 * para o menu "consulta pública", havia testado anteriormente com um sistema meu, e tinha funcionado, não descobri o porque de não navegar.
 * Não sei se dá pra ter um parametro para avaliação com este código, acredito que talvez a lógica pode ser avaliada e a tentativa mesmo tento poucos
 * dias para aprender.
 *
 * @author André Duarte <andre.silva141@fatec.sp.gov.br>
 * @since 17 de mai de 2017 20:31:42
 * @version 1.0
 */
public class TestandoAplicacao{

	@Test
	public void testando() throws InterruptedException {
		System.setProperty( "webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		driver.get( "https://projudi.tjpr.jus.br/projudi_consulta/" );
		//driver.findElement( By.linkText( "Consulta Pública " ) ).click();

		//CAPTURANDO O CONTEÚDO DO CAMPO 
		WebElement valorCampo = driver.findElement( By.tagName( "data-sitekey" ) );

		//DEIXAR SOMENTE OS NÚMEROS
		String valorNumerico = somenteNumeros( valorCampo.getText() );

		//CONVERTO STRING EM NÚMERICO
		Integer valorNumericoConvertido = Integer.parseInt( valorNumerico );

		//INVOCO O MÉTODO QUE FARÁ O CALCULO DE FIBONACCI, ME RETORNANDO UM VALOR
		Integer resultado = Fibonacci.calcularFibonacci( valorNumericoConvertido );

		//VOLTAR O RESULTADO PARA STRING
		String resultadoNumerico = resultado.toString();

		//SETANDO NO TEXTAREA A RESPOSTA
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement campoTexto = driver.findElement( By.id( "g-recaptcha-response" ) );
		if ( jse instanceof WebDriver ) {
			jse.executeScript( "arguments[0].setAttribute('style', 'visibility:hidden')", campoTexto );
			campoTexto.sendKeys( resultadoNumerico );
		}
		driver.close();
	}

	/**
	 * 
	 * Método responsável por manter apenas valores númericos da string e retornar estes valores.
	 *
	 * @param str
	 * @return
	 *
	 * @author André Duarte <andre.silva141@fatec.sp.gov.br>
	 * @since 17 de mai de 2017 20:47:46
	 * @version 1.0
	 */
	public static String somenteNumeros( String str ) {
		if ( str != null ) {
			return str.replaceAll( "[^0123456789]", "" );
		} else {
			return "";
		}

	}

}
