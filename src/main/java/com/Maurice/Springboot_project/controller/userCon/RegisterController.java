
package com.Maurice.Springboot_project.controller.userCon;

import com.Maurice.Springboot_project.model.CustomerModel;
import com.Maurice.Springboot_project.service.ServiceImpl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {

    private final CustomerService customerService;

    @Autowired
    public RegisterController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/register")
    public String getRegistrationPage(Model model) {
        model.addAttribute("userModel", new CustomerModel());
        return "register_page";
    }


    @PostMapping("/register")
    public String register(
            @ModelAttribute("userModel") CustomerModel customerModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            // Validation errors occurred, return to the registration form with error messages.
            return "register_page";
        }

        CustomerModel registeredUser = customerService.registerUser(
                customerModel.getUserName(),
                customerModel.getEmail(),
                customerModel.getPassword()
        );

        if (registeredUser == null) {
            // Registration failed, add an error message and return to the registration form.
            redirectAttributes.addFlashAttribute("errorMessage", "Registration failed.");
            return "redirect:/register";
        }

        // Registration successful, redirect to the login page.
        return "redirect:/login";
    }
}

