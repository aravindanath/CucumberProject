package cucumberFw.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage{
    @FindBy(id = "billing_first_name") private WebElement billingFirstnameFld;
    @FindBy(id = "billing_last_name") private WebElement billingLastNameFld;
    @FindBy(id = "billing_address_1") private WebElement billingAddressOneFld;
    @FindBy(id = "billing_city") private WebElement billingCityFld;
    @FindBy(id = "billing_state") private WebElement billingStateDropDown;
    @FindBy(id = "select2-billing_state-container") private WebElement alternateBillingStateDropDown;
    @FindBy(id = "billing_postcode") private WebElement billingZipFld;
    @FindBy(id = "billing_email") private WebElement billingEmailFld;
    @FindBy(id = "place_order") private WebElement placeOrderBtn;
    @FindBy(id = "order_comments") private WebElement noticeTxt;
    @FindBy(xpath = "//table[@class='woocommerce-table woocommerce-table--order-details shop_table order_details']/tfoot/tr/th[contains(text(),'Note:')]//following::td[1]")
    private WebElement noteMessage;
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterBillingFirstName(String billingFirstName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingFirstnameFld));
        e.clear();
        e.sendKeys(billingFirstName);
        return this;
    }

    public CheckoutPage enterBillingLastName(String billingLastName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingLastNameFld));
        e.clear();
        e.sendKeys(billingLastName);
        return this;
    }

    public CheckoutPage enterBillingAddressLineOne(String billingAddressLineOne){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingAddressOneFld));
        e.clear();
        e.sendKeys(billingAddressLineOne);
        return this;
    }

    public CheckoutPage enterBillingCity(String billingCity){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingCityFld));
        e.clear();
        e.sendKeys(billingCity);
        return this;
    }

    public CheckoutPage selectBillingState(String billingStateName){
        wait.until(ExpectedConditions.elementToBeClickable(alternateBillingStateDropDown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[text()='" + billingStateName + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        return this;
    }

    public CheckoutPage enterBillingZip(String billingZip){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingZipFld));
        e.clear();
        e.sendKeys(billingZip);
        return this;
    }

    public CheckoutPage enterBillingEmail(String billingEmail){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingEmailFld));
        e.clear();
        e.sendKeys(billingEmail);
        return this;
    }


    public CheckoutPage placeOrder(){
        waitForOverlaysToDisappear(overlay);
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
        return this;
    }

    public CheckoutPage enterNotes(String text){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(noticeTxt));
        e.clear();
        e.sendKeys(text);
        return this;
    }

    public String getNotice(){
        return wait.until(ExpectedConditions.visibilityOf(noteMessage)).getText();
    }
}
