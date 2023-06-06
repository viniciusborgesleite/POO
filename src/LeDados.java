import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class LeDados {
	static Scanner scanner = new Scanner(System.in);
	
	public static String lê_nome() {
		// Pega e valida o nome do cliente
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Insira o nome do cliente:");
		String nome = scanner.nextLine();
		
		while (Validacao.valida_nome(nome) == false) {
			System.out.println("O valor digitado acima não é válido: O nome deve conter apenas letras e, no máximo, 40 caracteres");
			nome = scanner.nextLine();
		}
		
		return nome;
	}
	
	public static String le_endereco() {
		// Pega o endereço do cliente
		System.out.println("Insira o endereço do cliente:");
		String endereco = scanner.nextLine();
		return endereco;
	}
	
	public static String le_cpf() {
		
		System.out.println("Insira o cpf do cliente: (123-456-789-00)");
		String cpf = scanner.nextLine();
		
		while(Validacao.ValidarCpf(cpf) == false) {
			System.out.println("O valor digitado acima não é válido: o cpf fornecido deve ter o seguinte formato: (123-456-789-00)");
			cpf = scanner.nextLine();
		}
		return cpf;
	}
	
	
	public static String le_genero() {
		// Pega o gênero do cliente
		System.out.println("Insira o gênero do cliente:");
		String genero = scanner.nextLine();
		return genero;
	}
	
	public static Date le_data_licenca() {
		
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
		
		return data_licenca;
	}
	
	public static String le_escolaridade() {
			// Pega o grau de escolaridade do cliente
			System.out.println("Insira o grau de escolaridade do cliente:");
			String escolaridade = scanner.nextLine();
			
			return escolaridade;
	}
	
	public static Date le_nascimento() {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
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
		return data_nascimento;
	}
	
	public static String le_classe() {
		System.out.println("Insira a classe econômica do cliente:");
		String economica = scanner.nextLine();
		return economica;
	}
	
	public static String le_nome_empresa() {	
		// Pega o nome da empresa e o valida
		
		System.out.println("Insira o nome da empresa:");
		String nome = scanner.nextLine();
		
		while (Validacao.valida_nome(nome) == false) {
			System.out.println("O valor digitado acima não é válido: O nome deve conter apenas letras e, no máximo, 40 caracteres");
			nome = scanner.nextLine();
		}
		return nome;
	}
	
	public static String le_endereco_empresa() {
		System.out.println("Insira o endereço da empresa:");
		String endereco = scanner.nextLine();
		return endereco;
	}
	
	public static String le_cnpj() {
		System.out.println("Insira o cnpj da empresa: (apenas os números: (ex: 12345678998765)");
		String cnpj = scanner.nextLine();
		
		while(Validacao.validar_cnpj(cnpj) == false) {
			System.out.println("O valor digitado acima não é válido: O cnpj deve ser válido e ser apenas com os seus números: (ex: 12345678998765)");
			cnpj = scanner.nextLine();
		}
		return cnpj;
	}
	
	public static Date le_data_fundacao() {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		
		// Pega e valida a data de fundação do cliente
		
		System.out.println("Insira a data de fundação cliente: (dia-mês-ano)");
		String fundacao = scanner.nextLine();
		
		boolean erro = true;
		Date data_fundacao = new Date();
		
		while (erro == true) {
			
			erro = false;
			
			while (Validacao.valida_data(fundacao) == false) {
				System.out.println("O valor digitado acima não é válido: a data fornecida deve ter o seguinte formato: (00-00-0000)");
				fundacao = scanner.nextLine();
			}
			
			try {
				
				data_fundacao = formato.parse(fundacao);
				
			} catch (ParseException e) {
				erro = true;
			}
		}
		return data_fundacao;

	}
	
	public static int le_quantidade_funcionarios() {
		// Pega e valida a quantidade de funcionários da empresa
		
		boolean erro = true;
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
		return int_quantidade_funcionarios;
	}
	
	public static String le_marca() {
		// Pega a marca do carro
		System.out.println("Insira a marca do carro:");
		String marca = scanner.nextLine();
		
		return marca;
	}
	
	public static String le_modelo() {
		// Pega o modelo do carro
		System.out.println("Insira o modelo do carro:");
		String modelo = scanner.nextLine();
		
		return modelo;
	}
	
	public static String le_placa() {
		System.out.println("Insira a placa do carro do carro: (ABC-1234 ou ABC1D23");
		String placa = scanner.nextLine();
		
		while (Validacao.valida_placa(placa) == false) {
			System.out.println("A placa inserida é inválida. A placa deve ser fornecida no formato antigo (ABC-1234) ou no formato Mercosul (ABC1D23)");
			System.out.println("Insira a placa do carro do carro: (ABC-1234 ou ABC1D23)");
			placa = scanner.nextLine();
		}
		
		return placa;
	}
	
	public static int le_fabricacao() {
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
		
		return int_fabricacao;
	}
	
	public static String le_nome_seguradora() {
		// Pega o nome da seguradora e o valida
		System.out.println("Insira o nome da seguradora:");
		String nome = scanner.nextLine();
		
		while (Validacao.valida_nome(nome) == false) {
			System.out.println("O nome inserido não é válido. Ele deve apresentar apenas letras e, no máximo, 40 caracteres");
			System.out.println("Insira o nome da seguradora:");
			nome = scanner.nextLine();
		}
		return nome;
	}
	
	public static String le_telefone() {
		System.out.println("Insira o telefone: 11912345678");
		String telefone = scanner.nextLine();
		
		while (Validacao.valida_telefone(telefone) == false) {
			System.out.println("O telefone inserido não é válido. O valor inserido deve conter apenas números e apresentar 11 dígitos.");
			System.out.println("Insira o telefone da seguradora: 11912345678");
			telefone = scanner.nextLine();
		}
		return telefone;
	}
	
	public static String le_email() {
		// Pega o email da seguradora
		System.out.println("Insira o email da seguradora:");
		String email = scanner.nextLine();
		
		return email;
	}
	
	public static String le_endereco_seguradora() {
		// Pega o endereço da seguradora
		System.out.println("Insira o endereço da seguradora:");
		String endereco = scanner.nextLine();
		
		return endereco;
	}
	
	public static Date le_data_sinistro() {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		
		// Pega e valida a data do sinistro
		
		System.out.println("Insira a data do sinistro: (dia-mês-ano)");
		
		String dSinistro = scanner.nextLine();
		
		boolean erro = true;
		Date data_sinistro = new Date();
		
		while (erro == true) {
			
			erro = false;
			
			while (Validacao.valida_data(dSinistro) == false) {
				System.out.println("O valor digitado acima não é válido: a data fornecida deve ter o seguinte formato: (00-00-0000)");
				dSinistro = scanner.nextLine();
			}
			
			try {
				
				data_sinistro = formato.parse(dSinistro);
				
			} catch (ParseException e) {
				erro = true;
			}
		}
		
		return data_sinistro;
	}
	
	public static String le_endereco_sinsitro() {
		// Lé o endereço do sinistro
		System.out.println("Insira o endereço do sinistro:");
		String endereco = scanner.nextLine();
		
		return endereco;
	}
	
	public static Date le_data_inicio() {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		
		// Pega e valida a data de início do seguro
		
		System.out.println("Insira a data de início do seguro: (dia-mês-ano)");
		
		String inicio = scanner.nextLine();
		
		boolean erro = true;
		Date data_inicio = new Date();
		
		while (erro == true) {
			
			erro = false;
			
			while (Validacao.valida_data(inicio) == false) {
				System.out.println("O valor digitado acima não é válido: a data fornecida deve ter o seguinte formato: (00-00-0000)");
				inicio = scanner.nextLine();
			}
			
			try {
				
				data_inicio = formato.parse(inicio);
				
			} catch (ParseException e) {
				erro = true;
			}
		}
		
		return data_inicio;
	}
	
	public static Date le_data_fim() {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		
		// Pega e valida a data do fim do seguro
		
		System.out.println("Insira a data de fim do seguro: (dia-mês-ano)");
		
		String fim = scanner.nextLine();
		
		boolean erro = true;
		Date data_fim = new Date();
		
		while (erro == true) {
			
			erro = false;
			
			while (Validacao.valida_data(fim) == false) {
				System.out.println("O valor digitado acima não é válido: a data fornecida deve ter o seguinte formato: (00-00-0000)");
				fim = scanner.nextLine();
			}
			
			try {
				data_fim = formato.parse(fim);
			} catch (ParseException e) {
				erro = true;
			}
		}
		
		return data_fim;
	}
	
	public static String le_code() {
		// Lê o código da frota
		
		System.out.println("Insira o código da frota");
		
		String code = scanner.nextLine();
		
		return code;
		
	}
	
	

}
