import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/api", "src/test/resources/features/ui"},
        glue = {"/stepDefinitions/api", "stepDefinitions/ui", "utils"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = false

)
public class Runner {
}
