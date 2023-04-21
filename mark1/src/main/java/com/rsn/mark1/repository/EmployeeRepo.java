package com.rsn.mark1.repository;

import com.rsn.mark1.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByEmailAndPassword(String email, String password);

    List<Employee> findAllById(int id);
}
