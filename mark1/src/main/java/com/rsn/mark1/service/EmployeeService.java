package com.rsn.mark1.service;

import com.rsn.mark1.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee saveData(Employee employee);

    Optional<Employee> logIn(String email, StringBuilder password);

    List<Employee> getAllData();

    List<Employee> getDataById(int id);


}
