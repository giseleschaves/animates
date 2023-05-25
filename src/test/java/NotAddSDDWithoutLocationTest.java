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

public class NotAddSDDWithoutLocationTest extends Hooks {
    public NotAddSDDWithoutLocationTest() throws IOException{
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

        Row row6 = sheet.getRow(6); //defining the row
        Cell cellR6C0 =  row6.getCell(0); //retrieving data

        String skuRow6 = cellR6C0.toString(); //converting the value to String
        System.out.println(skuRow6);

        home.getSearchInput().sendKeys(skuRow6);
        home.getSearchInput().sendKeys(Keys.ENTER);

        SearchPage search = new SearchPage();
        search.getFirstProduct().click();

        ProductPage product = new ProductPage();
        product.getSDDOption().click();

        //System.out.println(product.getBtnAddToCart().isEnabled());

        Assert.assertEquals(product.getBtnAddToCart().isEnabled(), false);

    }

}
