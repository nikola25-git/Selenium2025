package sedmica10.ponedeljak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Selenium10 {

    //"https://www.practicetestautomation.com/"
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.practicetestautomation.com/");

    }

    @BeforeMethod
    public void pageSetUp() {
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();
    }

    @Test
    public void userCanLogIn() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.clear();
        usernameField.sendKeys("student");
        passwordField.clear();
        passwordField.sendKeys("Password123");
        submitButton.click();

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButton.isDisplayed());

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.practicetestautomation.com/");
        WebElement loginTitle = driver.findElement(By.className("post-title"));
        Assert.assertTrue(loginTitle.isDisplayed());

    }


    @Test
    public void userCanLogOut() {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        usernameField.clear();
        usernameField.sendKeys("student");
        passwordField.clear();
        passwordField.sendKeys("Password123");
        submitButton.click();

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButton.isDisplayed());

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.practicetestautomation.com/logged-in-successfully");
        WebElement loginTitle = driver.findElement(By.className("post-title"));
        Assert.assertTrue(loginTitle.isDisplayed());
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
