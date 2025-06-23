package sedmica9.petak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Selenium7 {

    public static void main(String[] args) throws InterruptedException {

        // Sleepers - ceka toliko vremena koliko zadamo dok program ne nastavi sa radom
        // Implicit wait - ceka odredjeno vreme da se pojavi element
        // odnosno, ceka se odredjeno vreme dok se ne dobije greska "NoSuchElementException"
        // Implicit wait sluzi samo za ovu vrstu greske
        // Explicit wait - ceka dok se ne ispuni odredjeni uslov

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Za implicit wait je potrebno samo jednom na pocetku da napisemo ovu liniju koda
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // na kraju dodajemo vreme koliko ce program najvise da ceka da se element pojavi dok nam ne vrati gresku

        // Da bismo koristili Explicit wait moramo prvo da napravimo objekat za cekanje
        // Tom objektu takodje dodeljujemo vreme koliko ce najduze da se ceka da se uslov ispuni
        // Ako se uslov ne ispuni za dato vreme onda ce program da vrati gresku
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.navigate().to("https://practicetestautomation.com/");

        // Sleep ce uvek prvi put davati gresku jer nije dodat Exception na metodu
        // Potrebno je samo da kliknete na sleep i zatim na 'Add exception'
        // Klik na 'sleep' -> Alt + Enter -> klik na 'Add exception'
        Thread.sleep(3000);

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username"))));

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        String usernameCredentials = "student";
        String passwordCredentials = "Password123";

        usernameField.clear();
        usernameField.sendKeys(usernameCredentials);
        passwordField.clear();
        passwordField.sendKeys(passwordCredentials);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // U slucaju kada imamo cekanje da se URL promeni, ovo moze takodje biti deo testa
        // i asertacija linka moze biti suvisna
        // jer ako se URL ne promeni na ovaj zadati, onda ce test pasti na tom koraku
        wait.until(ExpectedConditions.urlToBe("https://practicetestautomation.com/logged-in-successfully/"));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Log out"))));

        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement loginTitle = driver.findElement(By.className("post-title"));
        Assert.assertTrue(loginTitle.isDisplayed());

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButton.isDisplayed());

        WebElement userTitle = driver.findElement(By.className("has-text-align-center"));
        String expectedUserTitle = "Congratulations " +usernameCredentials+ ". You successfully logged in!";
        Assert.assertEquals(userTitle.getText(), expectedUserTitle);



    }
}
