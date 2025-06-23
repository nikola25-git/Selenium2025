package sedmica9.petak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Domaci_petak {

//    Testirati dodavanje knjige u korpu i da li se knjiga obrise kada obrisete kolacice.

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.navigate().to("https://www.amazon.com/dp/1788473574");
        driver.manage().window().maximize();

        WebElement continueShoppingButton = driver.findElement(By.cssSelector("button[type = 'submit']"));
        wait.until(ExpectedConditions.visibilityOf(continueShoppingButton));
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();

        WebElement contShopBtn = driver.findElement(By.cssSelector("button[type = 'submit'"));
        wait.until(ExpectedConditions.urlContains("errors/validateCaptcha"));
        wait.until(ExpectedConditions.visibilityOf(contShopBtn));
        contShopBtn.click();


        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();

        Cookie cookie = new Cookie("session-id", "130-6294637-8779616");
        driver.manage().deleteCookie(cookie);
        driver.navigate().refresh();

        WebElement emptyCart = driver.findElement(By.id("sc-empty-cart"));
        Assert.assertTrue(emptyCart.isDisplayed());

        WebElement emptCrt = driver.findElement(By.xpath
                ("/html/body/div[1]/div[1]/div[3]/div[4]/div/div[2]/div[1]/div/div/div[2]/h3"));
        Assert.assertTrue(emptCrt.isDisplayed());

        WebElement cartCount = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartCount.getText(), "0");

        driver.close();

    }
}

