import java.util.ArrayList;
import java.util.Arrays;
public class Validacao {
	
	public static final ArrayList<Integer> listaIndex = new ArrayList<>(Arrays.asList(0, 1, 3, 4, 6, 7, 8, 9));
	
	private static int calcula_digito1(String cnpj) {
		
		int[] pesos = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
		
		int soma = 0;
		
		for(int i = 0; i < 12; i++) {
			soma += Character.getNumericValue(cnpj.charAt(i)) * pesos[i];
		}
		
		int resto = soma % 11;
		
		if(resto < 2) {
			return  0;
		}
		else {
			return 11 - resto;
		}
		
	}
	
	private static int calcula_digito2(String cnpj) {
		
		int[] pesos = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
		
		int soma = 0;
		
		for (int i = 0; i < 13; i++) {
			soma += Character.getNumericValue(cnpj.charAt(i)) * pesos[i];
		}
		
		int resto = soma % 11;
		
		if (resto < 2) {
			return 0;
		}
		else {
			return 11 - resto;
		}
	}
	
	private static boolean compara_digitos(String cnpj) {
		if (calcula_digito1(cnpj) != Character.getNumericValue(cnpj.charAt(12))) {
			return false;
		}
		else if (calcula_digito2(cnpj) != Character.getNumericValue(cnpj.charAt(13))) {
			return false;
		}
		else{
			return true;
		}
	}
	
	public static boolean validar_cnpj(String cnpj) {
		
		if(cnpj.length() != 14) {
			return false;
		}
		
		if (compara_digitos(cnpj) == false) {
			return false;
		}
		
		return true;
 }
	

	private static boolean caracteres_iguais(String cpf){
		// Verifica se todos os números são iguais, retornando true ou false
			
		for (int i = 0; i < cpf.length(); i++ ) {
			if(cpf.charAt(i) != cpf.charAt(0)) {
				return false;
			}
		}
		return true;
	}
	



	private static int  primeiro_digito_verificador(String cpf) {
		// Efetua o cálculo do primeiro digito verificador
		
		int soma_primeiro_digito = 0;
		
		for (int i = 0; i < 9; i++) {
			
			soma_primeiro_digito += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
			
		}
		
		int resto = soma_primeiro_digito % 11;
		
		if (resto < 2) {
			return 0;
		}
		
		else {
			return (11 - resto);
		}	
		
	}
	
	private static int segundo_digito_verificador(String cpf) {
		
		// Efetua o calculo do segundo dígito verificador do cpf
		
		int soma_segundo_digito = 0;
		
		for (int i = 0; i < 10; i++) {
			
			soma_segundo_digito += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
			
		}
		
		int resto = soma_segundo_digito % 11;
		
		if (resto < 2) {
			return 0;
		}
		
		else {
			return (11 - resto);
		}	
		
	}
	
	private static boolean compara_digitos_cpf(String cpf) {
		// Verifica se os dígitos comparadores calculados na função acima são compatíveis com 
		// o do cpf dado como entrada
			
		if (Character.getNumericValue(cpf.charAt(9)) == primeiro_digito_verificador(cpf)) {
			
			if (Character.getNumericValue(cpf.charAt(10)) == segundo_digito_verificador(cpf)) {
				return true;
			}
			else {
				return false;
			}
			
		}
		
		else {
			return false;
		}
		
		
	}
	
	
	
    
    public static boolean ValidarCpf(String cpf) {
    	// Avalia a validade do cpf
    	
    	String replaced_cpf = cpf.replaceAll("\\.", "");
    	replaced_cpf = replaced_cpf.replaceAll("-", "");
    	
    	if (replaced_cpf.length() != 11) { 
    		// Avalia o comprimento
    		return false;
    	}
   
    	if (caracteres_iguais(replaced_cpf) == true) {
    		// Avalia se todos os caracteres são iguais
    		return false;
    	}
    	
    	if(compara_digitos_cpf(replaced_cpf) == false){
    		// Avalia dígitos verificadores
    		return false;
    	}
   
    	else {
    		// Se todas as funções não identificarem algum erro, retorna true, ou seja
    		// o cpf é válido.
    		return true;
    	}
    	
    	
    	
    }
    
