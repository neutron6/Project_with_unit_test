package com.rsn.mark1.test_cases;


import com.rsn.mark1.model.Employee;
import com.rsn.mark1.repository.EmployeeRepo;
import com.rsn.mark1.service.EmployeeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class TestsCases {

    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    public void TestCase_1_ForSignIn_Service_Layer() {

        Employee employee = new Employee(1, "rushi", "nichit", "rsn@gmail.com", "rushi@123");

        Mockito.when(employeeRepo.findByEmailAndPassword(employee.getEmail(), employee.getPassword())).thenReturn(Optional.of(employee));

        Optional<Employee> result = employeeService.logIn(employee.getEmail(), employee.getPassword());

        assertTrue(result.isPresent());
        assertEquals(employee, result.get());
    }

    @Test
    public void TestCase_2_ForCreateAccount_Service_Layer() {
        Employee employee = new Employee(1, "rushi", "nichit", "rsn@gmail.com", "rushi@123");

        Mockito.when(employeeRepo.save(employee)).thenReturn(employee);

        //calling service method
        Employee result = employeeService.saveData(employee);

        //verify with result
        assertNotNull(result);
        assertEquals(employee.getId(), result.getId());
        assertEquals(employee.getFirstName(), result.getFirstName());
        assertEquals(employee.getLastName(), result.getLastName());
        assertEquals(employee.getEmail(), result.getEmail());
        assertEquals(employee.getPassword(), result.getPassword());

        //verify with repo save method
        Mockito.verify(employeeRepo, Mockito.times(1)).save(employee);

    }
}






