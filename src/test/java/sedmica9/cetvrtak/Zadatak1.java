package sedmica9.cetvrtak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Zadatak1 {

    //Zadatak 1
//Otici na Bing
//Zatim ukucati "Wikipedia" u polje za pretragu
//Odraditi pretragu i otvoriti stranicu
//Na stranici Wikipedia pretraziti "Nikola sedmica9.utorak.Tesla"

    //Raditi preko objekata!

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.bing.com");

        WebElement searchById = driver.findElement(By.id("sb_form_q"));
        WebElement searchByName = driver.findElement(By.name("q"));
        WebElement searchByClass = driver.findElement(By.className("sb_form_q"));
        WebElement searchByXPath = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/form/div[1]/div/textarea"));

        searchById.sendKeys("Wikipedia");
        Thread.sleep(1000);
        searchById.sendKeys(Keys.ENTER);

        WebElement wikiButtonSearchByLinkText = driver.findElement(By.linkText("Wikipedia"));
        wikiButtonSearchByLinkText.click();
        Thread.sleep(2000);

        List<String> tabovi = new ArrayList<>(driver.getWindowHandles());
        tabovi.add(tabovi.get(1));

        driver.switchTo().window(tabovi.get(1));

        WebElement wikiSearchBar = driver.findElement(By.id("searchInput"));
        driver.findElement(By.id("searchInput"));

        List<WebElement> wikiSearchBarList = new ArrayList<>();
        for (int i = 0; i < wikiSearchBarList.size(); i++) {
            if (wikiSearchBarList.get(i).getText().equals("Search Wikipedia")) {
                wikiSearchBarList.get(i).click();
                break;
            }
        }

        wikiSearchBar.sendKeys("Nikola sedmica9.utorak.Tesla");

//        Thread.sleep(2000);

//        List<WebElement> wikiSearchButtonIcon = new ArrayList<>(driver.findElements(By.linkText("search-input-button")));
//        for (int i = 0; i < wikiSearchButtonIcon.size(); i++) {
//            if (wikiSearchBarList.get(i).getText().equals("search-input-button"));
//            wikiSearchButtonIcon.get(i).click();
//            break;//
//        }

//        WebElement wikisearchButton;
//
//       WebElement wikiSearchButtonName = driver.findElement(By.cssSelector(".pure-button.pure-button-primary-progressive"));
        WebElement wikiSearchButtonName = driver.findElement(By.cssSelector("button[type='submit']"));
        wikiSearchButtonName.click();



    }

}
