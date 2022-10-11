package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComputersPage {
    WebDriver driver;

    public ComputersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectingProduct(String Product) {
        driver.findElement(By.xpath(String.format("//div[@class='page category-page']//a[contains(text(),'%s')]", Product))).click();
    }
}
