package sedmica9.cetvrtak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak2_1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://practicetestautomation.com/");

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLoginPage = driver.findElement(By.linkText("Test Login Page"));
        testLoginPage.click();


        WebElement usernameField = driver.findElement(By.cssSelector("input[id = 'username']"));
        usernameField.sendKeys("student");

        WebElement passwordField = driver.findElement(By.cssSelector("input[id = 'password']"));
        passwordField.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

        String expectedHeader = "Logged In Successfully";
        WebElement actualHeader = driver.findElement(By.className("post-title"));
        Assert.assertEquals(actualHeader.getText(), expectedHeader);

        WebElement logOutButton = driver.findElement
                (By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color"));
        Assert.assertTrue(logOutButton.isDisplayed());

        logOutButton.click();

        String expURL = "https://practicetestautomation.com/practice-test-login/";
        String actURL = driver.getCurrentUrl();

        Assert.assertEquals(actURL, expURL);

        driver.close();

    }
}
