package br.com.fiap.bookApi.service;

import br.com.fiap.bookApi.model.Livro;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class BooksApiService {

    /**
     *API Google Books - https://books.google.com.br/
     *A Google Books API permite que desenvolvedores integrem funcionalidades relacionadas a livros em suas aplicações. Com essa API,
     * é possível acessar informações sobre livros, incluindo títulos, autores, resumos, capas e muito mais.
     *
     * Exemplo de Consulta de Livro com parâmetro inauthor:
     * https://www.googleapis.com/books/v1/volumes?q=flowers+inauthor:keyes&key=AIzaSyBitYrZ40pUYhrX3V3rbhQcZb8t8giPdWk
     *
     * Saída:
     * URL: https://www.googleapis.com/books/v1/volumes?q=sarah+inauthor:keyes&key=AIzaSyBitYrZ40pUYhrX3V3rbhQcZb8t8giPdWk
     * */

    public Livro buscarLivro(String authors){
        try{
            String livro = "https://www.googleapis.com/books/v1/volumes?q=" + authors +"inauthor:keyes&key=AIzaSyBitYrZ40pUYhrX3V3rbhQcZb8t8giPdWk";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(livro))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Livro.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
