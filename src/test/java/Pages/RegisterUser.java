package Pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

public class RegisterUser {
    WebDriver driver;
    WebDriverWait wait;
    Random random = new Random();

    public static String path;
    int randomNumber = random.nextInt(50);

    String input = "//input[@id='%s' and @name='%s']";
    By registerButton = By.xpath("//button[@name='register-button']");
    By loginButton = By.xpath("//div[@class='buttons']//button[@type='submit']");
    public RegisterUser(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void registeringUser(String FirstName , String LastName, String Company , String Text , String Email, String Password, String ConfirmPassword ) throws IOException {
        path = System.getProperty("user.dir") + "//src//test//java//TestData//Credential.xlsx";
        FileInputStream propertyFile = null;
        try {
            propertyFile = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(propertyFile);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String firstNameCell = sheet.getRow(1).getCell(2).getStringCellValue();
        String lastNameCell = sheet.getRow(1).getCell(3).getStringCellValue();
        String emailCell = sheet.getRow(1).getCell(4).getStringCellValue();
        String companyCell = sheet.getRow(1).getCell(5).getStringCellValue();
        String passwordCell = sheet.getRow(1).getCell(6).getStringCellValue();
        driver.findElement(By.xpath(String.format(input, FirstName,FirstName))).sendKeys(firstNameCell);
        driver.findElement(By.xpath(String.format(input, LastName,LastName))).sendKeys(lastNameCell);
        driver.findElement(By.xpath(String.format(input, Company,Company))).sendKeys(companyCell);
        driver.findElement(By.xpath(String.format(input, Email,Email))).sendKeys(randomNumber+emailCell);
        driver.findElement(By.xpath(String.format(input, Password ,Password))).sendKeys(passwordCell);
        driver.findElement(By.xpath(String.format(input,ConfirmPassword,ConfirmPassword))).sendKeys(passwordCell);
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        driver.findElement(registerButton).click();
    }

    public void login(String Email , String Password) throws IOException {
        FileInputStream propertyFile = null;
        try {
            propertyFile = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(propertyFile);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String emailCell = sheet.getRow(1).getCell(4).getStringCellValue();
        String passwordCell = sheet.getRow(1).getCell(6).getStringCellValue();
        driver.findElement(By.xpath(String.format(input,Email,Email))).sendKeys(randomNumber+emailCell);
        driver.findElement(By.xpath(String.format(input,Password,Password))).sendKeys(passwordCell);
        driver.findElement(loginButton).click();
    }
}