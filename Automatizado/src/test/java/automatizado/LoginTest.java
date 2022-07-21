package automatizado;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest {
	
	private static LoginPO LoginPage;
	
	@BeforeClass
	public static void prepararTestes() {
		LoginPage = new LoginPO(driver);
	}

	@Test
	public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios() {
		
		LoginPage.executarAcaoDeLogar("", "");//Esse método criado lá em cima faz a ação de logar
		//LoginPage.escrever(LoginPage.inputEmail, ""); //LoginPage.inputEmail.sendKeys(""); Da outra forma esta passado metodo de ação na loginPage
		//LoginPage.escrever(LoginPage.inputSenha, "");
		
		LoginPage.buttonEntrar.click();
		String mensagem = LoginPage.obterMensagem();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
		
	}
	
	@Test
	public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia() {
		
		LoginPage.executarAcaoDeLogar("teste", "");
		//LoginPage.escrever(LoginPage.inputEmail, "teste"); //LoginPage.inputEmail.sendKeys(""); Da outra forma esta passado metodo de ação na loginPage
		//LoginPage.escrever(LoginPage.inputSenha, "");
		
		LoginPage.buttonEntrar.click();
		String mensagem = LoginPage.obterMensagem();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
		
	}
	
	@Test
	public void TC003_naoDeveLogarNoSistemaComEmailVazioEComSenhaIncorreta() {
		
		LoginPage.executarAcaoDeLogar("", "teste");
		//LoginPage.escrever(LoginPage.inputEmail, ""); //LoginPage.inputEmail.sendKeys(""); Da outra forma esta passado metodo de ação na loginPage
		//LoginPage.escrever(LoginPage.inputSenha, "teste");
		
		LoginPage.buttonEntrar.click();
		String mensagem = LoginPage.obterMensagem();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
		
	}
	
	@Test
	public void TC004_naoDeveLogarNoSistemaComEmailErradoESenhaErrada() {
		
		LoginPage.executarAcaoDeLogar("teste", "teste");
		
		LoginPage.buttonEntrar.click();
		String mensagem = LoginPage.obterMensagem();
		
		assertEquals(mensagem, "E-mail ou senha inválidos");
		
	}
	
	@Test
	public void TC005_naoDeveLogarNoSistemaComEmailCertoEComSenhaErrada() {
		
		LoginPage.executarAcaoDeLogar("Admin@admin.com", "teste");
		
		LoginPage.buttonEntrar.click();
		String mensagem = LoginPage.obterMensagem();
		
		assertEquals(mensagem, "E-mail ou senha inválidos");
	}
	
	@Test
	public void TC006_naoDeveLogarNoSistemaComEmailErradoESenhaComASenhaCorretas() {
		
		LoginPage.executarAcaoDeLogar("Aadmin@admin.com", "admin@123");
		
		LoginPage.buttonEntrar.click();
		String mensagem = LoginPage.obterMensagem();
		
		assertEquals(mensagem, "E-mail ou senha inválidos");
	}
	@Test
	public void TC007_deveLogarNoSistemaComEmailESenhaCorretos() {
		
		LoginPage.executarAcaoDeLogar("Admin@admin.com", "admin@123");
		
		assertEquals(LoginPage.obterTituloPagina(), "Controle de Produtos");
	}
	
}

 
