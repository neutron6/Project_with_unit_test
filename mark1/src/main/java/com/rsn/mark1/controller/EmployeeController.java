package com.rsn.mark1.controller;

import com.rsn.mark1.exception.UpdateDataEmployeeException;
import com.rsn.mark1.model.Employee;
import com.rsn.mark1.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import java.util.concurrent.TimeUnit;


import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/v1/api")
public class EmployeeController {

    Logger logger = Logger.getLogger(this.getClass().getName());
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/createAccount")
    @ResponseStatus(HttpStatus.CREATED)
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public Employee createAccount(@RequestBody Employee employee) {
        logger.log(Level.INFO, "*****create account API is activated*****");
        return employeeServiceImpl.saveData(employee);
    }

    @GetMapping("/signIn/{email}/{password}")
    @ResponseStatus(HttpStatus.OK)
    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
    public Optional<Employee> signIn(@PathVariable("email") String employeeEmail, @PathVariable("password") String employeePass) {
        logger.log(Level.INFO, "*****Sign in API is activated*****");
        return employeeServiceImpl.logIn(employeeEmail, employeePass);
    }

    @GetMapping("/getAllEmployeeData")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployeeData() {
        logger.log(Level.INFO, "*****Getting all employee data API is activated******");
        return employeeServiceImpl.getAllData();
    }

    @GetMapping("/getDataByEmployeeId/{id}")
    public Optional<Employee> getDataByEmployeeId(@PathVariable("id") int employeeId) {
        logger.log(Level.INFO, "getting data by employee id API is activated");
        return employeeServiceImpl.getDataById(employeeId);
    }

    @PutMapping("/updateAccount")
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<Employee> updateAccount(@RequestBody Employee employee) throws UpdateDataEmployeeException {
        logger.log(Level.INFO, "******** update API is calling *********");
        return Optional.ofNullable(employeeServiceImpl.updatedata(employee));
    }

    @GetMapping("/sortingByField/{field}")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> sortingByField(@PathVariable String field){
        logger.log(Level.INFO, "******** sortingByField API is calling *********");
        List<Employee> employeeList = employeeServiceImpl.findEmployeeWithSorting(field);
        return employeeList;
    }


}



	@GetMapping("/getDataByEmployeeId/{id}")
	public Optional<Employee> getDataByEmployeeId(@PathVariable("id") int employeeId) {
		logger.log(Level.INFO, "*******getting data by employee id API is activated******");
		return employeeServiceImpl.getDataById(employeeId);
	}

	@PutMapping("/updateEmployeeData/{id}")
	@ResponseStatus(HttpStatus.OK)
	@Retryable(maxAttempts = 5, value = { TimeoutException.class })
	public Optional<Employee> updateEmployeeData( @RequestBody Employee employee)
			throws UpdateDataEmployeeException {
		logger.log(Level.INFO, "*****update employee data API is activated*****");
		return Optional.ofNullable(employeeServiceImpl.updatedata(employee));

	}

}
