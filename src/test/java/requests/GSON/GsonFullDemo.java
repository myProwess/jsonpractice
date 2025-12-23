package requests.GSON;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

class Student {
    @SerializedName("student_name") // custom JSON field name
    private String name;

    @Expose // included in serialization
    private int age;

    @Expose(serialize = false, deserialize = false) // excluded
    private String secret;

    public Student(String name, int age, String secret) {
        this.name = name;
        this.age = age;
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", secret='" + secret + "'}";
    }
}

// Custom serializer/deserializer
class StudentAdapter implements JsonSerializer<Student>, JsonDeserializer<Student> {
    @Override
    public JsonElement serialize(Student src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject obj = new JsonObject();
        obj.addProperty("custom_name", src.toString());
        return obj;
    }

    @Override
    public Student deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        String full = json.getAsJsonObject().get("custom_name").getAsString();
        return new Student(full, 0, "N/A");
    }
}

public class GsonFullDemo {
    public static void main(String[] args) {
        // ===== Basic Serialization =====
        Student s1 = new Student("Alice", 20, "TopSecret");
        Gson gson = new Gson();
        String json = gson.toJson(s1);
        System.out.println("Basic Serialization: " + json);

        // ===== Basic Deserialization =====
        Student s2 = gson.fromJson(json, Student.class);
        System.out.println("Basic Deserialization: " + s2);

        // ===== Pretty Printing =====
        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println("Pretty JSON:\n" + prettyGson.toJson(s1));

        // ===== Custom Serializer/Deserializer =====
        Gson customGson = new GsonBuilder()
                .registerTypeAdapter(Student.class, new StudentAdapter())
                .create();
        String customJson = customGson.toJson(s1);
        System.out.println("Custom Serialization: " + customJson);
        Student customStudent = customGson.fromJson(customJson, Student.class);
        System.out.println("Custom Deserialization: " + customStudent);

        // ===== Exclusion Strategy =====
        Gson excludeGson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        System.out.println("Exclusion Strategy: " + excludeGson.toJson(s1));

        // ===== Collections =====
        List<Student> students = Arrays.asList(
                new Student("Bob", 22, "Hidden"),
                new Student("Charlie", 23, "Hidden")
        );
        String listJson = gson.toJson(students);
        System.out.println("List Serialization: " + listJson);

        Type listType = new TypeToken<List<Student>>() {}.getType();
        List<Student> deserializedList = gson.fromJson(listJson, listType);
        System.out.println("List Deserialization: " + deserializedList);

        // ===== Map Serialization =====
        Map<String, Integer> marks = new HashMap<>();
        marks.put("Math", 90);
        marks.put("Science", 85);
        String mapJson = gson.toJson(marks);
        System.out.println("Map Serialization: " + mapJson);

        Type mapType = new TypeToken<Map<String, Integer>>() {}.getType();
        Map<String, Integer> deserializedMap = gson.fromJson(mapJson, mapType);
        System.out.println("Map Deserialization: " + deserializedMap);
    }
}
