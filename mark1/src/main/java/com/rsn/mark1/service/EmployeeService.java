package com.rsn.mark1.service;

import com.rsn.mark1.exception.UpdateDataEmployeeException;
import com.rsn.mark1.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

	Employee saveData(Employee employee);

	Optional<Employee> logIn(String email, String password);

	List<Employee> getAllData();

	Optional<Employee> getDataById(int id);

  Employee updatedata(Employee employee) throws UpdateDataEmployeeException;

  List<Employee>  findEmployeeWithSorting(String field);


}
