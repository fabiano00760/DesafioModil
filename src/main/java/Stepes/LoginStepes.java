package Stepes;

import Main.AppDriver;
import Main.BasePage;
import com.github.javafaker.Name;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;

import java.sql.Driver;

public class LoginStepes  extends BasePage{
    Faker faker = new Faker();
    BasePage basePage;
    WebDriver driver;

    public LoginStepes() {
        basePage = new BasePage();
        driver = AppDriver.getDriver();
    }

    @Dado("que estou na página de login")
    public void que_estou_na_pagina_de_login() {
        AppDriver.getDriver();
        tirarFoto(driver, "telaLogin.jpg");


    }

    @Quando("inserir credenciais validas E tocar no botao de login")
    public void inserir_credenciais_validas_e_tocar_no_botao_de_login() {
        basePage.id_do_usuario(CadatroUsuario.nome);
        basePage.senha(CadatroUsuario.senha);
        basePage.logar();
        tirarFoto(driver, "Inserir credenciais validas.jpg");
    }

    @Entao("devo estar na pagina inicial")
    public void devo_estar_na_pagina_inicial() {
        basePage.TextListaDeProdutos();
        AppDriver.killDriver();
        tirarFoto(driver, "pagina inicial.jpg");
    }

}
