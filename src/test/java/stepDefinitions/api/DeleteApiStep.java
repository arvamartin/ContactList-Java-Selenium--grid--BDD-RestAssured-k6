package stepDefinitions.api;

import framework.core.utils.RequestUtil;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.Map;

public class DeleteApiStep {

    @When("send DELETE request to {string}")
    public void deleteContacts(String param) {
        Map<String, Object> headers = RequestUtil.buildAuthHeaders();

        Response response = RequestUtil.sendRequest("delete", param, headers, null);
        System.setProperty("actualStatusCode", String.valueOf(response.getStatusCode()));
    }
}
