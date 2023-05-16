import java.util.ArrayList;
import java.util.Scanner;

public enum Menu_Cadastro_Cliente {
	CADASTRO_CLIENTE_PJ(1, "Cadastrar um cliente do tipo Pessoa Jurídica"),
	CADASTRO_CLIENTE_PF(2, "Cadastrar um cliente do tipo Pessoa Física"),
	VOLTAR(3, "Voltar");
	
	private int valor;
	private String descricao;
	
	private Menu_Cadastro_Cliente(int valor, String descricao) {
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
		for (Menu_Cadastro_Cliente opcao : Menu_Cadastro_Cliente.values()) {
			System.out.println(opcao.get_valor() + " - " + opcao.get_descricao());
		}
	}
	
	public void seleciona_funcao(ArrayList<Seguradora> lista_seg) {
		this.imprime_menu();
		Scanner scanner = new Scanner(System.in);
		int teclado = scanner.nextInt();
		
		switch(teclado) {
		case 1:
			Cadastros.cadastrar_cliente_pj(Seleciona_objetos.seleciona_seguradora(lista_seg));
			break;
		case 2:
			Cadastros.cadastrar_cliente_pf(Seleciona_objetos.seleciona_seguradora(lista_seg));
			break;
		case 3:
			MenuCadastrar.CADASTRAR_CLIENTE.seleciona_opcao(lista_seg);
			break;
		}
		scanner.close();
	}
}
