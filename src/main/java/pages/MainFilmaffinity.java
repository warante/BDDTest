package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainFilmaffinity {
    WebDriver driver;

    @FindBy(linkText="Top Filmaffinity")
    WebElement topLink;

    @FindBy(css=".qc-cmp2-summary-buttons > button:nth-child(2)")
    WebElement acceptButton;

    public void clickTopFilmaffinity() {
        try {
            topLink.click();
        } catch (Exception e){
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(topLink));
            topLink.click();
        }
    }

    public void clickAcceptButton() { acceptButton.click(); }

    public MainFilmaffinity(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
