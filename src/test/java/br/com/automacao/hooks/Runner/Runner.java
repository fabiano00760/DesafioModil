package br.com.automacao.hooks.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        features = "src/main/Features/",
        glue = {"br.com.automacao"},
        tags = "@TesteLogin",
        monochrome = true,
        plugin = {"pretty", "json:Reports/report.json", "junit:Reports/report.xml", "html:Reports/cucumber-reports.html" },
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        stepNotifications = true)

public class Runner {

}