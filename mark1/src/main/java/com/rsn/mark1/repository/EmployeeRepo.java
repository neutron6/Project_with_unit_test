package com.rsn.mark1.repository;

import com.rsn.mark1.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@EnableJpaRepositories
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByEmailAndPassword(String email, String password);

    List<Employee> findAllById(UUID id);

    Optional<Employee> findById(UUID id);

    List<Employee> findAllByDateBetween(LocalDateTime startTime, LocalDateTime endTime);
}
