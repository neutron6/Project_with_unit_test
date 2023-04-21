package com.rsn.mark1.test_cases;


import com.rsn.mark1.model.Employee;
import com.rsn.mark1.repository.EmployeeRepo;
import com.rsn.mark1.service.EmployeeService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
public class TestsCases {

    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void TestCaseForSignIn() {

        Employee employee = new Employee(1, "rushi", "nichit", "rsn@gmail.com",  "rushi@123");

        Mockito.when(employeeRepo.findByEmailAndPassword(employee.getEmail(), employee.getPassword())).thenReturn(Optional.of(employee));

        Optional<Employee> result = employeeService.logIn(employee.getEmail(), employee.getPassword());

        Assert.assertEquals(employee, result);

    }
}
