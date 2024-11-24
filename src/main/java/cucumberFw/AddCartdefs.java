package cucumberFw;

import cucumberFw.factory.DriverFactory;
import cucumberFw.pages.CartPage;
import cucumberFw.pages.StorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddCartdefs {
  private   WebDriver driver ;

    @Given("I'm on a store page")
    public void iMOnAStorePage() {
        driver = DriverFactory.getDriver();
        new StorePage(driver).load("https://askomdch.com/");

    }

    @When("I add a {string} to the cart")
    public void iAddAToTheCart(String arg0) {

        StorePage sp = new StorePage(driver);
        sp.navigateToShopNow();

        sp.addBlueShoes();
    }

    @Then("I should see {int} {string}\" in the cart")
    public void iShouldSeeInTheCart(int arg0, String arg1) throws Throwable {

        new CartPage(driver).navigateToCart();
        driver.navigate().refresh();
     }
}