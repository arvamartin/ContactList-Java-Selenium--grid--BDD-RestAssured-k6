package stepDefinitions.api;

import io.cucumber.java.en.When;

public class DeleteApiStep {

    @When("send DELETE request to {string}")
    public void sendDeleteRequest(String endpoint) {
        ApiRequestHelper.sendAuthorizedRequest("delete", endpoint);
    }
}
