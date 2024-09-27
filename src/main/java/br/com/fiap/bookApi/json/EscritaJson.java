package br.com.fiap.bookApi.json;

import br.com.fiap.bookApi.model.Livro;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class EscritaJson {
    public static void main(String[] args) {
        Livro livro = new Livro();
        livro.setTitle("Táticas do Amor");
        livro.setAuthors("Sarah Adams");
        livro.setDescription("comédia romântica narra a amizade mais que especial entre uma bailarina sonhadora " +
                         " e um irresistível jogador de futebol americanoBree Camden está totalmente apaixonada por " +
                                "seu amigo de longa data, a lenda do futebol americano Nathan Donelson. ");
      //  livro.setTotalItems(1);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter("livro.json")){
            gson.toJson(livro, writer);
            System.out.println("Arquivo Json escrito com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever o arquivo" + e.getMessage() );
        }
    }
}
