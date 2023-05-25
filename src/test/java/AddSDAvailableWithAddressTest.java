import base.Hooks;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.CartPanel;
import pageObjects.Homepage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Listeners(resources.Listeners.class)

public class AddSDAvailableWithAddressTest extends Hooks {
    public AddSDAvailableWithAddressTest() throws IOException{
        super();
    }

    @Test
    public void AddSDItem() throws IOException {
        Homepage home = new Homepage();
        home.getSearchIcon().click();

        FileInputStream workbookLocation = new FileInputStream(System.getProperty("user.dir") +
                "\\src\\main\\java\\resources\\skus.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(workbookLocation);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Row row2 = sheet.getRow(2); //defining the row
        Cell cellR2C0 =  row2.getCell(0); //retrieving data
        Cell cellR2C1 =  row2.getCell(1);

        String skuRow2 = cellR2C0.toString(); //converting the value to String
        String skuName2 = cellR2C1.toString();
        System.out.println(skuRow2);

        home.getSearchInput().sendKeys(skuRow2); // I168757  I247070
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

        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        product.getBtnAddToCart().click();

        CartPanel cartPanel = new CartPanel();
        waitForElementVisible(cartPanel.getSkuName(), 10);
        //System.out.println("sku name => " + cartPanel.getSkuName().getText());
        Assert.assertEquals(cartPanel.getSkuName().getText(), skuName2);
        cartPanel.getContinueShopLink().click();
    }

}
