package br.com.automacao.hooks.hooks;


import br.com.automacao.Configuration.AppDriver;
import br.com.automacao.Utils.BasePage;
import br.com.automacao.Utils.Utils;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks extends BasePage {

  @AfterStep
  public void afterStepExecution() {
    tirarFoto();
  }

  @After
  public void afterScenarioExecution(Scenario scenario) {
    new Utils().salvarArquivosNoPdf(String.valueOf(scenario.getName()));
    AppDriver.killDriver();
  }

}