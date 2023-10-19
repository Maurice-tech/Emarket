package com.Maurice.Springboot_project.service.ServiceImpl;


import com.Maurice.Springboot_project.model.Category;
import com.Maurice.Springboot_project.repository.CategoryRepository;
import com.Maurice.Springboot_project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);

    }

    @Override
    public List<Category> getAllCategory() {

        return categoryRepository.findAll();
    }

    @Override
    public void removeCategoryById(int id) {
        categoryRepository.deleteById(id);

    }

    @Override
    public Optional<Category> getCategoryById(int id) {
        return categoryRepository.findById(id);
    }
}
