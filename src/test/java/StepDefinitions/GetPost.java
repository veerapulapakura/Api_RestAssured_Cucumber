package StepDefinitions;

import Utilities.RestAssuredExtentions;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.net.URISyntaxException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.Is.is;

public class GetPost {

    private  static ResponseOptions<Response> response;

   /* @Given("^i perform the GET operation of the \"([^\"]*)\"$")
    public void i_perform_the_GET_operation_of_the(String url) throws URISyntaxException {
        response= RestAssuredExtentions.GetOps(url);
    }*/

    @Given("^i perform the GET operation of the \"([^\"]*)\"$")
    public void i_perform_the_GET_operation_of_the(String url) throws Throwable {
        response= RestAssuredExtentions.GetOps(url);
    }

    @And("^I perform GET for the post number \"([^\"]*)\"$")
    public void iPerformGETForThePostNumber(String postNumber)  {
        BddStyleMethod.simpleGetPostMethodBDD("1");
    }

    @Then("^I should see the author name as \"([^\"]*)\"$")
    public void i_should_see_the_author_name_as(String arg1) throws Throwable {
        assertThat(response.getBody().jsonPath().get("author"), hasItem("typicode"));
    }

    @Then("^I should see the author names$")
    public void iShouldSeeTheAuthorNames() {
        BddStyleMethod.checkContainsCollection();
    }

    @Then("^I should see the correct GET value$")
    public void iShouldSeeTheCorrectGETValue() {
        BddStyleMethod.performGetWithPathParameter();
    }

    @Then("^I should see the correct GET value of that query parameter$")
    public void iShouldSeeTheCorrectGETValueOfThatQueryParameter() {
        BddStyleMethod.performGetWithQueryParameter();
    }

    @Given("^i perform the post operation of the \"([^\"]*)\"$")
    public void i_perform_the_Post_operation_of_the(String url) throws Throwable {
        BddStyleMethod.performPostithBodyParameter();
    }


    @Given("^i perform the post operation of the \"([^\"]*)\" with body$")
    public void iPerformThePostOperationOfTheWithBody(String url, DataTable dataTable) throws Throwable {
        var data  = dataTable.raw();
        // Setting Body
        HashMap<String, String> body = new HashMap<>();
        body.put("name", data.get(1).get(0));

        // Setting path parameter
        HashMap<String, String> pathParam = new HashMap<>();
        pathParam.put("profileNo", data.get(1).get(1));
        response =  RestAssuredExtentions.PostWithBodyAndPathParameter(url,pathParam,body);
    }

    @Then("^I should see the body has name as \"([^\"]*)\"$")
    public void iShouldSeeTheBodyHasNameAs(String name) throws Throwable {
        assertThat(response.getBody().jsonPath().get("name"), equalTo(name));
    }


}
