package day1;

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
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/");
    }

    @When("I add a {string} to the cart")
    public void iAddAToTheCart(String arg0) {

        driver.findElement(By.xpath("//a[@class='wp-block-button__link' and text()='Shop Now']")).click();
        By addShoe = By.xpath("//a[@aria-label='Add “Blue Shoes” to your cart']");
        driver.findElement(addShoe).click();
    }

    @Then("I should see {int} {string}\" in the cart")
    public void iShouldSeeInTheCart(int arg0, String arg1) throws Throwable {

     }
}