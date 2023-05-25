import base.Hooks;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.CartPanel;
import pageObjects.Homepage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;

import java.io.FileInputStream;
import java.io.IOException;

@Listeners(resources.Listeners.class)

public class AddSDDAvailableGeoLocationTest extends Hooks {
    public AddSDDAvailableGeoLocationTest() throws IOException{
        super();
    }

    @Test
    public void AddSDDItem() throws IOException {
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

        home.getSearchInput().sendKeys(skuRow2);
        home.getSearchInput().sendKeys(Keys.ENTER);

        SearchPage search = new SearchPage();
        search.getFirstProduct().click();

        ProductPage product = new ProductPage();
        product.getSDDOption().click();
        product.getUseLocationDeliveryLink().click();
        Assert.assertEquals(product.getCurrentAddress().isEnabled(), true);

        product.getBtnAddToCart().click();

        CartPanel cartPanel = new CartPanel();
        waitForElementVisible(cartPanel.getSkuName(), 10);
        //System.out.println("sku name => " + cartPanel.getSkuName().getText());
        Assert.assertEquals(cartPanel.getSkuName().getText(), skuName2);
        cartPanel.getContinueShopLink().click();
    }

}
