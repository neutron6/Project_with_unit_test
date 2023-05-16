package com.rsn.mark1.test_cases;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsn.mark1.controller.EmployeeController;
import com.rsn.mark1.model.Employee;
import com.rsn.mark1.service.EmployeeServiceImpl;

@WebMvcTest(EmployeeController.class) // Checking whole behaviour of application
public class NewTest {

	@MockBean
	private EmployeeServiceImpl employeeService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	public NewTest() {
	}

	@Test
	public void Test_For_createAccount() throws Exception {
		Employee employee = new Employee(UUID.randomUUID(), "John", "Don", "john@gmail,com", "123");

		mockMvc.perform(post("/v1/api/createAccount").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(employee))).andExpect(status().isCreated()).andDo(print());
	}

	@Test
	public void Test_For_signIn() throws Exception {
		Employee employee = new Employee(UUID.randomUUID(), "John", "Don", "john@gmail.com", "123");
		Employee employee1 = new Employee(UUID.randomUUID(), "rock", "kelvion", "rock@gmail.com", "123");
		Employee employee2 = new Employee(UUID.randomUUID(), "John", "cena", "cena@gmail.com", "123");

		when(employeeService.logIn("rock@gmail.com", "123")).thenReturn(Optional.of(employee1));
		mockMvc.perform(get("/v1/api/signIn/{email}/{password}", "rock@gmail.com", "123")).andExpect(status().isOk())
				.andExpect(jsonPath("$.email").value(employee1.getEmail()))
				.andExpect(jsonPath("$.password").value(employee1.getPassword())).andDo(print());

	}

	@Test
	public void Test_For_getAllEmployeeData() throws Exception {
		List<Employee> employeeList = new ArrayList<>();

		Employee employee1 = new Employee(UUID.randomUUID(), "rushi", "nichit", "rsn@gmail.com", "rushi@123");
		Employee employee2 = new Employee(UUID.randomUUID(), "aaksh", "rao", "ak@gmail.com", "ak@123");
		Employee employee3 = new Employee(UUID.randomUUID(), "rushi", "nichit", "rsn@gmail.com", "rushi@123");
		Employee employee4 = new Employee(UUID.randomUUID(), "aaksh", "rao", "ak@gmail.com", "ak@123");
		Employee employee5 = new Employee(UUID.randomUUID(), "rushi", "nichit", "rsn@gmail.com", "rushi@123");

		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeList.add(employee3);
		employeeList.add(employee4);
		employeeList.add(employee5);

		when(employeeService.getAllData()).thenReturn(employeeList);
		mockMvc.perform(get("/v1/api/getAllEmployeeData")).andExpect(status().isOk()).
		// andExpect(jsonPath("$.size").value(employeeList.size())).
				andDo(print());

	}

	@Test
	public void Test_For_getDataByEmployeeId() throws Exception {
		Employee employee1 = new Employee(UUID.randomUUID(), "rushi", "nichit", "rsn@gmail.com", "rushi@123");

		when(employeeService.getDataById(UUID.randomUUID())).thenReturn(Optional.of(employee1));
		mockMvc.perform(get("/v1/api/getDataByEmployeeId/{id}", 1)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(employee1.getId()))
				/*
				 * .andExpect(jsonPath("$.firstName").value(employee1.getFirstName()))
				 * .andExpect(jsonPath("$.lastName").value(employee1.getLastName()))
				 * .andExpect(jsonPath("$.email").value(employee1.getEmail()))
				 * .andExpect(jsonPath("$.password").value(employee1.getPassword()))
				 */
				.andDo(print());

	}

	@Test
	public void Test_For_updateEmployeeData() throws Exception {
		// Create the input and output employee objects
		Employee inputEmployee = new Employee(UUID.randomUUID(), "rushi", "nichit", "rsn@gmail.com", "rushi@123");
		Employee outputEmployee = new Employee(UUID.randomUUID(), "rushi", "nichit", "rsn@gmail.com", "rushi@456");

		// Mock the employee service to return the output employee when given the input
		// employee and ID
		when(employeeService.updatedata(inputEmployee)).thenReturn(outputEmployee);

		// Send a PUT request to the updateEmployeeData endpoint with the input employee
		// as the request body
		mockMvc.perform(put("/v1/api/updateEmployeeData/{id}", 1).contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(inputEmployee))).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is("1"))).andExpect(jsonPath("$.firstName", is("rushi")))
				.andExpect(jsonPath("$.lastName", is("nichit"))).andExpect(jsonPath("$.email", is("rsn@gmail.com")))
				.andExpect(jsonPath("$.password", is("rushi@456")));

		// Verify that the employee service was called with the correct input values

	}

}
