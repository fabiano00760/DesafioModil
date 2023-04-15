package br.com.automacao.Steps;

import br.com.automacao.Configuration.AppDriver;
import br.com.automacao.Utils.BasePage;
import io.cucumber.java.pt.Entao;
import org.openqa.selenium.WebDriver;


public class UsuarioJaCadastrado extends BasePage {
    BasePage basePage;
    WebDriver driver;

    public UsuarioJaCadastrado() {
        basePage = new BasePage();
        driver = AppDriver.getDriver();
    }
    @Entao("aparece mensagem Usuario ja Cadastrado")
    public void aparece_mensagem_usuario_ja_cadastrado() {
        basePage.cadastroComSucesso();
    }

}
