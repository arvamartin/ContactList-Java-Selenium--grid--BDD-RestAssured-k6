import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features/API", "src/test/resources/Features/UI"},
        glue = {"/StepDefinitions/API", "StepDefinitions/UI", "Utils"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = false
        , tags = "not @manualOnly"
)
public class Runner {
}