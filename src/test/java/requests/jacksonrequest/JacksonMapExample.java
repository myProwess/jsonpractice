package requests.jacksonrequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JacksonMapExample {

    public static void main(String[] args) throws Exception {

//        JacksonMapExample.prettyPrint();
        JacksonMapExample.serialization();
        JacksonMapExample.deserialization();
    }


    public static void serialization() throws IOException {
        //No need to define a separate POJO class.
        //Useful when dealing with dynamic or unknown JSON structures.

        ObjectMapper objectMapper = new ObjectMapper();

        // Creating a Map instead of a POJO
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("name", "morpheus");
        userMap.put("job", "leader");

        // Serialization: Convert Map to JSON string
        String jsonPayload = objectMapper.writeValueAsString(userMap);
        System.out.println("Serialized JSON from Map: " + jsonPayload);

    }

    public static void deserialization() throws IOException {
        String jsonResponse = "{\"name\":\"morpheus\",\"job\":\"leader\"}";
        ObjectMapper objectMapper = new ObjectMapper();

        // Deserialization: Convert JSON string to Map
        Map<String, Object> userMap = objectMapper.readValue(jsonResponse,
                new com.fasterxml.jackson.core.type.TypeReference<Map<String, Object>>() {});

        System.out.println("Deserialization... ");
        System.out.println("Name: " + userMap.get("name"));  // morpheus
        System.out.println("Job: " + userMap.get("job"));  // leader
    }

    public  static void prettyPrint() throws IOException {
        String rawJson = "{\"name\":\"morpheus\",\"job\":\"leader\"}";
        ObjectMapper objectMapper = new ObjectMapper();

// 🔹 Deserialization: Convert JSON string to a generic Object
        Object jsonObject = objectMapper.readValue(rawJson, Object.class);

// 🔹 Serialization: Convert Object back to formatted JSON string
        String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);

        System.out.println("Pretty Printed JSON:\n" + prettyJson);
    }

}