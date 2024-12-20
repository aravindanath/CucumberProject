package cucumberFw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath="//div[@class='site-primary-header-wrap ast-builder-grid-row-container site-header-focus-item ast-container']//div[@class='ast-builder-layout-element site-header-focus-item ast-header-woo-cart']")
    WebElement cartIcon;

    @FindBy(xpath="//a[contains(text(),'Proceed to checkout')]")
    WebElement checkoutButton;



    public void navigateToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();

    }

    public void proceedToCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();

    }


}
