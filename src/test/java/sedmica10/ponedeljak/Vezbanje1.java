package sedmica10.ponedeljak;

// Zadatak8
// Napraviti testove za login funkcionalnost koristeci anotacije
//https://practicetestautomation.com/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Vezbanje1 {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver();
    // driver ide u BeforeClass ako zelimo sve testove da radimo u istom browser-u, tj. prozoru
    }

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //driver ide u BeforeMethod ako svaki test zelimo u posebnom prozoru browser-a
        driver.navigate().to("https://practicetestautomation.com/");

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLoginPage = driver.findElement(By.linkText("Test Login Page"));
        testLoginPage.click();

    }

    @Test(priority = 10)
    public void userCanLogIn() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.sendKeys("student");
        passwordField.sendKeys("Password123");
        submitButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");

        WebElement loggedInSuccessfully = driver.findElement(By.className("post-title"));
        Assert.assertTrue(loggedInSuccessfully.isDisplayed());

        WebElement logOutButton = driver.findElement((By.linkText("Log out")));
        Assert.assertTrue(logOutButton.isDisplayed());
    }

    @Test(priority = 20)
    public void userCanLogOut() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.sendKeys("student");
        passwordField.sendKeys("Password123");
        submitButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");

        WebElement loggedInSuccessfully = driver.findElement(By.className("post-title"));
        Assert.assertTrue(loggedInSuccessfully.isDisplayed());

        WebElement logOutButtonAfter = driver.findElement((By.linkText("Log out")));
        Assert.assertTrue(logOutButtonAfter.isDisplayed());

        logOutButtonAfter.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");

        WebElement submitButtonAfter = driver.findElement(By.id("submit"));
        Assert.assertTrue(submitButtonAfter.isDisplayed());

    }

    @Test(priority = 30)
    public void incorrectUserName() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.sendKeys("someuser");
        passwordField.sendKeys("Password123");
        submitButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");

        WebElement usernameIsInvalid = driver.findElement(By.id("error"));
        Assert.assertTrue(usernameIsInvalid.isDisplayed());

    }

    @Test (priority = 40)
    public void incorrectPassword() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.sendKeys("student");
        passwordField.sendKeys("Password");
        submitButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");

        WebElement passwordIsInvalid = driver.findElement(By.id("error"));
        Assert.assertTrue(passwordIsInvalid.isDisplayed());
    }


    @AfterMethod
    public void clearCookies() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
