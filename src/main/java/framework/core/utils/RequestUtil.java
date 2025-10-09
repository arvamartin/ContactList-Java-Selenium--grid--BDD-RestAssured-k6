package framework.core.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.HashMap;
import java.util.Map;

import static framework.core.utils.Constants.BASE_URI;

public class RequestUtil {

    private static Logger logger = (Logger) LogManager.getLogger(RequestUtil.class);

    public static Response sendRequest(String method, String param, Map<String, Object> headers, Map<String, Object> reqBody) {
        RestAssured.baseURI = BASE_URI.getValue();

        try {
            RequestSpecification httpRequest = RestAssured.given()
                    .contentType("application/json");

            if (reqBody != null) {
                httpRequest.body(reqBody);
            }

            if (headers != null) {
                httpRequest.headers(headers);
            }
            Response response = switch (method.toLowerCase()) {
                case "put" -> httpRequest.put(param);
                case "patch" -> httpRequest.patch(param);
                case "post" -> httpRequest.post(param);
                case "delete" -> httpRequest.delete(param);
                default -> throw new IllegalArgumentException("Unsupported method: " + method);
            };
            System.setProperty("actualStatusCode", String.valueOf(response.getStatusCode()));
            return response;
        } catch (Exception e) {
            logger.warn("HTTP request failed: {}", e.getMessage(), e);
            return null;
        }
    }


    public static Map<String, Object> buildAuthHeaders() {
        Map<String, Object> headers = new HashMap<>();
        try {
            String authToken = System.getProperty("authToken");
            if (authToken == null || authToken.isEmpty()) {
                logger.warn("AuthToken issue in header, token is null || empty");
                throw new IllegalStateException("Authentication token is missing or empty.");
            }
            headers.put("Authorization", "Bearer " + authToken);
        } catch (Exception e) {
            logger.warn("Error while building authorization headers:" + e.getMessage());
            throw new RuntimeException("Failed to build authorization headers.", e);
        }
        return headers;
    }
}
