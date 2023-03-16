
public class Main {

    public static void main(String[] args) {
        Cliente vini = new Cliente("Vinícius Borges", "597.920.516-00", "04022004", 19);
        Seguradora liberty = new Seguradora("Liberty", "31998923231", "Liberty.seguradora@gumal.com", "Avenida das Rosas");
        Veiculo corsa = new Veiculo("Chevrolet", "Corsa Classic", "OWL-3132");
        Sinistro sin = new Sinistro("04022023", "Avenida do Contorno, Belo Horizonte");
        System.out.println(vini.ValidarCpf(vini.getCpf()));
    }
}