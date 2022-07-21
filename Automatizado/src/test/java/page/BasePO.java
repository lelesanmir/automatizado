package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para cria��o das novas PagesObjects.
 * Todas as pages devem ser herdadas desta classe.  
 * */
public abstract class BasePO {
	/**Driver base que ser� usado pelas pages*/
	protected WebDriver driver;
	
	
	/**
	 * Construtor base para cria��o da f�brica de elementos(PageFactory).
	 * @param driver 
	 */
	public BasePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * M�todo que retorna o t�tulo da p�gina atual.
	 * @return
	 */
	public String obterTituloPagina() {
		return driver.getTitle();
	}	
	
	/**
	 * M�todo para escreverem qualquer WebElement do tipo input e da um TAB no final.
	 * @param input Input a qual ser� escrito.
	 * @param texto texto que ser� escrito no input.
	 */
	public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto + Keys.TAB);
	}
}


