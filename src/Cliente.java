
import java.util.Calendar;
import java.util.Date;



public abstract class Cliente{
    
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    

	public Cliente(String nome, String telefone, String endereco, String email) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	public String getTelefone() {
		return telefone;
	}



	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int calcula_idade(Date nascimento) {
		// Calcula a idade do cidadão com base na data de nascimento
    	Calendar data_atual = Calendar.getInstance();
    	
    	Calendar data_nascimento = Calendar.getInstance();
    	
    	data_nascimento.setTime(nascimento);
    	
    	
    	int idade = data_atual.get(Calendar.YEAR) - data_nascimento.get(Calendar.YEAR);
    	
    	if(data_atual.get(Calendar.DAY_OF_YEAR) < data_nascimento.get(Calendar.DAY_OF_YEAR)) {
    		idade = idade - 1;
    	}
    	
    	return idade;
    	
    }
	
	public abstract void listar_veiculos(); 
	
	public abstract void remove_veiculo(Veiculo veiculo);
	
	
}