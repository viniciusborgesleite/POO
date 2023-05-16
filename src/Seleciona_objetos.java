import java.util.ArrayList;
import java.util.Scanner;

public class Seleciona_objetos {
	
	
	public static Seguradora seleciona_seguradora(ArrayList<Seguradora> lista) {
		// Seleciona, por meio da interação com o usuário, a seguradora a ser selecionada
		System.out.println("Selecione a seguradora sobre a qual a operação será feita:");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(i + " - " + lista.get(i).get_nome());
		}
		
		Scanner sc = new Scanner(System.in);
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
			System.out.println(i + " - " + seg.get_lista().get(i).getNome());
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o número correspondente ao cliente escolhido");
		int index = sc.nextInt();
		
		while(index >= seg.tamanho_lista_cliente()) {
			System.out.println("O número fornecido não é valido.");
			System.out.println("Digite o número correspondente ao cliente escolhido");
			index = sc.nextInt();		
		}
		
		System.out.println("Você selecionou o cliente " + seg.get_lista().get(index).getNome());
		
		return seg.get_lista().get(index);
		
	}
	
	public static Veiculo seleciona_veiculo(Cliente cliente) {
		// Seleciona, por meio da interação com o usuário, o veículo a ser selecionado
		System.out.println("Selecione o veículo ao qual o sinistro será adicionado:");
		
		for (int i = 0; i < cliente.getLista().size(); i++) {
			System.out.println(i + " - " + cliente.getLista().get(i).getPlaca());
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o número correspondente ao veículo escolhido");
		int index = sc.nextInt();
		
		while(index >= cliente.getLista().size()) {
			System.out.println("O número fornecido não é valido.");
			System.out.println("Digite o número correspondente ao veículo escolhido");
			index = sc.nextInt();		
		}
		
		
		System.out.println("Você selecionou a seguradora " + cliente.getLista().get(index).getPlaca());
		
		return cliente.getLista().get(index);
		
	}
	
	public static Sinistro seleciona_sinistro(Seguradora seg) {
		// Seleciona, por meio da interação com o usuário, o sinistro a ser selecionado
		System.out.println("Seleciona o sinistro que deseja excluir");
		
		for (int i = 0; i < seg.get_lista_sinistro().size(); i++) {
			System.out.println(i + " - " + seg.get_lista_sinistro().get(i));
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o número correspondente ao sinistro escolhido");
		int index = sc.nextInt();
		
		while(index >= seg.get_lista_sinistro().size()) {
			System.out.println("O número fornecido não é valido.");
			System.out.println("Digite o número correspondente ao sinistro escolhido");
			index = sc.nextInt();		
		}
		
		System.out.println("Você selecionou o sinistro " + seg.get_lista_sinistro().get(index));
		
		return seg.get_lista_sinistro().get(index);
		
	}
}
