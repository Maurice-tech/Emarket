package com.Maurice.Springboot_project.controller.admin;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Handle and return the error message here
        return "Product you're trying to add already exit in our database!!";
    }

    public String getErrorPath() {
        return "/error";
    }
}
