import java.util.ArrayList;
import java.util.Scanner;

public enum MenuListar {
	LISTAR_CLIENTE_SEG(1, "Listar clientes por meio da seguradora"),
	LISTAR_SINISTROS_SEGURO(2, "Listar sinistros por meio de um seguro"),
	LISTAR_SINISTRO_CONDUTOR(3, "Listar sinistros por meio de um condutor"),
	LISTAR_VEICULO(4, "Leistar veículos"),
	LISTAR_FROTA(5, "Listar frotas"),
	LISTAR_SEGURO(6, "Listar seguros"),
	LISTAR_CONDUTORES(7, "Listar condutores"),
	VOLTAR(8, "voltar");
	
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
			Seguradora seguradora_1 = Seleciona_objetos.seleciona_seguradora(lista_seg);
			seguradora_1.listar_clientes();
			break;
		case 2:
			Seguradora seguradora_2 = Seleciona_objetos.seleciona_seguradora(lista_seg);
			Seguro seguro = Seleciona_objetos.seleciona_seguro(seguradora_2);
			seguro.listar_sinistros();
			break;
		case 3: 
			Seguradora seguradora_3 = Seleciona_objetos.seleciona_seguradora(lista_seg);
			Seguro seguro_3 = Seleciona_objetos.seleciona_seguro(seguradora_3);
			Condutor condutor_3 = Seleciona_objetos.seleciona_condutor(seguro_3);
			condutor_3.listar_sinistros();
			break;
		case 4: 
			Seguradora seguradora_4 = Seleciona_objetos.seleciona_seguradora(lista_seg);
			Cliente cliente_4  = Seleciona_objetos.seleciona_cliente(seguradora_4);
			cliente_4.listar_veiculos();
			break;
		case 5:
			Seguradora seguradora_5 = Seleciona_objetos.seleciona_seguradora(lista_seg);
			ClientPJ cliente = Seleciona_objetos.seleciona_cliente_PJ(seguradora_5);
			cliente.listar_frota();;
			break;
		case 6:
			Seguradora seguradora_6 = Seleciona_objetos.seleciona_seguradora(lista_seg);
			seguradora_6.listar_seguros();
		case 7:
			Seguradora seguradora_7 = Seleciona_objetos.seleciona_seguradora(lista_seg);
			Seguro seguro_7 = Seleciona_objetos.seleciona_seguro(seguradora_7);
			seguro_7.listar_condutores();
		case 8:
			Menu.CADASTRAR.seleciona_opcao(lista_seg);
			break;
		}
		scanner.close();
	}
}
