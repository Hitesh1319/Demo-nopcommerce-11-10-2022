package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterUser {
    WebDriver driver;

    By input = By.xpath("//input[@type='text']");
    public RegisterUser(WebDriver driver) {
        this.driver = driver;
    }

    public void registeringUser(String inputPass) {

    }
}
