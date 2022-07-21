package automatizado.builder;

import page.ControleDeProdutoPO;

/**
 * Classe que sabe construir ou adicionar um produto na tela.
 * @author leona
 *
 */
public class ProdutoBuilder {

		private String codigo = "00001";
		private String nome = "Produto Padr�o";
		private Integer quantidade = 1;
		private Double valor = 1.0;
		private String data = "03/11/2021";
		
		private ControleDeProdutoPO controleDeProdutoPO;
		
		/** Construtor do ProdutorBuilder que recebe a pagina de controle do produto. */
		public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO) {
			this.controleDeProdutoPO = controleDeProdutoPO;
		}
		
		/**
		 * M�todo que sabe adicionar um c�digo builder.
		 * @param codigo C�digo que ser� adicionado.
		 * @return Retorna a pr�pria classe ProdutoBuilder.
		 */
		public ProdutoBuilder adicionarCodigo(String codigo) {
			this.codigo = codigo;
			return this;
		}
		
		/**
		 * M�todo que sabe adicionar um nome builder.
		 * @param nome Nome que ser� adicionado.
		 * @return Retorna a pr�pria classe ProdutoBuilder.
		 */
		public ProdutoBuilder adicionarNome(String nome) {
			this.nome = nome;
			return this;
		}
		
		/**
		 * M�todo que sabe adicionar um quantidade builder.
		 * @param quantidade Quantidade que ser� adicionada.
		 * @return Retorna a pr�pria classe ProdutoBuilder.
		 */
		public ProdutoBuilder adicionarQuantidade(Integer quantidade) {
			this.quantidade = quantidade;
			return this;
		}
		
		/**
		 * M�todo que sabe adicionar um valor builder.
		 * @param valor Valor que ser� adicionado.
		 * @return Retorna a pr�pria classe ProdutoBuilder.
		 */
		public ProdutoBuilder adicionarValor(Double valor) {
			this.valor = valor;
			return this;
		}
		
		/**
		 * M�todo que sabe adicionar um data builder.
		 * @param data Data que ser� adicionada.
		 * @return Retorna a pr�pria classe ProdutoBuilder.
		 */
		public ProdutoBuilder adicionarData(String data) {
			this.data = data;
			return this;
		}
		
		/**
		 * M�todo que comstr�i o produto, ou seja , adiciona o produto pela tela de cadastro. 
		 */
		public void buider() {
			controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, codigo);
			controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
			controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, (quantidade != null) ? quantidade.toString() : "");
			controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, (valor != null) ? valor.toString() : "");
			controleDeProdutoPO.escrever(controleDeProdutoPO.inputData,data);
			
			controleDeProdutoPO.buttonSalvar.click();

		}
		
	
}
