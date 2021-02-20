package ioc.example.dto;

public class EmployeeDTO {
    private int empId;

    public EmployeeDTO(int empId, String empName, String department) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
    }

    private String empName;
    private String department;

}
