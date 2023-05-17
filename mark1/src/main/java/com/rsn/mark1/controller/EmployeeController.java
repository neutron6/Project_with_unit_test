package com.rsn.mark1.controller;

import com.rsn.mark1.exception.DateNotFoundException;
import com.rsn.mark1.exception.UpdateDataEmployeeException;
import com.rsn.mark1.model.Employee;
import com.rsn.mark1.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
    public ResponseEntity<String> createAccount(@RequestBody Employee employee) {
        logger.log(Level.INFO, "*****create account API is activated*****");
        employeeServiceImpl.saveData(employee);
        System.out.println("-----------> EMPLOYEE ID =====>" + employee.getId() + " ----- OF ---->" + employee.getFirstName());
        return ResponseEntity.ok("****** Account is created successfully ***** ");
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
    public Optional<Employee> getDataByEmployeeId(@PathVariable("id") UUID employeeId) {
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
    public List<Employee> sortingByField(@PathVariable String field) {
        logger.log(Level.INFO, "******** sortingByField API is calling *********");
        List<Employee> employeeList = employeeServiceImpl.findEmployeeWithSorting(field);
        return employeeList;
    }

    @GetMapping("/sortByPagination/{offset}/{pageSize}/{field}")
    @ResponseStatus(HttpStatus.OK)
    public Page<Employee> sortByPagination(@PathVariable Integer offset, @PathVariable Integer pageSize, @PathVariable String field) {
        logger.log(Level.INFO, "******** sortByPagination API is calling *********");
        Page<Employee> employeePage = employeeServiceImpl.getEmployeeWithPaginationAndSort(offset, pageSize, field);
        return employeePage;
    }

    @DeleteMapping("/deleteAccount/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteAccount(UUID id) throws UpdateDataEmployeeException {
        logger.log(Level.INFO, "\"******** deleteAccount API is calling *********");
        employeeServiceImpl.deleteDataById(id);
        return ResponseEntity.ok("***** Account is deleted successfully ******");
    }

    @GetMapping("/enterDate/employee")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Employee>> enterDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) throws DateNotFoundException {
        List<Employee> employeeList = employeeServiceImpl.findEmployeeBetweenDate(from, to);
        return (ResponseEntity<List<Employee>>) employeeList;
    }

    @GetMapping("/singleDateEntryFeature/employee/{onDate}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Employee>> singleDateEntryFeature(@PathVariable LocalDate onDate) throws DateNotFoundException {
        return ResponseEntity.ok(employeeServiceImpl.findEmployeeOnDate(onDate));
    }


}


