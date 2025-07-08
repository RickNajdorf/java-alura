package br.com.alura.screenmatch;

import br.com.alura.screenmatch.modelos.TituloOMDB;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo> {

    @SerializedName("Title")
    private String nome;
    @SerializedName("Year")
    private int lancamento;
    private boolean incluidoNoPlano;
    private double somaAvaliacao;
    private  int totalAvaliacao;
    private int duracao;

    public Titulo(String nome, int lancamento) {
        this.nome = nome;
        this.lancamento = lancamento;
    }

    public Titulo(TituloOMDB meuTituloOMDB) {
        this.nome = meuTituloOMDB.title();
        this.lancamento = Integer.valueOf(meuTituloOMDB.year());
        this.duracao = Integer.valueOf(meuTituloOMDB.runtime().substring(0,2));
    }

    public int getTotalAvaliacao (){
        return totalAvaliacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome (){
        return this.nome;
    }

    public void setLancamento(int lancamento){
        this.lancamento = lancamento;
    }

    public int getLancamento() {
        return lancamento;
    }

    public void setDuracao (int duracao) {
        this.duracao = duracao;
    }
    public int getDuracao () {
        return this.duracao;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }


    public void exibirFicha(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + lancamento);
    }
    public void avalia(double nota){
        somaAvaliacao += nota;
        totalAvaliacao++;
    }
    public double mediaAvaliacao (){
        return  somaAvaliacao / totalAvaliacao;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "nome=" + nome +
                ", lançamento='" + lancamento + '\'' +
                "duração=" + duracao;
    }
}
