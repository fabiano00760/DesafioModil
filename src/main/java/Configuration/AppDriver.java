package Configuration;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppDriver {

    private static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }


    @BeforeAll
    public static <MobileElement extends WebElement> void createDriver() {

          DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
          File apk = new File("src/main/resources/alura_esporte.apk");
          desiredCapabilities.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
          desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
          desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");


        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    public static void killDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}