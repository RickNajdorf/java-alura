package Principal;

import br.com.alura.screenmatch.Titulo;
import br.com.alura.screenmatch.excecao.ErroFormatacaoAPI;
import br.com.alura.screenmatch.modelos.TituloOMDB;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import static com.google.gson.FieldNamingPolicy.UPPER_CAMEL_CASE;

public class MainComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pesquise por um filme:");
        var busca = scanner.nextLine();
        String nomeCorrigido = URLEncoder.encode(busca, "UTF-8");

        String endereco = "http://www.omdbapi.com/?t=" + nomeCorrigido + "&apikey=80ccb353";

        try{
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String result = response.body();

            System.out.println(result);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(UPPER_CAMEL_CASE).create();
            //Titulo meuTitulo = gson.fromJson(result, Titulo.class);
            TituloOMDB meuTituloOMDB = gson.fromJson(result, TituloOMDB.class);
            //try {
            Titulo meuTitulo = new Titulo(meuTituloOMDB);
            System.out.println(meuTitulo);
        } catch (NumberFormatException e){
            System.out.println("Aconteeu um erro: ");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println("Formato de titulo invalido.");
        }catch (ErroFormatacaoAPI e){
            System.out.println(e.getMessage());
        }

        System.out.println("Programa finalizado corretamente!");
    }
}
