import java.util.ArrayList;
import java.util.Scanner;

public enum MenuListar {
	LISTAR_CLIENTE_SEG(1, "Listar clientes por meio da seguradora"),
	LISTAR_SINISTROS_SEG(2, "Listar sinistros por meio da seguradora"),
	LISTAR_SINISTRO_CLI(3, "Listar sinistros por meio de um cliente"),
	LISTAR_VEICULO_CLI(4, "Leistar veículos por um cliente"),
	LISTAR_VEICULO_SEC(5, "Listar veículos por uma seguradora"),
	VOLTAR(6, "voltar");
	
private int valor;
private String descricao;
	
	private MenuListar(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}
	
	
	public int get_valor() {
		return this.valor;
	}
	
	public String get_descricao() {
		return this.descricao;
	}
		
	
	
	public void imprime_menu() {
		
		for (MenuListar opcao : MenuListar.values()) {
			System.out.println(opcao.get_valor() + " - " + opcao.get_descricao());
		}
	}
	
	public void seleciona_opcao(ArrayList<Seguradora> lista_seg) {
		this.imprime_menu();
		Scanner scanner = new Scanner(System.in);
		int teclado = scanner.nextInt();
		
		switch (teclado) {
		case 1:
			Seleciona_objetos.seleciona_seguradora(lista_seg).listar_clientes();
			
			break;
		case 2:
			Seleciona_objetos.seleciona_seguradora(lista_seg).listar_sinistros();
			break;
		case 3: 
			Seguradora seg = Seleciona_objetos.seleciona_seguradora(lista_seg);
			Cliente cliente = Seleciona_objetos.seleciona_cliente(seg);
			cliente.listar_sinistro(seg);
			break;
		case 4: 
			Seleciona_objetos.seleciona_cliente(Seleciona_objetos.seleciona_seguradora(lista_seg)); // lista veículos por cliente
			break;
		case 5:
			Seleciona_objetos.seleciona_seguradora(lista_seg).listar_veículos_seguradora();  // Listar veículos por Seguradora
			break;
		case 6:
			Menu.CADASTRAR.seleciona_opcao(lista_seg);
			break;
		}
		scanner.close();
	}
}
