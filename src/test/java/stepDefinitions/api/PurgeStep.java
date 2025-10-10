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
    private List<String> IDs;
    private Map<String, Object> headers;
    private Logger logger = LogManager.getLogger(getClass());


    @When("get the ID of all the contacts")
    public void getIDOfContacts() {
            RestAssured.baseURI = BASE_URI.getValue();
            headers = RequestUtil.buildAuthHeaders();

            Response response = RestAssured.given()
                    .headers(headers)
                    .get(CONTACTS_PARAM.getValue());

            IDs = response.jsonPath().getList("_id");
            System.out.println(IDs);
    }

    @When("delete the whole contact list")
    public void deleteWholeContactList() {
        if (IDs == null || IDs.isEmpty()) {
            logger.info("No contacts to delete.");
            return;
        }

        for (String id : IDs) {
            try {
                Response deleteResponse = RequestUtil.sendRequest("delete", CONTACTS_PARAM.getValue() + id, headers, null);
                System.setProperty("actualStatusCode", String.valueOf(deleteResponse.getStatusCode()));
            } catch (Exception e) {
                logger.warn("Error occurred while deleting contact with ID {}: {}", id, e.getMessage(), e);
            }
        }
    }
}
