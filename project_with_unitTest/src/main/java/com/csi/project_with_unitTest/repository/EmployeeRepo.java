package com.csi.project_with_unitTest.repository;

import com.csi.project_with_unitTest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    public Employee findByEmail(String email);
}
