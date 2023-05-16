import java.util.ArrayList;
import java.util.List;


public class Seguradora{
    
    private String name;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> lista_sinistro;
    private ArrayList<Cliente> lista_clientes;
    
    
    public Seguradora(String name, String telefone, String email, String endereco){
        this.name = name;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.lista_sinistro = new ArrayList<>();
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
    
 
	@Override
	public String toString() {
		return "Seguradora [name=" + name + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco
				+ "]";
	}

	public void adiciona_sinistro(Sinistro inst_sinistro) {
		lista_sinistro.add(inst_sinistro);
	}
	
	public void remove_sinistro(int index) {
		lista_sinistro.remove(index);
	}
    
	public Sinistro identifica_sinistro(int index) {
		return lista_sinistro.get(index);
	}
	
	public boolean adicionar_cliente(Cliente inst_cliente) {
		lista_clientes.add(inst_cliente);
		return true;
	}
	
	public ArrayList<Cliente> get_lista(){
		return this.lista_clientes;
	}
	
	public ArrayList<Sinistro> get_lista_sinistro(){
		return this.lista_sinistro;
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
	
	
	public void listar_clientes() {
		for (int i = 0; i < lista_clientes.size(); i++) {
			System.out.println(identifica_cliente(i));

		}
	}
	
	public boolean gerar_sinistro(String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
		Sinistro novo_sinistro = new Sinistro(data, endereco, seguradora, veiculo, cliente);
		adiciona_sinistro(novo_sinistro);
		return true;
	}
	
	public boolean visualizarSinistro(String nome) {
		
		for (int i = 0; i < lista_sinistro.size(); i++) {
			if(identifica_sinistro(i).getCliente().getNome() == nome) {
				System.out.println(identifica_sinistro(i));
				return true;
			}
		}
		return false;
		
		
	}
	
	public void listar_sinistros() {
		for (int i = 0; i < lista_sinistro.size(); i++) {
			System.out.println(identifica_sinistro(i));
		}
	}
	
	public boolean excluir_sinistro(int id) {
		for (int i = 0; i < lista_sinistro.size(); i++) {
			if (lista_sinistro.get(i).getId() == id) {
				lista_sinistro.remove(i);
				return true;
			}
		}
		return false;
	}
	
	private int calcula_quantidade_sinistro(Cliente cliente) {
		int contador = 0;
		for(int i = 0; i < this.lista_sinistro.size(); i++) {
			if (this.lista_sinistro.get(i).getCliente().equals(cliente)) {
				contador++;
			}
		}
		return contador;
	}
	
	public double calcularPrecoSeguroCliente(Cliente cliente) {
		
		double precoSeguro = cliente.calculaScore();
		int fator_sinistro = 1 + calcula_quantidade_sinistro(cliente);
		
		return precoSeguro + fator_sinistro;	
	}
	
	public double calcularReceita() {
		double receita = 0;
		for (int i = 0; i < this.lista_clientes.size(); i++) {
			receita = receita + lista_clientes.get(i).getValorSeguro();
		}
		return receita;
	}
	
	public void listar_veículos_seguradora() {
		for (int i = 0; i < this.lista_clientes.size(); i++) {
			this.lista_clientes.get(i).listar_veiculos();
		}
	}
}
