package br.com.fiap.bookApi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection obterConexao() {
            Connection conexao = null;
            try {
                conexao = DriverManager.getConnection(
                        "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl",
                        "rm558976", "170505"
                );
            } catch (SQLException erro) {
                erro.printStackTrace();
            }
            return conexao;
        }
    }


