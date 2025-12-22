package requests.GSON;

import com.google.gson.Gson;
import requests.GSON.POJO.Company;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadJsonFromFile {

    public static void main(String[] args) {
        String filePath = "input.json"; // Path to your external JSON file
        Gson gson = new Gson();

        try (Reader reader = new FileReader(filePath)) {
            // Deserialize JSON file directly into the CompanyData object
            Company company = gson.fromJson(reader, Company.class);

            // Access and print data
            System.out.println("Company: " + company.getCompanyName());
            System.out.println("Location: " + company.getHeadquarters().getCity() + ", " + company.getHeadquarters().getState());

            company.getDepartments().forEach(dept -> {
                System.out.println("\nDepartment: " + dept.getDeptName());
                dept.getEmployees().forEach(emp ->
                        System.out.println("- " + emp.getFirstName() + " " + emp.getLastName() + " (" + emp.getRole() + ")")
                );
            });

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
