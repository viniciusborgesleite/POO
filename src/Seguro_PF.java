import java.util.Date;

public class Seguro_PF extends Seguro{
	
	private Veiculo veiculo;
	private ClientPF clientepf;
	
	public Seguro_PF(Date dataInicio, Date dataFim, Seguradora seguradora, Veiculo veiculo, ClientPF clientepf) {
		super(dataInicio, dataFim, seguradora);
		this.veiculo = veiculo;
		this.clientepf = clientepf;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public ClientPF getCliente() {
		return clientepf;
	}

	public void setCliente(ClientPF cliente) {
		this.clientepf = cliente;
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
	
	public int calculaSinistrosCondutores() {
		// Itera sobre a lista de condutores do seguro e soma os sinsitros de cada um desses condutores
		int soma = 0;
		for (int i = 0; i < super.getLista_condutores().size(); i++) {
			soma = soma + super.getLista_condutores().get(i).getLista_sinistro().size();
		}
		return soma;
	}
	
	public double calcula_fator_idade() {
		// Calcula o fator idade com base na idade recebida
		int idade = this.clientepf.calcula_idade(this.clientepf.getDataNascimento());
		
		double fator_idade;
		
		if (idade < 30) {
			fator_idade = CalcSeguro.FATOR_18_30.getValor();
		}
		else if(idade < 60) {
			fator_idade = CalcSeguro.FATOR_30_60.getValor();
		}
		else {
			fator_idade = CalcSeguro.FATOR_60_90.getValor();		
		}
		
		return fator_idade;
	}
		
	public double calcularValor() {
			// calcula o valor do seguro
			int quantidadeVeiculos = this.getCliente().getLista_veiculos().size();
			int quantidadeSinistrosCliente = super.getLista_sinistros().size();
			int quantidadeSinistrosCondutores = calculaSinistrosCondutores();
			
			double valor = (CalcSeguro.VALOR_BASE).getValor() * calcula_fator_idade() * (1 + (1/(quantidadeVeiculos * 2))) * (2 + quantidadeSinistrosCliente/10) * (5 + quantidadeSinistrosCondutores/10);
			
			return valor;
	}
	
	public boolean gerar_sinistro(Sinistro sinistro) {
		adicionar_sinistro(sinistro);
		return true;
	}

	@Override
	public String toString() {
		return "Seguro_PF [veiculo=" + veiculo + ", clientepf=" + clientepf + "]";
	}

	
	
}
