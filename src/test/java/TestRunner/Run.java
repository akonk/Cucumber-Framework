package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Features/Loginfeature.feature",
        glue = "Stepdefinition",
        dryRun = true,
        monochrome = false,
        plugin = {"pretty","html:target/cucumber-reports/reports1.html"}
)
public class Run {
}
