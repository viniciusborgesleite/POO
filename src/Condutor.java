import java.util.ArrayList;
import java.util.Date;

public class Condutor {
	
	private String cpf;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private Date dataNasc;
	private ArrayList<Sinistro> lista_sinistro;
	
	public Condutor(String cpf, String nome, String telefone, String endereco, String email, Date dataNasc) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.dataNasc = dataNasc;

	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public ArrayList<Sinistro> getLista_sinistro() {
		return lista_sinistro;
	}

	public void setLista_sinistro(ArrayList<Sinistro> lista_sinistro) {
		this.lista_sinistro = lista_sinistro;
	}
	
	public boolean adicionar_sinistro(Sinistro sinistro) {
		this.lista_sinistro.add(sinistro);
		return true;
	}
	
	public void listar_sinistros() {
		for (Sinistro sinistro : this.getLista_sinistro()) {
			System.out.println(sinistro);
		}
	}
	
	public void remove_sinistro(Sinistro sinistro) {
		
		for (Sinistro sin : this.getLista_sinistro()) {
			
			if (sin.equals(sinistro)) {
				
				this.getLista_sinistro().remove(sin);
				
			}
		}
	}

	@Override
	public String toString() {
		return "Condutor [cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco
				+ ", email=" + email + ", dataNasc=" + dataNasc + "]";
	}
	
	
}
