package Stepes;

import Main.AppDriver;
import Main.BasePage;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;


public class LogarComCredenciaisInvalidas extends BasePage {
    Faker faker = new Faker();
    BasePage basePage;
    WebDriver driver;

    public LogarComCredenciaisInvalidas() {
        basePage = new BasePage();
        driver = AppDriver.getDriver();
    }

    @Quando("inserir credenciais invalidas E tocar no botao de login")
    public void inserir_credenciais_invalidas_e_tocar_no_botao_de_login() {
        basePage.CampoUsuario();
        basePage.CampoSenha();
        basePage.BtnLogar();
        tirarFoto(driver, " credenciais invalidas.jpg");
    }

    @Então("devo ver uma mensagem de erro")
    public void devo_ver_uma_mensagem_de_erro() {
        basePage.mensagemErroLogar();
        tirarFoto(driver, "messagem de erro.jpg ");
       AppDriver.killDriver();
    }


}
