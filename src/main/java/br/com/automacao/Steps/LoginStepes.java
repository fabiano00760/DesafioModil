package br.com.automacao.Steps;

import br.com.automacao.Configuration.AppDriver;
import br.com.automacao.Utils.BasePage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;

import static br.com.automacao.Steps.CadatroUsuario.nome;
import static br.com.automacao.Steps.CadatroUsuario.senha;

public class LoginStepes extends BasePage {
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

    @Quando("inserir credenciais validas E tocar no botao de login")
    public void inserir_credenciais_validas_e_tocar_no_botao_de_login() {
        //Usuario.conectar();
        //Usuario.salvar(nome, senha);
        basePage.id_do_usuario(nome);
        basePage.senha(senha);
        basePage.logar();
    }

    @Entao("devo estar na pagina inicial")
    public void devo_estar_na_pagina_inicial() {
        basePage.TextListaDeProdutos();
    }

}
