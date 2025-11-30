package stepDefinitions.api;

import framework.core.utils.ConfigReader;
import framework.core.utils.JsonParser;
import framework.core.utils.RequestUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static framework.core.utils.Constants.BASE_URI;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class GetApiStep {

    private RequestSpecification httpRequest;
    private Response response;
    private String authToken = null;
    private final String email = ConfigReader.getValue("user", "email");
    private final String password = ConfigReader.getValue("user", "password");


    @Given("get user's auth token")
    public void getUserSAuthToken() {
        Map<String, Object> body = new HashMap<>();
        body.put("email", email);
        body.put("password", password);

        Response loginResponse = RequestUtil.sendRequest("post",
                BASE_URI.getValue() + "/users/login",
                null,
                body);

        authToken = loginResponse.jsonPath().getString("token");
        System.setProperty("authToken", authToken);
    }


    @Given("hit the url with auth token")
    public void hitTheContactsGetUrl() {
        RestAssured.baseURI = BASE_URI.getValue();

        Map<String, Object> headers = RequestUtil.buildAuthHeaders();
        httpRequest = RestAssured.given().headers(headers);
    }

    @When("pass the {string} url in the request")
    public void passTheUrlOfProductsInTheRequest(String param) {
        response = httpRequest.get(param);
        response.body().prettyPrint();
        System.setProperty("actualStatusCode", String.valueOf(response.getStatusCode()));
    }


    @Then("receive the {int} response code")
    public void receiveTheResponseCode(int statusCode) {
        int actualStatusCode = Integer.parseInt(System.getProperty("actualStatusCode"));
        System.out.println(actualStatusCode);
        assertThat(actualStatusCode, is(statusCode));
    }


    @And("verify new contact from {string} appeared in GET response")
    public void verifyNewContactAppearedInGETResponse(String fileName) {
       boolean isContain = JsonParser.responseContainsSubset(fileName, response);
       assertThat(isContain, is(true));
    }
}
