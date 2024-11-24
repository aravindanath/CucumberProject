package cucumberFw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage  extends BasePage {
    public StorePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath="//a[@class='wp-block-button__link' and text()='Shop Now']")
    WebElement shopNowButton;

    @FindBy(xpath="//a[@aria-label='Add “Blue Shoes” to your cart']")
    WebElement addBlueShoe;


    public void navigateToShopNow(){
        wait.until(ExpectedConditions.elementToBeClickable(shopNowButton)).click();
    }

    public void addBlueShoes(){
        wait.until(ExpectedConditions.elementToBeClickable(addBlueShoe)).click();
    }

}
