package sedmica9.utorak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium3 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com");

        ///html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[1]/div[2]/textarea

        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[1]/div[2]/textarea"))
                .sendKeys("ITbootcamp");
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[1]/div[2]/textarea"))
                .sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[1]/div[2]/textarea"))
                .click();
    }
}
