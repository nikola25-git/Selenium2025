package sedmica9.cetvrtak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Domaci_cetvrtak {

    // Testirati bar 3 razlicita test case-a za logovanje na sledecem linku: https://www.saucedemo.com
    //(koristiti assert)

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.clear();
        usernameField.sendKeys("standard_user");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        String expectedURL = "https://www.saucedemo.com/inventory.html";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

        WebElement shoppingCart = driver.findElement(By.className("shopping_cart_link"));
        Assert.assertTrue(shoppingCart.isDisplayed());

        WebElement appLogo = driver.findElement(By.className("app_logo"));
        Assert.assertTrue(appLogo.isDisplayed());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));


        driver.navigate().to("https://www.saucedemo.com/");

        usernameField = driver.findElement(By.id("user-name"));
        usernameField.clear();
        usernameField.sendKeys("visual_user");

//        Thread.sleep(3000);

        passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys("sauce_secret");

        loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        expectedURL = "https://www.saucedemo.com/";
        actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL);

        WebElement errorMsg = driver.findElement(By.className("error-button"));
        Assert.assertTrue(errorMsg.isDisplayed());

        driver.switchTo().window(tabs.get(2));
        driver.navigate().to("https://www.saucedemo.com/");

        usernameField = driver.findElement(By.id("user-name"));
        usernameField.clear();
        usernameField.sendKeys("non_existent_user");


        passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys("secret_sauce");

        loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        expectedURL = "https://www.saucedemo.com/";
        actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL);

        errorMsg = driver.findElement(By.className("error-button"));
        Assert.assertTrue(errorMsg.isDisplayed());

        driver.close();

    }
}
