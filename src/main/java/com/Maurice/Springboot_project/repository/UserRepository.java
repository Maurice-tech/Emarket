package com.Maurice.Springboot_project.repository;

import com.Maurice.Springboot_project.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<CustomerModel,Long> {

    CustomerModel findByEmailAndPassword(String email, String password);
    Optional<CustomerModel> findFirstByUserName (String userName);

}
