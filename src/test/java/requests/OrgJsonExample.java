package requests;

import org.json.JSONArray;
import org.json.JSONObject;

public class OrgJsonExample {

    public static void main(String[] args) {
        // 1. Create a JSONObject
        JSONObject person = new JSONObject();
        person.put("name", "Alice");
        person.put("age", 30);
        person.put("isStudent", false);

        // 2. Create a JSONArray
        JSONArray hobbies = new JSONArray();
        hobbies.put("reading");
        hobbies.put("hiking");
        hobbies.put("coding");

        // Add the JSONArray to the JSONObject
        person.put("hobbies", hobbies);

        // Create a nested JSONObject
        JSONObject address = new JSONObject();
        address.put("street", "123 Main St");
        address.put("city", "Anytown");
        person.put("address", address);

        // Print the JSON object
        System.out.println("Created JSON Object:\n" + person.toString(2)); // Indented output

        // 3. Parse a JSON String
        String jsonString = "{\"product\":\"Laptop\",\"price\":1200.00,\"features\":[\"SSD\",\"8GB RAM\"]}";
        JSONObject product = new JSONObject(jsonString);

        // 4. Accessing values
        String productName = product.getString("product");
        double productPrice = product.getDouble("price");
        JSONArray productFeatures = product.getJSONArray("features");

        System.out.println("\nParsed JSON Values:");
        System.out.println("Product Name: " + productName);
        System.out.println("Product Price: " + productPrice);
        System.out.println("First Feature: " + productFeatures.getString(0));

        // 5. Modifying values
        person.put("age", 31);
        System.out.println("\nModified JSON Object:\n" + person.toString(2));
    }



}
