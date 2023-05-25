package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class CartPanel extends BasePage {
    public WebDriver driver;

    By skuName = By.xpath("//ol[@id='mini-cart']/li[@role='tab']//strong/a");
    By skuQty = By.xpath("//ol[@id='mini-cart']/li[@role='tab']//dd[@class='values']");

    By editCartBtn = By.cssSelector(".action.primary.viewcart > span > span");
    By checkoutBtn = By.cssSelector("button#top-cart-btn-checkout > span");
    By continueShopLink = By.cssSelector(".continue_shopping > span");


    public CartPanel() throws IOException {
        super();
    }

    public WebElement getSkuName() throws IOException {
        this.driver = getDriver();
        return driver.findElement(skuName);
    }

    public WebElement getSkuQty() throws IOException {
        this.driver = getDriver();
        return driver.findElement(skuQty);
    }

    public WebElement getEditCartBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(editCartBtn);
    }
    public WebElement getCheckoutBtn() throws IOException {
        this.driver = getDriver();
        return driver.findElement(checkoutBtn);
    }

    public WebElement getContinueShopLink() throws IOException {
        this.driver = getDriver();
        return driver.findElement(continueShopLink);
    }

}
