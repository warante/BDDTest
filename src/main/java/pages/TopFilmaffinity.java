package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TopFilmaffinity {
    WebDriver driver;

    @FindBy(id="top-movies")
    private WebElement listadoPeliculas;

    @FindBy(id="main-title")
    private WebElement pageTitle;

    List<WebElement> filas;

    public String getPelicula(String posicion) {
        filas = listadoPeliculas.findElements(By.tagName("ul"));
        return filas.get(Integer.parseInt(posicion)-1).getText();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public TopFilmaffinity(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
