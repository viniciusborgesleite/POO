import java.util.ArrayList;
import java.util.Scanner;
public enum MenuCadastrar{
	CADASTRAR_CLIENTE(1, "Cadastrar um cliente"),
	CADASTRAR_VEICULO(2, "Cadastrar um veículo"),
	CADASTRAR_SEGURADORA(3, "Cadastrar uma seguradora"),
	CADASTRAR_SEGURO(4, "Cadastrar um seguro"),
	CADASTRAR_FROTA(5, "Cadastrar uma frota"),
	CADASTRAR_CONDUTOR(6, "Cadastrar um condutor"),
	VOLTAR(7, "Voltar");
	
	private int valor;
	private String descricao;
	
	private MenuCadastrar(int valor, String descricao) {
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
		for (MenuCadastrar opcao : MenuCadastrar.values()) {
			System.out.println(opcao.get_valor() + " - " + opcao.get_descricao());
		}
	}
	
	public void seleciona_opcao(ArrayList<Seguradora> lista_seg) {
		this.imprime_menu();
		Scanner scanner = new Scanner(System.in);
		int teclado = scanner.nextInt();
		
		switch (teclado) {
			case 1:
				Menu_Cadastro_Cliente.CADASTRO_CLIENTE_PF.seleciona_funcao(lista_seg);
				break;
			case 2:
				Cadastros.cadastrar_veiculo(Seleciona_objetos.seleciona_seguradora(lista_seg));
				break;
			case 3:
				Cadastros.cadastrar_seguradora(lista_seg);
				break;
			case 4: 
				Menu_Cadastro_Seguro.CADASTRO_SEGURO_PF.seleciona_funcao(lista_seg);
				break;
			case 5:
				Cadastros.cadastrar_frota(Seleciona_objetos.seleciona_seguradora(lista_seg));
				break;
			case 6:
				Cadastros.cadastrar_condutor(Seleciona_objetos.seleciona_seguradora(lista_seg));
				break;
			case 7:
				Menu.CADASTRAR.seleciona_opcao(lista_seg);
				break;
		}
		scanner.close();
	}
	
	
	
}


