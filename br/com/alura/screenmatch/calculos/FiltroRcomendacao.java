package br.com.alura.screenmatch.calculos;

public class FiltroRcomendacao {

    public void filtra (Classificavel classificavel){
        if (classificavel.getClassificacao() >= 4){
            System.out.println("Esta entre os preferidos do momento!");
        } else if (classificavel.getClassificacao() >= 2) {
            System.out.println("Esta entre os melhores");
        } else {
            System.out.println("Existe");
        }
    }
}
