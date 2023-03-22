package Driver;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.cucumber.java.AfterAll;
import lombok.Data;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

@Data
public class AppDriver {

    public static AppiumDriver driver ;

    @Test
@Before
    public void  AppiumDriverConfig() throws MalformedURLException {
        File apk = new File("src/main/resources/alura_esporte.apk");

        DesiredCapabilities configuracoes = new DesiredCapabilities();
        configuracoes.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        configuracoes.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        configuracoes.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        URL urlConexao = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(urlConexao, configuracoes);
    }

    //@AfterAll
    public static AppiumDriver getDriver() {
        return driver;
    }



    public static void fecharDriver(){

        driver.close();
    }


    public static void matarDrive(){

        driver.quit();
    }

}