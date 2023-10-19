package com.Maurice.Springboot_project.controller.admin;

import com.Maurice.Springboot_project.model.AddProductModel;
import com.Maurice.Springboot_project.service.ServiceImpl.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AddProductController {
    private final AdminService adminService;

    @Autowired
    public AddProductController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/add_product")
    public String getAddProductPage(Model model) {
        model.addAttribute("addProduct", new AddProductModel());
        return "add_product_to_store";
    }


    @PostMapping("/add_product")
    public String addProduct(
            @ModelAttribute("addProductModel") AddProductModel addProductModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            // Validation errors occurred, return to the registration form with error messages.
            return "add_product_to_store";
        }


        AddProductModel addProductToStore = adminService.putProduct(
                addProductModel.getProductName(),
                addProductModel.getPrice(),
                addProductModel.getQuantity()
        );

        if (addProductToStore == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Adding To Store Failed.");
            return "redirect:/product";
        }

        // Registration successful, redirect to the login page.
        return "homePage";
    }
}
