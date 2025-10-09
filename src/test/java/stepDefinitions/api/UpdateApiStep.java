package stepDefinitions.api;

import framework.core.utils.JsonParser;
import framework.core.utils.RequestUtil;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class UpdateApiStep {
    Logger logger = LogManager.getLogger(getClass());

    @When("update contact from {string} in {string} {string} request")
    public void updateFullContact(String fileName, String param, String request) {
        try {
            Map<String, Object> reqBody = JsonParser.jsonReader(fileName);
            Map<String, Object> headers = RequestUtil.buildAuthHeaders();

            Response response = RequestUtil.sendRequest(request, param, headers, reqBody);
            System.setProperty("actualStatusCode", String.valueOf(response.getStatusCode()));
            response.getBody().prettyPrint();

        } catch (Exception e) {
            logger.warn("error: {}", e.getMessage(), e);
        }
    }
}

