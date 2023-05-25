import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class AddressTest {

    @Test
    public void endToEndTest() {
        // TODO Auto-generated method stub
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\java\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.animates.co.nz/royal-canin-labrador-junior-puppy-food-12kg.html");

        driver.findElement(By.cssSelector(".delivery-list > div:nth-of-type(1)")).click();
        driver.findElement(By.xpath("//input[@id='delivery-search']")).sendKeys("Queen Street");

        System.out.println("started to wait" + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()));

        try {
            Thread.sleep(10000);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("finished to wait" + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()));

        List<WebElement> origins = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".suggestion-container__list li > span")));


        for(WebElement origin:origins) {
            if(origin.getText().contains("7A Queen")) {
                System.out.println("address select=> " + origin.getText());
                origin.click();
                break;
            }
        }
    }

}

