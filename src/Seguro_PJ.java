import java.util.Date;

public class Seguro_PJ extends Seguro{
	
	private Frota frota;
	private ClientPJ cliente;
	
	public Seguro_PJ(Date dataInicio, Date dataFim, Seguradora seguradora, Frota frota, ClientPJ cliente) {
		super(dataInicio, dataFim, seguradora);
		
		this.frota = frota;
		this.cliente = cliente;
	}

	public Frota getFrota() {
		return frota;
	}

	public void setFrota(Frota frota) {
		this.frota = frota;
	}

	public ClientPJ getCliente() {
		return cliente;
	}

	public void setCliente(ClientPJ cliente) {
		this.cliente = cliente;
	}
	
	
	public boolean desautorizarCondutor(Condutor condutor) {
		for (int i = 0; i < super.getLista_condutores().size(); i++) {
			if (super.getLista_condutores().get(i).equals(condutor)) {
				super.getLista_condutores().remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void autorizarCondutor(Condutor condutor) {
		super.getLista_condutores().add(condutor);
	}

	
	private int calculaSinistrosCondutor() {
		// Calcula a quantidade de sinistros do condutor
		int soma = 0;
		
		for (Condutor condutor : this.getLista_condutores()) {
			soma = soma + condutor.getLista_sinistro().size();
		}
		return soma;
	}
	
	public double calcularValor() {
		// Calcula o valor do sinitro
		int quantidadeFunc = this.cliente.getQuantidadeFuncionarios();
		int quantidadeVeiculos = this.getFrota().getLista_veiculos().size();
		int AnosPosFundacao = this.cliente.calcula_idade(this.cliente.getDataFundacao());
		int quantidadeSinistrosCliente = this.getLista_sinistros().size();
		int quantidadeSinistrosCondutor = calculaSinistrosCondutor();
		
		double valor = CalcSeguro.VALOR_BASE.getValor() * (10 + (quantidadeFunc/10)) * (1 + 1/(quantidadeVeiculos + 2)) * (1 + 1/(AnosPosFundacao + 2)) * (2 + quantidadeSinistrosCliente/10) * (5 + quantidadeSinistrosCondutor/10);
		
		return valor;
	}
	
	public boolean gerar_sinistro(Sinistro sinistro) {
		adicionar_sinistro(sinistro);
		return true;
	}

	@Override
	public String toString() {
		return "Seguro_PJ [frota=" + frota + ", cliente=" + cliente + "]";
	}

	

	
	
}
