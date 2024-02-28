package stepdefinitions;



import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class openwheather {
	    
   
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	@Then("Test retrieving the current weather for a specific city")
	public void test_retrieving_the_current_weather_for_a_specific_city() {
		String apiUrl = "https://api.openweathermap.org/data/2.5/weather";
	    String apiKey = "077231a6d3789e0a5f829f30c865794e";
	    String city = "Pune";
        Response response = RestAssured.given()
                .param("q", city)
                .param("appid", apiKey)
                .get(apiUrl);

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.asPrettyString().toString());
        
        Assert.assertEquals(200, response.getStatusCode());
        ApplicationHooks.scn.log("Retrived the current weather for a specific city");
    }

	@Then("Test retrieving the five day forecast for a specific city")
	public void test_retrieving_the_five_day_forecast_for_a_specific_city() {
		String apiUrl = "https://api.openweathermap.org/data/2.5/forecast";
        String apiKey = "077231a6d3789e0a5f829f30c865794e";
        String city = "Pune"; 
        Response response = RestAssured.given()
                .param("q", city)
                .param("appid", apiKey)
                .get(apiUrl);

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.asPrettyString().toString());
        Assert.assertEquals(200, response.getStatusCode());
        ApplicationHooks.scn.log("Retrived the five day forecast for a specific city");
    }
	

	@Then("Test the response when querying with an invalid city name")
	public void test_the_response_when_querying_with_an_invalid_city_name() {
		String apiUrl = "https://api.openweathermap.org/data/2.5/weather";
	    String apiKey = "077231a6d3789e0a5f829f30c865794e";
	    String city = "XYZ";
        Response response = RestAssured.given()
                .param("q", city)
                .param("appid", apiKey)
                .get(apiUrl);

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.asPrettyString().toString());
        Assert.assertEquals(404, response.getStatusCode());
        ApplicationHooks.scn.log("Get the response when querying with an invalid city name");
	    
	}

	@Then("Test the response when querying with an invalid API key")
	public void test_the_response_when_querying_with_an_invalid_api_key() {
	    
		String apiUrl = "https://api.openweathermap.org/data/2.5/weather";
	    String apiKey = "077231a6d3a5f829f30c865794e";
	    String city = "Pune";
        Response response = RestAssured.given()
                .param("q", city)
                .param("appid", apiKey)
                .get(apiUrl);

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.asPrettyString().toString());
        Assert.assertEquals(401, response.getStatusCode());
        ApplicationHooks.scn.log("Get the response when querying with an invalid API key");
	}
		
	

}
