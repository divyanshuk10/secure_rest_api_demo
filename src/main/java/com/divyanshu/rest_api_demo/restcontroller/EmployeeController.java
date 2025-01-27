package com.divyanshu.rest_api_demo.restcontroller;

import com.divyanshu.rest_api_demo.repository.EmployeeRepository;
import com.divyanshu.rest_api_demo.restapi.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@Transactional
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    /// Get all employees
    /// localhost:8080/students
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.orElse(null);
    }

    @PostMapping("/employee/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addEmployee(@Valid @RequestBody Employee employee) {
        Employee newEmployee = new Employee();
        newEmployee.setDesignation(employee.getDesignation());
        newEmployee.setName(employee.getName());
        newEmployee.setSalary(employee.getSalary());
        newEmployee.setProject(employee.getProject());
        newEmployee.setJoiningDate(new Date());
        employeeRepository.save(newEmployee);
    }

    @PutMapping("/employee/update/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setDesignation(emp.getDesignation());
            employee.setName(emp.getName());
            employee.setSalary(emp.getSalary());
            employee.setProject(emp.getProject());
            employeeRepository.save(employee);
        }
    }

    @DeleteMapping("/employee/remove/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeRepository.deleteById(id);
    }

    @GetMapping("/totalCount")
    public int totalCount(){
        return employeeRepository.findAll().size();
    }

}
