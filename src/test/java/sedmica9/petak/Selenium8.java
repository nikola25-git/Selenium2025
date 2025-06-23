package sedmica9.petak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Selenium8 {

    public static void main(String[] args) throws InterruptedException {

        // WAITER-i

        // Sleepers
        // Implicit wait - pokusavace na pola sekunde, odredjeno vreme (koje preciziramo),
        // nakon kojeg ce vratiti gresku ukoliko ne pronadje element u zadatom roku
        // Explicit wait - cekace (odredjeno vreme) dok se odredjeni element ne pojavi

//        Thread.sleep(3000);

        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));



        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.manage().window().maximize();

        driver.navigate().to("https://practicetestautomation.com/");

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLoginPage = driver.findElement(By.linkText("Test Login Page"));
        testLoginPage.click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[id = 'username']"))));


        WebElement usernameField = driver.findElement(By.cssSelector("input[id = 'username']"));
        usernameField.sendKeys("student");

        WebElement passwordField = driver.findElement(By.cssSelector("input[id = 'password']"));
        passwordField.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        wait.until(ExpectedConditions.urlToBe("https://practicetestautomation.com/logged-in-successfully/"));
//        wait.until(ExpectedConditions.elementToBeClickable())

        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/"; // ovo je suvisno ako imamo
        // ovaj waiter iznad
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
