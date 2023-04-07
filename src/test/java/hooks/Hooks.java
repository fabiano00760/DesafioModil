package hooks;

import Main.AppDriver;
import Main.BasePage;
import Main.PrintScr;
import com.itextpdf.text.DocumentException;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;


import java.io.FileNotFoundException;
import java.sql.Driver;
/*
public class Hooks extends BasePage {

  WebDriver driver;

  public Hooks() {
    this.driver = AppDriver.getDriver();
  }

  @After
  public void afterScenarioExecution(Scenario scenario) throws DocumentException, FileNotFoundException {

    new PrintScr().salvarArquivosNoPdf(String.valueOf(scenario));

  }

  @AfterStep
  public void afterStepExecution() {

    tirarFoto(driver,"STEP NAME");

  }



}
 */