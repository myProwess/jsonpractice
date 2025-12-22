package requests.jacksonrequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonPOJOExample {

    public static void main(String[] args) throws Exception {

        //https://samedesilva.medium.com/jackson-objectmapper-in-rest-assured-8511dd62c608
        // Set the Base URI
        RestAssured.baseURI = "https://reqres.in/api";

        // Create a User object
        UserRequest user = new UserRequest("morpheus", "leader");

        // Convert Java Object to JSON using Jackson ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonPayload = objectMapper.writeValueAsString(user);

        // Send POST request
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(jsonPayload)
                .post("/users");

        // Print response
        System.out.println("Response: " + response.asString());

        // Deserialize JSON response back to Java Object
        UserResponse userResponse = objectMapper.readValue(response.asString(), UserResponse.class);

        System.out.println("Deserialized Response - Name: " + userResponse.getName());
        System.out.println("Deserialized Response - Job: " + userResponse.getJob());
        System.out.println("Deserialized Response - ID: " + userResponse.getId());
        System.out.println("Deserialized Response - CreatedAt: " + userResponse.getCreatedAt());
    }
}