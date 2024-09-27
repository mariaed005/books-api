package br.com.fiap.bookApi.teste;

import br.com.fiap.bookApi.dao.LivroDao;
import br.com.fiap.bookApi.model.Livro;

import java.util.List;

public class TesteBuscarLivro {

    public static void main(String[] args) {
        LivroDao livroDao = new LivroDao();


        Livro novoLivro = new Livro();
        novoLivro.setTitle("New Java Book");
        novoLivro.setAuthors("Author Test");
        novoLivro.setDescription("A book about Java programming.");


        livroDao.cadastrar(novoLivro);


        List<Livro> livros = livroDao.listar();
        for (Livro livro : livros) {
            System.out.println("Título: " + livro.getTitle());
            System.out.println("Autor: " + livro.getAuthors());
            System.out.println("Descrição: " + livro.getDescription());

        }
    }



}



