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

public class NotAddCeCGeoSelectStoreWithoutStockTest extends Hooks {
    public NotAddCeCGeoSelectStoreWithoutStockTest() throws IOException{
        super();
    }

    @Test
    public void AddCeCItem() throws IOException {
        Homepage home = new Homepage();
        home.getSearchIcon().click();

        FileInputStream workbookLocation = new FileInputStream(System.getProperty("user.dir") +
                "\\src\\main\\java\\resources\\skus.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(workbookLocation);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Row row5 = sheet.getRow(5); //defining the row
        Cell cellR5C0 =  row5.getCell(0); //retrieving data

        String skuRow5 = cellR5C0.toString(); //converting the value to String

        System.out.println(skuRow5);

        home.getSearchInput().sendKeys(skuRow5);
        home.getSearchInput().sendKeys(Keys.ENTER);

        SearchPage search = new SearchPage();
        search.getFirstProduct().click();

        ProductPage product = new ProductPage();
        product.getCeCOption().click();
        product.getUseLocationCeCLink().click();

        waitForElementVisible(product.getSelectNotAvailableStore(), 20);

        product.getSelectNotAvailableStore().click();

        //System.out.println("sku name => " + cartPanel.getSkuName().getText());
        Assert.assertEquals(product.getBtnAddToCart().isEnabled(), false);
    }

}
