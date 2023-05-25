package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class ProductPage extends BasePage {
    public WebDriver driver;

    By outStockMsg = By.cssSelector(".initial.product-info-only-store");

    /* Delivery options Locators */
    By sdOption = By.cssSelector(".delivery-list > div:nth-of-type(1)");
    By sddOption = By.cssSelector(".delivery-list > div:nth-of-type(2)");
    By cecOption = By.cssSelector(".click-and-collect-option.delivery-list__option");

    By sdStatus = By.xpath("//h4[contains(text(), 'Standard Delivery')]/following-sibling::div");
    By sddStatus = By.xpath("//h4[contains(text(), 'Same Day Delivery')]/following-sibling::div");
    By ccStatus = By.xpath("//h4[contains(text(), 'Click & Collect')]/following-sibling::div");

    /* Address Search Locators */
    By deliverySearch = By.xpath("//input[@id='delivery-search']");
    By storeSearch = By.xpath("//input[@id='postcode_search-cl']");

    By addressList = By.cssSelector(".suggestion-container__list li > span");

    By currentAddress = By.cssSelector(".current-address");

    By useLocationDeliveryLink = By.xpath("//form[@id='product_addtocart_form']//div[@class='delivery-options-container initial']//div[@class='search-container-text-wrapper']/button[.='Use my location']");
    By useLocationCeCLink = By.xpath("//form[@id='product_addtocart_form']//div[@class='delivery-options-container initial']//div[@class='postcode-search-field-cl']/div[1]/button[.='Use my location']");
    By selectAvailableStore = By.cssSelector("div:nth-of-type(1) > .available-qty1.click-and-collect-store > div:nth-of-type(5)");
    By selectNotAvailableStore = By.cssSelector("div:nth-of-type(1) > .available-qty0.click-and-collect-store > div:nth-of-type(4)");

    By geoModal = By.xpath(".//*[@id='allow']");

    By plusQty = By.cssSelector(".plus");
    By minusQty = By.cssSelector(".minus");
    By toggleRepeatDelivery = By.xpath("//div[@id='repeat-delivery-options']//a[@href='#']");
    By btnAddToCart = By.id("product-addtocart-button");
    By btnAddVetToCart = By.id("vet-popup-button");


    By msgProductAdded = By.xpath("//div[@data-ui-id='message-success']");


    public ProductPage() throws IOException {
        super();
    }

    public WebElement getOutStockMsg() throws IOException {
        this.driver = getDriver();
        return driver.findElement(outStockMsg);
    }

    public WebElement getSDOption() throws IOException {
        this.driver = getDriver();
        return driver.findElement(sdOption);
    }

    public WebElement getSDDOption() throws IOException {
        this.driver = getDriver();
        return driver.findElement(sddOption);
    }

    public WebElement getCeCOption() throws IOException {
        this.driver = getDriver();
        return driver.findElement(cecOption);
    }



    public WebElement getSdStatus() throws IOException {
        this.driver = getDriver();
        return driver.findElement(sdStatus);
    }
    public WebElement getSddStatus() throws IOException {
        this.driver = getDriver();
        return driver.findElement(sddStatus);
    }

    public WebElement getCCStatus() throws IOException {
        this.driver = getDriver();
        return driver.findElement(ccStatus);
    }

    public WebElement getDeliverySearch() throws IOException {
        this.driver = getDriver();
        return driver.findElement(deliverySearch);
    }

    public WebElement getUseLocationDeliveryLink() throws IOException {
        this.driver = getDriver();
        return driver.findElement(useLocationDeliveryLink);
    }

    public WebElement getUseLocationCeCLink() throws IOException {
        this.driver = getDriver();
        return driver.findElement(useLocationCeCLink);
    }

    public WebElement getSelectAvailableStore() throws IOException {
        this.driver = getDriver();
        return driver.findElement(selectAvailableStore);
    }

    public WebElement getSelectNotAvailableStore() throws IOException {
        this.driver = getDriver();
        return driver.findElement(selectNotAvailableStore);
    }

   public WebElement getGeoModal() throws IOException {
        this.driver = getDriver();
        return driver.findElement(geoModal);
    }

    public List<WebElement> getAddressList() throws IOException {
        this.driver = getDriver();
        return driver.findElements((By) addressList);
    }

    public WebElement getCurrentAddress() throws IOException {
        this.driver = getDriver();
        return  driver.findElement(currentAddress);
    }


    public WebElement getStoreSearch() throws IOException {
        this.driver = getDriver();
        return driver.findElement(storeSearch);
    }


    public WebElement getplusQty() throws IOException {
        this.getDriver();
        return driver.findElement(plusQty);
    }

    public WebElement getminusQty() throws IOException {
        this.getDriver();
        return driver.findElement(minusQty);
    }

    public WebElement getBtnAddToCart() throws IOException {
        this.getDriver();
        return driver.findElement(btnAddToCart);
    }

    public WebElement getBtnAddVetToCart() throws IOException {
        this.getDriver();
        return driver.findElement(btnAddVetToCart);
    }

    public WebElement getMsgProductAdded() throws IOException {
        this.getDriver();
        return  driver.findElement(msgProductAdded);
    }

    public WebElement getToggleRepeatDelivery() throws IOException {
        this.getDriver();
        return driver.findElement(toggleRepeatDelivery);
    }

}
