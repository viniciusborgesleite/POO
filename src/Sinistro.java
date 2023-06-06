import java.util.Date;
import java.util.ArrayList;
public class Sinistro {
	
	private static ArrayList<Integer> lista_id = new ArrayList<>();
	private final int id;
	private Date data;
	private String endereco;
	private Condutor condutor;
	private Seguro seguro;

	
	private int gerador_id(ArrayList<Integer> lista_id) {
		
		int novo_id;
		
		if (lista_id.size() == 0) {
			 novo_id = 0;
		}
		else {
			int ultimo_elemento = lista_id.get(lista_id.size() - 1);
			novo_id = ultimo_elemento + 1;
		}
		
		lista_id.add(novo_id);
		return  novo_id;
	}
	
	
	public Sinistro(Date data, String endereco, Condutor condutor, Seguro seguro ) {
		
		this.id = this.gerador_id(lista_id);
		this.data = data;
		this.endereco = endereco;
		this.condutor = condutor;
		this.seguro = seguro;
	}


	public int getId() {
		return id;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	

	public Condutor getCondutor() {
		return condutor;
	}


	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}


	public Seguro getSeguro() {
		return seguro;
	}


	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}


	@Override
	public String toString() {
		return "Sinistro [id=" + id + ", data=" + data + ", endereco=" + endereco + ", condutor=" + condutor
				+ ", seguro=" + seguro + "]";
	}


	


	


	
	
	
}
