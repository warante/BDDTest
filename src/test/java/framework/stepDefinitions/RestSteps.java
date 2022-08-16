package framework.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestSteps {
    private Response response;

    @Given("user set api URI {string}")
    public void userSetApiURI(String uri) {
        RestAssured.baseURI = uri;
    }

    @When("user set path {string} service and page {string}")
    public void user_set_path_service_and_page(String path, String page) {
         response = given().param("page", page)
                .get(path);
    }

    @Then("user expects response code {string}")
    public void user_expects_response_code(String code) {
        response.then()
                .statusCode(Integer.parseInt(code));
    }

    @When("user set path {string} episode number {string}")
    public void userSetPathEpisodeNumber(String path, String number) {
        response = given()
                .get(path + '/' +number);
    }

    @And("episode name {string}")
    public void episodeName(String name) {
        response.then()
                .body("name", equalTo(name));
    }

    @And("episode season {string}")
    public void episodeSeason(String season) {
        response.then()
                .body("episode", equalTo(season));
    }
}
