package cucumberFw;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;



@CucumberOptions(plugin="message:target/cucumber-report.ndjson")
public class RunCucumberTest extends AbstractTestNGCucumberTests{


}