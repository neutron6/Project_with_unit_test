package com.rsn.mark1.service;

import com.rsn.mark1.exception.DateNotFoundException;
import com.rsn.mark1.exception.UpdateDataEmployeeException;
import com.rsn.mark1.model.Employee;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeService {

    Employee saveData(Employee employee);

    Optional<Employee> logIn(String email, String password);

    List<Employee> getAllData();

    Optional<Employee> getDataById(UUID id);

    Employee updatedata(Employee employee) throws UpdateDataEmployeeException;

    List<Employee> findEmployeeWithSorting(String field);

    Page<Employee> getEmployeeWithPaginationAndSort(Integer offset, Integer pageSize, String field);

     void deleteDataById(UUID id) throws UpdateDataEmployeeException;

     List<Employee> findEmployeeBetweenDate(LocalDate from, LocalDate to) throws DateNotFoundException;

     List<Employee> findEmployeeOnDate(LocalDate onDate) throws DateNotFoundException;
}
