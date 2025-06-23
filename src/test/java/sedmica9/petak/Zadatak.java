package sedmica9.petak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak {

    // Zadatak 6
// Ulogovati se na wordpress aplikaciju koristeci sopstvene kredencijale
// Fokus treba da bude na cekanjima i lokatorima

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.navigate().to("https://wordpress.com/");

        String username = "nikolapribicevic8@gmail.com";
        String password = "TestLozinka123";

        WebElement loginButtonUser = driver.findElement(By.linkText("Log in"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButtonUser));
        loginButtonUser.click();

        WebElement loginField = driver.findElement(By.cssSelector("input[id = 'usernameOrEmail']"));
        wait.until(ExpectedConditions.elementToBeClickable(loginField));
        loginField.sendKeys(username);

        WebElement continueButton = driver.findElement(By.cssSelector("button[type = 'submit']"));
        wait.until(ExpectedConditions.visibilityOf(continueButton));
        continueButton.click();

        WebElement passField = driver.findElement(By.cssSelector("input[type = 'password']"));
        wait.until(ExpectedConditions.visibilityOf(passField));
        passField.sendKeys(password);

//        WebElement loginButtonPass = driver.findElement(By.cssSelector("button[type = 'submit']"));
        wait.until(ExpectedConditions.visibilityOf(continueButton));
        continueButton.click();


        String expectedURL = "https://wordpress.com/sites";
        wait.until(ExpectedConditions.urlToBe(expectedURL));
        String actualURL = driver.getCurrentUrl();
//        System.out.println(actualURL);
        Assert.assertEquals(actualURL, expectedURL);



        WebElement howdyBar = driver.findElement(By.className("masterbar__item-howdy-howdy"));
        Assert.assertTrue(howdyBar.isDisplayed());

        String howdyName = "Howdy, nikolapribicevic8";
        String actualName = howdyBar.getText();
        Assert.assertEquals(actualName, howdyName);

//        username.split("@", 0);
        Assert.assertTrue(howdyBar.getText().contains("nikolapribicevic8"));


//        driver.close();


    }
}
