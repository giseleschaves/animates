import base.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Homepage;

import java.io.IOException;
import java.time.Duration;

public class LoginTest extends Hooks {
    public LoginTest() throws IOException{
        super();
    }

  /* @Test
    public void SucessfullLogin() {
        Homepage home = new Homepage(driver);
        home.getLoginIcon().click();
        Duration.ofSeconds(20);
        home.getUsernameInput().sendKeys("giseleschaves@gmail.com");
        Duration.ofSeconds(20);
        home.getPasswordInput().sendKeys("Brenda0201!");
        home.getLoginButton().click();

        //Assert.assertEquals(product.getCCStatus().getText(), "Set store");

    }*/

    @Test
    public void InvalidPassword() throws IOException {
        Homepage home = new Homepage();
        home.getLoginIcon().click();
        Duration.ofSeconds(20);
        home.getUsernameInput().sendKeys("giseleschaves@gmail.com");
        Duration.ofSeconds(20);
        home.getPasswordInput().sendKeys("123456!");
        home.getLoginButton().click();
        Duration.ofSeconds(30);
        System.out.println("message => " + home.getMsgInvalidLogin().getText());
        Assert.assertEquals(home.getMsgInvalidLogin().getText(), "Invalid login or password.");
    }

}
