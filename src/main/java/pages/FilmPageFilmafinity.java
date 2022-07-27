package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilmPageFilmafinity {
    WebDriver driver;

    @FindBy(id="main-title")
    WebElement filmTitle;

    public String getFilmTitle(){
        return filmTitle.getText();
    }

    public FilmPageFilmafinity(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
