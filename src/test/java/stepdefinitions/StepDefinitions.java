package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class StepDefinitions {
    Response response;
    String apiKey;
    String apiUrl;

    @Given("load api key and base url")
    public void load_api_key_and_base_url() {
        Properties properties = new Properties();
        try {
            // Load the property file
            InputStream inputStream = StepDefinitions.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);
            inputStream.close();

            // Read properties
             apiKey = properties.getProperty("api.key");
             apiUrl = properties.getProperty("api.url");

             RestAssured.baseURI = apiUrl;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @When("I want to get weather details for location {string}")
    public void i_want_to_get_weather_details_for_location(String location) {
        response = RestAssured.given().log().all().contentType(ContentType.JSON).param("key", apiKey).param("q", location).get("/v1/current.json");

    }
    @Then("service should return response as {int}")
    public void service_should_return_response_as(Integer responseCode) {
        response.then().log().all().statusCode(responseCode);
    }

    @Then("service should return {string} as {string}")
    public void service_should_return_as(String path, String value) {
        JsonPath jsonpath = response.jsonPath();
        String valueFromResponse = jsonpath.get(path).toString();

        MatcherAssert.assertThat(valueFromResponse, Is.is(value));
    }

    @Then("the api response should match the weather response schema")
    public void the_api_response_should_match_the_weather_response_schema() {
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema.json"));
    }
}