    public static boolean valida_nome(String nome) {
    	//Função que valida um nome, avaliando se apresenta apenas letras e seu comprimento máximo
    	for (int i = 0; i < nome.length(); i++) {
    		if(Character.isLetter(nome.charAt(i)) == false) {
    			return false;
    		}
    	}
    	if (nome.length() > 40) {
    		return false;
    	}
    	else {
    		return true;
    	}
    	
    	
    }
    
    private static boolean valida_placa_antiga(String placa) {
    	// Função que valida a placa no formato antigo
    	if (placa.length() != 8) {
    		return false;
    	}
    	for (int i = 0; i < 3; i++) {
    		if(Character.isLetter(placa.charAt(i)) == false) {
    			return false;
    		}
    	}
    	for (int i = 4; i < 8; i++) {
    		if (Character.isDigit(placa.charAt(i)) == false) {
    			return false;
    		}
    	}
    	return true;
    }
    
    private static boolean valida_placa_mercosul(String placa) {
    	// Função que valida a placa no formato mercosul
    	if (placa.length() != 7) {
    		return false;
    	}
    	for (int i = 0; i < 3; i++) {
    		if(Character.isLetter(placa.charAt(i)) == false) {
    			return false;
    		}
    	}
    	if (Character.isDigit(placa.charAt(3)) == false) {
    		return false;
    	}
    	
    	if (Character.isLetter(placa.charAt(4)) == false) {
    		return false;
    	}
    	
    	for (int i = 5; i < 7; i++) {
    		if(Character.isDigit(placa.charAt(i)) == false) {
    			return false;
    		}
    	}
    	return true;
    }
    
    
    public static boolean valida_placa(String placa) {
    	// Função que valida a placa dada como entrada
    	if (valida_placa_antiga(placa) == true) {
    		return true;
    	}
    	
    	if (valida_placa_mercosul(placa) == true) {
    		return true;
    	}
    	
    	return false;
    }
    
    public static boolean valida_data(String data) {
    	// Função que valida a data no formato string
    	if (data.length() != 10) {
    		return false;
    	}
    	for (int i : listaIndex) {
    		if (Character.isDigit(data.charAt(i)) == false) {
    			return false;
    		}
    	}
    	
    	if (Character.getNumericValue(data.charAt(0)) > 3) {
    		if (Character.getNumericValue(data.charAt(0)) != 3 || Character.getNumericValue(data.charAt(1)) > 1){
    			return false;
    		}
    		
    	}
    	
    	if (Character.getNumericValue(data.charAt(3)) >= 1) {
    		if (Character.getNumericValue(data.charAt(4)) > 2 || Character.getNumericValue(data.charAt(3)) != 1) {
    			return false;
    		}
    	}
    	
    	if (data.charAt(2) != '-' || data.charAt(5) != '-') {
    		return false;
    	}
    	
    	return true;
    }
    
    public static boolean valida_data_int(String data) {
    	// Função que valida data dada no formato inteiro
    	if (data.length() != 8) {
    		return false;
    	}
    	for (int i = 0; i < 8; i++) {
    		if (Character.isDigit(data.charAt(i)) == false) {
    			return false;
    		}
    	}
    	if (Character.getNumericValue(data.charAt(0)) > 3) {
    		if (Character.getNumericValue(data.charAt(0)) != 3 || Character.getNumericValue(data.charAt(1)) > 1){
    			return false;
    		}
    		
    	}
    	
    	if (Character.getNumericValue(data.charAt(2)) >= 1) {
    		if (Character.getNumericValue(data.charAt(3)) > 2 || Character.getNumericValue(data.charAt(2)) != 1) {
    			return false;
    		}
    	}
    	return true;
    	
    }
   
    public static boolean valida_telefone(String telefone) {
    	// Função que valida telefone
    	if (telefone.length() != 11) {
    		return false;
    	}
    	
    	for (int i = 0; i < 11; i++) {
    		if (Character.isDigit(telefone.charAt(i)) == false) {
    			return false;
    		}
    	}
    	
    	if (telefone.charAt(2) != '9') {
    		return false;
    	}
    	
    	return true;
    }
	

}

