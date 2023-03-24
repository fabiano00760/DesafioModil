package Main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Conexao {

    private static final String URL = "jdbc:postgresql://localhost:5432/Cadastro";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "edu00760";

    private static Connection conexao;

    public static void salvarUsuario(String nome, String email, String senha) {

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Passo 1: Conectar-se ao banco de dados
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            // Passo 2: Definir a tabela

            String sql = "CREATE TABLE IF NOT EXISTS usuarios " +
                    "(id INTEGER not NULL AUTO_INCREMENT, " +
                    " nome VARCHAR(255), " +
                    " senha VARCHAR(255), " +
                    " PRIMARY KEY ( id ))";

            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();

            // Passo 3: Criar a classe Usuário

            Usuario usuario = new Usuario(nome, senha);
            sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(3, usuario.getSenha());
            stmt.executeUpdate();

            //pass 5 :fechar a conexao
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Tratamento de erros para o SQL
            se.printStackTrace();
        } catch (Exception e) {
            // Tratamento de erros para outras exceções
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }

        }
        class Usuario {
            private String nome;
            private String email;
            private String senha;

            public Usuario(String nome, String email, String senha) {
                this.nome = nome;
                this.email = email;
                this.senha = senha;
            }

            public String getNome() {
                return nome;
            }

            public void setNome(String nome) {
                this.nome = nome;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getSenha() {
                return senha;
            }

            public void setSenha(String senha) {
                this.senha = senha;
            }

            @Override
            public String toString() {
                return "Usuário [nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
            }
        }

    }
}
