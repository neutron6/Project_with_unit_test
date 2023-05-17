package com.rsn.mark1.service;

import com.rsn.mark1.exception.DateNotFoundException;

import com.rsn.mark1.exception.InvalidCredentialsException;
import com.rsn.mark1.exception.RecordNotFoundException;
import com.rsn.mark1.exception.UpdateDataEmployeeException;
import com.rsn.mark1.model.Employee;
import com.rsn.mark1.repository.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee saveData(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public Optional<Employee> logIn(String email, String password) {

		Optional<Employee> employee = employeeRepo.findByEmailAndPassword(email, password);

		if (employee.isEmpty()) {
			throw new InvalidCredentialsException("invalid credentials");
		}
		return employee;
	}

	@Override
	public List<Employee> getAllData() {
		return employeeRepo.findAll();
	}


	@Override
	public Employee updatedata(Employee employee) throws UpdateDataEmployeeException {
		return employeeRepo.save(employee);


    @Override
    public Optional<Employee> getDataById(UUID id) {
        return employeeRepo.findById(id);
    }


    @Override
    public Employee updatedata(Employee employee) throws UpdateDataEmployeeException {


        Optional<Employee> existingEmployee = employeeRepo.findById(employee.getId());
        existingEmployee.ifPresent(emp -> {
            emp.setFirstName(employee.getFirstName());
            emp.setLastName(employee.getLastName());
            emp.setEmail(employee.getEmail());
            emp.setPassword(employee.getPassword());
        });

        if (existingEmployee.isPresent()) {
            return employeeRepo.save(existingEmployee.get());
        } else {
            throw new UpdateDataEmployeeException("THE ENTERING DATA IS INVALID");
        }

    }

    @Override
    public List<Employee> findEmployeeWithSorting(String field) {
        return employeeRepo.findAll(Sort.by(Sort.Direction.ASC, field));
    }


    @Override
    public Page<Employee> getEmployeeWithPaginationAndSort(Integer offset, Integer pageSize, String field) {
        Page<Employee> employeePage = employeeRepo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return employeePage;

    }

    @Override
    public void deleteDataById(UUID id) throws UpdateDataEmployeeException {
        Optional<Employee> deleteEmp = employeeRepo.findById(id);

        if (deleteEmp.isPresent()) {
            Employee employee1 = deleteEmp.get();
            employeeRepo.delete(employee1);
        } else {
            throw new UpdateDataEmployeeException("**| THE ENTERING DATA IS INVALID |**");
        }

    }

    @Override
    public List<Employee> findEmployeeBetweenDate(LocalDate from, LocalDate to) throws DateNotFoundException {
        if (from.isAfter(to)) {
            throw new DateNotFoundException("THE DATE YOU ENTER MIGHT BE INCORRECT");
        } else {
            return employeeRepo.findAllByDateBetween(from.atStartOfDay(), to.atTime(23, 59, 59, 999999999));
        }
    }

    @Override
    public List<Employee> findEmployeeOnDate(LocalDate onDate) throws DateNotFoundException {
        Optional<Employee> employee = employeeRepo.findById(UUID.randomUUID());
        if (employee.isPresent()) {
            return employeeRepo.findAllByDateBetween(onDate.atStartOfDay(), onDate.atTime(23, 59, 59, 999999999));
        } else {
            throw new DateNotFoundException("THE DATE YOU ENTER MIGHT BE INCORRECT");
        }

    }


}
