package com.Maurice.Springboot_project.repository;

import com.Maurice.Springboot_project.model.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminModel,Long> {
    AdminModel findByEmailAndPassword(String email, String password);
    Optional<AdminModel> findFirstByEmail (String userName);
}
