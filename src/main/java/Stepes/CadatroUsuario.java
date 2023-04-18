package Stepes;

import Configuration.AppDriver;
import Utils.BasePage;
import Utils.PrintScr;
import com.github.javafaker.Faker;
import com.itextpdf.text.DocumentException;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.sql.SQLException;


public class CadatroUsuario extends BasePage {
    static Faker faker = new Faker();
    BasePage basePage;
    WebDriver driver;


    static String senha = faker.internet().password(1, 20, true);
    static String nome = faker.name().firstName();


    public CadatroUsuario() throws DocumentException {
        basePage = new BasePage();
        driver = AppDriver.getDriver();
        tirarFoto();
    }

    @Quando("clico no campo cadastra usuario")
    public void cloco_no_campo_cadastra_usuario() throws DocumentException {
        basePage.CampoTelaLogarCadastroUsuario();
        tirarFoto();
    }

    @E("preenchos os campos nome e senha e confirmo a senha")
    public void preenchos_os_campos_nome_e_senha_e_confirmo_a_senha() throws SQLException, DocumentException {

        basePage.campoNomeCadastro(nome);
        basePage.campoSenhaCadastro(senha);
        basePage.campoConfirmarSenhaCadastro(senha);
        tirarFoto();
    }

    @E("clico no campo cadastra")
    public void clico_no_campo_cadastra() {
        basePage.CampobtnCadastrarTelaCadastro();
    }

    @Entao("usuario cadastrado com sucesso")
    public void usuario_cadastrado_com_sucesso() throws DocumentException, IOException {
        basePage.cadastroComSucesso();
        tirarFoto();
        new PrintScr().salvarArquivosNoPdf("Teste.APK");
        AppDriver.killDriver();
    }
}
