package requests.jacksonbinding.POJO;

public class Employee {

    public Employee(String fName, String lName, String role) {
        this.firstName = fName;
        this.lastName = lName;
        this.role = role;
    }

    private String firstName;
    private String lastName;
    private String role;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
