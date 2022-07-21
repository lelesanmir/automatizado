package automatizado;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import page.GooglePO;

public class GoogleTest extends BaseTest {

	private static GooglePO googlePage;
	
	@BeforeClass
	public static void prepararTestes() {
		driver.get("https://google.com/");
		googlePage = new GooglePO(driver);
		
		
	}
	
	@Test
	public void TC001_deveserPossivelPesquisarNoGoogleOTextoBatataFrita() {
				
		//googlePage.inputPesquisa.sendKeys("Batata frita" + Keys.ENTER);
		googlePage.pesquisar("Batata frita");
	   
		//String resultado = googlePage.divResultadoPesquisa.getText();
		String resultado = googlePage.obterResultadosDaPesquisa();
		
		 assertTrue(resultado, resultado.contains("Aproximadamente"));		 
	}
	
	@Test
	public void TC002_deveSerPossivelPesquisarNoGoogleOTextoNutella() {
		
		
		googlePage.pesquisar("Nutella");
		   
		String resultado = googlePage.obterResultadosDaPesquisa();
		
		 assertTrue(resultado, resultado.contains("resultados"));
		 
	}
}




