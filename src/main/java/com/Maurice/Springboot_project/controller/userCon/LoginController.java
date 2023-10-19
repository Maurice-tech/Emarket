package com.Maurice.Springboot_project.controller.userCon;

import com.Maurice.Springboot_project.dto.LoginRequest;
import com.Maurice.Springboot_project.service.ServiceImpl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private final CustomerService customerService;

    @Autowired
    public LoginController(CustomerService customerService) {
        this.customerService = customerService;
    }




    @GetMapping("/login") // Handle GET requests for "/login"
    public String loginPage(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "login_page"; // Return the login page view
    }

    @PostMapping("/login/save")// Handle POST requests for "/login"
    public String loginUser(LoginRequest loginRequest) {
        // Perform login authentication using loginService
        return customerService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
    }
}


