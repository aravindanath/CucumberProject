package cucumberFw.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {"html:target/cucumber/cucumber.html"},
        glue = {"cucumberFw"},
        features = "src/test/resources"
)
public class TestNgRunnerTest extends AbstractTestNGCucumberTests {
}




