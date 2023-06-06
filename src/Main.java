import java.util.Date;
import java.util.List;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
 
    	
    	// Cria as datas na classe Date
    	Date dataLicenca = new Date(1239865200000L);
    	Date dataNascimento = new Date(1044265200000L);
    	
    	// Instancia os objetos corretamente
    	
    	Seguradora liberty = new Seguradora("58905355000100", "Liberty Seguros", "35994243163", "libertyseguros@gmail.com", "Rua Cristiano Ronaldo"); 
    	
    	ClientPF vini = new ClientPF("Vinícius Borges", "31994243163", "Rua Pires Silva", "viniciusborges369@gmail.com",  "125.545.776-76", "Masculino", dataLicenca, "Ensino Superior Incompleto", dataNascimento);
  
        ClientPF suelen = new ClientPF("Suelen Santos", "32994215432", "Rua do Governador Israel Pinheiro", "suelensantos@bol.com", "021.558.496-13", "Feminino", dataLicenca, "Ensino Médio completo", dataNascimento);
        
        ClientPJ petrobras = new ClientPJ("Petrobras", "21994243165", "Macaé - RJ", "Petrobras@estatal.com.br",  "97153858000128", dataNascimento, 35);
       
        Veiculo rover = new Veiculo("Land Rover", "RangeRover", "HGL-5096", 2023);
        
        Veiculo asx = new Veiculo("mitsubishi", "asx", "HGL-2031", 2015);
        
        Frota frota = new Frota("Cabuloso");
        
        Seguro_PF seguroPF = new Seguro_PF(dataLicenca, dataNascimento, liberty, rover, vini);
        
        Seguro_PJ seguroPJ = new Seguro_PJ(dataLicenca, dataNascimento, liberty, frota, petrobras);
        
        Condutor agostinho_carrara = new Condutor("125.545.776-76", "Agostinho Carrara", "31994243163", "Rua Roxo Moreira", "carrara_Taxi_Taxi_Carrara@gmail.com", dataNascimento);
        
        Sinistro sinistro = new Sinistro(dataLicenca, "Rua das Ostras", agostinho_carrara, seguroPF);
        
        //Adiciona os objetos aos seus espaços correspondentes no sistema
        liberty.adicionar_cliente(petrobras);
        
        liberty.adicionar_cliente(vini);
        
        liberty.adicionar_cliente(suelen);
        
        liberty.gerar_seguro(seguroPJ);
        
        liberty.gerar_seguro(seguroPF);
        
        petrobras.cadastrar_frota(frota);
        
        frota.adicionar_veiculo(asx);
        
        vini.cadastrar_veiculo(rover);
 
        seguroPF.autorizarCondutor(agostinho_carrara);
        
        seguroPF.adicionar_sinistro(sinistro);
        
        
        // Imprime os objetos utilizando o toString()
        
        System.out.println(liberty);
        System.out.println(vini);
        System.out.println(suelen);
        System.out.println(petrobras);
        System.out.println(rover);
        System.out.println(asx);
        System.out.println(frota);
        System.out.println(seguroPF);
        System.out.println(seguroPJ);
        System.out.println(agostinho_carrara);
        System.out.println(sinistro);
        // Adiciona seus clientes  
      
     
        
        
        ArrayList<Seguradora> lista_seguradora = new ArrayList<>(List.of(liberty));
        
        // Gera o menu textual
    	Menu.CADASTRAR.seleciona_opcao(lista_seguradora);
        
    
        
        
     
        
    }
}