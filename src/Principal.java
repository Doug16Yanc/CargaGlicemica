import java.text.DecimalFormat;
import java.util.*;

public class Principal {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        var principal = new Principal();
        Set<Nutriente> nutrientes = principal.inicializaNutrientes();
        var glicemico = new Glicemico(nutrientes);
        List<String> glicemicos = glicemico.retornaAlimentosPorCG();

        System.out.println("Alimentos por carga glicêmica.\n");

        glicemicos.forEach(System.out::println);

        System.out.println(("\nCarga glicêmica total : " + decimalFormat.format(glicemico.calcularCargaTotal())));

    }
    public Set<Nutriente> inicializaNutrientes() {
        return new HashSet<>(Arrays.asList(
                new Nutriente("Arroz", 1000.00, 28.00, 82.00),
                new Nutriente("Pão integral", 100.00, 11.00, 70.00),
                new Nutriente("Milho", 250.00, 25.00, 83.00),
                new Nutriente("Feijão", 1000.00, 30.00, 39.00),
                new Nutriente("Batata inglesa", 300.00, 35.00, 104.00)
        ));
    }
}