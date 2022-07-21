package automatizado;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.builder.ProdutoBuilder;
import page.ControleDeProdutoPO;
import page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTeste extends BaseTest {

	public static LoginPO LoginPage;
	public static ControleDeProdutoPO controleProdutoPage;

	@BeforeClass
	public static void prepararTestes() {
		LoginPage = new LoginPO(driver);
		LoginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

		controleProdutoPage = new ControleDeProdutoPO(driver);
		assertEquals(controleProdutoPage.obterTituloPagina(), "Controle de Produtos");

	}

	@Test
	public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar() {
		controleProdutoPage.buttonAdicionar.click();
		//TODO: Remover esse clique assim que o sistema for corrigido
		controleProdutoPage.buttonAdicionar.click();

		String titulo = controleProdutoPage.tituloModal.getText();
		assertEquals("Produto", titulo);
		controleProdutoPage.buttonSair.click();
		controleProdutoPage.buttonSair.click();
	}
	
//	@Test
//	public void TC002_naoDeverSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos() {
//		
//		controleProdutoPage.buttonAdicionar.click();
//		
//		controleProdutoPage.cadastrarProduto("00001", "Martelo", 10, 59.9, "");
//
//		//Aqui vamos capturar a mensagem de erro.
//		String mensagem = controleProdutoPage.spanMessagem.getText();
//		
//		assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
//	}
	
	@Test
	public void TC003_naoDeverSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos() {
		
		String mensagem = "Todos os campos são obrigatórios para o cadastro!";
		controleProdutoPage.buttonAdicionar.click();
		
		
		
		//Aqui cria o objetopara adicionar tela
		ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);

		//Aqui estamos testandose o produto é adicionado sem código
		produtoBuilder
		.adicionarCodigo("")
		.buider();
		
		assertEquals(mensagem, controleProdutoPage.spanMessagem.getText());
		
		//Aqui estamos testando so o produto é adicionado sem quantidade
		produtoBuilder
		.adicionarCodigo("00008")
		.adicionarValor(98.0)
		.adicionarNome("Serrote")
		.buider();
		
		assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
		
		//Aqui estamos testandose o produtoé adicionado sem nome
		produtoBuilder
		.adicionarCodigo("00016")
		.adicionarNome("")
		.adicionarValor(8.0)
		.buider();
		
		assertEquals(mensagem, controleProdutoPage.spanMessagem.getText());
		
		//Aqui estamos testandose o produtoé adicionado sem valor
		produtoBuilder
		.adicionarCodigo("00019")
		.adicionarNome("Cimento")
		.adicionarValor(null)
		.buider();
		
		assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
		
		//Aqui estamos testandose o produtoé adicionado sem nome
		produtoBuilder
		.adicionarCodigo("00010")
		.adicionarNome("Telha")
		.adicionarValor(38.0)
		.adicionarData("")
		.buider();
		
		assertEquals(mensagem, controleProdutoPage.spanMessagem.getText());	
		
		controleProdutoPage.buttonSair.click();
		
	}
}
