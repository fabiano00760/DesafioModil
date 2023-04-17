package hooks;

import Configuration.AppDriver;
import Utils.BasePage;
import Utils.PrintScr;
import com.itextpdf.text.DocumentException;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Hooks extends BasePage {


    @AfterStep
    public void afterStepExecution(){
        tirarFoto();
    }

    @After
    public void afterScenariosExecution(Scenario scenario) throws DocumentException, FileNotFoundException {
        new PrintScr().salvarArquivosNoPdf(String.valueOf(scenario.getName()));
        AppDriver.killDriver();
    }

}
