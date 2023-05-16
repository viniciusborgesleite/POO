import java.util.Date;
import java.util.Calendar;



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
    
    
    public int calcula_idade(Date nascimento) {
    	Calendar data_atual = Calendar.getInstance();
    	
    	Calendar data_nascimento = Calendar.getInstance();
    	
    	data_nascimento.setTime(nascimento);
    	
    	
    	int idade = data_atual.get(Calendar.YEAR) - data_nascimento.get(Calendar.YEAR);
    	
    	if(data_atual.get(Calendar.DAY_OF_YEAR) < data_nascimento.get(Calendar.DAY_OF_YEAR)) {
    		idade = idade - 1;
    	}
    	
    	return idade;
    	
    }
	public double calculaScore() {
		int valor_base = 100;
		int quantidade_carros = (this.getLista()).size();
		
		int idade = calcula_idade(this.DataNascimento);
		
		double fator_idade;
		
		if (idade < 30) {
			fator_idade = CalcSeguro.FATOR_18_30.getValor();
		}
		else if(idade < 60) {
			fator_idade = CalcSeguro.FATOR_30_60.getValor();
		}
		else {
			fator_idade = CalcSeguro.FATOR_60_90.getValor();		
		}
		
		double score = valor_base * quantidade_carros * fator_idade;
		
		return score;
		
	}
    
    

	
	
	
	
	
	
	
	
	
}
