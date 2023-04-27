package com.rsn.mark1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsn.mark1.exception.InvalidCredentialsException;
import com.rsn.mark1.exception.UpdateDataEmployeeException;
import com.rsn.mark1.model.Employee;
import com.rsn.mark1.repository.EmployeeRepo;

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
	public Optional<Employee> getDataById(int id) {
		return employeeRepo.findById(id);
	}

	@Override
	public Employee updatedata(Employee employee) throws UpdateDataEmployeeException {
		return employeeRepo.save(employee);

	}
}
