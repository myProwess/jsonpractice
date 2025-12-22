package requests.jacksonrequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JsonListExample {

    public static void main(String[] args) throws IOException {

    }

    public static void JsonListofMap() throws  IOException{
        // Perfect for handling JSON arrays when you don’t want to create a POJO.
        //Works well when data structure varies dynamically.
        ObjectMapper objectMapper = new ObjectMapper();

        List<Map<String, Object>> users = Arrays.asList(
                Map.of("name", "morpheus", "job", "leader"),
                Map.of("name", "neo", "job", "the one")
        );

        // 🔹 Serialization: Convert List of Maps to JSON
        String jsonPayload = objectMapper.writeValueAsString(users);
        System.out.println("Serialized JSON from List:\n" + jsonPayload);

        System.out.println("\nDeserialization of List of Maps");
        String jsonResponse = "[{\"name\":\"morpheus\",\"job\":\"leader\"},{\"name\":\"neo\",\"job\":\"the one\"}]";

        // 🔹 Deserialization: Convert JSON string to List of Maps
        List<Map<String, Object>> userList = objectMapper.readValue(jsonResponse,
                new com.fasterxml.jackson.core.type.TypeReference<List<Map<String, Object>>>() {});

        System.out.println("First User Name: " + userList.get(0).get("name"));  // morpheus
        System.out.println("Second User Job: " + userList.get(1).get("job"));   // the one
    }

    public static void javaArraytoStringExample() throws  IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        // Java array
        String[] names = {"morpheus", "neo", "trinity"};

        // 🔹 Serialization: Convert Java array to JSON string
        String jsonArray = objectMapper.writeValueAsString(names);

        System.out.println("Serialized JSON from Array: " + jsonArray);
    }

    public static void javaStringToJsonExample () throws  IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        // Java string
        String text = "Hello, World!";

        // 🔹 Serialization: Convert Java string to JSON string
        String jsonString = objectMapper.writeValueAsString(text);

        System.out.println("Serialized JSON String: " + jsonString);
    }

    public static void jsonStringToJavaStringExample () throws  IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        // JSON string
        String jsonString = "\"Hello, World!\"";  // Notice the double quotes

        // 🔹 Deserialization: Convert JSON string to Java string
        String text = objectMapper.readValue(jsonString, String.class);

        System.out.println("Deserialized Java String: " + text);
    }

}


