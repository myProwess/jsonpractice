package requests;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonExamples {

    public static void main(String[] args) {
        jsonExamples.test1();
        jsonExamples.test2();
    }

    public static void test1(){
        String jsonString = "{\"name\":\"Alice\",\"age\":28,\"city\":\"New York\"}";
        JSONParser parser = new JSONParser();

        try {
            JSONObject parsedObject = (JSONObject) parser.parse(jsonString);
            System.out.println("Name: " + parsedObject.get("name"));
            System.out.println("Age: " + parsedObject.get("age"));
            System.out.println("City: " + parsedObject.get("city"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void test2(){

        JSONObject person = new JSONObject();
        person.put("firstName", "Jane");
        person.put("lastName", "Smith");
        person.put("age", 25);

        JSONObject address = new JSONObject();
        address.put("street", "123 Main St");
        address.put("city", "Anytown");
        address.put("zipCode", "12345");
        person.put("address", address);

        JSONArray hobbies = new JSONArray();
        hobbies.add("reading");
        hobbies.add("hiking");
        hobbies.add("cooking");
        person.put("hobbies", hobbies);

        System.out.println(person.toJSONString());

    }
}
