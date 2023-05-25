package pageObjects;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class VetPrescriptionPanel extends BasePage {
    public WebDriver driver;

    By txtModal = By.id("vet-popup-modal-content");
    By acceptVetPrescription = By.xpath("//form[@id='vet-popup-modal-form']/div/div[2]/div[@class='control']/label[@class='label']");
    By btnVetAddToCart = By.id("popup-product-addtocart-button");

    public VetPrescriptionPanel() throws IOException {
        super();
    }

    public WebElement geTxtModal() throws IOException {
        this.driver = getDriver();
        return driver.findElement(txtModal);
    }


    public WebElement getAcceptVetPrescription() throws IOException {
        this.driver = getDriver();
        return driver.findElement(acceptVetPrescription);
    }

    public WebElement getBtnVetAddToCart() throws IOException {
        this.driver = getDriver();
        return driver.findElement(btnVetAddToCart);
    }
}
