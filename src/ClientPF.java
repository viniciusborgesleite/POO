import java.util.Date;


public class ClientPF extends Cliente{
	
	private String cpf;
	private String genero;
	private Date DataLicenca;
	private String educacao;
	private Date DataNascimento;
	private String classeEconomica;
	
	public ClientPF(String nome, String endereco, 
			String cpf, String genero, Date DataLicenca, String educacao, Date DataNascimento, String classeEconomica) {

		super(nome, endereco);
		// TODO Auto-generated constructor stub
		this.cpf = cpf;
		this.genero = genero;
		this.DataLicenca = DataLicenca;
		this.educacao = educacao;
		this.DataNascimento = DataNascimento;
		this.classeEconomica = classeEconomica;
		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getDataLicenca() {
		return DataLicenca;
	}

	public void setDataLicenca(Date dataLicenca) {
		DataLicenca = dataLicenca;
	}

	public String getEducacao() {
		return educacao;
	}

	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}

	public Date getDataNascimento() {
		return DataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		DataNascimento = dataNascimento;
	}

	public String getClasseEconomica() {
		return classeEconomica;
	}

	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}

	@Override
	public String toString() {
		return "ClientPF [nome = " + this.getNome() + ", endereco = " + this.getEndereco() + ", cpf = " + cpf + ", genero =" + genero + ", DataLicenca =" + DataLicenca + ", educacao =" + educacao
				+ ", DataNascimento =" + DataNascimento + ", classeEconomica =" + classeEconomica + "]";
	}
	
	
	public boolean caracteres_iguais(String cpf){
		// Verifica se todos os números são iguais, retornando true ou false
			
		for (int i = 0; i < cpf.length(); i++ ) {
			if(cpf.charAt(i) != cpf.charAt(0)) {
				return false;
			}
		}
		return true;
	}
	



	public int  primeiro_digito_verificador(String cpf) {
		// Efetua o cálculo do primeiro digito verificador
		
		int soma_primeiro_digito = 0;
		
		for (int i = 0; i < 9; i++) {
			
			soma_primeiro_digito += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
			
		}
		
		int resto = soma_primeiro_digito % 11;
		
		if (resto < 2) {
			return 0;
		}
		
		else {
			return (11 - resto);
		}	
		
	}
	
	public int segundo_digito_verificador(String cpf) {
		
		// Efetua o calculo do segundo dígito verificador do cpf
		
		int soma_segundo_digito = 0;
		
		for (int i = 0; i < 10; i++) {
			
			soma_segundo_digito += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
			
		}
		
		int resto = soma_segundo_digito % 11;
		
		if (resto < 2) {
			return 0;
		}
		
		else {
			return (11 - resto);
		}	
		
	}
	
	public boolean compara_digitos(String cpf) {
		// Verifica se os dígitos comparadores calculados na função acima são compatíveis com 
		// o do cpf dado como entrada
			
		if (Character.getNumericValue(cpf.charAt(9)) == primeiro_digito_verificador(cpf)) {
			
			if (Character.getNumericValue(cpf.charAt(10)) == segundo_digito_verificador(cpf)) {
				return true;
			}
			else {
				return false;
			}
			
		}
		
		else {
			return false;
		}
		
		
	}
	
	
	
    
    public boolean ValidarCpf(String cpf) {
    	// Avalia a validade do cpf
    	
    	String replaced_cpf = cpf.replaceAll("\\.", "");
    	replaced_cpf = replaced_cpf.replaceAll("-", "");
    	
    	if (replaced_cpf.length() != 11) { 
    		// Avalia o comprimento
    		return false;
    	}
   
    	if (caracteres_iguais(replaced_cpf) == true) {
    		// Avalia se todos os caracteres são iguais
    		return false;
    	}
    	
    	if(compara_digitos(replaced_cpf) == false){
    		// Avalia dígitos verificadores
    		return false;
    	}
   
    	else {
    		// Se todas as funções não identificarem algum erro, retorna true, ou seja
    		// o cpf é válido.
    		return true;
    	}
    	
    	
    	
    }
    
    

	
	
	
	
	
	
	
	
	
}
