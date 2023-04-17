package Others;

import lombok.Data;

import java.sql.SQLException;
import java.util.List;

@Data
public class Teste {
    public static void main(String[] args) {

        try {
            Usuario dao = new Usuario();
            List<Usuario> usuarios = UsuarioDAO.listar();
            for (Usuario usuario : usuarios) {
                System.out.println("id : " + usuario.getid()+ ": nome " + usuario.getNome() + ": senha " + usuario.getSenha() +": nomeTeste" + usuario.getNomeTeste() + ": status" + usuario.getStatus() + ": dataExecucao" + usuario.getDataExecucao());
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
    }
}