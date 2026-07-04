package stepDefinitions.api;

import framework.core.utils.RequestUtil;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import static framework.core.utils.Constants.BASE_URI;
import static framework.core.utils.Constants.CONTACTS_PARAM;


public class PurgeStep {
    private List<String> contactIds;
    private Map<String, Object> headers;
    private final Logger logger = LogManager.getLogger(getClass());


    @When("get the ID of all the contacts")
    public void getIdOfContacts() {
        RestAssured.baseURI = BASE_URI.getValue();
        headers = RequestUtil.buildAuthHeaders();

        Response response = RestAssured.given()
                .headers(headers)
                .get(CONTACTS_PARAM.getValue());

        contactIds = response.jsonPath().getList("_id");
        System.out.println(contactIds);
    }

    @When("delete the whole contact list")
    public void deleteWholeContactList() {
        if (contactIds == null || contactIds.isEmpty()) {
            logger.info("No contacts to delete.");
            return;
        }

        for (String id : contactIds) {
            try {
                Response deleteResponse = RequestUtil.sendRequest("delete", CONTACTS_PARAM.getValue() + id, headers, null);
                System.setProperty("actualStatusCode", String.valueOf(deleteResponse.getStatusCode()));
            } catch (Exception e) {
                logger.warn("Error occurred while deleting contact with ID {}: {}", id, e.getMessage(), e);
            }
        }
    }
}
