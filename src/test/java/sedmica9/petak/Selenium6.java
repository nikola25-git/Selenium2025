package sedmica9.petak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Selenium6 {

    public static void main(String[] args) {

        //Zadatak 5
//Na linku https://practicetestautomation.com/ otici do login stranice, uradite log in i dodajte asertacije

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        String usernameCredentials = "student";
        String passwordCredentials = "Password123";

        Assert.assertTrue(usernameField.isDisplayed());

//        driver.navigate().refresh();

//        Assert.assertTrue(usernameField.isDisplayed());


        usernameField.clear();
        usernameField.sendKeys(usernameCredentials);
        passwordField.clear();
        passwordField.sendKeys(passwordCredentials);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement loginTitle = driver.findElement(By.className("post-title"));
        Assert.assertTrue(loginTitle.isDisplayed());

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButton.isDisplayed());

        WebElement userTitle = driver.findElement(By.className("has-text-align-center"));
        String expectedUserTitle = "Congratulations " +usernameCredentials+ ". You successfully logged in!";
        Assert.assertEquals(userTitle.getText(), expectedUserTitle);

        // =======================

        logOutButton.click();

        Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);


        WebElement logOutButtonAfterLogout = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButtonAfterLogout.isDisplayed());

        // ========================

        boolean isPresent = false;
        try {
            isPresent = driver.findElement(By.linkText("Lout out")).isDisplayed();

        } catch(Exception e) {

        }

        Assert.assertFalse(isPresent);

    }
}
