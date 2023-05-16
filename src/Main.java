import java.util.Date;
import java.util.List;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
    	
    	// Cria as datas na classe Date
    	Date dataLicenca = new Date(1239865200000L);
    	Date dataNascimento = new Date(1044265200000L);
    	
    	// Cria os 3 objetos da classe cliente
    	ClientPF vini = new ClientPF("Vinícius Borges", "Rua Porda Silva", "125.545.776-76", "Masculino", dataLicenca, "Ensino Superior Incompleto", dataNascimento, "Classe baixa");
  
        ClientPF suelen = new ClientPF("Suelen Santos", "Rua do Governador Israel Pinheiro", "021.558.496-13", "Feminino", dataLicenca, "Ensino Médio completo", dataNascimento, "Classe baixa");
        
        //nome, endereço, cnpj, int fundação, int quantidade de funcionários
        ClientPJ petrobras = new ClientPJ("Petrobras", "Macaé - RJ", "97153858000128", 04022004, 35);
       
        
        // Cadastra os carros e os adiciona às listas de carros dos clientes
        Veiculo rover = new Veiculo("Land Rover", "RangeRover", "HGL-5096", 2023);
        petrobras.adiciona_veiculo(rover);
      
        
        Veiculo asx = new Veiculo("mitsubishi", "asx", "HGL-2031", 2015);
        vini.adiciona_veiculo(asx);
        
        
        // Inicializa um objeto da classe Seguradora
        Seguradora liberty = new Seguradora("Liberty Seguros", "19939392112", "liberty.seguros@gmail.com", "Rua São Paulo");  
        // Adiciona seus clientes 
      
        liberty.adicionar_cliente(vini);
        liberty.adicionar_cliente(suelen); 
        // Remove a cliente Suelen
        liberty.remover_cliente("Suelen Santos");
        // Gera um sinistro e o visualiza
        liberty.gerar_sinistro("04022004", "Rua Padre Miguel", liberty, asx, vini);
        liberty.gerar_sinistro("26052001", "Rua Oswaldo Cruz", liberty, rover, petrobras);
        liberty.visualizarSinistro("Vinícius Borges");
        
        // Lista os clientes do objeto "liberty"
        liberty.listar_clientes();
        liberty.listar_sinistros();
        
        liberty.calcularReceita();
        
        
        ArrayList<Seguradora> lista_seguradora = new ArrayList<>(List.of(liberty));
        
        // Gera o menu textual
        Menu.CADASTRAR.seleciona_opcao(lista_seguradora);
        
        for (int i = 0; i < lista_seguradora.size(); i++) {
        	Seguradora seg = lista_seguradora.get(i);
        	System.out.println(seg.get_nome());
        	for (int j = 0; j < seg.tamanho_lista_cliente(); j++) {
        		Cliente cli = seg.get_lista().get(j);
        		System.out.println(cli.getNome());
        		for (int k = 0; k < cli.getListaVeiculos().size(); k++) {
        			System.out.println(cli.getListaVeiculos().get(k));
        		}
        	}
        	
        	
        }
        
        
     
        
    }
}