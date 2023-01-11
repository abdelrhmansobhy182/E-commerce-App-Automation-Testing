import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src\\main\\resources\\Features"},
        glue = "StepDefinitions",
        tags = "@smoke",
        plugin = {"json:target/cucumber.json"}

)
public class OpenBrowser {}
