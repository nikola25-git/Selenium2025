package sedmica9.utorak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Vezbanje2 {

    //Zadatak 2
//Otvoriti browser i jos 5 tabova
//Na svakom tabu otvoriti URL po zelji
//Zatvoriti sve tabove osim onog gde je otvoren Google

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        ArrayList<String> tabovi = new ArrayList<>(driver.getWindowHandles());


        driver.switchTo().window(tabovi.get(1));
        driver.navigate().to("https://www.youtube.com/");

        driver.switchTo().window(tabovi.get(2));
        driver.navigate().to("https://www.linkedin.com/");

        driver.switchTo().window(tabovi.get(3));
        driver.navigate().to("https://www.lichess.org/");

        driver.switchTo().window(tabovi.get(4));
        driver.navigate().to("https://www.helloworld.rs/");

        driver.switchTo().window(tabovi.get(5));
        driver.navigate().to("https://www.google.com/");


//        driver.switchTo().window(tabovi.get(4));
//        driver.close();
//        driver.switchTo().window(tabovi.get(3));
//        driver.close();
//        driver.switchTo().window(tabovi.get(2));
//        driver.close();
//        driver.switchTo().window(tabovi.get(1));
//        driver.close();

        for (int i = 0; i < tabovi.size(); i++) {
            driver.switchTo().window(tabovi.get(i));
            if (!driver.getCurrentUrl().equals("https://www.google.com/")) {
                driver.close();
            }
        }




    }
}
