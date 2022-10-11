package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class NotebookPage {
    WebDriver driver;
    WebDriverWait wait;

    By sortByPrice = By.xpath("//select[@name='products-orderby']");
    By sortByDisplay = By.xpath("//select[@name='products-pagesize']");
    By productName = By.xpath("//h2[@class='product-title']");
    By productPrice = By.xpath("//div[@class='prices']");
    By productNameClick = By.xpath("//div[@class='picture']//a[@title='Show details for HP Spectre XT Pro UltraBook']");
    public NotebookPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void sortingPrice(String value) {
        driver.findElement(sortByPrice).click();
        driver.findElement(By.xpath("//select[@name='products-orderby']//option[text()='"+value+"']")).click();
    }

    public void sortingDisplay(String number) {
        driver.findElement(sortByDisplay).click();
        driver.findElement(By.xpath("//select[@name='products-pagesize']//option[text()='"+number+"']")).click();
    }

    public void displayingProducts() {
         List<WebElement> myElements = driver.findElements(productName);
         for(WebElement e : myElements) {
             System.out.println(e.getText());
         }
         List<WebElement> MyElementsPrice = driver.findElements(productPrice);
         for(WebElement b : MyElementsPrice) {
             System.out.println(b.getText());
         }
    }

    public void addingHpSpectreXtProUltraBook(String notebookName)  {
        wait.until(ExpectedConditions.elementToBeClickable(productNameClick));
        driver.findElement(productNameClick).click();
        driver.findElement(By.xpath("//button[text()='ADD TO PRODUCT']")).click();
    }

    public void verifyConfirmationMessage() {
        Assert.assertEquals(By.xpath("//div[@class='bar-notification success']//p"), "The product has been added to your ");
        driver.findElement(By.xpath("//span[@class='close']")).click();
    }
}