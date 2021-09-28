import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        monochrome = true,
        glue = "stepDefinitions",
        plugin = {"json:reports/cucumber.json"}
)
public class TestRunner {
}