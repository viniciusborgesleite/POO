import java.util.ArrayList;
import java.util.Scanner;

public enum MenuExcluir {
	EXCLUIR_CLIENTE(1, "Excluir um cliente"),
	ECLUIR_VEICULO(2, "Excluir um veículo"),
	EXCLUIR_SINSITRO(3, "Excluir um sinsitro"),
	VOLTAR(4, "Voltar");
	
private int valor;
private String descricao;
	
	private MenuExcluir(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public int get_valor() {
		return this.valor;
	}
	
	public String get_descricao(){
		return this.descricao;
	}
	
	public void imprime_menu() {
		for (MenuExcluir opcao : MenuExcluir.values()) {
			System.out.println(opcao.get_valor() + " - " + opcao.get_descricao());
		}
	}
	
	public void seleciona_opcao(ArrayList<Seguradora> lista_seg) {
		this.imprime_menu();
		Scanner scanner = new Scanner(System.in);
		int teclado = scanner.nextInt();
		
		switch (teclado) {
		case 1:
			Excluir.excluir_cliente(lista_seg);
			break;
		case 2: 
			Excluir.excluir_veiculo(lista_seg);
			break;
		case 3:
			Excluir.excluir_sinistro(lista_seg);
			break;
		case 4:
			Menu.CADASTRAR.seleciona_opcao(lista_seg);
		}
		scanner.close();
	}
}
