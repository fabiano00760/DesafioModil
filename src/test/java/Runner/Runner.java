package Runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        features = "src/test/Feature/Login.feature",
        glue = {"Stepes","FabricaDeDriver"},
        tags = "@web",
        monochrome = true,
        publish = true,
        plugin = {"pretty", "json:target/report.json", "junit:target/report.xml", "html:target/cucumber-reports.html" },
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        stepNotifications = true
)

public class Runner {

}
