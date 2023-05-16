
public class ClientPJ extends Cliente {
	
	private String cnpj;
	private int dataFundacao;
	private int qtdeFuncionarios;
	
	public ClientPJ(String nome, String endereco, String cnpj, int dataFundacao, int qtdeFuncionarios) {
		
		super(nome, endereco);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.qtdeFuncionarios = qtdeFuncionarios;
		// TODO Auto-generated constructor stub
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(int dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	public int getQtdeFuncionarios() {
		return qtdeFuncionarios;
	}

	public void setQtdeFuncionarios(int qtdeFuncionarios) {
		this.qtdeFuncionarios = qtdeFuncionarios;
	}

	@Override
	public String toString() {
		return "ClientPJ [nome = " + this.getNome() + ", endereco = " + this.getEndereco() + ", cnpj= " + cnpj + ", dataFundacao = " + dataFundacao + ", Quantidade de funcionários = " + qtdeFuncionarios + "]";
	}
	
	public double calculaScore() {
		
		double fator_funcionarios = 1 + (this.getLista().size()/100);
		int quantidade_funcionarios = this.qtdeFuncionarios;
		
		double score = CalcSeguro.VALOR_BASE.getValor() * fator_funcionarios * quantidade_funcionarios;
		
		return score;
		
	}
}
