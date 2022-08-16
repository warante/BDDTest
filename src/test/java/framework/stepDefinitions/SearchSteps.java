package framework.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import framework.pages.FilmPageFilmafinity;
import framework.pages.MainFilmaffinity;

public class SearchSteps {
    WebDriver driver;

    public SearchSteps() {
        this.driver = Hooks.getDriver();
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