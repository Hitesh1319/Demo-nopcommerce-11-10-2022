package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderUpper {
    WebDriver driver;

    public HeaderUpper(WebDriver driver) {
        this.driver = driver;
    }

    public void selectHeaderLink(String linkName) {
        driver.findElement(By.xpath("//div[@class='header-links-wrapper']//a[contains(text(),'"+linkName+"')]")).click();
    }
}
