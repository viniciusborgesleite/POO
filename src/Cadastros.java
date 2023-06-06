import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class Cadastros {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void cadastrar_cliente_pf(Seguradora seg) { // Lê os parâmetros e cadastra um cliente Pessoa Física	
	
		
		String nome = LeDados.lê_nome();
		
		String telefone = LeDados.le_telefone();
		
		String endereco = LeDados.le_endereco();
		
		String email = LeDados.le_email();
		
		String cpf = LeDados.le_cpf();
		
		String genero = LeDados.le_genero();
		
		Date data_licenca = LeDados.le_data_licenca();
		
		String escolaridade = LeDados.le_escolaridade();
		
		Date data_nascimento = LeDados.le_nascimento();
		
		ClientPF novo_cliente_pf = new ClientPF(nome, telefone, endereco, email, cpf, genero, data_licenca, escolaridade, data_nascimento);
		
		seg.adicionar_cliente(novo_cliente_pf);
		
		
	}
	
	public static void cadastrar_cliente_pj(Seguradora seg) { // Lê os parâmetros e cadastra um cliente Pessoa Jurídica
		
		// String nome, String telefone, String endereco, String email, String cnpj, Date dataFundacao, int quantidadeFuncionario
		
		
		 scanner = new Scanner(System.in);
		
		String nome = LeDados.le_nome_empresa();
		
		String telefone = LeDados.le_telefone();
		
		String endereco = LeDados.le_endereco_empresa();
		
		String email = LeDados.le_email();
		
		String cnpj = LeDados.le_cnpj();
		
		Date dataFundacao = LeDados.le_data_fundacao();
		
		int int_quantidade_funcionarios = LeDados.le_quantidade_funcionarios();
		
		ClientPJ novo_cliente_pj = new ClientPJ(nome, telefone, endereco, email, cnpj, dataFundacao, int_quantidade_funcionarios);
		
		seg.adicionar_cliente(novo_cliente_pj);
		
		
		}
		
	public static void cadastrar_veiculo(Seguradora seg) {
		// Lê os parâmetros e cadastra um veículo
			
		String marca = LeDados.le_marca();
		
		String modelo = LeDados.le_modelo();
		
		String placa = LeDados.le_placa();
		
		int int_fabricacao = LeDados.le_fabricacao();
		
		Veiculo novo_veiculo = new Veiculo(marca, modelo, placa, int_fabricacao);
		
		Cliente cliente = Seleciona_objetos.seleciona_cliente(seg);
		
		if (cliente instanceof ClientPF) {
			((ClientPF) cliente).cadastrar_veiculo(novo_veiculo);
		}
		
		else {
			
			Frota frota = Seleciona_objetos.seleciona_frota((ClientPJ) cliente);
			
			frota.adicionar_veiculo(novo_veiculo);
		}
			
			
			
		}
		
	public static void cadastrar_seguradora(ArrayList<Seguradora> lista) {
		// Lê os parâmetros e cadastra uma seguradora
		
		
		String cnpj = LeDados.le_cnpj(); 
		
		String nome = LeDados.le_nome_seguradora();
		
		String telefone = LeDados.le_telefone();
		
		String email =  LeDados.le_email();
		
		String endereco = LeDados.le_endereco_seguradora();
		                                       
		Seguradora nova_seguradora = new Seguradora(cnpj, nome, telefone, email, endereco);
		
		lista.add(nova_seguradora);
		
		
		
	}
		
	public static void cadastrar_sinistros(ArrayList<Seguradora> lista_seg) { // Lê os parâmetros e cadastra um sinistro
		
		// Dá a opção para o cliente selecionar a seguradora, o cliente e o veículo correspondentes ao sinistro
		//Date data, String endereco, Condutor condutor, Seguro seguro
		Seguradora seguradora = Seleciona_objetos.seleciona_seguradora(lista_seg);
		Seguro seguro = Seleciona_objetos.seleciona_seguro(seguradora);
		Condutor condutor = Seleciona_objetos.seleciona_condutor(seguro);
		
		
		Date data = LeDados.le_data_sinistro();
		
		String endereco = LeDados.le_endereco_sinsitro();
		
		Sinistro novo_sinistro = new Sinistro(data, endereco, condutor, seguro);
		
		seguro.adicionar_sinistro(novo_sinistro);
		 
		condutor.adicionar_sinistro(novo_sinistro);
		
		
	}
		
	public static void cadastrar_seguro_pf(Seguradora seg) {
		//public Seguro_PF(Date dataInicio, Date dataFim, Seguradora seguradora, Veiculo veiculo, ClientPF cliente) {
		
		Date dataInicio = LeDados.le_data_inicio();
		
		Date dataFim = LeDados.le_data_fim();
		
		ClientPF cliente = Seleciona_objetos.seleciona_cliente_PF(seg);
		
		Veiculo veiculo = Seleciona_objetos.seleciona_veiculo_PF(cliente);
		
		Seguro_PF novo_seguro_pf = new Seguro_PF(dataInicio, dataFim, seg, veiculo, cliente);
		
		seg.gerar_seguro(novo_seguro_pf);
		
	}
	
	public static void cadastrar_seguro_pj(Seguradora seg) {
		// public Seguro_PJ(Date dataInicio, Date dataFim, Seguradora seguradora, Frota frota, ClientPJ cliente) {
		
		Date dataInicio = LeDados.le_data_inicio();
		
		Date dataFim = LeDados.le_data_fim();
		
		ClientPJ cliente = Seleciona_objetos.seleciona_cliente_PJ(seg);
		
		Frota frota = Seleciona_objetos.seleciona_frota(cliente);
		
		Seguro_PJ novo_seguro_pj =  new Seguro_PJ(dataInicio, dataFim, seg, frota, cliente);
		
		seg.gerar_seguro(novo_seguro_pj);
		
		
	}
	
	public static void cadastrar_frota(Seguradora seg) {
		// Lê os parâmetros necessários e cadastra uma frota
		String code = LeDados.le_code();
		
		ClientPJ cliente = Seleciona_objetos.seleciona_cliente_PJ(seg);
		
		Frota frota = new Frota(code);
		
		cliente.cadastrar_frota(frota);
	}
	
	public static void cadastrar_condutor(Seguradora seg) {
		
		// Lê os parâmetros necessários e cadastra um novo condutor no seguro selecionado
		
		String cpf = LeDados.le_cpf();
		
		String nome = LeDados.lê_nome();
		
		String telefone = LeDados.le_telefone();
		
		String endereco = LeDados.le_endereco();
		
		String email = LeDados.le_email();
		
		Date dataNasc = LeDados.le_nascimento();
		
		Condutor condutor = new Condutor(cpf, nome, telefone, endereco, email, dataNasc);
		
		Seguro seguro = Seleciona_objetos.seleciona_seguro(seg);
		
		seguro.autorizarCondutor(condutor);
	}
		
		
		
		
}
