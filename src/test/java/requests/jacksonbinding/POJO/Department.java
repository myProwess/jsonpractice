package requests.jacksonbinding.POJO;

import java.util.List;

public class Department {
    public Department(String deptName) {
        this.deptName = deptName;
    }

    private String deptName;
   private List<Employee> employees;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
