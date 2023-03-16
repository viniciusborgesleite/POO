
public class Sinistro {
	
	private int id;
	private String data;
	private String endereco;
	
	
	public int Id_generator() {
		int new_id = (int) Math.floor(Math.random() * (1000) + 0);
		return new_id;
	}	
	
	
	public Sinistro(String data, String endereco) {
		this.id = this.Id_generator();
		this.data = data;
		this.endereco = endereco;
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


	@Override
	public String toString() {
		return "Sinistro [id=" + id + ", data=" + data + ", endereco=" + endereco + "]";
	}
	
	
}
