package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static utilities.Tools.delay;
import static utilities.Tools.setTextSequencial;

public class MainFilmaffinity {
    WebDriver driver;

    @FindBy(linkText="Top Filmaffinity")
    WebElement topLink;

    @FindBy(css=".qc-cmp2-summary-buttons > button:nth-child(2)")
    WebElement acceptButton;

    @FindBy(id="top-search-input")
    WebElement inputSearch;

    @FindBy(id="button-search")
    WebElement buttonSearch;

    @FindBy(className = "eac-item")
    List<WebElement> itemsList;

    public void clickTopFilmaffinity() {
        try {
            topLink.click();
        } catch (Exception e){
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(topLink));
            topLink.click();
        }
    }

    public void setInputSearch(String text){
        setTextSequencial(inputSearch, text, 10);
    }

    public void clickOnFirstElement() {
        inputSearch.click();
        delay(2000);
        WebElement item = itemsList.get(0);
        item.click();
    }

    public void closeBanner() { acceptButton.click(); }

    public MainFilmaffinity(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
