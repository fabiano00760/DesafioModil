package Stepes;

import Main.AppDriver;
import Main.BasePage;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;


public class CadatroUsuario {
    BasePage basePage;
    WebDriver driver;

    public CadatroUsuario() {
        basePage = new BasePage();
        driver = AppDriver.getDriver();
    }

    @Quando("clico em no campo cadastra usuario")
    public void cloco_em_no_campo_cadastra_usuario() {
      basePage.CampoTelaLogarCadastroUsuario();
    }
    @E("preenchos os campos nome e senha e confirmo a senha")
    public void preenchos_os_campos_nome_e_senha_e_confirmo_a_senha() {
        basePage.campoNomeCadastro("fabiano");
        basePage.campoSenhaCadastro("123");
        basePage.campoConfirmarSenhaCadastro("123");


    }
    @E("clico no campo cadastra")
    public void clico_no_campo_cadastra() {
      basePage.CampobtnCadastrarTelaCadastro();
    }
    @Entao("usuario cadastrado com sucesso")
    public void usuario_cadastrado_com_sucesso() {
        basePage.cadastroComSucesso();
//        driver.close();
    }
}
