import java.util.ArrayList;
import java.util.Date;

public class ClientPJ extends Cliente {
	
	private String cnpj;
	private Date dataFundacao;
	private int quantidadeFuncionarios;
	private ArrayList<Frota> lista_frota;
	
	public ClientPJ(String nome, String telefone, String endereco, String email, String cnpj, Date dataFundacao, int quantidadeFuncionarios) {
		
		super(nome, telefone, endereco, email);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.quantidadeFuncionarios = quantidadeFuncionarios;
		this.lista_frota = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	

	
	
	public String getCnpj() {
		return cnpj;
	}





	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}



	public ArrayList<Frota> getLista_frota() {
		return lista_frota;
	}





	public void setLista_frota(ArrayList<Frota> lista_frota) {
		this.lista_frota = lista_frota;
	}

	
	public boolean cadastrar_frota(Frota frota) {
		lista_frota.add(frota);
		return true;
	}
	
	
	
	
	
	public Date getDataFundacao() {
		return dataFundacao;
	}





	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}





	public int getQuantidadeFuncionarios() {
		return quantidadeFuncionarios;
	}





	public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
		this.quantidadeFuncionarios = quantidadeFuncionarios;
	}



	public boolean atualizar_frota(boolean adiciona, Frota frota, Veiculo veiculo) {
		
		if (adiciona) {
			frota.adicionar_veiculo(veiculo);
			return true;
		}
		else {
			frota.remove_veiculo(veiculo);
			
			if(frota.getLista_veiculos().size() == 0) {
				this.getLista_frota().remove(frota);
			}
			return true;
		}
	}
	

	public boolean getVeiculosPorFrota(Frota frota) {
		
		for (int i = 0; i < lista_frota.size(); i++) {
			if (lista_frota.get(i).equals(frota)) {
				System.out.println(frota.getLista_veiculos());
				return true;
			}
		}
		return false;
		
		
	
	}





	@Override
	public String toString() {
		return "ClientPJ [cnpj=" + cnpj + ", dataFundacao=" + dataFundacao + ", quantidadeFuncionarios="
				+ quantidadeFuncionarios + "]";
	}



	public void listar_veiculos() {
		
		for (Frota frota : this.getLista_frota()) {
			
			for (Veiculo veiculo : frota.getLista_veiculos()) {
				
				System.out.println(veiculo);
				
			}
			
		}
	}
	
	public void listar_frota() {
		for (Frota frota : this.getLista_frota()) {
			
			System.out.println(frota);
			
		}
	}
	
	public void remove_veiculo(Veiculo veiculo) {
		
		for (Frota frota : this.getLista_frota()) {
			
			for (Veiculo vei : frota.getLista_veiculos()) {
				
				if (vei.equals(veiculo)) {
					
					frota.getLista_veiculos().remove(vei);
					
				}
			}
		}
	}
	
	public void remover_frota(Frota frota) {
		
		for (Frota frot : this.getLista_frota()) {
			
			if(frot.equals(frota)) {
				
				this.getLista_frota().remove(frot);
				
			}
		}
	}
	
	
}

