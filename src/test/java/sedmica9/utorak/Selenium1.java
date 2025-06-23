package sedmica9.utorak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        // U ovoj komandi postavljam driver
        WebDriver driver = new ChromeDriver();
        // U ovoj komandi kreiram objekat sa kojim cu raditi kome dajem komande

//        driver.get("https://www.google.com"); //pokusava da otvori stranicu bez obzira na odziv
            //Jedan nacin da odemo na odredjenu stranicu je da koristimo .get()
       driver.manage().window().maximize(); // otvara browser u full screen-u
        driver.navigate().to("https://www.google.com"); //ceka da se stranica najpre otvori, tj. proverava da li je responsive
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://youtube.com");
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        System.out.println(driver.getCurrentUrl());

//        driver.close(); // zatvara trenutni tab na kom se nalazi
        driver.quit(); // zatvara ceo web browser - uglavnom ce se raditi u jednom tabu



    }
}
