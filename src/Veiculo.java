
public class Veiculo{
    private String marca;
    private String modelo;
    private String placa;
    
    //Construtor
    public Veiculo(String marca, String modelo, String placa){
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
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

	@Override
	public String toString() {
		return "Veiculo [marca=" + marca + ", modelo=" + modelo + ", placa=" + placa + "]";
	}
    
}
