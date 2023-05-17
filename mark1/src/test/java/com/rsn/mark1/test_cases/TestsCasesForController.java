//package com.rsn.mark1.test_cases;
//
//import com.rsn.mark1.controller.EmployeeController;
//import com.rsn.mark1.model.Employee;
//import com.rsn.mark1.service.EmployeeServiceImpl;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.http.ResponseEntity;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class TestsCasesForController {
//
//    @Mock
//    private EmployeeServiceImpl employeeService;
//
//    @InjectMocks
//    private EmployeeController employeeController;
//
//    private Employee employee;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        Employee employee = new Employee(UUID.randomUUID(), "John", "don", "john@gmail.com", "john123");
//
//    }
//
//
//    @Test
//    public void Test_1_for_CreateAccount() {
//
//        when(employeeService.saveData(employee)).thenReturn(employee);
//        ResponseEntity<String> result = employeeController.createAccount(employee);
//        assertEquals(employee, result);
//        Mockito.verify(employeeService, Mockito.times(1)).saveData(employee);
//
//    }
//
//    @Test
//    public void Test_2_for_signIn() {
//
//        Optional<Employee> employee1 = Optional.of(new Employee(UUID.randomUUID(), "John", "don", "john@gmail.com", "john123"));
//        when(employeeService.logIn("john@gmail.com", "john123")).thenReturn(employee1);
//        Optional<Employee> result = employeeController.signIn("john@gmail.com", "john123");
//        assertEquals(employee1, result);
//        Mockito.verify(employeeService, times(1)).logIn("john@gmail.com", "john123");
//
//    }
//
//    @Test
//    public void Test_3_for_getAllEmployeeData() {
//        List<Employee> employeeList = new ArrayList<>();
//        Employee employee1 = new Employee(UUID.randomUUID(), "rushi", "nichit", "rsn@gmail.com", "rushi@123");
//        Employee employee2 = new Employee(UUID.randomUUID(), "aaksh", "rao", "ak@gmail.com", "ak@123");
//        Employee employee3 = new Employee(UUID.randomUUID(), "rushi", "nichit", "rsn@gmail.com", "rushi@123");
//        Employee employee4 = new Employee(UUID.randomUUID(), "aaksh", "rao", "ak@gmail.com", "ak@123");
//        Employee employee5 = new Employee(UUID.randomUUID(), "rushi", "nichit", "rsn@gmail.com", "rushi@123");
//
//
//        employeeList.add(employee1);
//        employeeList.add(employee2);
//        employeeList.add(employee3);
//        employeeList.add(employee4);
//        employeeList.add(employee5);
//
//        when(employeeService.getAllData()).thenReturn(employeeList);
//        List<Employee> result = employeeController.getAllEmployeeData();
//        assertEquals(employeeList, result);
//        Mockito.verify(employeeService, times(1)).getAllData();
//    }
//
//    @Test
//    public void Test_4_for_getDataByEmployeeId() {
//
//        Optional<Employee> employee2 = Optional.of(new Employee(UUID.randomUUID(), "rushi", "nichit", "rsn@gmail.com", "rushi@123"));
//        when(employeeService.getDataById(UUID.randomUUID())).thenReturn(employee2);
//        Optional<Employee> result = employeeController.getDataByEmployeeId(UUID.randomUUID());
//        assertEquals(employee2, result);
//        Mockito.verify(employeeService, times(1)).getDataById(UUID.randomUUID());
//    }
//
//}
