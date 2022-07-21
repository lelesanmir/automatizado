package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePO extends BasePO {

	@FindBy(name = "q")
	public WebElement inputPesquisa;

	@FindBy(id = "result-stats")
	public WebElement divResultadoPesquisa;

	/**
	 * Construtor para a criaçãoda página do Google.
	 * 
	 * @param driver
	 */
	public GooglePO(WebDriver driver) {
		super(driver);
	}
	
	/** 
	 * Método que irá efetuar um pequisa no google baseando no texto informado e concluindo com enter.
	 * @param texto  Texto a ser pesquisado.
	 */
	public void pesquisar(String texto) {
		inputPesquisa.sendKeys(texto + Keys.ENTER);
	}
	
	/**
	 * Método que restorna o resultado aproxiamdado da pesquisa.
	 * @return  Retorna o resultado da pesquisa.
	 */
	public String obterResultadosDaPesquisa() {
		return divResultadoPesquisa.getText();
	}

}
