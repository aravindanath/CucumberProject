package cucumberFw.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class BasePage {



    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver,this);
    }


    public void load(String url){
        driver.get(url);
    }

    public void waitForOverlaysToDisappear(By overlay){
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("OVERLAY SIZE" + overlays.size());
        if(overlays.size() > 0){
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("OVERLAYS INVISIBLE");
        } else{
            System.out.println("OVERLAY NOT FOUND");
        }
    }

    protected WebDriver driver;
    protected WebDriverWait wait;

    public String firstName(){
        Faker faker = new Faker();
       return faker.name().firstName();
    }

    public String lastName(){
        Faker faker = new Faker();
        return faker.name().lastName();
    }

    public String state(){
        Faker faker = new Faker(new Locale("en-US"));
        return faker.address().state();
    }

    public String city(){
        Faker faker = new Faker(new Locale("en-US"));
        return faker.address().city();
    }

    public String address1(){
        Faker faker = new Faker(new Locale("en-US"));
        return faker.address().streetAddress();
    }
    public String zipcode(){
        Faker faker = new Faker(new Locale("en-US"));
        return faker.address().zipCode();
    }

    public String email(){
        Faker faker = new Faker();
        return faker.name().lastName()+"@testmail.com";
    }

    public String randomText(){
        Faker faker = new Faker();
        return faker.lorem().sentence();
    }
}
