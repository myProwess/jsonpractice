package requests.org.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class OrgJsonDemo {
    public static void main(String[] args) {
        try {
            // ===== 1. Creating JSONObject =====
            JSONObject student = new JSONObject();
            student.put("id", 101);
            student.put("name", "Alice");
            student.put("course", "Java");
            student.put("active", true);

            System.out.println("JSONObject: " + student);

            // ===== 2. Creating JSONArray =====
            JSONArray studentsArray = new JSONArray();
            studentsArray.put(student);
            studentsArray.put(new JSONObject().put("id", 102).put("name", "Bob").put("course", "Python"));

            System.out.println("JSONArray: " + studentsArray);

            // ===== 3. Parsing JSON String =====
            String jsonString = "{\"id\":200,\"name\":\"Charlie\",\"course\":\"C++\"}";
            JSONObject parsedObj = new JSONObject(jsonString);
            System.out.println("Parsed JSONObject: " + parsedObj);

            // ===== 4. Accessing Values =====
            int id = parsedObj.getInt("id");
            String name = parsedObj.getString("name");
            String course = parsedObj.optString("course", "Unknown"); // safe access
            System.out.println("Accessed Values: id=" + id + ", name=" + name + ", course=" + course);

            // ===== 5. Updating Values =====
            parsedObj.put("course", "Advanced C++");
            System.out.println("Updated JSONObject: " + parsedObj);

            // ===== 6. Removing Keys =====
            parsedObj.remove("course");
            System.out.println("After remove: " + parsedObj);

            // ===== 7. Converting Map to JSONObject =====
            Map<String, Object> map = new HashMap<>();
            map.put("language", "JavaScript");
            map.put("version", 2025);
            JSONObject mapObj = new JSONObject(map);
            System.out.println("Map to JSONObject: " + mapObj);

            // ===== 8. Converting JSONObject to String =====
            String jsonOutput = student.toString(); // compact
            String prettyJson = student.toString(4); // pretty print with indentation
            System.out.println("Compact JSON: " + jsonOutput);
            System.out.println("Pretty JSON:\n" + prettyJson);

            // ===== 9. Nested JSON Objects =====
            JSONObject address = new JSONObject();
            address.put("city", "Chennai");
            address.put("zip", "600119");
            student.put("address", address);
            System.out.println("Nested JSONObject: " + student);

            // ===== 10. Working with JSONArray =====
            JSONArray courses = new JSONArray();
            courses.put("Java");
            courses.put("Python");
            courses.put("C++");
            student.put("courses", courses);
            System.out.println("JSONArray inside JSONObject: " + student);

            // ===== 11. Exception Handling =====
            try {
                int invalid = student.getInt("nonexistent"); // throws JSONException
            } catch (JSONException e) {
                System.out.println("Caught JSONException: " + e.getMessage());
            }

        } catch (JSONException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}