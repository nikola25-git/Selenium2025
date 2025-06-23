package sedmica9.utorak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Vezbanje3 {
    //Zadatak 3
//Otici na Bing
//Zatim ukucati "Wikipedia" u polje za pretragu
//Odraditi pretragu i otvoriti stranicu
//Na stranici Wikipedia pretraziti "Nikola sedmica9.utorak.Tesla"

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://bing.com/"); // NE RADI!




        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[2]/form/div[1]/div/textarea"))
                .sendKeys("Wikipedia");
        Thread.sleep(5000);
        driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div[2]/form/div[1]/div/textarea"))
                .sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[4]/main/div[2]/ol[1]/li/div[1]/div[1]/div/div[5]/div/div/div[1]/div[1]/h2/a"))
                .click();
        List<String> tabovi = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabovi.get(1));
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/main/div[2]/form/fieldset/div/input"))
                .sendKeys("Nikola sedmica9.utorak.Tesla");
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/main/div[2]/form/fieldset/div/input"))
                .sendKeys(Keys.ENTER);

    }

}
