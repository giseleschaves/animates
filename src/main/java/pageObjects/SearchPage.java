package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class SearchPage extends BasePage {
    public WebDriver driver;

    By firstProduct = By.cssSelector(".product-item-link");

    public SearchPage() throws IOException {
        super();
    }

    public WebElement getFirstProduct() throws IOException {
        this.driver = getDriver();
        return driver.findElement(firstProduct);
    }
}
