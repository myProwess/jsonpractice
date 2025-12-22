package requests.jacksonbinding;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import requests.jacksonbinding.POJO.Company;
import requests.jacksonbinding.POJO.Department;
import requests.jacksonbinding.POJO.Employee;
import requests.jacksonbinding.POJO.Headquarters;

import java.io.File;
import java.io.IOException;

public class JacksonSerializationExample {

    public static void main(String[] args) {
        // 1. Create and populate Java Objects
        Company company = new Company();
        company.setCompanyName("TechCorp");
        company.setHeadquarters(new Headquarters("San Francisco", "CA"));

        // Engineering Department
        Department eng = new Department("Engineering");
        eng.getEmployees().add(new Employee("John", "Doe", "Developer"));
        eng.getEmployees().add(new Employee("Jane", "Smith", "Manager"));

        // Sales Department
        Department sales = new Department("Sales");
        sales.getEmployees().add(new Employee("Peter", "Jones", "Sales Rep"));

        company.getDepartments().add(eng);
        company.getDepartments().add(sales);

        // 2. Initialize ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // Enable pretty printing (indented output)
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            // 3. Serialize: Java Object -> JSON String
            String jsonOutput = mapper.writeValueAsString(company);
            System.out.println("Serialized JSON:\n" + jsonOutput);

            // 4. Serialize: Java Object -> External File (output.json)
            mapper.writeValue(new File("output.json"), company);
            System.out.println("\nJSON successfully saved to output.json");

        } catch (IOException e) {
            System.err.println("Serialization failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
