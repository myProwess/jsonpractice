package requests.GSON;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class GSON_JSON_Parser {

    public static void main(String[] args) {
        String jsonString = "{\"name\":\"Alice\", \"age\":30, \"city\":\"New York\"}";

        // 1. Use JsonParser to parse the string into a generic JsonElement
        JsonElement jsonElement = JsonParser.parseString(jsonString);

        // 2. Check if the element is a JsonObject and cast it
        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            // 3. Access data using the JsonObject's get() method
            JsonElement nameElement = jsonObject.get("name");

            // 4. Extract the value as a specific primitive type
            if (nameElement != null && nameElement.isJsonPrimitive()) {
                String name = nameElement.getAsString();
                int age = jsonObject.get("age").getAsInt(); // Direct extraction

                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }
        }
    }
}