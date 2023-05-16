
public class Veiculo{
    private String marca;
    private String modelo;
    private String placa;
    private int anoFabricacao;
    
    //Construtor
    public Veiculo(String marca, String modelo, String placa, int anoFabricacao){
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.anoFabricacao = anoFabricacao;
    }
    
    //Getters and setters
    
    public String set_marca(){
        return marca;
        
    }
    
    public void set_marca(String marca){
        this.marca = marca;
    }
    
    public String set_modelo(){
        return modelo;
        
    }
    
    public void set_modelo(String modelo){
        this.modelo = modelo;
    }
    
    public String set_placa(){
        return placa;
        
    }
    
    public void set_placa(String placa){
        this.placa = placa;
    }

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	public String toString() {
		return "Veiculo [marca=" + marca + ", modelo=" + modelo + ", placa=" + placa + ", anoFabricacao="
				+ anoFabricacao + "]";
	}

	
    
}
