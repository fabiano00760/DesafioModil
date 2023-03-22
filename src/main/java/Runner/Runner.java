package Runner;

import io.cucumber.core.snippets.SnippetType;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        features = "/home/fabiano/IdeaProjects/Desafio-mobile-t1m2-fabiano-silva/src/main/resources/Features/Login.feature",
        glue = {"Stepes","Driver.AppDriver"},
        tags = "@web",
        monochrome = true,
        publish = true,
        plugin = {"pretty", "json:target/report.json", "junit:target/report.xml", "html:target/cucumber-reports.html" },
      //  snippets = CucumberOptions.SnippetType.CAMELCASE,
        stepNotifications = true)

public class Runner {
}
