package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.Constants;
import resources.PayLoad;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StepDefinition {

    RequestSpecification httpRequest;

    Response response;

    String responseBody;

    @Given("AddPost Payload")
    public void add_post_payload() {
        RestAssured.baseURI = Constants.BASE_URI;
        httpRequest=RestAssured.given();
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(PayLoad.addUser(11,"Stephan Butler"));
    }

    @Given("postID Payload")
    public void post_id_payload() {
        RestAssured.baseURI=Constants.BASE_URI;
        httpRequest = RestAssured.given();
    }

    @When("User calls {string} with {string} httprequest")
    public void user_calls_with_httprequest(String resource, String method) {

        APIResources resourceAPI = APIResources.valueOf(resource);
        if(method.equalsIgnoreCase("post")) {
            response = httpRequest.request(Method.POST, resourceAPI.getResource());
        } else if(method.equalsIgnoreCase("get")) {
            response = httpRequest.request(Method.GET, resourceAPI.getResource());
        } else if(method.equalsIgnoreCase("delete")) {
            response = httpRequest.request(Method.DELETE, resourceAPI.getResource());
        }
        responseBody = response.getBody().asString();
    }

    @Then("the API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(Integer int1) {
        Integer code = response.getStatusCode();
        assertEquals(code,int1);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectedValue) {
        String status=response.getStatusLine();
        assertEquals(status,expectedValue);
    }

    @Then("number of comments returned is {int}")
    public void number_of_comments_returned_is(Integer size) {
        List li =  response.jsonPath().getList("id");
        Integer commentsNumber = li.size();
        assertEquals(commentsNumber,size);
    }
}
