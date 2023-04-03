package Main;

import java.sql.SQLException;
import java.util.List;

public class Teste {
    public static void main(String[] args) {

        try {
            UsuarioDAO dao = new UsuarioDAO();
            List<Usuario> usuarios = dao.listar();
            for (Usuario usuario : usuarios) {
                System.out.println("id : " + usuario.getid()+ ": nome " + usuario.getNome() + ": senha " + usuario.getSenha() );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
    }
}