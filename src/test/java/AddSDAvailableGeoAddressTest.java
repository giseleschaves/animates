import base.Hooks;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.CartPanel;
import pageObjects.Homepage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;

import java.io.IOException;

@Listeners(resources.Listeners.class)

public class AddSDAvailableGeoAddressTest extends Hooks {
    public AddSDAvailableGeoAddressTest() throws IOException{
        super();
    }

    @Test
    public void AddSDItem() throws IOException {
        Homepage home = new Homepage();
        home.getSearchIcon().click();
        home.getSearchInput().sendKeys("I247070");
        home.getSearchInput().sendKeys(Keys.ENTER);

        SearchPage search = new SearchPage();
        search.getFirstProduct().click();

        ProductPage product = new ProductPage();
        product.getSDOption().click();
        product.getUseLocationDeliveryLink().click();
        Assert.assertEquals(product.getCurrentAddress().isEnabled(), true);

        product.getBtnAddToCart().click();

        CartPanel cartPanel = new CartPanel();
        waitForElementVisible(cartPanel.getSkuName(), 10);
        //System.out.println("sku name => " + cartPanel.getSkuName().getText());
        Assert.assertEquals(cartPanel.getSkuName().getText(), "Royal Canin Labrador Retriever Puppy Food 12kg");
        cartPanel.getContinueShopLink().click();
    }

}
