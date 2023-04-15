package br.com.automacao.Steps;

import br.com.automacao.Configuration.AppDriver;
import br.com.automacao.Utils.BasePage;
import com.itextpdf.text.DocumentException;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;

import java.io.FileNotFoundException;


public class LogarComCredenciaisInvalidas extends BasePage {
    Faker faker = new Faker();
    BasePage basePage;
    WebDriver driver;

    public LogarComCredenciaisInvalidas() {
        basePage = new BasePage();
        driver = AppDriver.getDriver();
    }

    @Quando("inserir credenciais invalidas E tocar no botao de login")
    public void inserir_credenciais_invalidas_e_tocar_no_botao_de_login() throws DocumentException {
        basePage.CampoUsuario();
        basePage.CampoSenha();
        basePage.BtnLogar();
    }

    @Então("devo ver uma mensagem de erro")
    public void devo_ver_uma_mensagem_de_erro() throws DocumentException, FileNotFoundException {
        basePage.mensagemErroLogar();
    }


}
