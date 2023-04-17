
public class ClientPJ extends Cliente {
	
	private String cnpj;
	private int dataFundacao;
	
	public ClientPJ(String nome, String endereco, String cnpj, int dataFundacao) {
		
		super(nome, endereco);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
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

	
	
	@Override
	public String toString() {
		return "ClientPJ [nome = " + this.getNome() + ", endereco = " + this.getEndereco() + ", cnpj= " + cnpj + ", dataFundacao = " + dataFundacao + "]";
	}

	public int calcula_digito1(String cnpj) {
		
		int[] pesos = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
		
		int soma = 0;
		
		for(int i = 0; i < 12; i++) {
			soma += Character.getNumericValue(cnpj.charAt(i)) * pesos[i];
		}
		
		int resto = soma % 11;
		
		if(resto < 2) {
			return  0;
		}
		else {
			return 11 - resto;
		}
		
	}
	
	public int calcula_digito2(String cnpj) {
		
		int[] pesos = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
		
		int soma = 0;
		
		for (int i = 0; i < 13; i++) {
			soma += Character.getNumericValue(cnpj.charAt(i)) * pesos[i];
		}
		
		int resto = soma % 11;
		
		if (resto < 2) {
			return 0;
		}
		else {
			return 11 - resto;
		}
	}
	
	public boolean compara_digitos(String cnpj) {
		if (calcula_digito1(cnpj) != Character.getNumericValue(cnpj.charAt(12))) {
			return false;
		}
		else if (calcula_digito2(cnpj) != Character.getNumericValue(cnpj.charAt(13))) {
			return false;
		}
		else{
			return true;
		}
	}
	
	public boolean validar_cnpj(String cnpj) {
		
		if(cnpj.length() != 14) {
			return false;
		}
		
		if (compara_digitos(cnpj) == false) {
			return false;
		}
		
		return true;
 }
}
