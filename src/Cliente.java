import java.util.ArrayList;
import java.util.List;


public class Cliente{
    
    private String nome;
    private String endereco;
    private List<Veiculo> listaVeiculos;



	public Cliente(String nome, String endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = new ArrayList<>();
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
	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", endereco=" + endereco + ", listaVeiculos=" + listaVeiculos + "]";
	}



	public void adiciona_veiculo(Veiculo veiculo_add) {
		listaVeiculos.add(veiculo_add);
	}
	
	public void remover_veiculo(int index) {
		listaVeiculos.remove(index);
		
	}
	public Veiculo identifica_veiculo(int index) {
		return listaVeiculos.get(index);
	}
	
	
}