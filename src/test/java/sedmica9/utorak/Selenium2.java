package sedmica9.utorak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Selenium2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()"); // obrati paznju na tacnost script-a u Stringu,
        // posto nece prijaviti gresku ako nije dobro otkucana
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        driver.navigate().to("https://www.youtube.com"); //i dalje se izvrsava na prvom tabu

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        // ova komanda pravi jendu listu u koju automatski ubacuje prethodno otvorene tabove
        // ovo naravno mora da se radi nakon otvaranja tabova
        driver.switchTo().window(listaTabova.get(1)); // otvara u sledecem tabu
        //otvara se u prvom sledecem OTVORENOM tabu
        driver.navigate().to("https://www.google.com");

        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to("https://www.linkedin.com");

        driver.switchTo().window(listaTabova.get(3));
        driver.navigate().to("htttps://www.joberty.com");

        driver.close();
        driver.switchTo().window(listaTabova.get(2));
        driver.close();






    }
}
