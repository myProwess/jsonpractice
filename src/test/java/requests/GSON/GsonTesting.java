package requests.GSON;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class GsonTesting {
    public static void main(String[] args) {
        GsonTesting.GsonJsonToObjectExample();
        //GsonTesting.GsonObjectToJSONExample();
    }

    public static void GsonObjectToJSONExample(){
        Gson gson = new Gson();

        Map<String, Object> javaObject = new HashMap<>();

        javaObject.put("aNumber", 1);
        javaObject.put("aString", "foo");
        javaObject.put("aBoolean", true);
        javaObject.put("aList", Arrays.asList("red", "green", "blue"));

        String jsonString = gson.toJson(javaObject);
        System.out.println(jsonString);
    }

    public static  void GsonJsonToObjectExample(){
        Gson gson = new Gson();

        String jsonString = "{\"aNumber\":1,\"aBoolean\":true,\"aString\":\"foo\",\"aList\":[\"red\",\"green\",\"blue\"]}";

        String jsonString1 = "{'employee.name':'Bob','employee.salary':10000}";

        Map javaObject = gson.fromJson(jsonString1, Map.class);

        System.out.println("aList: " + javaObject.get("aList"));
        System.out.println("aNumber: " + javaObject.get("aNumber"));
    }



}
