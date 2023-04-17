package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;

import static Configuration.AppDriver.getDriver;

public class BasePage extends PrintScr {


    public BasePage() {
        this.driver = getDriver();
    }

    static WebDriver driver;

    public void id_do_usuario(String name) {
        driver.findElement(By.id("br.com.alura.aluraesporte:id/input_usuario")).sendKeys(name);
    }

    public void senha(String senha) {
        driver.findElement(By.id("br.com.alura.aluraesporte:id/input_senha")).sendKeys(senha);
    }

    public void logar() {
        driver.findElement(By.id("br.com.alura.aluraesporte:id/login_botao_logar")).click();

    }

    public void CampoTelaLogarCadastroUsuario(){
        driver.findElement(By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario")).click();
    }

    public void mensagemErroLogar() {
        driver.findElement(By.id("br.com.alura.aluraesporte:id/mensagem_erro_login")).isDisplayed();
    }

    public void campoNomeCadastro(String nomeCampoCadastro){
        driver.findElement(By.id("br.com.alura.aluraesporte:id/input_nome")).sendKeys(nomeCampoCadastro);

    }

    public void campoSenhaCadastro(String senhaCampoCadastro){
        driver.findElement(By.id("br.com.alura.aluraesporte:id/input_senha")).sendKeys(senhaCampoCadastro);
    }

    public void campoConfirmarSenhaCadastro(String comfirmarSenhaCadastro){
        driver.findElement(By.id("br.com.alura.aluraesporte:id/input_confirmar_senha")).sendKeys(comfirmarSenhaCadastro);
    }

    public void CampobtnCadastrarTelaCadastro(){
        driver.findElement(By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar")).click();
    }

    public void cadastroComSucesso(){
        driver.findElement(By.id("br.com.alura.aluraesporte:id/login_botao_logar")).isDisplayed();
    }

   public void UsuarioJaCadastrado(){
        driver.findElement(By.id("br.com.alura.aluraesporte:id/erro_cadastro")).isDisplayed();
   }

    public void TextListaDeProdutos(){
      //  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView")).getText().contains("Lista de produtos");

    }

    public void BtnLogar(){
        driver.findElement(By.id("br.com.alura.aluraesporte:id/login_botao_logar")).click();
    }

    public void CampoUsuario(){
        driver.findElement(By.id("br.com.alura.aluraesporte:id/input_usuario")).sendKeys("fabiano");
    }
    public  void CampoSenha(){
        driver.findElement(By.id("br.com.alura.aluraesporte:id/input_senha")).sendKeys("12345678");
    }

    public static void tirarFoto0(WebDriver navegador, String passo) {
        String arquivo = "target/out/Screenshots" + passo ;
        File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshot, new File(arquivo));
        } catch (Exception e) {
            System.out.println("Houveram problemas ao copiar o arquivo para a pasta" + e.getMessage());
        }
    }
}
