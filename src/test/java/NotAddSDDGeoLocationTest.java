import base.Hooks;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;

import java.io.FileInputStream;
import java.io.IOException;

@Listeners(resources.Listeners.class)

public class NotAddSDDGeoLocationTest extends Hooks {
    public NotAddSDDGeoLocationTest() throws IOException{
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

        Row row13 = sheet.getRow(13); //defining the row
        Cell cellR13C0 =  row13.getCell(0); //retrieving data
        Cell cellR13C1 =  row13.getCell(1);

        String skuRow13 = cellR13C0.toString(); //converting the value to String
        String skuName13 = cellR13C1.toString();
        System.out.println(skuRow13);

        home.getSearchInput().sendKeys(skuRow13);
        home.getSearchInput().sendKeys(Keys.ENTER);

        SearchPage search = new SearchPage();
        search.getFirstProduct().click();

        ProductPage product = new ProductPage();
        product.getSDDOption().click();
        product.getUseLocationDeliveryLink().click();
        Assert.assertEquals(product.getCurrentAddress().isEnabled(), true);

        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Assert.assertEquals(product.getBtnAddToCart().isEnabled(), false);
    }

}
