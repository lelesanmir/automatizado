package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{

	//#region Região dos WebElements
	@FindBy(id = "email")
	public WebElement inputEmail;
	
	@FindBy(id = "senha")
	public WebElement inputSenha;
	
	@FindBy(id = "btn-entrar")
	public WebElement buttonEntrar;
	
	@FindBy(css = "form.form-login>div.alert>span")
	public WebElement spanMessagem;
	//#endregion Região dos WebElements
	
	/** 
	 * Construtor padrão para a criação de uma nova instância da página de login.	
	 * @param driver Driver da página de login.
	 */
	public LoginPO(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * Método que obtem a mensagen disparada na tela.
	 * @return Texto da mensagem.
	 */
	public String obterMensagem() {
		return this.spanMessagem.getText();
	}
	
	/** 
	 * Método que tenta executar a ação de logar no sistema.
	 * @param email Email para tentativa de login.
	 * @param senha Senha para tentativa de login.
	 */
	public void	executarAcaoDeLogar(String email, String senha) {
		escrever(inputEmail, email); //LoginPage.inputEmail.sendKeys(""); Da outra forma esta passado metodo de ação na loginPage
		escrever(inputSenha, senha);
		
		buttonEntrar.click();
	}
	
	//Apricipio esse metodo esta sobrando.
//	public String obterTituloPagina(){ 
//		return driver.getTitle();
//	}
	
}




