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

public class NotAddSDWithoutLocationTest extends Hooks {
    public NotAddSDWithoutLocationTest() throws IOException{
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

        Row row15 = sheet.getRow(15); //defining the row
        Cell cellR15C0 =  row15.getCell(0); //retrieving data

        String skuRow15 = cellR15C0.toString(); //converting the value to String
        System.out.println(skuRow15);

        home.getSearchInput().sendKeys(skuRow15); // I248122
        home.getSearchInput().sendKeys(Keys.ENTER);

        SearchPage search = new SearchPage();
        search.getFirstProduct().click();

        ProductPage product = new ProductPage();
        product.getSDOption().click();

        //System.out.println(product.getBtnAddToCart().isEnabled());

        Assert.assertEquals(product.getBtnAddToCart().isEnabled(), false);

    }

}
