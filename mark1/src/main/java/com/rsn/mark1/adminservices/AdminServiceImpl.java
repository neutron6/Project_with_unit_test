package com.rsn.mark1.adminservices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsn.mark1.model.Admin;
import com.rsn.mark1.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepo adminRepo;

	public Admin createAdmin(Admin admin) {
		return adminRepo.save(admin);

	}

	@Override
	public boolean authenticate(String adminId, String adminPass) {

		Optional<Admin> adminOptional = adminRepo.findByAdminId(adminId);
		if (adminOptional.isPresent()) {
			
		}

		return false;
	}

}
