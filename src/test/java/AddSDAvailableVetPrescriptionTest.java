import base.Hooks;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.FileInputStream;
import java.io.IOException;

@Listeners(resources.Listeners.class)

public class AddSDAvailableVetPrescriptionTest extends Hooks {
    public AddSDAvailableVetPrescriptionTest() throws IOException{
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

        Row row12 = sheet.getRow(12); //defining the row
        Cell cellR12C0 =  row12.getCell(0); //retrieving data
        Cell cellR12C1 =  row12.getCell(1);

        String skuRow12 = cellR12C0.toString(); //converting the value to String
        String skuName12 = cellR12C1.toString();
        System.out.println(skuRow12);

        home.getSearchInput().sendKeys(skuRow12); // I168757  I247070
        home.getSearchInput().sendKeys(Keys.ENTER);

        SearchPage search = new SearchPage();
        search.getFirstProduct().click();

        ProductPage product = new ProductPage();
        product.getSDOption().click();


        product.getBtnAddVetToCart().click();

        VetPrescriptionPanel vetPanel = new VetPrescriptionPanel();

        waitForElementVisible(vetPanel.getAcceptVetPrescription(), 30);
        vetPanel.getAcceptVetPrescription().click();
        vetPanel.getBtnVetAddToCart().click();


        CartPanel cartPanel = new CartPanel();
        waitForElementVisible(cartPanel.getContinueShopLink(), 10);

        //System.out.println("sku name => " + cartPanel.getSkuName().getText());
        Assert.assertEquals(cartPanel.getSkuName().getText(), skuName12);
        cartPanel.getContinueShopLink().click();
    }

}

