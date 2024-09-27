package br.com.fiap.bookApi.json;

import br.com.fiap.bookApi.model.Livro;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeituraJson {

    public static void main(String[] args) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("livro.json")) {
            Livro livro = gson.fromJson(reader, Livro.class);
            System.out.println("Title: " + livro.getTitle());
            System.out.println("Authors: " + livro.getAuthors());
            System.out.println("Description: " + livro.getDescription());
           // System.out.println("Total de Itens: " + livro.getTotalItems());
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }
    }
}

