import java.util.Date;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
    	
    	// Cria as datas na classe Date
    	Date dataLicenca = new Date(1239865200000L);
    	Date dataNascimento = new Date(1044265200000L);
    	
    	// Cria os 3 objetos da classe cliente
    	ClientPF vini = new ClientPF("Vinícius Borges", "Rua Porda Silva", "125.545.776-76", "Masculino", dataLicenca, "Ensino Superior Incompleto", dataNascimento, "Classe baixa");
        ClientPJ conpec = new ClientPJ("Conpec", "Rua das Ostras", "17004463000124", 04022004);
        ClientPF suelen = new ClientPF("Suelen Santos", "Rua do Governador Israel Pinheiro", "021.558.496-13", "Feminino", dataLicenca, "Ensino Médio completo", dataNascimento, "Classe baixa");
        
        // Imprime se os cpf's e cnpj's inscritos são válidos ou não
        System.out.println(conpec.validar_cnpj(conpec.getCnpj()));
        System.out.println(vini.ValidarCpf(suelen.getCpf()));
        
        // Cadastra os carros e os adiciona às listas de carros dos clientes
        Veiculo rover = new Veiculo("Land Rover", "RangeRover", "HGL-5096", 2023);
        conpec.adiciona_veiculo(rover);
        
        Veiculo asx = new Veiculo("mitsubishi", "asx", "HGL-2031", 2015);
        vini.adiciona_veiculo(asx);
        
        
        // Inicializa um objeto da classe Seguradora
        Seguradora liberty = new Seguradora("Liberty Seguros", "19939392112", "liberty.seguros@gmail.com", "Rua São Paulo");  
        // Adiciona seus clientes 
        liberty.adicionar_cliente(conpec);
        liberty.adicionar_cliente(vini);
        liberty.adicionar_cliente(suelen); 
        // Remove a cliente Suelen
        liberty.remover_cliente("Suelen Santos");
        // Gera um sinistro e o visualiza
        liberty.gerar_sinistro("04022004", "Rua Padre Miguel", liberty, asx, vini);
        liberty.visualizarSinistro("Vinícius Borges");
        // Lista os clientes do objeto "liberty"
        liberty.listar_clientes();
        liberty.listar_sinistros();
        
        // Gera o menu textual
        
        int comando = -1;
        
        // Enquanto a entrada não for 0;
        while(comando != 0) {
        	// Imprime as instruções para o usuário
        	Scanner scanner = new Scanner(System.in);
        	System.out.println("Digite o número da opção que quer acessar: ");
        	System.out.println("0 - Fechar interface");
        	System.out.println("1 - Nome da seguradora");
        	System.out.println("2 - Telefone da seguradora");
        	System.out.println("3 - Endereço da seguradora");
        	System.out.println("4 - Email da seguradora");
        	System.out.println("5 - Lista de clientes da seguradora");
        	System.out.println("6 - Lista de sinistros da seguradora");
        	
        	// De acordo com o comando dado, retorna a informação desejada.
        	if (scanner.hasNextInt()) {
        		comando = scanner.nextInt();
            	
            	
            	if(comando == 1) {
            		System.out.println(liberty.get_nome());
            	}
            	else if(comando == 2) {
            		System.out.println(liberty.get_telefone());
            	}
            	else if(comando == 3) {
            		System.out.println(liberty.get_endereco());
            	}
            	else if(comando == 4) {
            		System.out.println(liberty.get_email());
            	}
            	else if (comando == 5) {
            		liberty.listar_clientes();
            	}
            	else if (comando == 6) {
            		liberty.listar_sinistros();
            	}
            	else if (comando != 0){ // Se o usuário não fornecer uma entrada no intervalo de 0 a 6, retorna a mensagem de erro:
            		System.out.println("Entrada inválida. Digite apenas o número referente a opção desejada.");
            	}
        	}
        	else {
        		System.out.println("Entrada inválida. Digite apenas o número referente a opção desejada.");
        		scanner.nextLine(); 
        	}
        	
        	
        }
     
        
    }
}