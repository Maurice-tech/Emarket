package com.Maurice.Springboot_project.repository;

import com.Maurice.Springboot_project.model.ViewProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ViewProductRepository extends JpaRepository<ViewProductModel,Long> {
//    List<ViewProductModel> findAll (String ProductName);
}
