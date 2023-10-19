package com.Maurice.Springboot_project.service.ServiceImpl;


import com.Maurice.Springboot_project.model.Product;
import com.Maurice.Springboot_project.repository.ProductRepository;
import com.Maurice.Springboot_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductionServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductionServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();

    }

    @Override
    public void addProduct(Product product) {
    productRepository.save(product);

    }

    @Override
    public void removeProductById(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAllProductsByCategoryId(int id) {
        return productRepository.findAllByCategory_Id(id);
    }
}


