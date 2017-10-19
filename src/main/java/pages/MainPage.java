package pages;

import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ZeBr on 21.09.2017.
 */
public class MainPage {

    private WebDriver webDriver;

    @FindBy(css = "input[value='title']")
    WebElement titleRadioBtn;
    @FindBy(css = "input[type='submit']")
    WebElement searchBtn;
    @FindBy(id = "q")
    WebElement searchInput;

    public MainPage(WebDriver driver) {
        webDriver = driver;

        PageFactory.initElements(webDriver, this);
    }

    public void switchSearchToTitle() {
        titleRadioBtn.click();
    }

    public void searchBtnClick() {
        searchBtn.click();
    }

    public void enterSearchText(String text) {
        searchInput.clear();
        searchInput.sendKeys(text);
    }


}
