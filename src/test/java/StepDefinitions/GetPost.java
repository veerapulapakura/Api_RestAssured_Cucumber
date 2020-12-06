package StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.Is.is;

public class GetPost {

    @Given("^i perform the GET operation of the \"([^\"]*)\"$")
    public void iPerformTheGETOperationOfThe(String url) throws Throwable {

    }

    @And("^I perform GET for the post number \"([^\"]*)\"$")
    public void iPerformGETForThePostNumber(String postNumber) throws Throwable {
        BddStyleMethod.simpleGetPostMethodBDD("1");
    }

    @Then("^I should see the author name as \"([^\"]*)\"$")
    public void iShouldSeeTheAuthorNameAs(String arg0) throws Throwable {
    }

    @Then("^I should see the author names$")
    public void iShouldSeeTheAuthorNames() {
        BddStyleMethod.checkContainsCollection();
    }
}
