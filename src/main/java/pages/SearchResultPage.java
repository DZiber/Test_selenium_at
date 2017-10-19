package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by ZeBr on 03.10.2017.
 */
public class SearchResultPage {

    private WebDriver webDriver;
    private WebDriverWait wait;


    public SearchResultPage(WebDriver driver) {
        webDriver = driver;
        wait = new WebDriverWait(webDriver, 30, 500);

        PageFactory.initElements(webDriver, this);
    }

    public void WaitForSearchResult() {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("top")));
    }

    public void openBookPageBy(String bookTitle) {

        List<WebElement> books = webDriver.findElement(By.className("top"))
                .findElement(By.tagName("table"))
                .findElements(By.tagName("tr"));

        for (WebElement book : books) {
            WebElement bookLink = book.findElement(By.tagName("a"));
            if (bookLink.getAttribute("title").contains(bookTitle)) {
                bookLink.click();
                break;
            }
        }

    }

}
