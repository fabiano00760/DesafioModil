package Stepes;

import Driver.AppDriver;
import Pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Locale;

public class LoginStepes {

    private final LoginPage loginPage;
    private final AppiumDriver<MobileElement> driver;

    public LoginStepes() {

        driver = AppDriver.getDriver();
     loginPage = new LoginPage(driver);
    }

    @Dado("que estou na página de login")
    public void que_estou_na_página_de_login() {
        AppDriver.getDriver();

    }
    @Quando("eu inserir credenciais válidas E tocar no botão de login")
    public void eu_inserir_credenciais_válidas_e_tocar_no_botão_de_login() {
        loginPage.id_do_usuario("fabiano");
        loginPage.senha("1234");
        loginPage.logar();

    }
    @Então("eu devo estar na página inicial")
    public void eu_devo_estar_na_página_inicial() {
       // Assert.assertEquals(driver.findElementsById());

    }

}
