package framework.stepDefinitions;

import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import framework.pages.TopFilmaffinity;

public class RankingSteps {
    WebDriver driver;
    private String pageTitle = "Top FilmAffinity";

    public RankingSteps() { this.driver = Hooks.getDriver();    }

    @Then("verify position {string}, name {string}, director {string}, point {string}")
    public void verifyPositionNameDirectorPoint(String posicion, String nombre, String director, String nota) {
        TopFilmaffinity topFilmaffinity = new TopFilmaffinity(driver);
        String pelicula = topFilmaffinity.getPelicula(posicion);
        Assert.assertTrue(pelicula.contains(nombre) && pelicula.contains(director) && pelicula.contains(nota.replace('.', ',')));
    }

    @Then("verify header tittle")
    public void verifyHeaderTittle() {
        TopFilmaffinity topFilmaffinity = new TopFilmaffinity(driver);
        Assert.assertEquals(topFilmaffinity.getPageTitle(), pageTitle);
    }
}