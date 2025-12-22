package requests.jacksonbinding;

import com.fasterxml.jackson.databind.ObjectMapper;
import requests.jacksonbinding.POJO.Company;
import java.io.File;
import java.io.IOException;

public class JacksonFileReaderExample {

    public static void main(String[] args) {
        // ObjectMapper is the primary class for all Jackson operations
        ObjectMapper mapper = new ObjectMapper();

        // Target file path
        File jsonFile = new File("data.json");

        try {
            // Read the file and map its content directly to the Company Java class
            Company company = mapper.readValue(jsonFile, Company.class);

            // Verify data extraction
            System.out.println("Company Name: " + company.getCompanyName());
            System.out.println("HQ City: " + company.getHeadquarters().getCity());

            company.getDepartments().forEach(dept -> {
                System.out.println("\nDepartment: " + dept.getDeptName());
                dept.getEmployees().forEach(emp ->
                        System.out.println(" - " + emp.getFirstName() + " " + emp.getLastName() + " (" + emp.getRole() + ")")
                );
            });

        } catch (IOException e) {
            System.err.println("Error processing the JSON file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}