package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src\\main\\resources\\Feature"},
        glue = "StepDefinitions",
        tags = "@smoke",
        plugin = {"json:target/cucumber.json"}

)
public class testRunner {
}
