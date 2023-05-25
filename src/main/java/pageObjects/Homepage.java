package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Homepage extends BasePage {
    public WebDriver driver;

    By categoryDog = By.id("ui-id-5");
    By searchIcon = By.xpath("//div[@class='block block-search initial']/span[@class='aicon-search search-toggle']");
    By searchInput = By.id("search");
    By loginIcon = By.id("my-account-link");
    By usernameInput = By.id("username");
    By passwordInput = By.id("pass");
    By loginButton = By.id("bnt-animates-login-authentication");
    By LogOutLink = By.linkText("Log Out");
    By msgInvalidLogin = By.xpath("//div[@id='animates-login-authentication']/div[1]/div");

    public Homepage() throws IOException {
        super();
    }

    public WebElement getCategoryDogLink() throws IOException {
        this.driver = getDriver();
        return driver.findElement(categoryDog);
    }

    public WebElement getSearchIcon() throws IOException {
        this.driver = getDriver();
        return driver.findElement(searchIcon);
    }

    public WebElement getSearchInput() throws IOException {
        this.driver = getDriver();
        return driver.findElement(searchInput);
    }

    public WebElement getLoginIcon() throws IOException {
        this.driver = getDriver();
        return driver.findElement(loginIcon);
    }

    public WebElement getUsernameInput() throws IOException {
        this.driver = getDriver();
        return driver.findElement(usernameInput);
    }

    public WebElement getPasswordInput() throws IOException {
        this.driver = getDriver();
        return driver.findElement(passwordInput);
    }

    public WebElement getLoginButton() throws IOException {
        this.driver = getDriver();
        return driver.findElement(loginButton);
    }

    public WebElement getLogOutLink() throws IOException {
        this.driver = getDriver();
        return driver.findElement(LogOutLink);
    }

    public WebElement getMsgInvalidLogin() throws IOException {
        this.driver = getDriver();
        return driver.findElement(msgInvalidLogin);
    }
}
