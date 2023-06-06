import java.util.ArrayList;
import java.util.Scanner;

public enum Menu_Cadastro_Seguro {
	CADASTRO_SEGURO_PF(1, "Cadastrar um seguro do tipo pessoa física"),
	CADASTRO_SEGURO_PJ(2, "Cadastrar um seguro do tipo pessoa jurídica"),
	VOLTAR(3, "Voltar");
	
	private int valor;
	private String descricao;
	
	private Menu_Cadastro_Seguro(int valor, String descricao) {
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
		for (Menu_Cadastro_Seguro opcao : Menu_Cadastro_Seguro.values()) {
			System.out.println(opcao.get_valor() + " - " + opcao.get_descricao());
		}
	}
	
	public void seleciona_funcao(ArrayList<Seguradora> lista_seg) {
		this.imprime_menu();
		Scanner scanner = new Scanner(System.in);
		int teclado = scanner.nextInt();
		
		switch(teclado) {
		case 1:
			Cadastros.cadastrar_seguro_pf(Seleciona_objetos.seleciona_seguradora(lista_seg));
			break;
		case 2:
			Cadastros.cadastrar_seguro_pj(Seleciona_objetos.seleciona_seguradora(lista_seg));
			break;
		case 3:
			MenuCadastrar.CADASTRAR_CLIENTE.seleciona_opcao(lista_seg);
			break;
		}
	}
}
