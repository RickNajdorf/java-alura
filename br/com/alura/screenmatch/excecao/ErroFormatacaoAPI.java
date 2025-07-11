package br.com.alura.screenmatch.excecao;

public class ErroFormatacaoAPI extends RuntimeException {
    private String mensagem;
    public ErroFormatacaoAPI(String s) {
        this.mensagem = s;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
