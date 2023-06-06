import java.util.ArrayList;
import java.util.Date;

public abstract class Seguro {
	private static ArrayList<Integer> lista_id = new ArrayList<>();
	private final int id;
	private Date dataInicio;
	private Date dataFim;
	private Seguradora seguradora;
	private ArrayList<Sinistro> lista_sinistros;
	private ArrayList<Condutor> lista_condutores;
	private double valor_mensal;
	
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
	
	public abstract double calcularValor();
	
	public Seguro(Date dataInicio, Date dataFim, Seguradora seguradora) {
		super();
		this.id = gerador_id(lista_id);
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.seguradora = seguradora;
		this.lista_sinistros = new ArrayList<>();
		this.lista_condutores = new ArrayList<>();
		this.valor_mensal = 0;
		
		
	}


	public int getId() {
		return id;
	}


	public Date getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}


	public Date getDataFim() {
		return dataFim;
	}


	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}


	public Seguradora getSeguradora() {
		return seguradora;
	}


	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}


	public ArrayList<Sinistro> getLista_sinistros() {
		return lista_sinistros;
	}


	public void setLista_sinistros(ArrayList<Sinistro> lista_sinistros) {
		this.lista_sinistros = lista_sinistros;
	}


	public ArrayList<Condutor> getLista_condutores() {
		return lista_condutores;
	}


	public void setLista_condutores(ArrayList<Condutor> lista_condutores) {
		this.lista_condutores = lista_condutores;
	}


	public double getValor_mensal() {
		setValor_mensal(this.calcularValor());
		return valor_mensal;
	}


	public void setValor_mensal(double valor_mensal) {
		this.valor_mensal = valor_mensal;
	}
	
	public abstract Cliente getCliente();
	
	public boolean adicionar_sinistro(Sinistro sinistro) {
		lista_sinistros.add(sinistro);
		return true;
	}
	
	public void listar_sinistros() {
		for (Sinistro sinistro : this.lista_sinistros) {
			System.out.println(sinistro);
		}
	}
	
	public void listar_condutores() {
		for (Condutor condutor : this.getLista_condutores()) {
			System.out.println(condutor);
		}
	}
	
	public void remove_sinistro(Sinistro sinistro) {
		
		for (Sinistro sin : this.getLista_sinistros()) {
			if (sin.equals(sinistro)) {
				this.getLista_sinistros().remove(sin);
			}
		}
	}
	
	public void remover_condutor(Condutor condutor) {
		
		for (Condutor cond : this.getLista_condutores()) {
			if(cond.equals(condutor)) {
				this.getLista_condutores().remove(cond);
			}
		}
	}
	
	
	
	public abstract boolean desautorizarCondutor(Condutor condutor);
	
	public abstract void autorizarCondutor(Condutor condutor);
	
	public abstract boolean gerar_sinistro(Sinistro sinistro);

	@Override
	public String toString() {
		return "Seguro [id=" + id + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", seguradora=" + seguradora
				+ ", valor_mensal=" + this.getValor_mensal() + "]";
	}

	
	
	
	
}
