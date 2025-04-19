package steps;


import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

public class APIStepDefinitions {
    private Response response;
    private RequestSpecification request = RestAssured.given();

    @Given("I send a GET request to {string}")
    public void i_send_a_get_request_to(String url) {
        response = request.get(url);
    }

    @Given("I send a POST request to {string} with body:")
    public void i_send_a_post_request_with_body(String url, String body) {
        response = request.header("Content-Type", "application/json")
                .body(body)
                .post(url);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int expectedStatusCode) {
        Assertions.assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("the response should contain {string}")
    public void the_response_should_contain(String expectedText) {
        Assertions.assertTrue(response.getBody().asString().contains(expectedText));
    }
}
