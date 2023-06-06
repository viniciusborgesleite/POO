import java.util.ArrayList;

public class Frota {
	
	private String code;
	private ArrayList<Veiculo> lista_veiculos;
	
	
	public Frota(String code) {
		super();
		this.code = code;
		this.lista_veiculos = new ArrayList<>();
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public ArrayList<Veiculo> getLista_veiculos() {
		return lista_veiculos;
	}


	public void setLista_veiculos(ArrayList<Veiculo> lista_veiculos) {
		this.lista_veiculos = lista_veiculos;
	}
	
	public boolean adicionar_veiculo(Veiculo veiculo) {
		lista_veiculos.add(veiculo);
		return true;
	}
	
	public boolean remove_veiculo(Veiculo veiculo) {
		for (int i = 0; i < lista_veiculos.size(); i++) {
			if (lista_veiculos.get(i).equals(veiculo)) {
				lista_veiculos.remove(i);
				return true;
			}
		}
		return false;
	}


	@Override
	public String toString() {
		return "Frota [code=" + code + "]";
	}
	
	
	
}
