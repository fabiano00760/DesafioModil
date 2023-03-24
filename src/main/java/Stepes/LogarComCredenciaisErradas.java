package Stepes;

import Main.AppDriver;
import Main.BasePage;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;


public class LogarComCredenciaisErradas {
    Faker faker = new Faker();
    BasePage basePage;
    WebDriver driver;

    public LogarComCredenciaisErradas() {
        basePage = new BasePage();
        driver = AppDriver.getDriver();
    }

    @Quando("eu inserir credenciais invalidas E tocar no botao de login")
    public void eu_inserir_credenciais_invalidas_e_tocar_no_botao_de_login() {
        basePage.id_do_usuario("fabiano");
        basePage.senha("1234");
        basePage.logar();
    }
    @Entao("eu devo ver uma mensagem de erro")
    public void eu_devo_ver_uma_mensagem_de_erro() {
        basePage.mensagemErroLogar();
//        driver.close();

    }

}
