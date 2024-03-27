package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber", "json:target/cucumber.json"},
        features="src/test/resources/features",
        glue="step_definitions",
        tags="@regression",
        dryRun = false,
        monochrome = false
)

        public class UITestRunner{
}
