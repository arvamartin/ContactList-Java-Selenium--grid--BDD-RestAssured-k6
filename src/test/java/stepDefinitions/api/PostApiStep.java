package stepDefinitions.api;

import framework.core.utils.JsonParser;
import framework.core.utils.RequestUtil;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import java.util.Map;

public class PostApiStep {


    @When("send new contact from {string} in {string} post request")
    public void sendNewContact(String fileName, String param) {
        Map<String, Object> reqBody = JsonParser.jsonReader(fileName);
        Map<String, Object> headers = RequestUtil.buildAuthHeaders();

        Response response = RequestUtil.sendRequest("post", param, headers, reqBody);
        System.setProperty("actualStatusCode", String.valueOf(response.getStatusCode()));
        System.out.println(response.jsonPath().getString("_id"));
    }
}
