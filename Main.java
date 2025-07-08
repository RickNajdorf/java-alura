import br.com.alura.screenmatch.Episodio;
import br.com.alura.screenmatch.Movie;
import br.com.alura.screenmatch.Serie;
import br.com.alura.screenmatch.calculos.CalcularTempo;
import br.com.alura.screenmatch.calculos.Classificavel;
import br.com.alura.screenmatch.calculos.FiltroRcomendacao;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Movie meufilme = new Movie("Clube da luta", 1999);
        Movie outroFilme = new Movie("Superman", 2025);

        meufilme.setNome("Clube da luta");
       // meufilme.setLancamento(1999);
        meufilme.setDuracao(180);
        meufilme.setIncluidoNoPlano(true);

        System.out.println("Duração do filme" + meufilme.getDuracao());
        meufilme.exibirFicha();
        meufilme.avalia(8);
        meufilme.avalia(5);
        meufilme.avalia(10);
        // System.out.println(meufilme.somaAvaliacao);
        System.out.println(meufilme.getTotalAvaliacao());
        System.out.printf("%.2f\n", meufilme.mediaAvaliacao());

        Serie lost = new Serie("Lost", 2001);
        //lost.setNome("Lost");
        //lost.setLancamento(2001);
        lost.setEpisodiosPorTemporada(23);
        lost.setMinutosPorEpisodio(45);
        lost.setTemporadas(6);
        lost.exibirFicha();
        System.out.println("Duração da maratona da série: " + lost.getDuracao());

        CalcularTempo calculo = new CalcularTempo();
        outroFilme.setDuracao(100);

        calculo.calculoTempo(meufilme);
        calculo.calculoTempo(outroFilme);
        calculo.calculoTempo(lost);
        System.out.println(calculo.getTempoTotal());

        Classificavel classifica;
        FiltroRcomendacao filtra = new FiltroRcomendacao();
        Episodio episodio = new Episodio();

        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisu(300);

        filtra.filtra(episodio);
        filtra.filtra(meufilme);
        var filmeDoRick = new Movie("Os suspeitos", 2012);
        filmeDoRick.setDuracao(200);
        // filmeDoRick.setNome("Os suspeitos");
        //filmeDoRick.setLancamento(2002);
        filmeDoRick.avalia(10);

        ArrayList<Movie> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDoRick);
        listaDeFilmes.add(meufilme);
        listaDeFilmes.add(outroFilme);

        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Filme: " + listaDeFilmes.get(0));
        System.out.println(listaDeFilmes);
        System.out.println("toString do filme " + listaDeFilmes.get(0).toString());


    }
}