package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopMenu {
    WebDriver driver;
    public TopMenu(WebDriver driver) {
        this.driver = driver;
    }

    public void selectingMenu(String Menu) {
        driver.findElement(By.xpath(String.format("//a[contains(text(),'%s')]", Menu))).click();
    }
}