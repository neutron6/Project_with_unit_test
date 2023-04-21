package com.rsn.mark1.controller;

import com.rsn.mark1.model.Employee;
import com.rsn.mark1.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/v1/api")
public class EmployeeController {

    Logger logger = Logger.getLogger(this.getClass().getName());
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/createAccount")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Employee createAccount(@RequestBody Employee employee) {
        logger.log(Level.INFO, "*****create account api is activated*****");
        return employeeServiceImpl.saveData(employee);
    }

    @GetMapping("/signIn/{email}/{password}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Employee> signIn(@PathVariable("email") String employeeEmail, @PathVariable("password") String employeePass) {
        logger.log(Level.INFO, "*****Sign in is activated*****");
        return employeeServiceImpl.logIn(employeeEmail, employeePass);
    }

    @GetMapping("/getAllEmployeeData")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployeeData() {
        logger.log(Level.INFO, "*****Getting all employee data******");
        return employeeServiceImpl.getAllData();
    }

    @GetMapping("/getDataByEmployeeId/{id}")
    public Optional<Employee> getDataByEmployeeId(@PathVariable("id") int employeeId) {
        logger.log(Level.INFO,"getting data by employee id is activated");
        return employeeServiceImpl.getDataById(employeeId);
    }

}


