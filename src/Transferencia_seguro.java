import java.util.ArrayList;

public class Transferencia_seguro {
	
	public static void transfere_seguro(ArrayList<Seguradora> lista_seg) {
		// Função de transferir seguro de um cliente para o outro
		System.out.println("Selecione a seguradora do cliente vendedor:");
		Seguradora seg_cliente_vendedor = Seleciona_objetos.seleciona_seguradora(lista_seg);
		
		System.out.println("Selecione o cliente vendedor:");
		Cliente vendedor = Seleciona_objetos.seleciona_cliente(seg_cliente_vendedor);
		
		System.out.println("Selecione a seguradora do cliente comprador:");
		Seguradora seg_cliente_comprador = Seleciona_objetos.seleciona_seguradora(lista_seg);
		
		System.out.println("Selecione o cliente comprador:");
		Cliente comprador = Seleciona_objetos.seleciona_cliente(seg_cliente_comprador);
		
		for (int i = 0; i < vendedor.getListaVeiculos().size(); i++) {
			comprador.adiciona_veiculo(vendedor.getListaVeiculos().get(i));
		}
		
		ArrayList<Veiculo> aux_lista_veiculos = vendedor.getListaVeiculos();
		aux_lista_veiculos.clear();
		
		vendedor.setListaVeiculos(aux_lista_veiculos);
		
		vendedor.setValorSeguro(seg_cliente_vendedor.calcularPrecoSeguroCliente(vendedor));
		
		comprador.setValorSeguro(seg_cliente_comprador.calcularPrecoSeguroCliente(comprador));
		
	}
}
