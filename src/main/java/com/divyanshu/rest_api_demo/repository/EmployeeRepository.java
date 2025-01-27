package com.divyanshu.rest_api_demo.repository;

import com.divyanshu.rest_api_demo.restapi.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}