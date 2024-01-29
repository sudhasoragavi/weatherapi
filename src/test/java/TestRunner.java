import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Specify the path to your feature files
        glue = "stepdefinitions", // Specify the package where your step definitions are located
        plugin = {"json:target/cucumber.json"} // Specify the plugins for reporting
)
public class TestRunner {
}
