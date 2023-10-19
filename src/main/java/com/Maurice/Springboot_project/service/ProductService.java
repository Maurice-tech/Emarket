package com.Maurice.Springboot_project.service;


import com.Maurice.Springboot_project.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    void addProduct(Product product);

    void removeProductById(Long id);

    Optional<Product> getProductById(Long id);

    List<Product> getAllProductsByCategoryId(int id);


}
