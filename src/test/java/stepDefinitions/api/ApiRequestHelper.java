package stepDefinitions.api;

import framework.core.utils.JsonParser;
import framework.core.utils.RequestUtil;
import io.restassured.response.Response;

import java.util.Map;

final class ApiRequestHelper {

    private ApiRequestHelper() {
    }

    static Response sendAuthorizedRequest(String method, String endpoint) {
        return sendAuthorizedRequest(method, endpoint, null);
    }

    static Response sendAuthorizedRequest(String method, String endpoint, String bodyFileName) {
        Map<String, Object> body = bodyFileName == null ? null : JsonParser.jsonReader(bodyFileName);
        Map<String, Object> headers = RequestUtil.buildAuthHeaders();

        Response response = RequestUtil.sendRequest(method, endpoint, headers, body);
        System.setProperty("actualStatusCode", String.valueOf(response.getStatusCode()));
        return response;
    }
}
