package requests;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonSimpleWriter {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        obj.put("name", "Pankaj Kumar");
        obj.put("age", 32);

        JSONObject obj1 = new JSONObject();
        obj1.put("name", "Ganesh Kumar");
        obj1.put("age", 25);

        JSONArray cities = new JSONArray();
        cities.add("New York");
        cities.add("Bangalore");
        cities.add("San Francisco");

        obj.put("cities", cities);
        obj.put("newObj",obj1);

        try {
            FileWriter file = new FileWriter("data.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(obj.toJSONString());
    }

}