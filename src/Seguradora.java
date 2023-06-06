import java.util.ArrayList;
import java.util.List;


public class Seguradora{
    
	private final String cnpj;
    private String name;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Seguro> lista_seguros;
    private ArrayList<Cliente> lista_clientes;
    
    
    public Seguradora(String cnpj, String name, String telefone, String email, String endereco){
    	this.cnpj = cnpj;
        this.name = name;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.lista_seguros = new ArrayList<>();
        this.lista_clientes = new ArrayList<>();
    }
    
    // Getters and setters
    
    public String get_nome(){
        return name;
    }
    
    public void  set_name(String name){
        this.name = name;
    }
    
    public String get_telefone(){
        return telefone;
    }
    
    public void set_telefone(String telefone){
        this.telefone = telefone;
    }
    
    public String get_email(){
        return email;
    }
    
    public void set_email(String email){
        this.email = email;
    }
    
    public String get_endereco(){
        return endereco;
    }
    
    public void set_endereco(String endereco){
        this.endereco = endereco;
    }
 
	public String getCnpj() {
		return cnpj;
	}
	
	public ArrayList<Cliente> get_lista_clientes(){
		return this.lista_clientes;
	}
	
	public ArrayList<Seguro> get_lista_seguros(){
		return this.lista_seguros;
	}

	
	@Override
	public String toString() {
		return "Seguradora [cnpj=" + cnpj + ", name=" + name + ", telefone=" + telefone + ", email=" + email
				+ ", endereco=" + endereco + ", lista_seguros=" + lista_seguros + ", lista_clientes=" + lista_clientes
				+ "]";
	}

	public void listar_clientes() {
		for (int i = 0; i < lista_clientes.size(); i++) {
			System.out.println(identifica_cliente(i));

		}
	}
	
	public void gerar_seguro(Seguro seguro) {
		lista_seguros.add(seguro);
	}
	
	public boolean cancelar_seguro(int id) {
		for (int i = 0; i < lista_seguros.size(); i++) {
			if (lista_seguros.get(i).getId() == id) {
				lista_seguros.remove(i);
				return true;
			}
		}
		return false;
	}

    
	public Seguro identifica_seguro(int index) {
		return lista_seguros.get(index);
	}
	
	
	public boolean adicionar_cliente(Cliente inst_cliente) {
		lista_clientes.add(inst_cliente);
		return true;
	}
	
	public boolean remover_cliente(String nome) {
		int i;
		for (i = 0;  i < lista_clientes.size(); i++) {
			
			if(lista_clientes.get(i).getNome() == nome) {
				lista_clientes.remove(i);
				return true;
			}
		
		}
		return false;
	}
	
	public Cliente identifica_cliente(int index) {
		return lista_clientes.get(index);
	}
	
	public int tamanho_lista_cliente() {
		return lista_clientes.size();
	}
	
	
	public void listar_seguros() {
		for (Seguro seguro : this.lista_seguros) {
			System.out.println(seguro);
		}
	}
	
	public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente){
		
		ArrayList<Seguro> listaSeguroCliente = new ArrayList<>();
		
		for (int i = 0; i < lista_seguros.size(); i++) {
			
			if (lista_seguros.get(i).getCliente().equals(cliente)) {
				listaSeguroCliente.add(lista_seguros.get(i));
			}
		}
		return listaSeguroCliente;
	}
	
	public ArrayList<Sinistro> getSinistrosPorCliente(Cliente cliente){
		
		ArrayList<Sinistro> listaSinistroCliente = new ArrayList<>();
			
		for (int i = 0; i < lista_seguros.size(); i++) {
			
			if (lista_seguros.get(i).getCliente().equals(cliente)) {
				return lista_seguros.get(i).getLista_sinistros();
			}
		}
		return listaSinistroCliente;
	}
	
	public double calcularReceita() {
		double soma = 0;
		
		for (Seguro seguro : this.lista_seguros) {
			soma = soma + seguro.getValor_mensal();
		}
		
		return soma;
		
	}
	
	public void remover_seguro(Seguro seguro) {
		
		for (Seguro seg : this.get_lista_seguros()) {
			if (seg.equals(seguro)) {
				this.get_lista_seguros().remove(seg);
			}
		}
	}
}

	
