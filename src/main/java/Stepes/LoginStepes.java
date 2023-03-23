package Stepes;

import Main.AppDriver;
import Main.BasePage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;

public class LoginStepes {

     BasePage basePage;
     WebDriver driver;

    public LoginStepes() {
        basePage = new BasePage();
        driver = AppDriver.getDriver();
    }

    @Dado("que estou na página de login")
    public void que_estou_na_pagina_de_login() {
        AppDriver.getDriver();
    }
    @Quando("eu inserir credenciais validas E tocar no botao de login")
    public void eu_inserir_credenciais_validas_e_tocar_no_botao_de_login() {
        basePage.id_do_usuario("fabiano");
        basePage.senha("123");
        basePage.logar();
    }
    @Entao("eu devo estar na pagina inicial")
    public void eu_devo_estar_na_pagina_inicial() {
        basePage.TextListaDeProdutos();
//        driver.close();
    }

}
