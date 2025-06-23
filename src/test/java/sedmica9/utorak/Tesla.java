package sedmica9.utorak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tesla {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://duckduckgo.com/"); // R A D I !!!


        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div/div/main/article/div[1]/div[1]/div[2]/div/header/div/section[2]/form/div/div/input"))
                .sendKeys("Wikipedia");
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div/div/main/article/div[1]/div[1]/div[2]/div/header/div/section[2]/form/div/div/input"))
                .sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[4]/div/div/div/div[2]/section[1]/ol/li[1]/article/div[3]/h2/a/span"))
                .click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/main/div[2]/form/fieldset/div/input"))
                .sendKeys("Nikola sedmica9.utorak.Tesla");
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/main/div[2]/form/fieldset/div/input"))
                .sendKeys(Keys.ENTER);

    }
}
