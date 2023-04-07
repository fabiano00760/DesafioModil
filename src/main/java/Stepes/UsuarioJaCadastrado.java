package Stepes;

import Main.AppDriver;
import Main.BasePage;
import Main.PrintScr;
import com.github.javafaker.Faker;
import com.itextpdf.text.DocumentException;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;


public class UsuarioJaCadastrado extends BasePage {
    BasePage basePage;
    WebDriver driver;

    public UsuarioJaCadastrado() {
        basePage = new BasePage();
        driver = AppDriver.getDriver();
    }
    @Entao("aparece mensagem Usuario ja Cadastrado")
    public void aparece_mensagem_usuario_ja_cadastrado() throws DocumentException, FileNotFoundException {
        basePage.cadastroComSucesso();
        tirarFoto(driver, "ja cadastrado.jpg");
        new PrintScr().salvarArquivosNoPdf("TST");
        AppDriver.killDriver();
    }

}
