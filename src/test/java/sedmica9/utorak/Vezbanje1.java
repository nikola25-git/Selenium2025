package sedmica9.utorak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Zadatak 1
//Pokrenite browser, idite na Linkedin sajt, uradite refresh, idite na Joberty sajt
//vratite se nazad i odstampajte poslednji URL na kom se nalazite
//na kraju zatvorite driver

public class Vezbanje1 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.linkedin.com");
        driver.navigate().refresh();
        driver.navigate().to("https://www.joberty.com");
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        driver.close();
    }
}
