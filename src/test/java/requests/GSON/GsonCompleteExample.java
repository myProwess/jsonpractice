package requests.GSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonCompleteExample {

    // 1. Define a simple Java class (POJO)
    static class Person {
        private String name;
        private int age;
        private String position;
        // Gson ignores transient or static fields by default
        private transient String secretInfo = "hidden";

        // Constructors, getters, and setters are good practice but optional for basic Gson
        public Person(String name, int age, String position) {
            this.name = name;
            this.age = age;
            this.position = position;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + ", position='" + position + "'}";
        }
    }

    public static void main(String[] args) {
        // Create a Gson instance with pretty printing enabled for readability
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // --- Serialization: Java Object to JSON String ---
        Person person = new Person("John Doe", 30, "Software Engineer");
        String json = gson.toJson(person);

        System.out.println("--- Serialization (Java Object -> JSON) ---");
        System.out.println(json);

        // --- Deserialization: JSON String to Java Object ---
        String inputJson = """
        {
          "name": "Jane Doe",
          "age": 25,
          "position": "UX Designer"
        }
        """;
        Person parsedPerson = gson.fromJson(inputJson, Person.class);

        System.out.println("\n--- Deserialization (JSON -> Java Object) ---");
        System.out.println("Parsed Object: " + parsedPerson);
        // Accessing a field:
        System.out.println("Name: " + parsedPerson.name);
    }
}

