package com.Maurice.Springboot_project.repository;

import com.Maurice.Springboot_project.model.AddProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddProductRepository extends JpaRepository<AddProductModel,Long> {
    Optional<AddProductModel> findFirstByProductName (String ProductName);


//    Optional<AddProductModel> findAddProductModelByProductName (String ProductName);

}
