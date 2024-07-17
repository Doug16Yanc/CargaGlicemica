import java.util.*;
import java.util.stream.Collectors;

public class Glicemico {
    private Set<Nutriente> nutrientes;

    public Glicemico(Set<Nutriente> nutrientes) {
        this.nutrientes = nutrientes;
    }

    private double calcularCargaGlicemica(Nutriente nutriente) {
        return (nutriente.massaCarboidratos() * nutriente.indiceGlicemico()) / 100.00;
    }

    public double calcularCargaTotal() {
        return nutrientes.stream()
                .mapToDouble(nutriente -> (nutriente.massaCarboidratos() * nutriente.indiceGlicemico()) / 100.00)
                .sum();
    }

    public List<String> retornaAlimentosPorCG() {
        return nutrientes.stream()
                .sorted(Comparator.comparingDouble(this::calcularCargaGlicemica).reversed())
                .map(nutriente -> {
                        double carga = calcularCargaGlicemica(nutriente);
                          return  " " + nutriente.nome() + " -  " + carga;
                        }
                ).collect(Collectors.toList());
    }
}
