package com.csi.project_with_unitTest.service;

import com.csi.project_with_unitTest.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee saveData(Employee employee);

    List<Employee> getAllData();

    Optional<Employee> getDataById(int id);

    Employee updateData(Employee updateData);

    void deleteData(int id);


}
