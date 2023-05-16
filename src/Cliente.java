import java.util.ArrayList;
import java.util.List;


public class Cliente{
    
    private String nome;
    private String endereco;
    private ArrayList<Veiculo> listaVeiculos;
    private double valorSeguro;



	public Cliente(String nome, String endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = new ArrayList<>();
		this.valorSeguro = 0;
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
	
	public ArrayList<Veiculo> getLista(){
		return listaVeiculos;
	}
	
	
	public ArrayList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}



	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}



	public double getValorSeguro() {
		return valorSeguro;
	}



	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}



	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", endereco=" + endereco + ", listaVeiculos=" + listaVeiculos
				+ ", valorSeguro=" + valorSeguro + "]";
	}

	public void listar_sinistro(Seguradora seg) {
		for (int i = 0; i < seg.get_lista_sinistro().size(); i++) {
			
			if(seg.get_lista_sinistro().get(i).getCliente().getNome() == this.nome) {
				System.out.println(seg.get_lista_sinistro().get(i));
				
			}
		}
	}

	public void adiciona_veiculo(Veiculo veiculo_add) {
		listaVeiculos.add(veiculo_add);
	}
	

	public boolean remover_veiculo(String placa) {
		for (int i = 0; i < listaVeiculos.size(); i ++) {
			if (listaVeiculos.get(i).getPlaca() == placa) {
				listaVeiculos.remove(i);
				return true;
			}
		}
		return false;
		
	}
	public Veiculo identifica_veiculo(int index) {
		return listaVeiculos.get(index);
	}
	
	public void listar_veiculos() {
		for (int i = 0; i < this.listaVeiculos.size(); i++){
			System.out.println(this.listaVeiculos.get(i).getPlaca());
		}
	}
	
	public double calculaScore() {
		return 0;
	}
	
	
}