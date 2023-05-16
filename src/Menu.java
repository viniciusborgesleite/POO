import java.util.ArrayList;
import java.util.Scanner;

public enum Menu {
	CADASTRAR(1, "Cadastrar"),
	LISTAR(2, "Listar objetos"),
	EXCLUIR(3, "Exlcuir um objeto"),
	GERAR_SINISTRO(4, "Gerar um sinistro"),
	TRANSFERIR_SEGURO(5, "Transferir um seguro"),
	CALCULAR_RECEITA_SEGURADORA(6, "Calcular a receita geral da Seguradora"),
	SAIR(0, "Sair");

	
	private int valor;
	private String descricao;
	
	private Menu(int valor, String descricao) {
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
		for (Menu opcao : Menu.values()) {
			System.out.println(opcao.get_valor() + " - " + opcao.get_descricao());
		}
	}
	
	
	
	public void seleciona_opcao(ArrayList<Seguradora> lista_seg) {
		this.imprime_menu();
		Scanner scanner = new Scanner(System.in);
		int teclado = scanner.nextInt();
		
		switch (teclado) {
		case 1:
			MenuCadastrar.CADASTRAR_CLIENTE.seleciona_opcao(lista_seg);
			break;
		
		case 2:
			MenuListar.LISTAR_CLIENTE_SEG.seleciona_opcao(lista_seg);
			break;
		
		case 3:
			MenuExcluir.EXCLUIR_CLIENTE.seleciona_opcao(lista_seg);
			break;
		case 4:
			Cadastros.cadastrar_sinistros(lista_seg);
			break;
		case 5:
			Transferencia_seguro.transfere_seguro(lista_seg);
			break;
		case 6:
			Seleciona_objetos.seleciona_seguradora(lista_seg).calcularReceita();
			break;
		case 0: 
			//break
			break;
			
		}
		scanner.close();
		
	}	
}
