package automatizado;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Classe base que serve de herança para todas as classes de teste.
 * @author leona
 *
 */
public abstract class BaseTest {
	/** Driver do navegador da pagina atual */
	protected static WebDriver driver;
	/**Caminho da URL do sistema a ser testado. */
	private static final String URL_BASE = "file:///C:/Users/leona/Desktop/Teste%20automatizados/sistema/login.html";
	/** Caminho relativodo driver ao projeto referente ao path*/
	private static final String CAMINHO_DRIVER = "src/test/resources/resource/chromedriver.exe";

		/**
		 * Método para iniciar o driver do navegador antes de qualquerclasse de teste
		 */
		@BeforeClass
		public static void iniciar() {
			System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get(URL_BASE);
		}
		
		/**
		 * Método para finalizar o driver do navegador depois de qualquer classe de teste
		 */
		@AfterClass
		public static void finalizar() {
			driver.quit();
		}
}
