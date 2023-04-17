package Others;

import Configuration.Conn;
import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class Usuario {

    private int id;
    private String nome;
    private String senha;
    private String nomeTeste;
    private String status;
    private LocalDateTime dataExecucao;


    public int getid() {
        return id;
    }

    private static Connection conexao;

    public static void conectar() throws SQLException {
        conexao = Conn.conectar();
    }

    public static void salvar(String nome, String senha,String nomeTeste,String status) throws SQLException {

        conectar();
        String sql = "INSERT INTO usuario (nome, senha, nome_teste, status, data_execucao) values (?, ?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, nome);
        ps.setString(2, senha);
        ps.setString(3, nomeTeste);
        ps.setString(4, status);
        ps.setTimestamp(5, new Timestamp(System.currentTimeMillis()));

        ps.executeUpdate();
        System.out.println(Conn.conectar());
        Conn.desconectar();
    }


}
