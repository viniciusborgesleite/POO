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
		
		Cliente cliente = Seleciona_objetos.seleciona_cliente(seg);
		
		Veiculo veiculo = Seleciona_objetos.seleciona_veiculo(cliente);
		
		cliente.remove_veiculo(veiculo);
		
	}
	
	public static void excluir_sinistro(ArrayList<Seguradora> lista_seg) { // Exclui um sinistro da lista de sinistros da seguradora
		
		Seguradora seg = Seleciona_objetos.seleciona_seguradora(lista_seg);
		
		Seguro seguro = Seleciona_objetos.seleciona_seguro(seg);
		
		Sinistro sinistro = Seleciona_objetos.seleciona_sinistro(seguro);
		
		Condutor condutor = Seleciona_objetos.seleciona_condutor(seguro);
		
		seguro.remove_sinistro(sinistro);
		
		condutor.remove_sinistro(sinistro);
		
		
	}
	
	public static void excluir_seguro(ArrayList<Seguradora> lista_seg) {
		
		Seguradora seg = Seleciona_objetos.seleciona_seguradora(lista_seg);
		
		Seguro seguro = Seleciona_objetos.seleciona_seguro(seg);
		
		seg.remover_seguro(seguro);
		
	}
	
	public static void excluir_condutor(ArrayList<Seguradora> lista_seg) {
		
		Seguradora seg = Seleciona_objetos.seleciona_seguradora(lista_seg);
		
		Seguro seguro = Seleciona_objetos.seleciona_seguro(seg);
		
		Condutor condutor = Seleciona_objetos.seleciona_condutor(seguro);
		
		seguro.remover_condutor(condutor);
		
	}
	
	public static void excluir_frota(ArrayList<Seguradora> lista_seg) {
		
		Seguradora seg = Seleciona_objetos.seleciona_seguradora(lista_seg);
		
		ClientPJ cliente = Seleciona_objetos.seleciona_cliente_PJ(seg);
		
		Frota frota = Seleciona_objetos.seleciona_frota(cliente);
		
		cliente.remover_frota(frota);
	}
}

