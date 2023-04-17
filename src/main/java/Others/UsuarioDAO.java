package Others;

import Configuration.Conn;
import Others.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private static Connection conexao;

    public UsuarioDAO() throws SQLException {
        conexao = Conn.conectar();
    }

    public static List<Usuario> listar() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setNomeTeste(rs.getString("nomeTeste"));
            usuario.setStatus(rs.getString("status"));
            usuario.setDataExecucao(LocalDateTime.parse(rs.getString("dataExecucao")));
            usuarios.add(usuario);
        }
        rs.close();
        ps.close();
        return usuarios;
    }
}