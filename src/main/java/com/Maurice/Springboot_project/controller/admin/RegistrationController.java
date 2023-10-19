package com.Maurice.Springboot_project.controller.admin;

import com.Maurice.Springboot_project.model.AdminModel;
import com.Maurice.Springboot_project.model.CustomerModel;
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
public class RegistrationController {
    private final AdminService adminService;

    @Autowired
    public RegistrationController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping("/ad_register")
    public String getRegistrationPage(Model model) {
        model.addAttribute("adminModel", new CustomerModel());
        return "admin_register_page";
    }

    @GetMapping("/admin_homepage")
    public String getHomepage(Model model) {
        model.addAttribute("adminModel", new CustomerModel());
        return "homePage";
    }


    @PostMapping("/ad_register")
    public String register(
            @ModelAttribute("adminModel") AdminModel adminModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            // Validation errors occurred, return to the registration form with error messages.
            return "register_page";
        }

//
        AdminModel registeredAdmin = adminService.registerAdmin(
                adminModel.getFirstname(),
                adminModel.getLastname(),
                adminModel.getEmail(),
                adminModel.getPassword()
        );

        if (registeredAdmin == null) {
            // Registration failed, add an error message and return to the registration form.
            redirectAttributes.addFlashAttribute("errorMessage", "Registration failed.");
            return "redirect:/register";
        }

        // Registration successful, redirect to the login page.
        return "redirect:/login";
    }
}

