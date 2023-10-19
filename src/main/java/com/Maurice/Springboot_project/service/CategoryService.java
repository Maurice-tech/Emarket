package com.Maurice.Springboot_project.service;

import com.Maurice.Springboot_project.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    void addCategory(Category category);

    List<Category> getAllCategory();

    void removeCategoryById(int id);

    Optional<Category> getCategoryById(int id);
}
