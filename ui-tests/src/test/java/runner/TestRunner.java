package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "com.epam.reportportal.cucumber.ScenarioReporter"},
        features = {"src/test/resources/features"},
        glue = "stepDefs",
        monochrome = true,
        stepNotifications = true,
        tags = "@Parallel"
)
public class TestRunner {

}
