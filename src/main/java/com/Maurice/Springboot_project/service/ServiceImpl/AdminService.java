package com.Maurice.Springboot_project.service.ServiceImpl;

import Exceptions.ThrowMyCustomException;
import com.Maurice.Springboot_project.model.AddProductModel;
import com.Maurice.Springboot_project.model.AdminModel;
import com.Maurice.Springboot_project.model.ViewProductModel;
import com.Maurice.Springboot_project.repository.AddProductRepository;
import com.Maurice.Springboot_project.repository.AdminRepository;
import com.Maurice.Springboot_project.repository.ViewProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements com.Maurice.Springboot_project.service.AdminService {

    @Autowired
    private final AdminRepository adminRepository;
    private final AddProductRepository addProductRepository;
    private final ViewProductRepository viewProductRepository;

    public AdminService(AdminRepository adminRepository, AddProductRepository addProductRepository, ViewProductRepository viewProductRepository) {
        this.adminRepository = adminRepository;
        this.addProductRepository = addProductRepository;
        this.viewProductRepository = viewProductRepository;
    }

    @Override
    public AdminModel registerAdmin(String firstName, String lastName, String email, String password) {
        if (email == null || password == null) {
                return null;
            }
            else {
                if (adminRepository.findFirstByEmail(email).isPresent()){
                    return null;
                }

                AdminModel adminModel = new AdminModel();

                adminModel.setFirstname(firstName);
                adminModel.setLastname(lastName);
                adminModel.setEmail(email);
                adminModel.setPassword(password);
                adminRepository.save(adminModel);

                return adminModel;
            }
        }


    @Override
    public String loginAdmin(String email, String password) {
        if (email == null || password == null) {
            // Invalid credentials, return the login page URL
            return "admin_login_page";
        }
        else {
            // Attempt to find a user with the provided email in the repository
            AdminModel adminModel = adminRepository.findByEmailAndPassword(email, password);

            // If a user with the given email is found and the password matches
            if (adminModel != null) {
                // Return the home page URL
                return "homePage";
            }
            else {
                // Authentication failed, return the login page URL
                return "redirect:/admin_login";

            }
        }
    }

    @Override
    public AddProductModel putProduct(String productName, Double price, Integer quantity) {
        if (productName == null || quantity == null) {
            return null;
        }
        else {
            if (addProductRepository.findFirstByProductName(productName).isPresent()){
                throw new ThrowMyCustomException("This product has been added!");
            }

            AddProductModel addProductModel = new AddProductModel();

            addProductModel.setProductName(productName);
            addProductModel.setPrice(price);
            addProductModel.setQuantity(quantity);
            addProductRepository.save(addProductModel);

            return addProductModel;
        }
    }


    @Override
    public void ViewProductService(ViewProductRepository viewProductRepository) {
        List<ViewProductModel> products = viewProductRepository.findAll();

        // Perform some example operations
        for (ViewProductModel product : products) {
            // Example: Do something with each product (e.g., print the product name)
            System.out.println("Product Name: " + product.getProductName());
        }
    }
}
