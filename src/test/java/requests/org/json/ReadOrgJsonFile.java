package requests.org.json;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.FileReader;
import java.io.IOException;

public class ReadOrgJsonFile {

    public static void main(String[] args) {
        String filePath = "input.json";

        // Use try-with-resources to automatically close the file reader
        try (FileReader reader = new FileReader(filePath)) {
            // JSONTokener handles parsing the raw reader stream
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject root = new JSONObject(tokener);

            // Access top-level fields
            System.out.println("Company: " + root.getString("companyName"));

            // Access nested object (headquarters)
            JSONObject hq = root.getJSONObject("headquarters");
            System.out.println("HQ: " + hq.getString("city") + ", " + hq.getString("state"));

            // Traverse the departments array
            JSONArray departments = root.getJSONArray("departments");
            for (int i = 0; i < departments.length(); i++) {
                JSONObject dept = departments.getJSONObject(i);
                System.out.println("\nDepartment: " + dept.getString("deptName"));

                // Traverse the employees array within each department
                JSONArray employees = dept.getJSONArray("employees");
                for (int j = 0; j < employees.length(); j++) {
                    JSONObject emp = employees.getJSONObject(j);
                    System.out.println(" - " + emp.getString("firstName") + " " +
                            emp.getString("lastName") + " [" +
                            emp.getString("role") + "]");
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
