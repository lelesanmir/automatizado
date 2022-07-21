package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{

	//#region Regi�o dos WebElements
	@FindBy(id = "email")
	public WebElement inputEmail;
	
	@FindBy(id = "senha")
	public WebElement inputSenha;
	
	@FindBy(id = "btn-entrar")
	public WebElement buttonEntrar;
	
	@FindBy(css = "form.form-login>div.alert>span")
	public WebElement spanMessagem;
	//#endregion Regi�o dos WebElements
	
	/** 
	 * Construtor padr�o para a cria��o de uma nova inst�ncia da p�gina de login.	
	 * @param driver Driver da p�gina de login.
	 */
	public LoginPO(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * M�todo que obtem a mensagen disparada na tela.
	 * @return Texto da mensagem.
	 */
	public String obterMensagem() {
		return this.spanMessagem.getText();
	}
	
	/** 
	 * M�todo que tenta executar a a��o de logar no sistema.
	 * @param email Email para tentativa de login.
	 * @param senha Senha para tentativa de login.
	 */
	public void	executarAcaoDeLogar(String email, String senha) {
		escrever(inputEmail, email); //LoginPage.inputEmail.sendKeys(""); Da outra forma esta passado metodo de a��o na loginPage
		escrever(inputSenha, senha);
		
		buttonEntrar.click();
	}
	
	//Apricipio esse metodo esta sobrando.
//	public String obterTituloPagina(){ 
//		return driver.getTitle();
//	}
	
}




