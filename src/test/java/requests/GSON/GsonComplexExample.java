package requests.GSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import requests.GSON.POJO.*;
import java.util.Arrays;

public class GsonComplexExample {

    public static void main(String[] args) {
        // --- 1. Serialization (Java Object to JSON String) ---
        // Create the Java objects (omitted for brevity, assume a 'company' instance exists)
        // ... (example data construction) ...

        // For demonstration, we use a simple object creation here
        Company company = new Company();
        company.setCompanyName("TechCorp");
        company.setHeadquarters(new Headquarters());
        company.getHeadquarters().setCity("San Francisco");

        Employee emp1 = new Employee(); emp1.setFirstName("John"); emp1.setLastName("Doe"); emp1.setRole("Developer");
        Department dept1 = new Department(); dept1.setDeptName("Engineering"); dept1.setEmployees(Arrays.asList(emp1));
        company.setDepartments(Arrays.asList(dept1));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonOutput = gson.toJson(company);

        System.out.println("--- JSON Output ---");
        System.out.println(jsonOutput);

        // --- 2. Deserialization (JSON String back to Java Object) ---
       // String complexJsonInput = /* ... paste the JSON structure from step 1 here ... */;

        System.out.println("\n--- Deserialization ---");
        Company deserializedCompany = gson.fromJson(jsonOutput, Company.class);
        System.out.println("Company Name: " + deserializedCompany.getCompanyName());
        System.out.println("Headquarters City: " + deserializedCompany.getHeadquarters().getCity());
        System.out.println("First Employee Role: " + deserializedCompany.getDepartments().get(0).getEmployees().get(0).getRole());
    }
}