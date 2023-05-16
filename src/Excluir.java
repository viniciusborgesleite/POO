import java.util.ArrayList;

public class Excluir {

	public static void excluir_cliente(ArrayList<Seguradora> lista_seg) {  // Exclui um cliente da lista de clientes da seguradora selecionada
		
		// Identifica o cliente proprietário do veículo a ser excluído
		Seguradora seg = Seleciona_objetos.seleciona_seguradora(lista_seg);
		Cliente cliente =  Seleciona_objetos.seleciona_cliente(seg);
		
		seg.remover_cliente(cliente.getNome());
	
	}
	
	public static void excluir_veiculo(ArrayList<Seguradora> lista_seg) { // Exclui um veículo da lista de veículos de um cliente
		// Identifica o veículo a ser excluído
		Seguradora seg = Seleciona_objetos.seleciona_seguradora(lista_seg);
		Cliente cliente =  Seleciona_objetos.seleciona_cliente(seg);
		Veiculo veiculo = Seleciona_objetos.seleciona_veiculo(cliente);
		
		cliente.remover_veiculo(veiculo.getPlaca());
	}
	
	public static void excluir_sinistro(ArrayList<Seguradora> lista_seg) { // Exclui um sinistro da lista de sinistros da seguradora
		
		Seguradora seg = Seleciona_objetos.seleciona_seguradora(lista_seg);
		
		Sinistro sinistro = Seleciona_objetos.seleciona_sinistro(seg);
		
		seg.remove_sinistro(sinistro.getId());
		
	}
}

