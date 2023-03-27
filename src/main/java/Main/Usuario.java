package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Usuario {
    private static Connection conexao;

    public static void conectar()throws SQLException{
        conexao = Conn.conectar();
    }

    public static void  salvar(String nome, String senha) throws SQLException{

        String sql = "INSERT INTO usuario(nome, senha) values (?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1,nome);
        ps.setString(2,senha);
        ps.executeUpdate();
        Conn.desconectar();
    }



}