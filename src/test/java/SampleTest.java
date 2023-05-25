import base.Hooks;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;

import java.io.IOException;
import java.util.List;

public class SampleTest extends Hooks {
    public SampleTest() throws IOException{
        super();
    }

    @Test
    public void endToEndTest() throws IOException {
        Homepage home = new Homepage();
        home.getSearchIcon().click();
        home.getSearchInput().sendKeys("I168757");
        home.getSearchInput().sendKeys(Keys.ENTER);

        SearchPage search = new SearchPage();
        search.getFirstProduct().click();

        ProductPage product = new ProductPage();
        product.getSDOption().click();

        product.getDeliverySearch().sendKeys("Queen Street");

        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        List<WebElement> addresses = product.getAddressList();

        for(WebElement address:addresses) {
            if(address.getText().contains("7A Queen")) {
                address.click();
                break;
            }

        }



        /* Search Store Address
        product.getStoreSearch().sendKeys("Albany, Auckland, New Zealand");
        product.getStoreSearch().sendKeys(Keys.ENTER); */


        /* quantity
        product.getplusQty().click();
        product.getminusQty().click() */;


        /*product.getBtnAddVetToCart().click();

        VetPrescriptionPanel vetPanel = new VetPrescriptionPanel();

        waitForElementVisible(vetPanel.getAcceptVetPrescription(), 30);
        vetPanel.getAcceptVetPrescription().click();
        vetPanel.getBtnVetAddToCart().click();


        CartPanel cartPanel = new CartPanel();
        waitForElementVisible(cartPanel.getContinueShopLink(), 10);
        /* Cart Panel Interactions
        cartPanel.getEditCartBtn().click();
        cartPanel.getCheckoutBtn().click(); > Go to Checkout */
        //cartPanel.getContinueShopLink().click();

        //Assert.assertEquals(product.getCCStatus().getText(), "Set store");

    }

}
