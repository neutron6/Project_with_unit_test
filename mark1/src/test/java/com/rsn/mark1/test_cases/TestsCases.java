package com.rsn.mark1.test_cases;

import com.rsn.mark1.model.Employee;
import com.rsn.mark1.repository.EmployeeRepo;
import com.rsn.mark1.service.EmployeeService;
import com.rsn.mark1.service.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
//@WebMvcTest
public class TestsCases {

    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    public void TestCaseForSignIn_Service_Layer() {

        Employee employee = new Employee(1, "rushi", "nichit", "rsn@gmail.com", "rushi@123");

        Mockito.when(employeeRepo.findByEmailAndPassword(employee.getEmail(), employee.getPassword())).thenReturn(Optional.of(employee));

        Optional<Employee> result = employeeService.logIn(employee.getEmail(), employee.getPassword());

        assertTrue(result.isPresent());
        assertEquals(employee, result.get());
    }


//    @Autowired
//    private MockMvc mockMvc; // Autowired MockMvc for API testing
//
//    @Autowired
//    private ObjectMapper objectMapper; // Autowired ObjectMapper for converting JSON to Object and vice versa
//
//    @MockBean
//    private EmployeeService employeeService; // Mocked EmployeeService to perform unit tests
//
//    @Test
//    public void TestCaseForCreateAccount_then_itWillReturnEmployeeObject() throws Exception {
//
//        // Create Employee object for testing
//        Employee employee = Employee.builder().id(1).firstName("rushi").
//                lastName("nichit").
//                email("rushi@gmail.com").
//                password("rushi123").
//                build();
//
//        // Define the behavior of employeeService's saveData method
//        given(employeeService.saveData(any(Employee.class))).willAnswer(invocationOnMock -> invocationOnMock.getArguments());
//
//        // Perform API call using MockMvc
//        ResultActions response = mockMvc.perform(post("/v1/api/createAccount").
//                contentType(MediaType.APPLICATION_JSON).
//                content(objectMapper.writeValueAsString(employee)));
//
//        // Validate API response
//        response.andDo(print()).
//                andExpect(status().isCreated()). // Expect status code to be 201
//                andExpect(jsonPath("$.firstName", is(employee.getFirstName()))). // Expect first name to match with the request
//                andExpect(jsonPath("$.lastName", is(employee.getLastName()))). // Expect last name to match with the request
//                andExpect(jsonPath("$.email", is(employee.getEmail()))). // Expect email to match with the request
//                andExpect(jsonPath("$.password", is(employee.getPassword()))); // Expect password to match with the request
//    }


}
