package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by ZeBr on 03.10.2017.
 */
public class BooksSite {
    WebDriver webDriver;

    public BooksSite(WebDriver driver) {
        webDriver = driver;
    }

    public MainPage mainPage() {
        return new MainPage(webDriver);
    }

    public SearchResultPage searchResultPage() {
        return new SearchResultPage(webDriver);
    }
}
