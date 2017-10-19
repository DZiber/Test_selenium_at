import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BooksSite;
import pages.MainPage;

/**
 * Created by ZeBr on 26.09.2017.
 */
public class LearnJTest {

    WebDriver webDriver;
    BooksSite webSite;
    WebDriverWait wait;

    @Before
    public void setUp() {

        webDriver = new FirefoxDriver();
        wait = new WebDriverWait(webDriver, 30, 500);
        webSite = new BooksSite(webDriver);

        webDriver.get("http://it-ebooks.info/");

        System.out.println("Step 1 Enter text to search input");
        webSite.mainPage().enterSearchText("java");

        System.out.println("Step 2 Switch search type to title");
        webSite.mainPage().switchSearchToTitle();

        System.out.println("Step 3 Searching for text");
        webSite.mainPage().searchBtnClick();

        System.out.println("Step 4 Wait for search results");
        webSite.searchResultPage().WaitForSearchResult();
    }

    @Test
    public void testSearchBookUrl() {

        System.out.println("Check url");
        Assert.assertTrue(
                webDriver.getCurrentUrl()
                        .contains("search/?q=java&type=title"));

    }

    @Test
    public void testBookSearch() {

        System.out.println("Check search result");
        Assert.assertTrue(
                webDriver.findElement(By.className("top"))
                        .findElement(By.tagName("table"))
                        .findElements(By.tagName("tr"))
                        .size() == 10);


    }

    @Test
    public void openBookInfoFromResultsPage() {

        System.out.println("Open book info page from results page");
        webSite.searchResultPage().openBookPageBy("Java EE 6 Pocket Guide");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1[itemprop='name']")));
      /*  Assert.assertTrue(webDriver.findElement());
*/

    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}
