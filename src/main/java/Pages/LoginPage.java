package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

@Data
public class LoginPage {

    private final  AppiumDriver<MobileElement> driver;

    Driver AppDriver;



    public LoginPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(id="br.com.alura.aluraesporte:id/input_usuario")
    private MobileElement username;

    @AndroidFindBy(id="br.com.alura.aluraesporte:id/input_senha")
    private MobileElement password;

    @AndroidFindBy(id="br.com.alura.aluraesporte:id/login_botao_logar")
    private MobileElement btnLoga;

    public void id_do_usuario(String name){
        username.sendKeys(name);
    }

    public void senha(String senha){
         password.sendKeys(senha);
    }

    public void logar(){
        btnLoga.click();
    }

//    public void LoginMensagemErro(){
//        driver.findElement(By.id("br.com.alura.aluraesporte:id/mensagem_erro_login")).isDisplayed();
//
//    }

}
