package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCart {
    WebDriver driver;
    WebDriverWait wait;

    By radioInput = By.xpath("//input[@id='termsofservice']");
    By checkoutButton = By.xpath("//button[@id='checkout']");
    By updateCart = By.xpath("//button[@name='updatecart' and @type='submit']");
    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickingOnShoppinCart(String shoppingCart) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(shoppingCart)));
        driver.findElement(By.linkText(shoppingCart)).click();
    }

    public void checkout() {
        driver.findElement(radioInput).click();
        driver.findElement(checkoutButton).click();
    }

    public void increasingQuantities(String Quantities) {
        driver.findElement(By.xpath("//input[@type='text' and @class='qty-input']")).sendKeys(Quantities);
        driver.findElement(updateCart).click();
    }
}