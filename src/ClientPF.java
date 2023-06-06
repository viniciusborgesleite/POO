import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;



public class ClientPF extends Cliente{
	
	private String cpf;
	private String genero;
	private Date DataLicenca;
	private String educacao;
	private Date DataNascimento;
	private ArrayList<Veiculo> lista_veiculos;

	
	public ClientPF(String nome, String telefone, String endereco, String email,
			String cpf, String genero, Date DataLicenca, String educacao, Date DataNascimento) {

		super(nome, telefone, endereco, email);
		// TODO Auto-generated constructor stub
		this.cpf = cpf;
		this.genero = genero;
		this.DataLicenca = DataLicenca;
		this.educacao = educacao;
		this.DataNascimento = DataNascimento;
		this.lista_veiculos = new ArrayList<>();
		
		
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

	public ArrayList<Veiculo> getLista_veiculos() {
		return lista_veiculos;
	}

	public void setLista_veiuclos(ArrayList<Veiculo> lista_veiuclos) {
		this.lista_veiculos = lista_veiuclos;
	}

	public boolean cadastrar_veiculo(Veiculo veiculo) {
		lista_veiculos.add(veiculo);
		return true;
	}
	
	public boolean remover_veiculo(Veiculo veiculo) {
		for (int i = 0; i < lista_veiculos.size(); i++) {
			if (lista_veiculos.get(i).equals(veiculo)) {
				lista_veiculos.remove(i);
				return true;
			}
		}
		return false;
	}
    
    
   public void listar_veiculos() {
	   for (Veiculo veiculo : this.getLista_veiculos()) {
		   System.out.println(veiculo);
	   }
   }
   
   public void remove_veiculo(Veiculo veiculo) {
	 
	   for (Veiculo vei : this.getLista_veiculos()) {
		   if (vei.equals(veiculo)) {
			   this.getLista_veiculos().remove(vei);
		   }
	   }
	   
   }

	@Override
	public String toString() {
		return "ClientPF [cpf=" + cpf + ", genero=" + genero + ", DataLicenca=" + DataLicenca + ", educacao=" + educacao
				+ ", DataNascimento=" + DataNascimento + "]";
	}

    
    

	
	
	
	
	
	
	
	
	
}
