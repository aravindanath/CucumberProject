package cucumberFw.hooks;

import cucumberFw.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class MyHooks {

    private WebDriver driver;

    @Before
    public void before(){
        driver = DriverFactory.initialize(System.getProperty("browser","chrome"));
    }


    @After
    private void after(){
        driver.quit();
    }
}
