package stepDefinitions.api;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpdateApiStep {
    private final Logger logger = LogManager.getLogger(getClass());

    @When("update contact from {string} in {string} {string} request")
    public void updateContact(String fileName, String endpoint, String requestMethod) {
        try {
            Response response = ApiRequestHelper.sendAuthorizedRequest(requestMethod, endpoint, fileName);
            response.getBody().prettyPrint();
        } catch (Exception e) {
            logger.warn("error: {}", e.getMessage(), e);
        }
    }
}

