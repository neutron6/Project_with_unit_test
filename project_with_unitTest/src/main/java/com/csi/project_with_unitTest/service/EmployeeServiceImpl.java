package com.csi.project_with_unitTest.service;

import com.csi.project_with_unitTest.exception.RecordNotFoundException;
import com.csi.project_with_unitTest.model.Employee;
import com.csi.project_with_unitTest.repository.EmployeeRepo;
import com.csi.project_with_unitTest.exception.RecordNotDeleteException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee saveData(Employee employee) {

        Optional<Employee> savedEmployee = Optional.ofNullable(employeeRepo.findByEmail(employee.getEmail()));

        if (savedEmployee.isPresent()) {
            throw new RecordNotFoundException("employee already existed" + employee.getEmail());
        }

        return employeeRepo.save(employee);
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
    public Employee updateData(Employee updateData) {
        return employeeRepo.save(updateData);
    }

    @Override
    public void deleteData(int id) {

        Optional<Employee> deleteEmployee = employeeRepo.findById(id);

        if (deleteEmployee.stream().noneMatch(employee -> employeeRepo.existsById(id))) {
            throw new RecordNotDeleteException("Inserted data is not existed");
        } else {
            employeeRepo.deleteById(id);
        }


    }
}
