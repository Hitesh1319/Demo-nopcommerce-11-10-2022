package Pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class BillablePage {
    WebDriver driver;
    WebDriverWait wait;
    public static String path;

    String userDetail = "//input[@id='%s' and @name='%s']";
    String continueButton = "//button[@onclick='%s']";
    By countryBilling = By.xpath("//select[@id='BillingNewAddress_CountryId']");
    By countrySelect = By.xpath("//option[@value='133' and text()='India']");
    By orderPlacedVerification = By.xpath("//div[@class='section order-completed']//div[@class='title']//strong");

    public BillablePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void FillingBillDetails(String cityId ,String cityName, String address1Id,String address1Name,String address2Id,String address2Name,String phoneId,String phoneName) throws IOException {
        path = System.getProperty("user.dir") + "//src//test//java//TestData//Credential.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet2");
        String cityCell = sheet.getRow(1).getCell(0).getStringCellValue();
        String address1Cell = sheet.getRow(1).getCell(1).getStringCellValue();
        String address2Cell = sheet.getRow(1).getCell(2).getStringCellValue();
        driver.findElement(By.xpath(String.format(userDetail, "BillingNewAddress_City", "BillingNewAddress.City"))).sendKeys(cityCell);
        driver.findElement(By.xpath(String.format(userDetail, "BillingNewAddress_Address1", "BillingNewAddress.Address1"))).sendKeys(address1Cell);
        driver.findElement(By.xpath(String.format(userDetail, "BillingNewAddress_ZipPostalCode", "BillingNewAddress.ZipPostalCode"))).sendKeys(address2Cell);
        driver.findElement(By.xpath(String.format(userDetail, "BillingNewAddress_PhoneNumber", "BillingNewAddress.PhoneNumber"))).sendKeys("1234567890");
        driver.findElement(countryBilling).click();
        driver.findElement(countrySelect).click();
        driver.findElement(By.xpath(String.format(continueButton, "Billing.save()"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(continueButton,"ShippingMethod.save()"))));
        driver.findElement(By.xpath(String.format(continueButton, "ShippingMethod.save()"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(continueButton,"PaymentMethod.save()"))));
        driver.findElement(By.xpath(String.format(continueButton, "PaymentMethod.save()"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(continueButton,"PaymentInfo.save()"))));
        driver.findElement(By.xpath(String.format(continueButton, "PaymentInfo.save()"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(continueButton,"ConfirmOrder.save()"))));
        driver.findElement(By.xpath(String.format(continueButton, "ConfirmOrder.save()"))).click();
    }

    public void orderVerify() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderPlacedVerification));
        String actual = driver.findElement(orderPlacedVerification).getText();
        Assert.assertEquals(actual,"Your order has been successfully processed!");
    }
}