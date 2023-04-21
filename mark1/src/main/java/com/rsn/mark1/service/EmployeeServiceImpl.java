package com.rsn.mark1.service;

import com.rsn.mark1.exception.InvalidCredentialsException;
import com.rsn.mark1.model.Employee;
import com.rsn.mark1.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public Employee saveData(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Optional<Employee> logIn(String email, StringBuilder password) {

        Optional<Employee> employee = employeeRepo.findByEmailAndPassword(email,password);

        if (employee.isEmpty()){
            throw new InvalidCredentialsException("invalid credentials");
        }
        return employee;
    }

    @Override
    public List<Employee> getAllData() {
        return employeeRepo.findAll();
    }

    @Override
    public List<Employee> getDataById(int id) {
        return null;
    }
}
