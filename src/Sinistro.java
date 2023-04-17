
public class Sinistro {
	
	private int id;
	private String data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;
	
	public int Id_generator() {
		int new_id = (int) Math.floor(Math.random() * (1000) + 0);
		return new_id;
	}	
	
	
	public Sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
		this.id = this.Id_generator();
		this.data = data;
		this.endereco = endereco;
		this.seguradora = seguradora;
		this.veiculo = veiculo;
		this.cliente = cliente;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	


	public Seguradora getSeguradora() {
		return seguradora;
	}


	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}


	public Veiculo getVeiculo() {
		return veiculo;
	}


	public void setVeiculo(Veiculo inst_veiculo) {
		veiculo = inst_veiculo;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	@Override
	public String toString() {
		return "Sinistro [id=" + id + ", data=" + data + ", endereco=" + endereco + ", seguradora=" + seguradora
				+ ", Veiculo=" + veiculo + ", cliente=" + cliente + "]";
	}


	
	
	
}
