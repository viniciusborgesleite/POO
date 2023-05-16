import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class Cadastros {
	
	public static void cadastrar_cliente_pf(Seguradora seg) { // Lê os parâmetros e cadastra um cliente Pessoa Física
		Scanner scanner = new Scanner(System.in);
		
		
		// Pega e valida o nome do cliente
		System.out.println("Insira o nome do cliente:");
		String nome = scanner.nextLine();
		while (Validacao.valida_nome(nome) == false) {
			System.out.println("O valor digitado acima não é válido: O nome deve conter apenas letras e, no máximo, 40 caracteres");
			nome = scanner.nextLine();
		}
		
		//// Pega o endereço do cliente
		System.out.println("Insira o endereço do cliente:");
		String endereco = scanner.nextLine();
		
		
		// Pega o cpf do cliente e o valida
		System.out.println("Insira o cpf do cliente: (123-456-789-00)");
		String cpf = scanner.nextLine();
		while(Validacao.ValidarCpf(cpf) == false) {
			System.out.println("O valor digitado acima não é válido: o cpf fornecido deve ter o seguinte formato: (123-456-789-00)");
			cpf = scanner.nextLine();
		}
		
		
		// // Pega o gênero do cliente
		System.out.println("Insira o gênero do cliente:");
		String genero = scanner.nextLine();
		
		
		
		// Pega e valida a data da licença gerada
		System.out.println("Insira a data da licença gereada: (dia-mês-ano)");
		String licenca = scanner.nextLine();
		
		boolean errado = true;
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		Date data_licenca = new Date();
		
		while (errado == true) {
			errado = false;
			while (Validacao.valida_data(licenca) == false) {
				System.out.println("O valor digitado acima não é válido: a data fornecida deve ter o seguinte formato: (00-00-0000)");
				licenca = scanner.nextLine();
			}

			try {
				 data_licenca = formato.parse(licenca);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				errado = true;
			}
		}
		
		
		// Pega o grau de escolaridade do cliente
		System.out.println("Insira o grau de escolaridade do cliente:");
		String escolaridade = scanner.nextLine();
		
		
		// Pega e valida a data de nascimento do cliente
		System.out.println("Insira a data de nascimento do cliente: (dia-mês-ano)");
		String nascimento = scanner.nextLine();
		
		boolean erro = true;
		Date data_nascimento = new Date();
		while (erro == true) {
			erro = false;
			while (Validacao.valida_data(nascimento) == false) {
				System.out.println("O valor digitado acima não é válido: a data fornecida deve ter o seguinte formato: (00-00-0000)");
				nascimento = scanner.nextLine();
			}
			
			try {
				data_nascimento = formato.parse(nascimento);
			} catch (ParseException e) {
				erro = true;
			}
		}
		
		
		// Pega a classe econômica do cliente
		System.out.println("Insira a classe econômica do cliente:");
		String economica = scanner.nextLine();
		
		scanner.close();
		
		ClientPF novo_cliente_pf = new ClientPF(nome, endereco, cpf, genero, data_licenca, escolaridade, data_nascimento, economica);
		
		novo_cliente_pf.setValorSeguro(seg.calcularPrecoSeguroCliente(novo_cliente_pf));
		
		seg.adicionar_cliente(novo_cliente_pf);
		
		
	}
	
	public static void cadastrar_cliente_pj(Seguradora seg) { // Lê os parâmetros e cadastra um cliente Pessoa Jurídica
		Scanner scanner = new Scanner(System.in);
		
		// Pega o nome da empresa e o valida
		System.out.println("Insira o nome da empresa:");
		String nome = scanner.nextLine();
		
		while (Validacao.valida_nome(nome) == false) {
			System.out.println("O valor digitado acima não é válido: O nome deve conter apenas letras e, no máximo, 40 caracteres");
			nome = scanner.nextLine();
		}
		
		
		
		// Pega o endereço da empresa 
		System.out.println("Insira o endereço da empresa:");
		String endereco = scanner.nextLine();
		
		
		
		// Pega o cnpj da empresa e o valida
		System.out.println("Insira o cnpj da empresa: (apenas os números: (ex: 12345678998765)");
		String cnpj = scanner.nextLine();
		
		while(Validacao.validar_cnpj(cnpj) == false) {
			System.out.println("O valor digitado acima não é válido: O cnpj deve ser válido e ser apenas com os seus números: (ex: 12345678998765)");
			cnpj = scanner.nextLine();
		}
		
		
		// Pega o valor da data de fundação da empresa e a valida
		boolean erro = true;
		int int_fundacao = 0;
		while (erro) {
			System.out.println("Insira a data de fundação da empresa: (Ex: 04022004)");
			String fundacao = scanner.nextLine();
			
			while (Validacao.valida_data_int(fundacao) == false) {
				System.out.println("A data inserida é inválida: a data deve conter apenas números, no formato (ddMMyyyy)");
				System.out.println("Insira a data de fundação da empresa: (Ex: 04022004)");
				 fundacao = scanner.nextLine();
			}
			try {
				int_fundacao = Integer.parseInt(fundacao);
			}
			catch (NumberFormatException e) {
				erro = true;
			}	
		}
		
	
		
		// Pega e valida a quantidade de funcionários da empresa
		erro = true;
		int int_quantidade_funcionarios = 0;
		while (erro == true) {
			erro = false;
			System.out.println("Insira a quantidade de funcionários da empresa: ");
			String quantidade_funcionarios = scanner.nextLine();
			
			try {
				int_quantidade_funcionarios = Integer.parseInt(quantidade_funcionarios);
			}
			catch (NumberFormatException e) {
				System.out.println("O valor do ano inserido é inválido. Certifique-se de que apenas números foram digitados.");
				erro = true;
			}
		}
		
		ClientPJ novo_cliente_pj = new ClientPJ(nome, endereco, cnpj, int_fundacao, int_quantidade_funcionarios);
		
		novo_cliente_pj.setValorSeguro(seg.calcularPrecoSeguroCliente(novo_cliente_pj));
		
		seg.adicionar_cliente(novo_cliente_pj);
		
		scanner.close();
		}
		
		public static void cadastrar_veiculo(Cliente cliente) {
			Scanner scanner = new Scanner(System.in);
			
			// Pega a marca do carro
			System.out.println("Insira a marca do carro:");
			String marca = scanner.nextLine();
			
			
			// Pega o modelo do carro
			System.out.println("Insira o modelo do carro:");
			String modelo = scanner.nextLine();
			
			
			// Pega e valida a placa do carro
			System.out.println("Insira a placa do carro do carro: (ABC-1234 ou ABC1D23");
			String placa = scanner.nextLine();
			
			while (Validacao.valida_placa(placa) == false) {
				System.out.println("A placa inserida é inválida. A placa deve ser fornecida no formato antigo (ABC-1234) ou no formato Mercosul (ABC1D23)");
				System.out.println("Insira a placa do carro do carro: (ABC-1234 ou ABC1D23)");
				placa = scanner.nextLine();
			}
			
			
			
			// Pega e valida o ano de fabricação do carro
			boolean erro = true;
			int int_fabricacao = 2004;
			while (erro) {
				erro = false;
				
				System.out.println("Insira o ano de fabricação do carro: (Ex: 2004)");
				String fabricacao = scanner.nextLine();
				
				
				try {
					int_fabricacao = Integer.parseInt(fabricacao);
				} catch (NumberFormatException e ) {
					System.out.println("O valor do ano inserido é inválido. Certifique-se de que apenas números foram digitados.");
					erro = true;
				}
			}
			
			Veiculo novo_veiculo = new Veiculo(marca, modelo, placa, int_fabricacao);
			cliente.adiciona_veiculo(novo_veiculo);
			
			scanner.close();	
			
			
		}
		
		public static void cadastrar_seguradora(ArrayList<Seguradora> lista) {
			Scanner scanner = new Scanner(System.in);
			
			
			// Pega o nome da seguradora e o valida
			System.out.println("Insira o nome da seguradora:");
			String nome = scanner.nextLine();
			
			while (Validacao.valida_nome(nome) == false) {
				System.out.println("O nome inserido não é válido. Ele deve apresentar apenas letras e, no máximo, 40 caracteres");
				System.out.println("Insira o nome da seguradora:");
				nome = scanner.nextLine();
			}
			
			
			// Pega o telefone da seguradora e o valida
			System.out.println("Insira o telefone da seguradora: 11912345678");
			String telefone = scanner.nextLine();
			
			while (Validacao.valida_telefone(telefone) == false) {
				System.out.println("O telefone inserido não é válido. O valor inserido deve conter apenas números e apresentar 11 dígitos.");
				System.out.println("Insira o telefone da seguradora: 11912345678");
				telefone = scanner.nextLine();
			}
			
			
			// Pega o email da seguradora
			System.out.println("Insira o email da seguradora:");
			String email = scanner.nextLine();
			
			
			// Pega o endereço da seguradora
			System.out.println("Insira o endereço da seguradora:");
			String endereco = scanner.nextLine();
			
			
			Seguradora nova_seguradora = new Seguradora(nome, telefone, email, endereco);
			
			lista.add(nova_seguradora);
			
			scanner.close();
			
		}
		
		public static void cadastrar_sinistros(ArrayList<Seguradora> lista_seg) { // Lê os parâmetros e cadastra um sinistro
			
			
			// Dá a opção para o cliente selecionar a seguradora, o cliente e o veículo correspondentes ao sinistro
			Seguradora seg = Seleciona_objetos.seleciona_seguradora(lista_seg);
			Cliente cliente =  Seleciona_objetos.seleciona_cliente(seg);
			Veiculo veiculo = Seleciona_objetos.seleciona_veiculo(cliente);
			
			Scanner scanner = new Scanner(System.in);
			
			
			// Lê os outros parâmetros e cadastra o sinistro
			System.out.println("Insira a data do sinistro no formato (dd-MM-yyyy)");
			String data = scanner.nextLine();
			
			while (Validacao.valida_data(data) == false) {
				System.out.println("O valor digitado acima não é válido: a data fornecida deve ter o seguinte formato: (00-00-0000)");
				data = scanner.nextLine();
			}
			
			
			System.out.println("Insira o endereço do sinistro:");
			String endereco = scanner.nextLine();
			
			seg.gerar_sinistro(data, endereco, seg, veiculo, cliente);
			
			scanner.close();
			
		}
		
		
		
}
