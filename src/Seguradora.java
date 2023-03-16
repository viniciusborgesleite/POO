
public class Seguradora{
    
    private String name;
    private String telefone;
    private String email;
    private String endereco;
    
    public Seguradora(String name, String telefone, String email, String endereco){
        this.name = name;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }
    
    // Getters and setters
    
    public String get_nome(){
        return name;
    }
    
    public void  set_name(String name){
        this.name = name;
    }
    
    public String get_telefone(){
        return telefone;
    }
    
    public void set_telefone(String telefone){
        this.telefone = telefone;
    }
    
    public String get_email(){
        return email;
    }
    
    public void set_email(String email){
        this.email = email;
    }
    
    public String get_endereco(){
        return endereco;
    }
    
    public void set_endereco(String endereco){
        this.endereco = endereco;
    }
    
    
}
