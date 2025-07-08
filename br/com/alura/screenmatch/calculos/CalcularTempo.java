package br.com.alura.screenmatch.calculos;
import br.com.alura.screenmatch.Titulo;

public class CalcularTempo {
    private int tempoTotal;

    public int getTempoTotal(){
        return this.tempoTotal;
    }

    public void calculoTempo (Titulo titulo) {

        tempoTotal += titulo.getDuracao();

    }
}
