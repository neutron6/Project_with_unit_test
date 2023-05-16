package com.rsn.mark1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rsn.mark1.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {

	Optional<Admin> findByAdminId(String adminId);
}
