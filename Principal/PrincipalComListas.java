package Principal;

import br.com.alura.screenmatch.Movie;
import br.com.alura.screenmatch.Serie;
import br.com.alura.screenmatch.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalComListas {
    public static void main(String[] args) {
        var filmeDoRick = new Movie("Os suspeitos", 2012);
        Movie meufilme = new Movie("Clube da luta", 1999);
        Movie outroFilme = new Movie("Superman", 2025);
        Serie lost = new Serie("Lost", 2001);

        filmeDoRick.avalia(10);
        meufilme.avalia(10);
        outroFilme.avalia(8);
        List<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoRick);
        lista.add(meufilme);
        lista.add(outroFilme);
        lista.add(lost);
        for (Titulo item: lista){
            System.out.println(item.getNome());
            if (item instanceof Movie filme && filme.getClassificacao() > 2){
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }
        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("DiCaprio");
        buscaPorArtista.add("Aneglina");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);

        System.out.println("Ordenado");
        System.out.println(buscaPorArtista);

        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getLancamento));
        System.out.println(lista);
    }
}
