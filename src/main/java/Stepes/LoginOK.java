package Stepes;

import Configuration.AppDriver;
import Utils.BasePage;
import Utils.PrintScr;
import Others.Usuario;
import com.itextpdf.text.DocumentException;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.sql.SQLException;

import static Stepes.CadatroUsuario.nome;
import static Stepes.CadatroUsuario.senha;

public class LoginOK extends BasePage {
    BasePage basePage;
    WebDriver driver;

    public LoginOK() {
        basePage = new BasePage();
        driver = AppDriver.getDriver();
    }

    @Dado("que estou na página de login")
    public void que_estou_na_pagina_de_login() throws DocumentException {
        AppDriver.getDriver();
        tirarFoto();

    }

    @Quando("inserir credenciais validas E tocar no botao de login")
    public void inserir_credenciais_validas_e_tocar_no_botao_de_login() throws SQLException, DocumentException {


        try {
            Usuario.conectar();
            String status = "true";
            String nomeTeste = "Login ok ";
            basePage.id_do_usuario(nome);
            basePage.senha(senha);
            basePage.logar();
            tirarFoto();
            Usuario.salvar(nome, senha,status,nomeTeste);
        }catch (Exception e){
            Usuario.conectar();
            String status = "false";
            String nomeTeste = "Login ok ";
            System.out.println(e.getMessage());
            Usuario.salvar(nome, senha,status,nomeTeste);
        }
    }

    @Entao("devo estar na pagina inicial")
    public void devo_estar_na_pagina_inicial() throws DocumentException, IOException {
        basePage.TextListaDeProdutos();
        tirarFoto();
        new PrintScr().salvarArquivosNoPdf("Teste.APK");
        AppDriver.killDriver();



    }


}
