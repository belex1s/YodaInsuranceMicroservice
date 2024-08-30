package com.example.employee.service;

import com.example.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        // Add some dummy employees for testing
        employees.add(new Employee(1L, "John Doe", "Engineering", 50000));
        employees.add(new Employee(2L, "Jane Smith", "Marketing", 60000));
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(Long id) {
        return employees.stream().filter(emp -> emp.getId().equals(id)).findFirst().orElse(null);
    }

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public void deleteEmployee(Long id) {
        employees.removeIf(emp -> emp.getId().equals(id));
    }
}
