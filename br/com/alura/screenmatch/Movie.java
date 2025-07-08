package br.com.alura.screenmatch;

import br.com.alura.screenmatch.calculos.Classificavel;

import javax.print.attribute.standard.Media;

public class Movie extends Titulo implements Classificavel {
    String diretor;


    public Movie(String nome, int lancamento) {
        super(nome, lancamento);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) mediaAvaliacao() / 2;
    }

    @Override
    public String toString() {
        return "Filme: "+ this.getNome() + " (" + this.getLancamento() + ") ";
    }
}