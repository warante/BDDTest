package stepsImplementations;

import com.google.common.io.Files;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.FilmPageFilmafinity;
import pages.MainFilmaffinity;
import pages.TopFilmaffinity;

import java.io.File;
import java.io.IOException;


public class BDDGenericTests {
    WebDriver driver;
    private String url = "https://www.filmaffinity.com/es";
    private String pageTitle = "Top FilmAffinity";

    @Given("user is in filmaffinity")
    public void userIsInFilmaffinity() {
        driver.get(url);
        MainFilmaffinity mainFilmaffinity = new MainFilmaffinity(driver);
        mainFilmaffinity.closeBanner();
    }

    @When("user click on top button")
    public void userClickOnTopButton() {
        MainFilmaffinity mainFilmaffinity = new MainFilmaffinity(driver);
        mainFilmaffinity.clickTopFilmaffinity();
    }

    @Then("verify position {string}, name {string}, director {string}, point {string}")
    public void verifyPositionNameDirectorPoint(String posicion, String nombre, String director, String nota) {
        TopFilmaffinity topFilmaffinity = new TopFilmaffinity(driver);
        String pelicula = topFilmaffinity.getPelicula(posicion);

        System.out.println("nombre película: " + pelicula);
        Assert.assertTrue(pelicula.contains(nombre) && pelicula.contains(director) && pelicula.contains(nota.replace('.', ',')));
        // driver.quit();
    }

    @Then("verify header tittle")
    public void verifyHeaderTittle() {
        TopFilmaffinity topFilmaffinity = new TopFilmaffinity(driver);
        Assert.assertEquals(topFilmaffinity.getPageTitle(), pageTitle);
        // driver.quit();
    }


    @Before
    public void setUp(){
        String browser = "chrome"; //chrome | firefox
        Boolean options = false;
        driver = utilities.DriverFactory.setDriver(browser, options);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);

            try{
                Files.move(screenshot, new File("resources/screenshots/" + scenario.getName() + "-" + scenario.getLines() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        driver.quit();
    }

    @When("user type the film name {string}")
    public void userTypeTheFilmName(String text) {
        MainFilmaffinity mainFilmaffinity = new MainFilmaffinity(driver);
        mainFilmaffinity.setInputSearch(text);
    }

    @Then("verify title is {string}")
    public void verifyTitleIs(String title) {
        FilmPageFilmafinity filmPageFilmafinity = new FilmPageFilmafinity(driver);
        Assert.assertEquals(filmPageFilmafinity.getFilmTitle(), title);
    }

    @And("click on first element")
    public void clickOnFirstElement() {
        MainFilmaffinity mainFilmaffinity = new MainFilmaffinity(driver);
        mainFilmaffinity.clickOnFirstElement();
    }
}

