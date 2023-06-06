import java.util.ArrayList;
import java.util.Scanner;

public class Seleciona_objetos {
	static Scanner sc = new Scanner(System.in);
	
	public static Seguradora seleciona_seguradora(ArrayList<Seguradora> lista) {
		// Seleciona, por meio da interação com o usuário, a seguradora a ser selecionada
		System.out.println("Selecione a seguradora sobre a qual a operação será feita:");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(i + " - " + lista.get(i).get_nome());
		}
		
		sc = new Scanner(System.in);
		System.out.println("Digite o número correspondente à seguradora escolhida");
		int index = sc.nextInt();
		
		while(index > lista.size()) {
			System.out.println("O número fornecido não é valido.");
			System.out.println("Digite o número correspondente à seguradora escolhida");
			index = sc.nextInt();		
		}
		
		System.out.println("Você selecionou a seguradora " + lista.get(index).get_nome());
		
		return lista.get(index);
	}
	
	
	public static Cliente seleciona_cliente(Seguradora seg) {
		// Seleciona, por meio da interação com o usuário, o cliente a ser selecionado
		System.out.println("Selecione o cliente sobre o qual a operação será feita:");
		
		for (int i = 0; i < seg.tamanho_lista_cliente(); i++) {
			System.out.println(i + " - " + seg.get_lista_clientes().get(i).getNome());
		}
		
		 sc = new Scanner(System.in);
		System.out.println("Digite o número correspondente ao cliente escolhido");
		int index = sc.nextInt();
		
		while(index >= seg.tamanho_lista_cliente()) {
			System.out.println("O número fornecido não é valido.");
			System.out.println("Digite o número correspondente ao cliente escolhido");
			index = sc.nextInt();		
		}
		
		System.out.println("Você selecionou o cliente " + seg.get_lista_clientes().get(index).getNome());
		
		return seg.get_lista_clientes().get(index);
		
	}
	
	public static Frota seleciona_frota(ClientPJ cliente) {
		
		System.out.println("Selecione a frota desejada");
		
		for (int i = 0; i < cliente.getLista_frota().size(); i++) {
			System.out.println(i + " - " + cliente.getLista_frota().get(i));
		}
		
		sc = new Scanner(System.in);
		System.out.println("Digite o número correspondente à frota escolhida");
		int index = sc.nextInt();
		
		while(index >= cliente.getLista_frota().size()) {
			System.out.println("O número fornecido não é valido.");
			System.out.println("Digite o número correspondente à frota escolhida");
			index = sc.nextInt();		
		}
		
		System.out.println("Você selecionou a frota " + cliente.getLista_frota().get(index));
		
		return cliente.getLista_frota().get(index);
		
	}
	
	public static Veiculo seleciona_veiculo(Cliente cliente) { 
		// Seleciona, por meio da interação com o usuário, o veículo a ser selecionado
		
			
		if (cliente instanceof ClientPF) {
			
			ArrayList<Veiculo> lista_veiculo = ((ClientPF) cliente).getLista_veiculos();
			
			for (int i = 0; i < lista_veiculo.size(); i++) {
				System.out.println(i + " - " + lista_veiculo.get(i).getPlaca());
			}
			
			sc = new Scanner(System.in);
			System.out.println("Digite o número correspondente ao veículo escolhido");
			int index = sc.nextInt();
			
			while(index >= lista_veiculo.size()) {
				System.out.println("O número fornecido não é valido.");
				System.out.println("Digite o número correspondente ao veículo escolhido");
				index = sc.nextInt();		
			}
			System.out.println("Você selecionou o veículo " + lista_veiculo.get(index).getPlaca());
			
			return lista_veiculo.get(index);
		}
		
		else {
			Frota frota  = seleciona_frota((ClientPJ) cliente);
			
			for (int i = 0; i < frota.getLista_veiculos().size(); i++) {
				System.out.println(i + " - " + frota.getLista_veiculos().get(i).getPlaca());
			}
			
			sc = new Scanner(System.in);
			System.out.println("Digite o número correspondente ao veículo escolhido");
			int index = sc.nextInt();
			
			while(index >= frota.getLista_veiculos().size()) {
				System.out.println("O número fornecido não é valido.");
				System.out.println("Digite o número correspondente ao veículo escolhido");
				index = sc.nextInt();		
			}
			System.out.println("Você selecionou o veículo " + frota.getLista_veiculos().get(index).getPlaca());
			
			return frota.getLista_veiculos().get(index);
		}
				
		
	}
	
