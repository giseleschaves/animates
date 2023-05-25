package pageObjects;

import base.BasePage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginPage extends BasePage {
    public WebDriver driver;


    /*By sddStatus = By.xpath("//h4[contains(text(), 'Same Day Delivery')]/following-sibling::div");
    By ccStatus = By.xpath("//h4[contains(text(), 'Click & Collect')]/following-sibling::div");
    By deliverySearch = By.xpath("//input[@id='delivery-search']");
    By toggleRepeatDelivery = By.xpath("//div[@id='repeat-delivery-options']//a[@href='#']");
    By btnAddToCart = By.id("product-addtocart-button");
    By msgProductAdded = By.xpath("//div[@data-ui-id='message-success']");*/


    public LoginPage() throws IOException {
        super();
    }

    /*public WebElement getLoginIcon() {
        return driver.findElement(loginIcon);
    }*/


}
