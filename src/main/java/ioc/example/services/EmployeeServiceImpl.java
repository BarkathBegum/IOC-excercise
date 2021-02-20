package ioc.example.services;

import ioc.example.dto.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService {
    // For this exercise no need to have EmployeeRepository  we will implement repository later in this course
//	EmployeeRepository employeeDAO = new EmployeeRepositoryImpl();
    @Override
    public void insert(EmployeeDTO emp) {
        System.out.println("inserted");
    }

    public void delete(int empId) {
        System.out.println("deleted");
    }
}
interface EmployeeService {
    public void insert(EmployeeDTO emp);
}
