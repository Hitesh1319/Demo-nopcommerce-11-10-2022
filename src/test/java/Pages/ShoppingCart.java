package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCart {
    WebDriver driver;

    By radioInput = By.xpath("//input[@id='termsofservice']");
    By checkoutButton = By.xpath("//button[@id='checkout']");
    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
    }

    public void clickingOnShoppinCart(String shoppingCart) {
        driver.findElement(By.linkText(shoppingCart)).click();
    }

    public void checkout() {

    }
}
