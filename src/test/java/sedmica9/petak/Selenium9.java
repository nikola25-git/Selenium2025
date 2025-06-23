package sedmica9.petak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Selenium9 {

    public static void main(String[] args) {


        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.navigate().to("https://wordpress.com/");

        Cookie cookie = new Cookie("wordpress_logged_in",
                "nikolapribicevic8%7C1845055441%7CfeszCEmG1Hl9L3Rl7EMnh0xCN3bpDojwILb0AvdyBTQ%7C7d5138eb1c793f286e008bdec1d53e8695a9217678572a79adc29adfc0b99b2d");

        driver.manage().addCookie(cookie);

        driver.navigate().refresh();

        // Logovanje preko kolacica ne radimo kao poseban test,
        // jer se korisnici nece logovati na taj nacin.
        // Mozemo se logovati preko kolacica da bismo ustedeli vreme koje je potrebno za logovanje,
        // kada zelimo nesto dalje da radimo na aplikaciji; npr. u ovom slucaju zelimo da testiramo promenu username-a.

        // Takodje moze da sluzi i kao 'workaround' kad postoji problem kod logovanja,
        // gde neki deo aplikacije ne radi, i da ne bismo ostali blokirani, mozemo se logovati na ovaj nacin.

        // U dogovoru sa developerima moze se na test okruzenjima podesiti veca duzina trajanja sesije,
        // i ova vrednost kolacica bi mogla da bude aktivna mnogo duze, pod uslovom da se ne izlogujete rucno,
        // jer bi to poslalo zahtev da se ponisti vrednost kolacica.


        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }
}
