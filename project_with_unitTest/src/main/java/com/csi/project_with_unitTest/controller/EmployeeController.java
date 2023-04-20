package com.csi.project_with_unitTest.controller;

import com.csi.project_with_unitTest.model.Employee;
import com.csi.project_with_unitTest.service.EmployeeService;
import com.csi.project_with_unitTest.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/?s1")
public class EmployeeController {

    Logger logger = Logger.getLogger(this.getClass().getName());


    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/create_Your_Account")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create_Your_Account(@RequestBody Employee employee) {
        logger.log(Level.FINE, "create_Your_Account API is been Called");
        return employeeServiceImpl.saveData(employee);
    }

    @GetMapping("/getAllEmployees")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees() {
        logger.log(Level.INFO, "getallEmployee API has been called");
        return employeeServiceImpl.getAllData();
    }

    @GetMapping("/gettingDataByEmployeeId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Employee> gettingDataByEmployeeId(@PathVariable("id") int employeeId) {
        logger.log(Level.INFO, "gettingDataByEmployeeId API has been called");

        return employeeServiceImpl.getDataById(employeeId);
    }

    @PutMapping("/updateYourEmployeeData/{id}")
    public ResponseEntity<Employee> updateYourEmployeeData(@PathVariable("id") int employeeId,
                                                           @RequestBody Employee employee) {
        logger.log(Level.INFO, "updateYourEmployeeData API has been called");

        return employeeServiceImpl.getDataById(employeeId).
                map(employee1 -> {
                    employee1.setEmail(employee.getEmail());
                    employee1.setFirstName(employee.getFirstName());
                    employee1.setLastName(employee.getLastName());

                    Employee updatedEmployee = employeeServiceImpl.updateData(employee1);

                    return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());

    }
}
