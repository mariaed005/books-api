package br.com.fiap.bookApi.dao;

import br.com.fiap.bookApi.model.Livro;
import br.com.fiap.bookApi.dao.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDao {


    public List<Livro> listar() {
        List<Livro> livros = new ArrayList<>();
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        try {
            comandoSQL = conexao.prepareStatement("SELECT * FROM livro ORDER BY title");
            ResultSet rs = comandoSQL.executeQuery();
            while (rs.next()) {
                Livro livro = new Livro();
                livro.setTitle(rs.getString("title"));
                livro.setAuthors(rs.getString("authors"));
                livro.setDescription(rs.getString("description"));
                livros.add(livro);
            }
            comandoSQL.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livros;
    }


    public void cadastrar(Livro livro) {
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        try {
            String sql = "INSERT INTO livro(title, authors, description) VALUES (?, ?, ?)";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setString(1, livro.getTitle());
            comandoSQL.setString(2, livro.getAuthors());
            comandoSQL.setString(3, livro.getDescription());
            comandoSQL.executeUpdate();
            comandoSQL.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Livro buscarPorTitulo(String titulo) {
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        Livro livro = new Livro();
        try {
            String sql = "SELECT * FROM livro WHERE title = ?";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setString(1, titulo);
            ResultSet rs = comandoSQL.executeQuery();
            if (rs.next()) {
                livro.setTitle(rs.getString("title"));
                livro.setAuthors(rs.getString("authors"));
                livro.setDescription(rs.getString("description"));
            }
            comandoSQL.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livro;
    }

    public List<Livro> buscarPorTituloParcial(String title) {
        List<Livro> livros = new ArrayList<>();
        Connection conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSQL = null;
        try {
            String sql = "SELECT * FROM livro WHERE title LIKE ? ORDER BY title";
            comandoSQL = conexao.prepareStatement(sql);
            comandoSQL.setString(1, "%" + title + "%");
            ResultSet rs = comandoSQL.executeQuery();
            while (rs.next()) {
                Livro livro = new Livro();
                livro.setTitle(rs.getString("title"));
                livro.setAuthors(rs.getString("authors"));
                livro.setDescription(rs.getString("description"));
                livros.add(livro);
            }
            comandoSQL.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livros;
    }
}
