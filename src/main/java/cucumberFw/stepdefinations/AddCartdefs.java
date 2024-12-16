package cucumberFw.stepdefinations;

import cucumberFw.factory.DriverFactory;
import cucumberFw.pages.BasePage;
import cucumberFw.pages.CartPage;
import cucumberFw.pages.CheckoutPage;
import cucumberFw.pages.StorePage;
import cucumberFw.utils.PropertyUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class AddCartdefs {
  private   WebDriver driver ;

    @Given("I'm on a store page")
    public void iMOnAStorePage() {
        driver = DriverFactory.getDriver();
        String url = PropertyUtils.getValue("baseurl");
        new StorePage(driver).load(url);

    }

    @When("I add a {string} to the cart")
    public void iAddAToTheCart(String arg0) {

        StorePage sp = new StorePage(driver);
        sp.navigateToShopNow();

        sp.addBlueShoes();
    }

    @Then("I should see {int} {string}\" in the cart")
    public void iShouldSeeInTheCart(int arg0, String arg1) {

        new CartPage(driver).navigateToCart();
        driver.navigate().refresh();
     }

    @And("I'm on a checkout page")
    public void iMOnACheckoutPage() {
        new CartPage(driver).proceedToCheckout();
    }

    @When("I provide billing information")
    public void iProvideBillingInformation(){
        CheckoutPage cp = new CheckoutPage(driver);
        BasePage bp = new BasePage(driver);
        cp.enterBillingFirstName(bp.firstName());
        cp.enterBillingLastName(bp.lastName());
        cp.enterBillingCity(bp.city());
        cp.enterBillingAddressLineOne(bp.address1());
        cp.enterBillingEmail(bp.email());
        cp.enterBillingZip(bp.zipcode());
        cp.selectBillingState(bp.state());
        cp.enterNotes(bp.randomText());

    }

    @And("I placed the order")
    public void iPlacedTheOrder() {
        CheckoutPage cp = new CheckoutPage(driver);
        cp.placeOrder();

    }

    @And("Order should be placed successfully")
    public void orderShouldBePlacedSuccessfully() {
        CheckoutPage cp = new CheckoutPage(driver);
        cp.getNotice();
        Assert.assertEquals(cp.getNotice(),cp.getNotice());
        System.out.println("Order: "+ cp.getNotice());
    }
}