package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn{
    private static Connection conexao;
    private static final String URL = "jdbc:postgresql://localhost:5432/Cadastro";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "edu00760";

    public static Connection conectar() {
        try {
            if (conexao == null || conexao.isClosed()) {
                Class.forName("org.postgresql.Driver");
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
             //   System.out.println("Banco conectado!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return conexao;
    }

    public static void desconectar() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                conexao = null;
            }
            System.out.println("Banco conectado!");
        } catch (SQLException e) {
            System.err.println("Erro ao desconectar do banco de dados: " + e.getMessage());
        }
    }
}