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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class TestsCases {

    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    public void TestCase_1_ForSignIn_Service_Layer() { //---->passed

        Employee employee = new Employee(1, "rushi", "nichit", "rsn@gmail.com", "rushi@123");

        Mockito.when(employeeRepo.findByEmailAndPassword(employee.getEmail(), employee.getPassword())).thenReturn(Optional.of(employee));

        Optional<Employee> result = employeeService.logIn(employee.getEmail(), employee.getPassword());

        assertTrue(result.isPresent());
        assertEquals(employee, result.get());
    }

    @Test
    public void TestCase_2_ForCreateAccount_Service_Layer() {//---->passed
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

    @Test
    public void TestCase_3_ForGetAllEmployeeData() {//---->passed

        List<Employee> employeeList = new ArrayList<>();

        Employee employee1 = new Employee(1, "rushi", "nichit", "rsn@gmail.com", "rushi@123");
        Employee employee2 = new Employee(2, "aaksh", "rao", "ak@gmail.com", "ak@123");
        Employee employee3 = new Employee(3, "rushi", "nichit", "rsn@gmail.com", "rushi@123");
        Employee employee4 = new Employee(4, "aaksh", "rao", "ak@gmail.com", "ak@123");
        Employee employee5 = new Employee(5, "rushi", "nichit", "rsn@gmail.com", "rushi@123");


        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);

        Mockito.when(employeeRepo.findAll()).thenReturn(employeeList);

        List<Employee> result = employeeService.getAllData();

        assertEquals(employeeList, result);

        Mockito.verify(employeeRepo, Mockito.times(1)).findAll();


    }

    @Test
    public void TestCase_4_ForGetDataById() {//---->passed

        Optional<Employee> employee1 = Optional.of(new Employee(1, "rushi", "nichit", "rsn@gmail.com", "rushi@123"));

        Mockito.when(employeeRepo.findById(1)).thenReturn(employee1);

        Optional<Employee> result = employeeService.getDataById(1);

        assertEquals(employee1, result);

        Mockito.verify(employeeRepo, Mockito.times(1)).findById(1);

    }
}






