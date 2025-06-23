package sedmica9.cetvrtak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Selenium5 {

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

        WebElement wikiSearchButtonName = driver.findElement(By.cssSelector("button[type='submit']"));
        wikiSearchButtonName.click();


        // ================================================


        String expectedURL = "https://en.wikipedia.org/wiki/Nikola_Tesla";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL);

        WebElement pageTitle = driver.findElement(By.id("firstHeading"));
//        System.out.println("TITLE JE: " + pageTitle.getText());

        Assert.assertEquals(pageTitle.getText(), "Nikola sedmica9.utorak.Tesla");
        // Ovde je bitno dodati .getText() pri poredjenju,
        // inace ce porediti web element sa tekstom, umesto tekst sa tekstom

        WebElement pageImage = driver.findElement(By.className("infobox-image"));
        Assert.assertTrue(pageImage.isDisplayed());
        // Ovde se uvek mora dodati .isDisplayed prilikom provere postojanja slike na stranici


        driver.quit();



    }
}
