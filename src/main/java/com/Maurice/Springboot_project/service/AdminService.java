package com.Maurice.Springboot_project.service;

import com.Maurice.Springboot_project.model.AddProductModel;
import com.Maurice.Springboot_project.model.AdminModel;
import com.Maurice.Springboot_project.repository.ViewProductRepository;

public interface AdminService {
    public AdminModel registerAdmin(String firstName, String lastName , String email, String password);
    public String loginAdmin(String email, String password);
    public AddProductModel putProduct(String productName, Double price , Integer quantity);
    public void ViewProductService(ViewProductRepository viewProductRepository);
}
