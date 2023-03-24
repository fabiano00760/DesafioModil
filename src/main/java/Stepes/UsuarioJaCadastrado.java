package Stepes;

import Main.AppDriver;
import Main.BasePage;
import com.github.javafaker.Faker;
import io.cucumber.java.pt.Entao;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;


public class UsuarioJaCadastrado {
    Faker faker = new Faker();
    BasePage basePage;
    WebDriver driver;

    public UsuarioJaCadastrado() {
        basePage = new BasePage();
        driver = AppDriver.getDriver();
    }
    @Entao("aparece mensagem Usuario ja Cadastrado")
    public void aparece_mensagem_usuario_ja_cadastrado() {
        basePage.UsuarioJaCadastrado();
        AppDriver.killDriver();
    }

}

