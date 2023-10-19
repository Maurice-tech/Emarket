package com.Maurice.Springboot_project.controller.admin;

import com.Maurice.Springboot_project.dto.LoginRequest;
import com.Maurice.Springboot_project.service.ServiceImpl.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminLoginController {
    private final AdminService adminService;


    @Autowired
    public AdminLoginController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin_login") // Handle GET requests for "/login"
    public String adminLoginPage(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "admin_login_page"; // Return the login page view
    }

    @PostMapping("/admin_login")// Handle POST requests for "/login"
    public String loginAdmin(LoginRequest loginRequest) {
        // Perform login authentication using loginService
        return adminService.loginAdmin(loginRequest.getEmail(), loginRequest.getPassword());
    }
}
