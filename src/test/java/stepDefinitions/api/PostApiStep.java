package stepDefinitions.api;

import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class PostApiStep {


    @When("send new contact from {string} in {string} post request")
    public void sendNewContact(String fileName, String endpoint) {
        Response response = ApiRequestHelper.sendAuthorizedRequest("post", endpoint, fileName);
        System.out.println(response.jsonPath().getString("_id"));
    }
}
