package Main;

import static  Main.AppDriver.getDriver;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.github.javafaker.Faker;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import org.openqa.selenium.By;

import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BasePage {

    Faker faker = new Faker();

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
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView")).getText().contains("Lista de produtos");

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



    public static void tirarFoto(WebDriver navegador, String passo) {
        String folderPath = "C:/Users/fabiano.silva/Desktop/DesafioModil/target/out/";

        // Cria o objeto LocalDate com a data atual
        LocalDate now = LocalDate.now();

        // Cria o nome da pasta com a data atual
        String folderName = now.format(DateTimeFormatter.ISO_LOCAL_DATE);

        // Cria o caminho completo da pasta com a data atual
        String folderPathWithDate = folderPath + File.separator + folderName;

        // Cria a pasta com a data atual, se ela ainda não existir
        File folder = new File(folderPathWithDate);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Define o nome do arquivo PDF com a data atual
        String fileName = String.format("%s_%d.pdf", now.format(DateTimeFormatter.ISO_LOCAL_DATE), System.currentTimeMillis());

        // Define o caminho completo do arquivo PDF
        String filePath = folderPathWithDate + File.separator + fileName;

        try {
            // Cria o documento PDF

            int numScreenshots = 1;

// Cria uma lista para armazenar todas as screenshots
            List<Image> screenshots = new ArrayList<>();

// Captura as screenshots e adiciona à lista
            for (int i = 1; i <= numScreenshots; i++) {
                // Captura a screenshot
                File screenshotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

                // Cria um objeto Image com a screenshot capturada
                Image screenshot = Image.getInstance(screenshotFile.getPath());
                screenshot.scaleToFit(PageSize.A4.rotate().getWidth() / 2, PageSize.A4.rotate().getHeight() / 2);

                // Adiciona a screenshot à lista
                screenshots.add(screenshot);
            }

            Document document = new Document();

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));

            document.open();

// Adiciona todas as screenshots a uma única página do documento PDF
            document.newPage();
            for (Image screenshot : screenshots) {
                document.add(screenshot );
            }

// Adiciona a descrição final ao documento PDF
            document.newPage();
            document.add(new com.itextpdf.text.Paragraph(passo));

// Fecha o documento e salva o arquivo PDF
            document.close();
            writer.close();
        } catch (IOException | DocumentException e) {
            // Trata possíveis exceções
        }

    }
}
