package com.Maurice.Springboot_project.repository;

import com.Maurice.Springboot_project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
