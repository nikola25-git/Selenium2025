package sedmica9.cetvrtak;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Selenium4 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.bing.com");


        // Lokator / Selektori
        WebElement searchByID =  driver.findElement(By.id("sb_form_q"));
        // Prvi po prioritetu i najcescde je jedinstven element
        WebElement searchByName = driver.findElement(By.name("q"));
        // Drugi po prioritetu, nije nuzno jedinstven element
        WebElement searchByClass = driver.findElement(By.className("sb_form_q"));
        // Treci po prioritetu, retko kada jedinstven element
        WebElement searchByRelativeXPath = driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));
        // Relativni xpath je nestablian jer program trazi element koji se zavrsava sa datim stringom
        WebElement searchByFullXPath = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[2]/form/div[1]/div/textarea"));
        // Apsolutni xpath je nestabilan jer program trazi element pocevsi od pocetka html-a

        // -------------------------

        WebElement wikipediaButtonByLinkText = driver.findElement(By.linkText("Wikipedia"));
        // Retko koriscen lokator zbog slabe pojave unutar html-a
        // Da bi se element mogao pronaci kroz link text, taj element mora u sebi sadrzati <a href
        // i obavezno u sebi sadrzi neki tekst.

        WebElement wikipediaButtonByClassCss = driver.findElement(By.className(""));
        // Ako imamo element koji u klasi ima vise vrednosti, tj. tokena (postoji razmak),
        // onda taj element mozemo naci preko CSS selektora,
        // tako sto cemo umesto razmaka upisati tacku i staviti tacku na pocetku

        //<textarea id="sb_form_q" class="sb_form_q" name="q" type="search" inputmode="search" maxlength="2000" autocomplete="off" autofocus="" aria-autocomplete="both" placeholder="" aria-label="0 characters out of 2000" spellcheck="false" autocorrect="off" autocapitalize="none" rows="1" enterkeyhint="search" style="width: 843px;"></textarea>

        WebElement kakoSeKreiraCssSelektor = driver.findElement(By.cssSelector("tag[atribut = 'vrednost']"));
        WebElement searchByCss = driver.findElement(By.cssSelector("textarea[type = 'search']"));

        // Ako element nije jedinstven, mozemo napraviti listu elemenata,
        // i dati komandu koji element iz liste cemo da

        List<WebElement> wikipediaButtonList = driver.findElements(By.className("b_gwaBody"));
        wikipediaButtonList.get(1).click();

        // Ako hocemo da izvrsimo proveru nad elementima iz liste,
        // moramo to uraditi kroz petlju

        List<WebElement> wikipediaTitleList = driver.findElements(By.className("b_gwaBody"));
        for (int i = 0; i < wikipediaTitleList.size(); i++) {
            if (wikipediaTitleList.get(i).getText().equals("Wikipedia, the free encyclopedia"));
            wikipediaButtonList.get(i).click();
            break;
        }

        // Pronalazenje elementa preko njegovog parent-a

        // <div class="search-input" id="search-input">
            // <label for="searchInput" class="screen-reader-text" data-jsl10n="portal.search-input-label">Search Wikipedia</label>
        
        // Hocemo da pronadjemo child element preko parent elementa
        // tako sto prvo pronadjemo parent i onda radimo findElement sa tim elementom
        WebElement parent = driver.findElement(By.id("search-input"));
        WebElement child = parent.findElement(By.className("screen-reader-text"));
    }
}