public static Seguro seleciona_seguro(Seguradora seg) {
		
		// Seleciona, por meio da interação com o usuário, o seguro a ser selecionado
		
		System.out.println("Seleciona o seguro que deseja selecionar");
		
		for (int i = 0; i < seg.get_lista_seguros().size(); i++) {
			System.out.println(i + " - " + seg.get_lista_seguros().get(i));
		}
		
		sc = new Scanner(System.in);
		System.out.println("Digite o número correspondente ao sinistro escolhido");
		int index = sc.nextInt();
		
		while(index >= seg.get_lista_seguros().size()) {
			System.out.println("O número fornecido não é valido.");
			System.out.println("Digite o número correspondente ao sinistro escolhido");
			index = sc.nextInt();		
		}
		
		System.out.println("Você selecionou o sinistro " + seg.get_lista_seguros().get(index));
		
		return seg.get_lista_seguros().get(index);
		
	}
	
	public static Sinistro seleciona_sinistro(Seguro seguro) { // Refatorar
		// Seleciona, por meio da interação com o usuário, o sinistro a ser selecionado
		
		System.out.println("Seleciona o sinistro desejado");
		
		for (int i = 0; i < seguro.getLista_sinistros().size(); i++) {
			System.out.println(i + " - " + seguro.getLista_sinistros().get(i));
		}
		
		sc = new Scanner(System.in);
		System.out.println("Digite o número correspondente ao sinistro escolhido");
		int index = sc.nextInt();
		
		while(index >= seguro.getLista_sinistros().size()) {
			System.out.println("O número fornecido não é valido.");
			System.out.println("Digite o número correspondente ao sinistro escolhido");
			index = sc.nextInt();		
		}
		
		System.out.println("Você selecionou o sinistro " + seguro.getLista_sinistros().get(index));
		
		return seguro.getLista_sinistros().get(index);
		
	}
	
	public static Condutor seleciona_condutor(Seguro seguro) {
		
		// Seleciona, por meio da interação com o usuário, o condutor a ser selecionado
		
		System.out.println("Seleciona o seguro desejado");
		
		for (int i = 0; i < seguro.getLista_condutores().size(); i++) {
			System.out.println(i + " - " + seguro.getLista_condutores().get(i));
		}
		
		sc = new Scanner(System.in);
		System.out.println("Digite o número correspondente ao sinistro escolhido");
		int index = sc.nextInt();
		
		while(index >= seguro.getLista_condutores().size()) {
			System.out.println("O número fornecido não é valido.");
			System.out.println("Digite o número correspondente ao sinistro escolhido");
			index = sc.nextInt();		
		}
		
		System.out.println("Você selecionou o sinistro " + seguro.getLista_condutores().get(index));
		
		return seguro.getLista_condutores().get(index);
				
	}
	
	private static ArrayList<ClientPF> lista_cliente_PF(Seguradora seg){
		ArrayList<ClientPF> lista_clientes_pf = new ArrayList<>();
		
		for (Cliente cliente : seg.get_lista_clientes()) {
			if (cliente instanceof ClientPF) {
				lista_clientes_pf.add((ClientPF)cliente);
			}
		}
		return lista_clientes_pf;
	}
	
	public static ClientPF seleciona_cliente_PF(Seguradora seg) {
		// Seleciona, por meio da interação com o usuário, o cliente do tipo pf
		
		System.out.println("Selecione o cliente desejado");
		
		ArrayList<ClientPF> lista_clientes_pf = lista_cliente_PF(seg);
		
		for (int i = 0; i < lista_clientes_pf.size(); i++) {
			System.out.println(i + " - " + lista_clientes_pf.get(i));
		}
		
		sc = new Scanner(System.in);
		System.out.println("Digite o número correspondente ao cliente escolhido");
		int index = sc.nextInt();
		
		while(index >= lista_clientes_pf.size()) {
			System.out.println("O número fornecido não é valido.");
			System.out.println("Digite o número correspondente ao cliente escolhido");
			index = sc.nextInt();		
		}
		
		System.out.println("Você selecionou o cliente PF " + lista_clientes_pf.get(index));
		
		return lista_clientes_pf.get(index);
	}
	
	public static Veiculo seleciona_veiculo_PF(ClientPF cliente) {
		//// Seleciona, por meio da interação com o usuário, o veículo a ser selecionado
		System.out.println("Selecione o veículo desejado");
		
		for (int i = 0; i < cliente.getLista_veiculos().size(); i++) {
			System.out.println(i + " - " + cliente.getLista_veiculos().get(i));
		}
		
		sc = new Scanner(System.in);
		System.out.println("Digite o número correspondente ao veículo escolhido");
		int index = sc.nextInt();
		
		while(index >= cliente.getLista_veiculos().size()) {
			System.out.println("O número fornecido não é valido.");
			System.out.println("Digite o número correspondente ao veículo escolhido");
			index = sc.nextInt();		
		}
		
		System.out.println("Você selecionou o veículo " + cliente.getLista_veiculos().get(index));
		
		return cliente.getLista_veiculos().get(index);
	}
	
	private static ArrayList<ClientPJ> lista_cliente_pj(Seguradora seg){
		
		ArrayList<ClientPJ> lista_clientes_pj = new ArrayList<>();
		
		for (Cliente cliente : seg.get_lista_clientes()) {
			if (cliente instanceof ClientPJ) {
				lista_clientes_pj.add((ClientPJ)cliente);
			}
		}
		
		return lista_clientes_pj;
	}
	
	public static ClientPJ seleciona_cliente_PJ(Seguradora seg) {
		
		ArrayList<ClientPJ> lista_clientes_pj = lista_cliente_pj(seg);
		
		System.out.println("Selecione o cliente desejado");
		
		
		for (int i = 0; i < lista_clientes_pj.size(); i++) {
			System.out.println(i + " - " + lista_clientes_pj.get(i));
		}
		
		sc = new Scanner(System.in);
		System.out.println("Digite o número correspondente ao cliente escolhido");
		int index = sc.nextInt();
		
		while(index >= lista_clientes_pj.size()) {
			System.out.println("O número fornecido não é valido.");
			System.out.println("Digite o número correspondente ao cliente escolhido");
			index = sc.nextInt();		
		}
		
		System.out.println("Você selecionou o cliente PF " + lista_clientes_pj.get(index));
		
		return lista_clientes_pj.get(index);
		
	}
	

}
