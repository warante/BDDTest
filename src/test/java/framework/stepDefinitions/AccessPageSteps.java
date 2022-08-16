package framework.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import framework.pages.MainFilmaffinity;

public class AccessPageSteps {
    WebDriver driver;
    private String url = "https://www.filmaffinity.com/";

    public AccessPageSteps() {
        this.driver = Hooks.getDriver();
    }

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
}