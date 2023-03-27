package Stepes;

import Main.AppDriver;
import Main.BasePage;
import Main.Usuario;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;

import java.sql.SQLException;


public class CadatroUsuario {
    Faker faker = new Faker();
    BasePage basePage;
    WebDriver driver;


    String senha = faker.internet().password(1, 20, true);
    String nome = faker.name().firstName();


    public CadatroUsuario() {
        basePage = new BasePage();
        driver = AppDriver.getDriver();
    }

    @Quando("clico em no campo cadastra usuario")
    public void cloco_em_no_campo_cadastra_usuario() {
      basePage.CampoTelaLogarCadastroUsuario();
    }
    @E("preenchos os campos nome e senha e confirmo a senha")
    public void preenchos_os_campos_nome_e_senha_e_confirmo_a_senha() throws SQLException {
        Usuario.conectar();
        Usuario.salvar(nome, senha);
        basePage.campoNomeCadastro(nome);
        basePage.campoSenhaCadastro(senha);
        basePage.campoConfirmarSenhaCadastro(senha);


    }
    @E("clico no campo cadastra")
    public void clico_no_campo_cadastra() {
      basePage.CampobtnCadastrarTelaCadastro();
    }
    @Entao("usuario cadastrado com sucesso")
    public void usuario_cadastrado_com_sucesso() {
        basePage.cadastroComSucesso();
          AppDriver.killDriver();
    }
}
