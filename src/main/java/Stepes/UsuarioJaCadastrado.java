package Stepes;

import Configuration.AppDriver;
import Utils.BasePage;
import Utils.PrintScr;
import com.itextpdf.text.DocumentException;
import io.cucumber.java.pt.Entao;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class UsuarioJaCadastrado extends BasePage {
    BasePage basePage;
    WebDriver driver;

    public UsuarioJaCadastrado() {
        basePage = new BasePage();
        driver = AppDriver.getDriver();
    }

    @Entao("aparece mensagem Usuario ja Cadastrado")
    public void aparece_mensagem_usuario_ja_cadastrado() throws DocumentException, IOException {
        basePage.cadastroComSucesso();
        tirarFoto();
        //tirarFoto(driver, "ja cadastrado.jpg");
        new PrintScr().salvarArquivosNoPdf("Teste.APK");
        AppDriver.killDriver();
    }

}
