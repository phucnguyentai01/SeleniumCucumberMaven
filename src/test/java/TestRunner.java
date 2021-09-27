import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import utilities.DriverFactory;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        plugin = {"json:reports/cucumber.json"}
)
public class TestRunner {
        @AfterClass
        public static void tearDownClass() {
                DriverFactory.quitDriver();
        }
}